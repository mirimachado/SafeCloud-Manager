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

@Entity(name = "dashboard")
@Table(name = "dashboard")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Dashboard {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotNull
    private UUID userId;
    @NotNull
    private String configJson;
    @CreationTimestamp
    private LocalDateTime lastUpdated;

    public Dashboard(){

    }

    public Dashboard(String configJson, UUID userId, LocalDateTime lastUpdated) {
        this.configJson = configJson;
        this.userId = userId;
        this.lastUpdated = lastUpdated;
    }

}
