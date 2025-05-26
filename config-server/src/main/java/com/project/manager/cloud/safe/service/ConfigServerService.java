package com.project.manager.cloud.safe.service;

import com.project.manager.cloud.safe.dto.ConfigServerRequestDTO;
import com.project.manager.cloud.safe.entity.ConfigServer;
import com.project.manager.cloud.safe.repository.ConfigServerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ConfigServerService {

    @Autowired
    private ConfigServerRepository repository;

    public ResponseEntity<List<ConfigServer>> getAllConfigs() {
        List<ConfigServer> configs = repository.findAll();
        return ResponseEntity.ok(configs);
    }

    @Transactional
    public ResponseEntity<?> createConfig(ConfigServerRequestDTO data) {
        ConfigServer config = ConfigServer.builder()
                .environment(data.environment())
                .configRepoUrl(data.configRepoUrl())
                .build();

        repository.save(config);
        return ResponseEntity.ok("Configuração criada com sucesso.");
    }

    @Transactional
    public ResponseEntity<?> updateConfig(ConfigServerRequestDTO data) {
        Optional<ConfigServer> configOpt = repository.findById(data.id());
        if (configOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Configuração com id " + data.id() + " não encontrada.");
        }

        ConfigServer config = configOpt.get();
        config.setEnvironment(data.environment());
        config.setConfigRepoUrl(data.configRepoUrl());

        repository.save(config);
        return ResponseEntity.ok("Configuração atualizada com sucesso.");
    }

    @Transactional
    public ResponseEntity<?> deleteConfig(UUID id) {
        Optional<ConfigServer> configOpt = repository.findById(id);
        if (configOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Configuração com id " + id + " não encontrada.");
        }

        repository.delete(configOpt.get());
        return ResponseEntity.ok("Configuração deletada com sucesso.");
    }
}
