package com.project.manager.cloud.safe.usersettings.controller;

import com.project.manager.cloud.safe.usersettings.dto.UserSettingsRequestDTO;
import com.project.manager.cloud.safe.usersettings.entity.UserSettings;
import com.project.manager.cloud.safe.usersettings.service.UserSettingsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user_settings")
public class UserSettingsController {

    @Autowired
    private UserSettingsService service;

    @GetMapping
    public ResponseEntity<List<UserSettings>> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getByUserId(@PathVariable UUID userId) {
        return service.getByUserId(userId);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid UserSettingsRequestDTO dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable UUID id, @RequestBody @Valid UserSettingsRequestDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        return service.delete(id);
    }
}
