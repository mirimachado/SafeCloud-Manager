package com.project.manager.cloud.safe.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "logging")
@Table(name = "logging")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Logging {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotBlank
    private String level;
    @NotBlank
    private String message;

    @CreationTimestamp
    private LocalDateTime timestamp;

    private String source;

    public Logging(){

    }

    public Logging(String level, String message, LocalDateTime timestamp, String source) {
        this.level = level;
        this.message = message;
        this.timestamp = timestamp;
        this.source = source;
    }

}
