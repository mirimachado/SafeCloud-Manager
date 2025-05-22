package com.project.manager.cloud.safe.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "access_control_entry")
@Table(name = "access_control_entry")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Builder
public class AccessControlEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotNull
    private UUID userId;
    @NotNull
    private String resource;
    @NotNull
    private String permission;

    @Column(nullable = true)
    private UUID roleId;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime grantedAt;

    @Column(nullable = true)
    private UUID grantedBy;

    @Column(nullable = true)
    private LocalDateTime expiresAt;

    @Column(nullable = false)
    private boolean active = true;

    @Column(columnDefinition = "TEXT")
    private String conditions;

    @Column(length = 500)
    private String notes;



}
