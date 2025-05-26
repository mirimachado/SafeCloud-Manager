package com.project.manager.cloud.safe.notificationconfig.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.UUID;

@Entity(name = "notification_config")
@Table(name = "notification_config")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Builder
public class NotificationConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotNull
    private UUID userId;
    @NotNull
    private Boolean emailEnabled;
    @NotNull
    private Boolean smsEnabled;
    @NotNull
    private Boolean pushEnabled;



}
