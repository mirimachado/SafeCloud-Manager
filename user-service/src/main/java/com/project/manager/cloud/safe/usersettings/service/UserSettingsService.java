package com.project.manager.cloud.safe.usersettings.service;

import com.project.manager.cloud.safe.usersettings.dto.UserSettingsRequestDTO;
import com.project.manager.cloud.safe.usersettings.entity.UserSettings;
import com.project.manager.cloud.safe.usersettings.repository.UserSettingsRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserSettingsService {

    @Autowired
    private UserSettingsRepository repository;

    public ResponseEntity<List<UserSettings>> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    public ResponseEntity<?> getById(UUID id) {
        Optional<UserSettings> optional = repository.findById(id);
        if (optional.isPresent()) {
            return ResponseEntity.ok(optional.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Configuração não encontrada");
        }
    }

    public ResponseEntity<?> getByUserId(UUID userId) {
        Optional<UserSettings> optional = repository.findByUserId(userId);
        if (optional.isPresent()) {
            return ResponseEntity.ok(optional.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Configuração para o usuário não encontrada");
        }
    }

    @Transactional
    public ResponseEntity<?> create(UserSettingsRequestDTO dto) {
        if (dto.user() == null || dto.theme().isBlank() || dto.language().isBlank()) {
            return ResponseEntity.badRequest().body("Todos os campos são obrigatórios.");
        }

        Optional<UserSettings> existing = repository.findByUserId(dto.user().getId());
        if (existing.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Usuário já possui configurações salvas.");
        }

        UserSettings settings = UserSettings.builder()
                .user(dto.user())
                .theme(dto.theme())
                .language(dto.language())
                .build();

        repository.save(settings);
        return ResponseEntity.status(HttpStatus.CREATED).body(settings);
    }

    @Transactional
    public ResponseEntity<?> update(UUID id, UserSettingsRequestDTO dto) {
        Optional<UserSettings> optional = repository.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Configuração não encontrada");
        }

        if (dto.user() == null || dto.theme().isBlank() || dto.language().isBlank()) {
            return ResponseEntity.badRequest().body("Todos os campos são obrigatórios.");
        }

        UserSettings settings = optional.get();
        settings.setUser(dto.user());
        settings.setTheme(dto.theme());
        settings.setLanguage(dto.language());

        repository.save(settings);
        return ResponseEntity.ok(settings);
    }

    @Transactional
    public ResponseEntity<?> delete(UUID id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Configuração não encontrada");
        }
        repository.deleteById(id);
        return ResponseEntity.ok("Configuração removida com sucesso");
    }
}
