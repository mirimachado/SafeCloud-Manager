package com.project.manager.cloud.safe.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;


import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "backup")
@Table(name = "backup")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Backup {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotNull
    private UUID userId;
    @NotNull
    private String filePath;
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(length = 255, nullable = false)
    private String fileName;

    @Column(nullable = false)
    private Long fileSize;

    @Column(length = 100, nullable = false)
    private String fileType;

    @Column(length = 100, nullable = false)
    private String storageLocation;

    @Column(length = 50, nullable = false)
    private String status;

    @Column(length = 256, unique = true, nullable = false)
    private String hashChecksum;

    @Column(nullable = true)
    private LocalDateTime expiresAt;

    @Column(nullable = true)
    private LocalDateTime lastVerifiedAt;

    @Column(nullable = false)
    private boolean deleted = false;

    @Column(length = 500)
    private String notes;

    public Backup(){

    }

    public Backup(UUID userId, String filePath, LocalDateTime createdAt) {
        this.userId = userId;
        this.filePath = filePath;
        this.createdAt = createdAt;
    }

}
