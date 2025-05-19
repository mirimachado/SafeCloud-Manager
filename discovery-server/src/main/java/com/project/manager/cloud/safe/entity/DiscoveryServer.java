package com.project.manager.cloud.safe.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDateTime;

@Entity(name = "discoveryserver")
@Table(name = "discoveryserver")
@EqualsAndHashCode(of = "id")
@CrossOrigin
public class DiscoveryServer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public LocalDateTime getLastSeen() {
        return lastSeen;
    }

    public void setLastSeen(LocalDateTime lastSeen) {
        this.lastSeen = lastSeen;
    }
}
