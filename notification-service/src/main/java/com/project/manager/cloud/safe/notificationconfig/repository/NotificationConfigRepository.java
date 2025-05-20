package com.project.manager.cloud.safe.notificationconfig.repository;

import com.project.manager.cloud.safe.notificationconfig.entity.NotificationConfig;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NotificationConfigRepository extends JpaRepository<NotificationConfig, Long> {

    @Override
    Optional<NotificationConfig> findById(Long id);
}
