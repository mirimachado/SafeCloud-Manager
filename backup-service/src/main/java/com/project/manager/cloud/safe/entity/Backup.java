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

    public Backup(){

    }

    public Backup(UUID userId, String filePath, LocalDateTime createdAt) {
        this.userId = userId;
        this.filePath = filePath;
        this.createdAt = createdAt;
    }

}
