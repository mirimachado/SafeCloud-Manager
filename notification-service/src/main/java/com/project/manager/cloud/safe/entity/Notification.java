package com.project.manager.cloud.safe.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "notification")
@Table(name = "notification")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank
    private String title;
    @NotBlank
    private String message;
    @NotNull
    private UUID userId;

    private Boolean read;
    @UpdateTimestamp
    private LocalDateTime sentAt;


    public Notification(){

    }

    public Notification(String title, String message, UUID userId, Boolean read, LocalDateTime sentAt) {
        this.title = title;
        this.message = message;
        this.userId = userId;
        this.read = false;
        this.sentAt = sentAt;
    }

}
