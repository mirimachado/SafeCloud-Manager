package com.project.manager.cloud.safe.service;

import com.project.manager.cloud.safe.dto.AuditlogRequestDTO;
import com.project.manager.cloud.safe.entity.Auditlog;
import com.project.manager.cloud.safe.repository.AuditlogRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuditlogService {

    @Autowired
    private AuditlogRepository repository;

    public ResponseEntity getAuditLogs(){
        List<Auditlog> auditLogs = repository.findAll();
        return ResponseEntity.ok(auditLogs);
    }
    @Transactional
    public ResponseEntity createAuditLog(AuditlogRequestDTO data){
            Auditlog auditLogs = Auditlog.builder()
                    .action(data.action())
                    .details(data.details())
                    .method(data.method())
                    .module(data.module())
                    .entityId(data.entityId())
                    .entityAffected(data.entityAffected())
                    .errorMessage(data.errorMessage())
                    .ipAddress(data.ipAddress())
                    .timestamp(data.timestamp())
                    .userAgent(data.userAgent())
                    .userId(data.userId())
                    .build();

            repository.save(auditLogs);
            return ResponseEntity.ok("Log criado com sucesso.");

        }

    @Transactional
    public ResponseEntity<?> updateAuditLog(AuditlogRequestDTO data) {
        Optional<Auditlog> auditLogs = repository.findById(data.id());

        auditLogs.ifPresent(existingAuditLog -> {
            existingAuditLog.setAction(data.action());
            existingAuditLog.setDetails(data.details());
            existingAuditLog.setMethod(data.method());
            existingAuditLog.setModule(data.module());
            existingAuditLog.setEntityId(data.entityId());
            existingAuditLog.setEntityAffected(data.entityAffected());
            existingAuditLog.setErrorMessage(data.errorMessage());
            existingAuditLog.setIpAddress(data.ipAddress());
            existingAuditLog.setTimestamp(data.timestamp());
            existingAuditLog.setUserAgent(data.userAgent());
            existingAuditLog.setUserId(data.userId());
            repository.save(existingAuditLog);
        });

        if (auditLogs.isPresent()) {
            return ResponseEntity.ok("Log atualizado com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Log com id " + data.id() + " não encontrado.");
        }
    }

    @Transactional
    public ResponseEntity deleteAuditLog(UUID id){
        Optional<Auditlog> auditLog = repository.findById(id);
        if (auditLog.isPresent()) {
            repository.delete(auditLog.get());
            return ResponseEntity.ok("Registro de log deletado com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Registro de Log com id " + id + " não encontrado.");
        }


    }
}
