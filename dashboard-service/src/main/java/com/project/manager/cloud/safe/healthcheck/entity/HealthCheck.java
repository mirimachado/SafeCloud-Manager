package com.project.manager.cloud.safe.healthcheck.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Date;

@Entity(name = "healthcheck")
@Table(name = "healthcheck")
@EqualsAndHashCode(of = "id")
@CrossOrigin
public class HealthCheck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCheckedAt() {
        return checkedAt;
    }

    public void setCheckedAt(Date checkedAt) {
        this.checkedAt = checkedAt;
    }
}
