package com.project.manager.cloud.safe.healthcheck.controller;

import com.project.manager.cloud.safe.healthcheck.dto.HealthCheckRequestDTO;
import com.project.manager.cloud.safe.healthcheck.entity.HealthCheck;
import com.project.manager.cloud.safe.healthcheck.service.HealthCheckService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/health-check")
public class HealthCheckController {

    @Autowired
    private HealthCheckService service;

    @GetMapping
    public ResponseEntity<List<HealthCheck>> getAll() {
        return service.getAll();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid HealthCheckRequestDTO data) {
        return service.create(data);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody @Valid HealthCheckRequestDTO data) {
        return service.update(data);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        return service.delete(id);
    }
}
