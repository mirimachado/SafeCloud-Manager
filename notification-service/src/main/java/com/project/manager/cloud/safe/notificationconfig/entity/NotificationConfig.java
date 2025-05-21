package com.project.manager.cloud.safe.notificationconfig.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity(name = "notification_config")
@Table(name = "notification_config")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
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

    public NotificationConfig(){

    }

    public NotificationConfig(UUID userId, Boolean emailEnabled, Boolean smsEnabled, Boolean pushEnabled) {
        this.userId = userId;
        this.emailEnabled = true;
        this.smsEnabled = false;
        this.pushEnabled = true;
    }


}
