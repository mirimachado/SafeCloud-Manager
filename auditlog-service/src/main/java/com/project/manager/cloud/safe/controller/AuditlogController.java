package com.project.manager.cloud.safe.controller;

import com.project.manager.cloud.safe.dto.AuditlogRequestDTO;
import com.project.manager.cloud.safe.service.AuditlogService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/audit_log")
public class AuditlogController {



    @Autowired
    private AuditlogService auditlogService;

    @GetMapping
    public ResponseEntity getAuditLogs(){
        return auditlogService.getAuditLogs();

    }

    @PostMapping
    public ResponseEntity createAlerts(@RequestBody @Valid AuditlogRequestDTO data) {
        return auditlogService.createAuditLog(data);
    }

    @PutMapping()
    public ResponseEntity updateAlerts(@RequestBody @Valid AuditlogRequestDTO data) {
        return auditlogService.updateAuditLog(data);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAlerts(@PathVariable UUID id) {
        return auditlogService.deleteAuditLog(id);
    }


}
