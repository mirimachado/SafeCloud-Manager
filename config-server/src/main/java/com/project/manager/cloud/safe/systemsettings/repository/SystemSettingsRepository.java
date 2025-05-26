package com.project.manager.cloud.safe.systemsettings.repository;

import com.project.manager.cloud.safe.systemsettings.entity.SystemSettings;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SystemSettingsRepository extends JpaRepository<SystemSettings, UUID> {
    @Override
    Optional<SystemSettings> findById(UUID id);
}
