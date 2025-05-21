package com.project.manager.cloud.safe.healthcheck.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


import java.util.Date;
import java.util.UUID;

@Entity(name = "health_check")
@Table(name = "health_check")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class HealthCheck {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotNull
    private String serviceName;
    @NotNull
    private String status;
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkedAt;

    public HealthCheck(){

    }

    public HealthCheck(String serviceName, String status, Date checkedAt) {
        this.serviceName = serviceName;
        this.status = status;
        this.checkedAt = checkedAt;
    }


}
