package com.project.manager.cloud.safe.healthcheck.repository;

import com.project.manager.cloud.safe.healthcheck.entity.HealthCheck;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface HealthCheckRepository extends JpaRepository<HealthCheck, UUID>{
    @Override
    Optional<HealthCheck> findById(UUID id);
}
