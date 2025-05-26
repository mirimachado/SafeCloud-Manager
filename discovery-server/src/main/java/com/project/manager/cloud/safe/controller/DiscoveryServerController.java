package com.project.manager.cloud.safe.controller;

import com.project.manager.cloud.safe.dto.DiscoveryServerRequestDTO;
import com.project.manager.cloud.safe.entity.DiscoveryServer;
import com.project.manager.cloud.safe.service.DiscoveryServerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/discovery_server")
public class DiscoveryServerController {

    @Autowired
    private DiscoveryServerService service;

    @GetMapping
    public ResponseEntity<List<DiscoveryServer>> getAll() {
        return service.getAll();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid DiscoveryServerRequestDTO data) {
        return service.create(data);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable UUID id, @RequestBody @Valid DiscoveryServerRequestDTO data) {
        return service.update(id, data);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        return service.delete(id);
    }
}
