package com.project.manager.cloud.safe.healthcheck.repository;

import com.project.manager.cloud.safe.healthcheck.entity.HealthCheck;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HealthCheckRepository extends JpaRepository<HealthCheck, Long>{
    @Override
    Optional<HealthCheck> findById(Long id);
}
