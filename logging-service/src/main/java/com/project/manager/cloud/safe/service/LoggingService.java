package com.project.manager.cloud.safe.service;

import com.project.manager.cloud.safe.dto.LoggingRequestDTO;
import com.project.manager.cloud.safe.entity.Logging;
import com.project.manager.cloud.safe.repository.LoggingRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LoggingService {

    @Autowired
    private LoggingRepository repository;

    public ResponseEntity<List<Logging>> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @Transactional
    public ResponseEntity<?> create(LoggingRequestDTO data) {
        Logging log = Logging.builder()
                .level(data.level())
                .message(data.message())
                .timestamp(data.timestamp() != null ? data.timestamp() : LocalDateTime.now())
                .source(data.source())
                .build();

        repository.save(log);
        return ResponseEntity.ok("Log registrado com sucesso.");
    }

    @Transactional
    public ResponseEntity<?> update(UUID id, LoggingRequestDTO data) {
        Optional<Logging> optional = repository.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Log com id " + id + " não encontrado.");
        }

        Logging log = optional.get();
        log.setLevel(data.level());
        log.setMessage(data.message());
        log.setTimestamp(data.timestamp());
        log.setSource(data.source());

        repository.save(log);
        return ResponseEntity.ok("Log atualizado com sucesso.");
    }

    @Transactional
    public ResponseEntity<?> delete(UUID id) {
        Optional<Logging> optional = repository.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Log com id " + id + " não encontrado.");
        }

        repository.deleteById(id);
        return ResponseEntity.ok("Log removido com sucesso.");
    }
}
