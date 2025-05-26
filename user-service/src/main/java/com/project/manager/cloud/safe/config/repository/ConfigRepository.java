package com.project.manager.cloud.safe.config.repository;

import com.project.manager.cloud.safe.config.entity.Config;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ConfigRepository extends JpaRepository<Config, UUID> {
    @Override
    Optional<Config> findById(UUID id);
}
