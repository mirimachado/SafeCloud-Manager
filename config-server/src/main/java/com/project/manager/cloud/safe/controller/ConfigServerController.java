package com.project.manager.cloud.safe.controller;

import com.project.manager.cloud.safe.dto.ConfigServerRequestDTO;
import com.project.manager.cloud.safe.entity.ConfigServer;
import com.project.manager.cloud.safe.service.ConfigServerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/config_server")
public class ConfigServerController {

    @Autowired
    private ConfigServerService service;

    @GetMapping
    public ResponseEntity<List<ConfigServer>> getAll() {
        return service.getAllConfigs();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid ConfigServerRequestDTO data) {
        return service.createConfig(data);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody @Valid ConfigServerRequestDTO data) {
        return service.updateConfig(data);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        return service.deleteConfig(id);
    }
}
