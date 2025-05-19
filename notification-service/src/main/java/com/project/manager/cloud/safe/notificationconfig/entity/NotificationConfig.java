package com.project.manager.cloud.safe.notificationconfig.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import org.springframework.web.bind.annotation.CrossOrigin;

@Entity(name = "notificationconfig")
@Table(name = "notificationconfig")
@EqualsAndHashCode(of = "id")
@CrossOrigin
public class NotificationConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private Long userId;
    @NotNull
    private Boolean emailEnabled;
    @NotNull
    private Boolean smsEnabled;
    @NotNull
    private Boolean pushEnabled;

    public NotificationConfig(){

    }

    public NotificationConfig(Long userId, Boolean emailEnabled, Boolean smsEnabled, Boolean pushEnabled) {
        this.userId = userId;
        this.emailEnabled = true;
        this.smsEnabled = false;
        this.pushEnabled = true;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Boolean getEmailEnabled() {
        return emailEnabled;
    }

    public void setEmailEnabled(Boolean emailEnabled) {
        this.emailEnabled = emailEnabled;
    }

    public Boolean getSmsEnabled() {
        return smsEnabled;
    }

    public void setSmsEnabled(Boolean smsEnabled) {
        this.smsEnabled = smsEnabled;
    }

    public Boolean getPushEnabled() {
        return pushEnabled;
    }

    public void setPushEnabled(Boolean pushEnabled) {
        this.pushEnabled = pushEnabled;
    }
}
