package com.project.manager.cloud.safe.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import org.springframework.web.bind.annotation.CrossOrigin;

@Entity(name = "accesscontrolentry")
@Table(name = "accesscontrolentry")
@EqualsAndHashCode(of = "id")
@CrossOrigin
public class AccessControlEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    @NotNull
    private String resource;
    @NotNull
    private String permission;

    public AccessControlEntry(){

    }

    public AccessControlEntry(Long userId, String resource, String permission) {
        this.userId = userId;
        this.resource = resource;
        this.permission = permission;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
