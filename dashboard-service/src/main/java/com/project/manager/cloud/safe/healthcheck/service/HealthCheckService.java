package com.project.manager.cloud.safe.healthcheck.service;

import com.project.manager.cloud.safe.healthcheck.dto.HealthCheckRequestDTO;
import com.project.manager.cloud.safe.healthcheck.entity.HealthCheck;
import com.project.manager.cloud.safe.healthcheck.repository.HealthCheckRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class HealthCheckService {

    @Autowired
    private HealthCheckRepository repository;

    public ResponseEntity<List<HealthCheck>> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @Transactional
    public ResponseEntity<?> create(HealthCheckRequestDTO data) {
        HealthCheck healthCheck = HealthCheck.builder()
                .serviceName(data.serviceName())
                .status(data.status())
                .checkedAt(data.checkedAt() != null ? data.checkedAt() : new Date())
                .build();

        repository.save(healthCheck);
        return ResponseEntity.ok("Health check criado com sucesso.");
    }

    @Transactional
    public ResponseEntity<?> update(HealthCheckRequestDTO data) {
        Optional<HealthCheck> optional = repository.findById(data.id());
        if (optional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Health check com id " + data.id() + " não encontrado.");
        }

        HealthCheck healthCheck = optional.get();
        healthCheck.setServiceName(data.serviceName());
        healthCheck.setStatus(data.status());
        healthCheck.setCheckedAt(data.checkedAt() != null ? data.checkedAt() : new Date());

        repository.save(healthCheck);
        return ResponseEntity.ok("Health check atualizado com sucesso.");
    }

    @Transactional
    public ResponseEntity<?> delete(UUID id) {
        Optional<HealthCheck> optional = repository.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Health check com id " + id + " não encontrado.");
        }

        repository.delete(optional.get());
        return ResponseEntity.ok("Health check deletado com sucesso.");
    }
}
