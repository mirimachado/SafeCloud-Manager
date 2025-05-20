package com.project.manager.cloud.safe.repository;

import com.project.manager.cloud.safe.entity.Logging;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoggingRepository extends JpaRepository<Logging, Long> {
    @Override
    Optional<Logging> findById(Long id);
}
