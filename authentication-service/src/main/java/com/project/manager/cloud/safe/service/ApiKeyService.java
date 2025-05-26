package com.project.manager.cloud.safe.service;

import com.project.manager.cloud.safe.dto.requests.ApiKeyRequestDTO;
import com.project.manager.cloud.safe.entity.ApiKey;
import com.project.manager.cloud.safe.repository.ApiKeyRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ApiKeyService {

    @Autowired
    private ApiKeyRepository repository;

    public ResponseEntity<?> getApiKeys() {
        List<ApiKey> apiKeys = repository.findAll();
        return ResponseEntity.ok(apiKeys);
    }

    @Transactional
    public ResponseEntity<?> createApiKey(ApiKeyRequestDTO data) {
        if (repository.findByKey(data.key()).isPresent()) {
            return ResponseEntity.badRequest().body("Essa chave de API já existe.");
        }

        ApiKey apiKey = ApiKey.builder()
                .key(data.key())
                .label(data.label())
                .userId(data.userId())
                .build();

        repository.save(apiKey);
        return ResponseEntity.ok("Chave de API criada com sucesso.");
    }

    @Transactional
    public ResponseEntity<?> updateApiKey(UUID id, ApiKeyRequestDTO data) {
        Optional<ApiKey> optionalApiKey = repository.findById(id);

        if (optionalApiKey.isPresent()) {
            ApiKey apiKey = optionalApiKey.get();
            apiKey.setKey(data.key());
            apiKey.setLabel(data.label());
            apiKey.setUserId(data.userId());

            repository.save(apiKey);
            return ResponseEntity.ok("Chave de API atualizada com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Chave de API com id " + id + " não encontrada.");
        }
    }

    @Transactional
    public ResponseEntity<?> deleteApiKey(UUID id) {
        Optional<ApiKey> optionalApiKey = repository.findById(id);

        if (optionalApiKey.isPresent()) {
            repository.delete(optionalApiKey.get());
            return ResponseEntity.ok("Chave de API deletada com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Chave de API com id " + id + " não encontrada.");
        }
    }
}
