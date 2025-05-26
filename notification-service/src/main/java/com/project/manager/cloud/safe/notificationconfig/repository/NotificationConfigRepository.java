package com.project.manager.cloud.safe.notificationconfig.repository;

import com.project.manager.cloud.safe.notificationconfig.entity.NotificationConfig;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface NotificationConfigRepository extends JpaRepository<NotificationConfig, UUID> {

    @Override
    Optional<NotificationConfig> findById(UUID id);
}
