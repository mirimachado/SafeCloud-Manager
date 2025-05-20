package com.project.manager.cloud.safe.repository;

import com.project.manager.cloud.safe.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    @Override
    Optional<Notification> findById(Long id);
}
