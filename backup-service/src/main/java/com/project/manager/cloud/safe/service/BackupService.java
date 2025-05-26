package com.project.manager.cloud.safe.service;

import com.project.manager.cloud.safe.dto.BackupRequestDTO;
import com.project.manager.cloud.safe.entity.Backup;
import com.project.manager.cloud.safe.repository.BackupRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BackupService {

    @Autowired
    private BackupRepository repository;

    public ResponseEntity<List<Backup>> getAllBackups() {
        List<Backup> backups = repository.findAll();
        return ResponseEntity.ok(backups);
    }

    @Transactional
    public ResponseEntity<?> createBackup(BackupRequestDTO data) {
        Optional<Backup> existingBackup = repository.findByHashChecksum(data.hashChecksum());
        if (existingBackup.isPresent()) {
            return ResponseEntity.badRequest()
                    .body("Backup com esse hashChecksum já existe. Não é possível duplicar.");
        }

        Backup backup = Backup.builder()
                .userId(data.userId())
                .filePath(data.filePath())
                .fileName(data.fileName())
                .fileSize(data.fileSize())
                .fileType(data.fileType())
                .storageLocation(data.storageLocation())
                .status(data.status())
                .hashChecksum(data.hashChecksum())
                .expiresAt(data.expiresAt())
                .lastVerifiedAt(data.lastVerifiedAt())
                .deleted(false)
                .notes(data.notes())
                .build();

        repository.save(backup);
        return ResponseEntity.ok("Backup criado com sucesso.");
    }

    @Transactional
    public ResponseEntity<?> updateBackup(BackupRequestDTO data) {
        Optional<Backup> backupOpt = repository.findById(data.id());
        if (backupOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Backup com id " + data.id() + " não encontrado.");
        }

        Backup backup = backupOpt.get();

        if (!backup.getHashChecksum().equals(data.hashChecksum())) {
            Optional<Backup> existingBackup = repository.findByHashChecksum(data.hashChecksum());
            if (existingBackup.isPresent()) {
                return ResponseEntity.badRequest()
                        .body("Outro backup com esse hashChecksum já existe.");
            }
        }

        backup.setUserId(data.userId());
        backup.setFilePath(data.filePath());
        backup.setFileName(data.fileName());
        backup.setFileSize(data.fileSize());
        backup.setFileType(data.fileType());
        backup.setStorageLocation(data.storageLocation());
        backup.setStatus(data.status());
        backup.setHashChecksum(data.hashChecksum());
        backup.setExpiresAt(data.expiresAt());
        backup.setLastVerifiedAt(data.lastVerifiedAt());
        backup.setNotes(data.notes());

        repository.save(backup);
        return ResponseEntity.ok("Backup atualizado com sucesso.");
    }

    @Transactional
    public ResponseEntity<?> deleteBackup(UUID id) {
        Optional<Backup> backupOpt = repository.findById(id);
        if (backupOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Backup com id " + id + " não encontrado.");
        }

        repository.delete(backupOpt.get());
        return ResponseEntity.ok("Backup deletado com sucesso.");
    }
}
