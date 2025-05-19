package com.project.manager.cloud.safe.entity;

import com.project.manager.cloud.safe.enums.SeverityAlerts;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDateTime;

@Entity(name = "alertservice")
@Table(name = "alertservice")
@EqualsAndHashCode(of = "id")
@CrossOrigin
public class AlertService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String message;
    @NotNull
    private SeverityAlerts severity;
    @CreationTimestamp
    private LocalDateTime timestamp;
    @NotNull
    private Boolean resolved;


    public AlertService(){

    }

    public AlertService(String message, SeverityAlerts severity, LocalDateTime timestamp, Boolean resolved) {
        this.message = message;
        this.severity = severity;
        this.timestamp = timestamp;
        this.resolved = false;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public SeverityAlerts getSeverity() {
        return severity;
    }

    public void setSeverity(SeverityAlerts severity) {
        this.severity = severity;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Boolean getResolved() {
        return resolved;
    }

    public void setResolved(Boolean resolved) {
        this.resolved = resolved;
    }
}
