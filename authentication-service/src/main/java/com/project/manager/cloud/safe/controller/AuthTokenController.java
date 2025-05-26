package com.project.manager.cloud.safe.controller;

import com.project.manager.cloud.safe.dto.requests.AuthTokenRequestDTO;
import com.project.manager.cloud.safe.service.AuthTokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/auth_tokens")
public class AuthTokenController {

    @Autowired
    private AuthTokenService service;

    @GetMapping
    public ResponseEntity<?> getAllTokens() {
        return service.getAuthTokens();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid AuthTokenRequestDTO data) {
        return service.createAuthToken(data);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody @Valid AuthTokenRequestDTO data) {
        return service.updateAuthToken(data);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        return service.deleteAuthToken(id);
    }
}
