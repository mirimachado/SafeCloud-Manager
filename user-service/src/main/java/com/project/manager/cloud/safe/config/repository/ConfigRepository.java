package com.project.manager.cloud.safe.config.repository;

import com.project.manager.cloud.safe.config.entity.Config;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ConfigRepository extends JpaRepository<Config, Long> {
    @Override
    Optional<Config> findById(Long id);
}
