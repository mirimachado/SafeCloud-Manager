package com.project.manager.cloud.safe.service;

import com.project.manager.cloud.safe.dto.NotificationRequestDTO;
import com.project.manager.cloud.safe.entity.Notification;
import com.project.manager.cloud.safe.repository.NotificationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository repository;

    public ResponseEntity<List<Notification>> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    public ResponseEntity<Optional<Notification>> getByUser(UUID userId) {
        return ResponseEntity.ok(repository.findByUserId(userId));
    }

    @Transactional
    public ResponseEntity<?> create(NotificationRequestDTO data) {
        Notification notification = Notification.builder()
                .title(data.title())
                .message(data.message())
                .userId(data.userId())
                .read(data.read() != null ? data.read() : false)
                .build();

        repository.save(notification);
        return ResponseEntity.ok("Notificação criada com sucesso.");
    }

    @Transactional
    public ResponseEntity<?> update(UUID id, NotificationRequestDTO data) {
        Optional<Notification> optional = repository.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Notificação com id " + id + " não encontrada.");
        }

        Notification notification = optional.get();
        notification.setTitle(data.title());
        notification.setMessage(data.message());
        notification.setUserId(data.userId());
        notification.setRead(data.read());

        repository.save(notification);
        return ResponseEntity.ok("Notificação atualizada com sucesso.");
    }

    @Transactional
    public ResponseEntity<?> delete(UUID id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Notificação com id " + id + " não encontrada.");
        }

        repository.deleteById(id);
        return ResponseEntity.ok("Notificação removida com sucesso.");
    }
}
