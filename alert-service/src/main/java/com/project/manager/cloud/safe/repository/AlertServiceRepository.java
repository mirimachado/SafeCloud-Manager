package com.project.manager.cloud.safe.repository;

import com.project.manager.cloud.safe.entity.AlertService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AlertServiceRepository extends JpaRepository<AlertService, Long> {
    Optional<AlertService> findById(Long id);
}
