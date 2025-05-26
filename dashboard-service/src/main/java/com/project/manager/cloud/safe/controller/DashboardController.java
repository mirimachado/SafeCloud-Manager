package com.project.manager.cloud.safe.controller;

import com.project.manager.cloud.safe.dto.DashboardRequestDTO;
import com.project.manager.cloud.safe.entity.Dashboard;
import com.project.manager.cloud.safe.service.DashboardService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    private DashboardService service;

    @GetMapping
    public ResponseEntity<List<Dashboard>> getAll() {
        return service.getAllDashboards();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid DashboardRequestDTO data) {
        return service.createDashboard(data);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody @Valid DashboardRequestDTO data) {
        return service.updateDashboard(data);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        return service.deleteDashboard(id);
    }
}
