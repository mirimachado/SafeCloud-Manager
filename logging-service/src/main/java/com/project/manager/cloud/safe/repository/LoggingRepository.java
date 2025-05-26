package com.project.manager.cloud.safe.repository;

import com.project.manager.cloud.safe.entity.Logging;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface LoggingRepository extends JpaRepository<Logging, UUID> {
    @Override
    Optional<Logging> findById(UUID id);
}
