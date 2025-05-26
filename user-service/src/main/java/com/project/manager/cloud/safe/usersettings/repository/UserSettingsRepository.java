package com.project.manager.cloud.safe.usersettings.repository;

import com.project.manager.cloud.safe.usersettings.entity.UserSettings;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserSettingsRepository extends JpaRepository<UserSettings, UUID> {

    @Override
    Optional<UserSettings> findById(UUID id);
    Optional<UserSettings> findByUserId(UUID userId);



}
