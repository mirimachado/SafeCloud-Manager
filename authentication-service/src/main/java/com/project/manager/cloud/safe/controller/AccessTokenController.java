package com.project.manager.cloud.safe.controller;

import com.project.manager.cloud.safe.dto.requests.AccessTokenRequestDTO;
import com.project.manager.cloud.safe.service.AccessTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/access_token")
public class AccessTokenController {

    @Autowired
    private AccessTokenService service;

    @GetMapping
    public ResponseEntity<?> getAccessToken() {
        return service.getAccessToken();
    }

    @PostMapping
    public ResponseEntity<?> createAccessToken(@RequestBody AccessTokenRequestDTO data) {
        return service.createAccessToken(data);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAccessToken(@PathVariable UUID id,
                                               @RequestBody AccessTokenRequestDTO data) {
        return service.updateAccessToken(id, data);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAccessToken(@PathVariable UUID id) {
        return service.deleteAccessToken(id);
    }
}
