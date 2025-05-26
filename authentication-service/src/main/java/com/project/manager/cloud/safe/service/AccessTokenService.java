package com.project.manager.cloud.safe.service;

import com.project.manager.cloud.safe.dto.requests.AccessTokenRequestDTO;
import com.project.manager.cloud.safe.entity.AccessToken;
import com.project.manager.cloud.safe.repository.AccessTokenRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AccessTokenService {

    @Autowired
    private AccessTokenRepository repository;

    public ResponseEntity<?> getAccessToken() {
        List<AccessToken> accessTokens = repository.findAll();
        return ResponseEntity.ok(accessTokens);
    }

    @Transactional
    public ResponseEntity<?> createAccessToken(AccessTokenRequestDTO data) {
        AccessToken token = AccessToken.builder()
                .token(data.token())
                .userId(data.userId())
                .expiresAt(data.expiresAt())
                .created(data.created())
                .build();

        repository.save(token);
        return ResponseEntity.ok("Token de acesso criado com sucesso.");
    }

    @Transactional
    public ResponseEntity<?> updateAccessToken(UUID id, AccessTokenRequestDTO data) {
        Optional<AccessToken> existingToken = repository.findById(id);

        if (existingToken.isPresent()) {
            AccessToken token = existingToken.get();
            token.setToken(data.token());
            token.setUserId(data.userId());
            token.setExpiresAt(data.expiresAt());
            token.setCreated(data.created());

            repository.save(token);
            return ResponseEntity.ok("Token de acesso atualizado com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Token de acesso com id " + id + " não encontrado.");
        }
    }

    @Transactional
    public ResponseEntity<?> deleteAccessToken(UUID id) {
        Optional<AccessToken> token = repository.findById(id);
        if (token.isPresent()) {
            repository.delete(token.get());
            return ResponseEntity.ok("Token de acesso deletado com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Token de acesso com id " + id + " não encontrado.");
        }
    }
}
