package com.project.manager.cloud.safe.systemlog.repository;

import com.project.manager.cloud.safe.systemlog.entity.SystemLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SystemLogRepository extends JpaRepository<SystemLog, UUID> {
    @Override
    Optional<SystemLog> findById(UUID id);
}
