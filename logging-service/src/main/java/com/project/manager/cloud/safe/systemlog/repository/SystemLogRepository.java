package com.project.manager.cloud.safe.systemlog.repository;

import com.project.manager.cloud.safe.systemlog.entity.SystemLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SystemLogRepository extends JpaRepository<SystemLog, Long> {
    @Override
    Optional<SystemLog> findById(Long id);
}
