package com.project.manager.cloud.safe.service;

import com.project.manager.cloud.safe.dto.VaultRequestDTO;
import com.project.manager.cloud.safe.entity.Vault;
import com.project.manager.cloud.safe.repository.VaultRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class VaultService {

    private final VaultRepository repository;

    @Transactional
    public ResponseEntity<?> create(VaultRequestDTO dto) {
        if (dto.userId() == null || dto.dataKey().isBlank() || dto.dataValue().isBlank()) {
            return ResponseEntity.badRequest().body("Todos os campos obrigatórios devem ser preenchidos");
        }

        Vault vault = Vault.builder()
                .userId(dto.userId())
                .dataKey(dto.dataKey())
                .dataValue(dto.dataValue())
                .build();

        repository.save(vault);
        return ResponseEntity.status(HttpStatus.CREATED).body(vault);
    }

    public ResponseEntity<?> findById(UUID id) {
        Optional<Vault> optional = repository.findById(id);
        if (optional.isPresent()) {
            return ResponseEntity.ok(optional.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Registro não encontrado");
        }
    }

    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @Transactional
    public ResponseEntity<?> update(UUID id, VaultRequestDTO dto) {
        Optional<Vault> optional = repository.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Registro não encontrado");
        }

        Vault vault = optional.get();

        if (dto.userId() != null) {
            vault.setUserId(dto.userId());
        }

        if (dto.dataKey() != null && !dto.dataKey().isBlank()) {
            vault.setDataKey(dto.dataKey());
        }

        if (dto.dataValue() != null && !dto.dataValue().isBlank()) {
            vault.setDataValue(dto.dataValue());
        }

        repository.save(vault);
        return ResponseEntity.ok(vault);
    }

    @Transactional
    public ResponseEntity<?> delete(UUID id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Registro não encontrado");
        }

        repository.deleteById(id);
        return ResponseEntity.ok("Registro deletado com sucesso");
    }
}
