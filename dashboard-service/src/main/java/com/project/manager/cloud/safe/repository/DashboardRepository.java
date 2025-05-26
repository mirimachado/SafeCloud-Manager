package com.project.manager.cloud.safe.repository;

import com.project.manager.cloud.safe.entity.Dashboard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface DashboardRepository extends JpaRepository<Dashboard, UUID> {
    @Override
    Optional<Dashboard> findById(UUID id);
}
