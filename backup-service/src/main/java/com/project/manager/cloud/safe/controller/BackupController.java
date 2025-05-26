package com.project.manager.cloud.safe.controller;

import com.project.manager.cloud.safe.dto.BackupRequestDTO;
import com.project.manager.cloud.safe.service.BackupService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/backups")
public class BackupController {

    @Autowired
    private BackupService backupService;

    @GetMapping
    public ResponseEntity<?> getAllBackups() {
        return backupService.getAllBackups();
    }

    @PostMapping
    public ResponseEntity<?> createBackup(@RequestBody @Valid BackupRequestDTO data) {
        return backupService.createBackup(data);
    }

    @PutMapping
    public ResponseEntity<?> updateBackup(@RequestBody @Valid BackupRequestDTO data) {
        return backupService.updateBackup(data);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBackup(@PathVariable UUID id) {
        return backupService.deleteBackup(id);
    }
}
