package com.project.manager.cloud.safe.systemlog.service;

import com.project.manager.cloud.safe.systemlog.dto.SystemLogRequestDTO;
import com.project.manager.cloud.safe.systemlog.entity.SystemLog;
import com.project.manager.cloud.safe.systemlog.repository.SystemLogRepository;
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
public class SystemLogService {

    @Autowired
    private SystemLogRepository repository;

    public ResponseEntity<List<SystemLog>> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @Transactional
    public ResponseEntity<?> create(SystemLogRequestDTO data) {
        SystemLog log = SystemLog.builder()
                .level(data.level())
                .message(data.message())
                .timestamp(data.timestamp() != null ? data.timestamp() : new Date())
                .userId(data.userId())
                .build();

        repository.save(log);
        return ResponseEntity.ok("Log registrado com sucesso.");
    }

    @Transactional
    public ResponseEntity<?> update(UUID id, SystemLogRequestDTO data) {
        Optional<SystemLog> optional = repository.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Log com id " + id + " não encontrado.");
        }

        SystemLog log = optional.get();
        log.setLevel(data.level());
        log.setMessage(data.message());
        log.setTimestamp(data.timestamp());
        log.setUserId(data.userId());

        repository.save(log);
        return ResponseEntity.ok("Log atualizado com sucesso.");
    }

    @Transactional
    public ResponseEntity<?> delete(UUID id) {
        Optional<SystemLog> optional = repository.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Log com id " + id + " não encontrado.");
        }

        repository.deleteById(id);
        return ResponseEntity.ok("Log removido com sucesso.");
    }
}
