package com.project.manager.cloud.safe.usersettings.repository;

import com.project.manager.cloud.safe.usersettings.entity.UserSettings;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserSettingsRepository extends JpaRepository<UserSettings, Long> {

    @Override
    Optional<UserSettings> findById(Long id);
}
