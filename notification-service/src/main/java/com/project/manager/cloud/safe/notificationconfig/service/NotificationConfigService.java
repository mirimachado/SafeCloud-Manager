package com.project.manager.cloud.safe.notificationconfig.service;

import com.project.manager.cloud.safe.notificationconfig.dto.NotificationConfigRequestDTO;
import com.project.manager.cloud.safe.notificationconfig.entity.NotificationConfig;
import com.project.manager.cloud.safe.notificationconfig.repository.NotificationConfigRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class NotificationConfigService {

    @Autowired
    private NotificationConfigRepository repository;

    public ResponseEntity<List<NotificationConfig>> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    public ResponseEntity<NotificationConfig> getById(UUID id) {
        Optional<NotificationConfig> config = repository.findById(id);
        return config.map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @Transactional
    public ResponseEntity<?> create(NotificationConfigRequestDTO data) {
        NotificationConfig config = NotificationConfig.builder()
                .userId(data.userId())
                .emailEnabled(data.emailEnabled())
                .smsEnabled(data.smsEnabled())
                .pushEnabled(data.pushEnabled())
                .build();

        repository.save(config);
        return ResponseEntity.ok("Configuração criada com sucesso.");
    }

    @Transactional
    public ResponseEntity<?> update(UUID id, NotificationConfigRequestDTO data) {
        Optional<NotificationConfig> optional = repository.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Configuração não encontrada.");
        }

        NotificationConfig config = optional.get();
        config.setUserId(data.userId());
        config.setEmailEnabled(data.emailEnabled());
        config.setSmsEnabled(data.smsEnabled());
        config.setPushEnabled(data.pushEnabled());

        repository.save(config);
        return ResponseEntity.ok("Configuração atualizada com sucesso.");
    }

    @Transactional
    public ResponseEntity<?> delete(UUID id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Configuração não encontrada.");
        }

        repository.deleteById(id);
        return ResponseEntity.ok("Configuração removida com sucesso.");
    }
}
