package com.project.manager.cloud.safe.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity(name = "config_server")
@Table(name = "config_server")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Builder
public class ConfigServer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String environment;

    private String configRepoUrl;

    public ConfigServer(String environment, String configRepoUrl) {
        this.environment = environment;
        this.configRepoUrl = configRepoUrl;
    }
}
