package com.project.manager.cloud.safe.systemlog.controller;

import com.project.manager.cloud.safe.systemlog.dto.SystemLogRequestDTO;
import com.project.manager.cloud.safe.systemlog.entity.SystemLog;
import com.project.manager.cloud.safe.systemlog.service.SystemLogService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/system-logs")
public class SystemLogController {

    @Autowired
    private SystemLogService service;

    @GetMapping
    public ResponseEntity<List<SystemLog>> getAll() {
        return service.getAll();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid SystemLogRequestDTO data) {
        return service.create(data);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable UUID id, @RequestBody @Valid SystemLogRequestDTO data) {
        return service.update(id, data);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        return service.delete(id);
    }
}
