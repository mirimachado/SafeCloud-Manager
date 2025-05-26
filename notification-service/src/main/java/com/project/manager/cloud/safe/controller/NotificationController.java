package com.project.manager.cloud.safe.controller;

import com.project.manager.cloud.safe.dto.NotificationRequestDTO;
import com.project.manager.cloud.safe.entity.Notification;
import com.project.manager.cloud.safe.service.NotificationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private NotificationService service;

    @GetMapping
    public ResponseEntity<List<Notification>> getAll() {
        return service.getAll();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<Optional<Notification>> getByUser(@PathVariable UUID userId) {
        return service.getByUser(userId);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid NotificationRequestDTO data) {
        return service.create(data);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable UUID id, @RequestBody @Valid NotificationRequestDTO data) {
        return service.update(id, data);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        return service.delete(id);
    }
}
