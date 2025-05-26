package com.project.manager.cloud.safe.systemsettings.controller;

import com.project.manager.cloud.safe.systemsettings.dto.SystemSettingsRequestDTO;
import com.project.manager.cloud.safe.systemsettings.entity.SystemSettings;
import com.project.manager.cloud.safe.systemsettings.service.SystemSettingsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/system_settings")
public class SystemSettingsController {

    @Autowired
    private SystemSettingsService service;

    @GetMapping
    public ResponseEntity<List<SystemSettings>> getAll() {
        return service.getAllSettings();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid SystemSettingsRequestDTO data) {
        return service.createSetting(data);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody @Valid SystemSettingsRequestDTO data) {
        return service.updateSetting(data);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        return service.deleteSetting(id);
    }
}
