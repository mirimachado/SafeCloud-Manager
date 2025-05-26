package com.project.manager.cloud.safe.repository;

import com.project.manager.cloud.safe.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface NotificationRepository extends JpaRepository<Notification, UUID> {
    @Override
    Optional<Notification> findById(UUID id);
    Optional<Notification> findByUserId(UUID userId);
}
