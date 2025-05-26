package com.project.manager.cloud.safe.controller;

import com.project.manager.cloud.safe.dto.requests.ApiKeyRequestDTO;
import com.project.manager.cloud.safe.service.ApiKeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api_key")
public class ApiKeyController {

    @Autowired
    private ApiKeyService service;

    @GetMapping
    public ResponseEntity<?> getApiKeys() {
        return service.getApiKeys();
    }

    @PostMapping
    public ResponseEntity<?> createApiKey(@RequestBody ApiKeyRequestDTO data) {
        return service.createApiKey(data);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateApiKey(@PathVariable UUID id,
                                          @RequestBody ApiKeyRequestDTO data) {
        return service.updateApiKey(id, data);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteApiKey(@PathVariable UUID id) {
        return service.deleteApiKey(id);
    }
}
