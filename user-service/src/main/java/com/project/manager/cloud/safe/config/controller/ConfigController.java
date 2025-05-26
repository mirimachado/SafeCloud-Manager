package com.project.manager.cloud.safe.config.controller;

import com.project.manager.cloud.safe.config.dto.ConfigRequestDTO;
import com.project.manager.cloud.safe.config.entity.Config;
import com.project.manager.cloud.safe.config.service.ConfigService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/configs")
public class ConfigController {

    @Autowired
    private ConfigService service;

    @GetMapping
    public ResponseEntity<List<Config>> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Config> getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid ConfigRequestDTO dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable UUID id, @RequestBody @Valid ConfigRequestDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        return service.delete(id);
    }
}
