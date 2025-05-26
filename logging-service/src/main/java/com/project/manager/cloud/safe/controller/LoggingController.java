package com.project.manager.cloud.safe.controller;

import com.project.manager.cloud.safe.dto.LoggingRequestDTO;
import com.project.manager.cloud.safe.entity.Logging;
import com.project.manager.cloud.safe.service.LoggingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/logging")
public class LoggingController {

    @Autowired
    private LoggingService service;

    @GetMapping
    public ResponseEntity<List<Logging>> getAll() {
        return service.getAll();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid LoggingRequestDTO data) {
        return service.create(data);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable UUID id, @RequestBody @Valid LoggingRequestDTO data) {
        return service.update(id, data);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        return service.delete(id);
    }
}
