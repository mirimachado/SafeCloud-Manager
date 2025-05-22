package com.project.manager.cloud.safe.repository;

import com.project.manager.cloud.safe.entity.AlertService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AlertServiceRepository extends JpaRepository<AlertService, UUID> {
    Optional<AlertService> findById(UUID id);
    Optional<AlertService> findByCode(String code);
}
