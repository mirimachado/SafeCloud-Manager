package com.project.manager.cloud.safe.errorreport.service;

import com.project.manager.cloud.safe.errorreport.dto.ErrorReportRequestDTO;
import com.project.manager.cloud.safe.errorreport.entity.ErrorReport;
import com.project.manager.cloud.safe.errorreport.repository.ErrorReportRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ErrorReportService {

    @Autowired
    private ErrorReportRepository repository;

    public ResponseEntity<List<ErrorReport>> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @Transactional
    public ResponseEntity<?> create(ErrorReportRequestDTO data) {
        ErrorReport report = ErrorReport.builder()
                .userId(data.userId())
                .errorMessage(data.errorMessage())
                .stackTrace(data.stackTrace())
                .createdAt(data.createdAt() != null ? data.createdAt() : new Date())
                .build();

        repository.save(report);
        return ResponseEntity.ok("Erro registrado com sucesso.");
    }

    @Transactional
    public ResponseEntity<?> update(UUID id, ErrorReportRequestDTO data) {
        Optional<ErrorReport> optional = repository.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Erro com id " + id + " não encontrado.");
        }

        ErrorReport report = optional.get();
        report.setUserId(data.userId());
        report.setErrorMessage(data.errorMessage());
        report.setStackTrace(data.stackTrace());
        report.setCreatedAt(data.createdAt());

        repository.save(report);
        return ResponseEntity.ok("Erro atualizado com sucesso.");
    }

    @Transactional
    public ResponseEntity<?> delete(UUID id) {
        Optional<ErrorReport> optional = repository.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Erro com id " + id + " não encontrado.");
        }

        repository.deleteById(id);
        return ResponseEntity.ok("Erro removido com sucesso.");
    }
}
