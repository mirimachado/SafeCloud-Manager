package com.project.manager.cloud.safe.notificationconfig.controller;

import com.project.manager.cloud.safe.notificationconfig.dto.NotificationConfigRequestDTO;
import com.project.manager.cloud.safe.notificationconfig.entity.NotificationConfig;
import com.project.manager.cloud.safe.notificationconfig.service.NotificationConfigService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/notification-configs")
public class NotificationConfigController {

    @Autowired
    private NotificationConfigService service;

    @GetMapping
    public ResponseEntity<List<NotificationConfig>> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotificationConfig> getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid NotificationConfigRequestDTO data) {
        return service.create(data);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable UUID id, @RequestBody @Valid NotificationConfigRequestDTO data) {
        return service.update(id, data);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        return service.delete(id);
    }
}
