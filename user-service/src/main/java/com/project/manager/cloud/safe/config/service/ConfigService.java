package com.project.manager.cloud.safe.config.service;

import com.project.manager.cloud.safe.config.dto.ConfigRequestDTO;
import com.project.manager.cloud.safe.config.entity.Config;
import com.project.manager.cloud.safe.config.repository.ConfigRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ConfigService {

    @Autowired
    private ConfigRepository repository;

    public ResponseEntity<List<Config>> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    public ResponseEntity<Config> getById(UUID id) {
        Optional<Config> optional = repository.findById(id);
        return optional.map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @Transactional
    public ResponseEntity<Config> create(ConfigRequestDTO dto) {
        Config config = Config.builder()
                .key(dto.key())
                .value(dto.value())
                .system(dto.system())
                .build();
        repository.save(config);
        return ResponseEntity.status(HttpStatus.CREATED).body(config);
    }

    @Transactional
    public ResponseEntity<?> update(UUID id, ConfigRequestDTO dto) {
        Optional<Config> optional = repository.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Configuração não encontrada");
        }
        Config config = optional.get();
        config.setKey(dto.key());
        config.setValue(dto.value());
        config.setSystem(dto.system());
        repository.save(config);
        return ResponseEntity.ok(config);
    }

    @Transactional
    public ResponseEntity<?> delete(UUID id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Configuração não encontrada");
        }
        repository.deleteById(id);
        return ResponseEntity.ok("Configuração deletada com sucesso");
    }
}
