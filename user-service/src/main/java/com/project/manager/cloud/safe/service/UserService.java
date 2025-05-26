package com.project.manager.cloud.safe.service;

import com.project.manager.cloud.safe.dto.UserRequestDTO;
import com.project.manager.cloud.safe.entity.User;
import com.project.manager.cloud.safe.enums.UserRole;
import com.project.manager.cloud.safe.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
import java.util.regex.Pattern;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    private final Pattern passwordPattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^\\w\\s]).{8,}$");

    @Transactional
    public ResponseEntity<?> create(UserRequestDTO dto) {

        if (repository.findByEmailIgnoreCase(dto.email()).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Email já cadastrado");
        }

        if (dto.token() != null && !dto.token().isBlank()) {
            if (repository.findByToken(dto.token()).isPresent()) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Token já está em uso");
            }
        }

        if (repository.findByNameIgnoreCase(dto.name()).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Nome já cadastrado");
        }

        if (!passwordPattern.matcher(dto.password()).matches()) {
            return ResponseEntity.badRequest().body("Senha inválida: deve conter letras maiúsculas, minúsculas, números e caracteres especiais");
        }

        User user = User.builder()
                .name(dto.name())
                .email(dto.email())
                .password(dto.password())
                .role(dto.role() != null ? dto.role() : UserRole.USER)
                .token(dto.token())
                .active(true)
                .build();

        repository.save(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @Transactional
    public ResponseEntity<?> update(UUID id, UserRequestDTO dto) {
        Optional<User> optionalUser = repository.findById(id);
        if (optionalUser.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
        }

        User user = optionalUser.get();

        if (repository.findByEmailIgnoreCaseAndIdNot(dto.email(), id).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Email já cadastrado para outro usuário");
        }

        if (dto.token() != null && !dto.token().isBlank()) {
            if (repository.findByTokenAndIdNot(dto.token(), id).isPresent()) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Token já está em uso por outro usuário");
            }
        }

        if (repository.findByNameIgnoreCaseAndIdNot(dto.name(), id).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Nome já cadastrado para outro usuário");
        }

        user.setName(dto.name());
        user.setEmail(dto.email());
        user.setRole(dto.role() != null ? dto.role() : user.getRole());
        user.setToken(dto.token());

        if (dto.password() != null && !dto.password().isBlank()) {
            if (!passwordPattern.matcher(dto.password()).matches()) {
                return ResponseEntity.badRequest().body("Senha inválida: deve conter letras maiúsculas, minúsculas, números e caracteres especiais");
            }
            user.setPassword(dto.password());
        }

        repository.save(user);

        return ResponseEntity.ok(user);
    }

    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    public ResponseEntity<User> getById(UUID id) {
        Optional<User> user = repository.findById(id);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @Transactional
    public ResponseEntity<?> delete(UUID id) {
        Optional<User> optionalUser = repository.findById(id);
        if (optionalUser.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
        }

        User user = optionalUser.get();

        if (!user.getActive()) {
            return ResponseEntity.badRequest().body("Usuário já está inativo");
        }

        user.setActive(false);
        repository.save(user);

        return ResponseEntity.ok("Usuário desativado com sucesso");
    }

    @Transactional
    public ResponseEntity<?> activate(UUID id) {
        Optional<User> optionalUser = repository.findById(id);
        if (optionalUser.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
        }

        User user = optionalUser.get();

        if (user.getActive()) {
            return ResponseEntity.badRequest().body("Usuário já está ativo");
        }

        user.setActive(true);
        repository.save(user);

        return ResponseEntity.ok("Usuário ativado com sucesso");
    }


}
