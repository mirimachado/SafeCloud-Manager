package com.project.manager.cloud.safe.entity;

import com.project.manager.cloud.safe.enums.SeverityAlerts;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "alert_service")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Builder
public class AlertService {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(updatable = false, nullable = false)
    private UUID id;

    @NotBlank
    @Column(nullable = false)
    private String message;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SeverityAlerts severity;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime timestamp;

    @NotNull
    @Column(nullable = false)
    private Boolean resolved;

    @Column
    private LocalDateTime resolvedAt;

    @Column(length = 1000)
    private String resolutionNote;

    @Column(length = 255)
    private String source;

    @Column(length = 100)
    private String category;

    @Column(length = 1000)
    private String context;

    @Column(length = 255)
    private String assignedTo;

    @Column(length = 100, unique = true)
    private String code;

    @Column(length = 255)
    private String relatedEntityId;

    @Column(length = 100)
    private String relatedEntityType;

    @Column
    private Integer priority;


}
