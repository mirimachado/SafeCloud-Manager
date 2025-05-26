package com.project.manager.cloud.safe.service;

import com.project.manager.cloud.safe.dto.requests.AuthTokenRequestDTO;
import com.project.manager.cloud.safe.entity.AuthToken;
import com.project.manager.cloud.safe.repository.AuthTokenRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthTokenService {

    @Autowired
    private AuthTokenRepository repository;

    public ResponseEntity<?> getAuthTokens() {
        List<AuthToken> tokens = repository.findAll();
        return ResponseEntity.ok(tokens);
    }

    @Transactional
    public ResponseEntity<?> createAuthToken(AuthTokenRequestDTO data) {
        Optional<AuthToken> existingToken = repository.findAll()
                .stream()
                .filter(token -> token.getToken().equals(data.token()))
                .findFirst();

        if (existingToken.isPresent()) {
            return ResponseEntity.badRequest().body("Esse token de autenticação já existe.");
        }

        AuthToken token = AuthToken.builder()
                .token(data.token())
                .userId(data.userId())
                .expiresAt(data.expiresAt())
                .revoked(false)
                .build();

        repository.save(token);
        return ResponseEntity.ok("Token de autenticação criado com sucesso.");
    }

    @Transactional
    public ResponseEntity<?> updateAuthToken(AuthTokenRequestDTO data) {
        Optional<AuthToken> optionalToken = repository.findById(data.id());

        if (optionalToken.isPresent()) {
            AuthToken token = optionalToken.get();
            token.setToken(data.token());
            token.setUserId(data.userId());
            token.setExpiresAt(data.expiresAt());

            repository.save(token);
            return ResponseEntity.ok("Token de autenticação atualizado com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Token de autenticação com id " + data.id() + " não encontrado.");
        }
    }

    @Transactional
    public ResponseEntity<?> deleteAuthToken(UUID id) {
        Optional<AuthToken> token = repository.findById(id);
        if (token.isPresent()) {
            repository.delete(token.get());
            return ResponseEntity.ok("Token de autenticação deletado com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Token de autenticação com id " + id + " não encontrado.");
        }
    }
}
