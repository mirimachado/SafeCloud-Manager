package com.project.manager.cloud.safe.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "discovery_server")
@Table(name = "discovery_server")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class DiscoveryServer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull
    private String serviceName;

    private String endpoint;
    @UpdateTimestamp
    private LocalDateTime lastSeen;

    public DiscoveryServer(){

    }

    public DiscoveryServer(String serviceName, String endpoint, LocalDateTime lastSeen) {
        this.serviceName = serviceName;
        this.endpoint = endpoint;
        this.lastSeen = lastSeen;
    }


}
