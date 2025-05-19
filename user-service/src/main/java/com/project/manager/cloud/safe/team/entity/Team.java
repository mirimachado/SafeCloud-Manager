package com.project.manager.cloud.safe.team.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Date;

@Entity(name = "team")
@Table(name = "team")
@EqualsAndHashCode(of = "id")
@CrossOrigin
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private Long organizationId;
    @NotNull
    private String name;

    private Date createdAt;

    public Team(){

    }

    public Team(Long organizationId, String name, Date createdAt) {
        this.organizationId = organizationId;
        this.name = name;
        this.createdAt = createdAt;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
