package com.project.manager.cloud.safe.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;


import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "audit_logs")
@Table(name = "audit_logs")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Builder
public class Auditlog {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotNull
    private UUID userId;
    @NotNull
    private String action;
    @CreationTimestamp
    private LocalDateTime timestamp;
    @NotBlank
    private String details;

    @Column(length = 100)
    private String ipAddress;

    @Column(length = 500)
    private String userAgent;

    @Column(length = 100)
    private String entityAffected;

    @Column(length = 100)
    private String entityId;

    @Column(nullable = false)
    private Boolean success;

    @Column(length = 50)
    private String method;

    @Column(length = 100)
    private String module;

    @Column(length = 1000)
    private String errorMessage;


}
