package com.project.manager.cloud.safe.systemsettings.repository;

import com.project.manager.cloud.safe.systemsettings.entity.SystemSettings;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SystemSettingsRepository extends JpaRepository<SystemSettings, Long> {
    @Override
    Optional<SystemSettings> findById(Long id);
}
