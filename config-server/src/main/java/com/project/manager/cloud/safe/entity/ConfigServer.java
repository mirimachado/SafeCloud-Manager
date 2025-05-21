package com.project.manager.cloud.safe.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity(name = "config_server")
@Table(name = "config_server")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
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
