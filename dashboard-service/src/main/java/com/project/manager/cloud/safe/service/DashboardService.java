package com.project.manager.cloud.safe.service;

import com.project.manager.cloud.safe.dto.DashboardRequestDTO;
import com.project.manager.cloud.safe.entity.Dashboard;
import com.project.manager.cloud.safe.repository.DashboardRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DashboardService {

    @Autowired
    private DashboardRepository repository;

    public ResponseEntity<List<Dashboard>> getAllDashboards() {
        return ResponseEntity.ok(repository.findAll());
    }

    @Transactional
    public ResponseEntity<?> createDashboard(DashboardRequestDTO data) {
        Dashboard dashboard = Dashboard.builder()
                .userId(data.userId())
                .configJson(data.configJson())
                .lastUpdated(LocalDateTime.now())
                .build();

        repository.save(dashboard);
        return ResponseEntity.ok("Dashboard criado com sucesso.");
    }

    @Transactional
    public ResponseEntity<?> updateDashboard(DashboardRequestDTO data) {
        Optional<Dashboard> dashboardOpt = repository.findById(data.id());
        if (dashboardOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Dashboard com id " + data.id() + " não encontrado.");
        }

        Dashboard dashboard = dashboardOpt.get();
        dashboard.setUserId(data.userId());
        dashboard.setConfigJson(data.configJson());
        dashboard.setLastUpdated(LocalDateTime.now());

        repository.save(dashboard);
        return ResponseEntity.ok("Dashboard atualizado com sucesso.");
    }

    @Transactional
    public ResponseEntity<?> deleteDashboard(UUID id) {
        Optional<Dashboard> dashboardOpt = repository.findById(id);
        if (dashboardOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Dashboard com id " + id + " não encontrado.");
        }

        repository.delete(dashboardOpt.get());
        return ResponseEntity.ok("Dashboard deletado com sucesso.");
    }
}
