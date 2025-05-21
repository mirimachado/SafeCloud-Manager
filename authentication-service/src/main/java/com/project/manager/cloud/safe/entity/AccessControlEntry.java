package com.project.manager.cloud.safe.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity(name = "access_control_entry")
@Table(name = "access_control_entry")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class AccessControlEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotNull
    private UUID userId;
    @NotNull
    private String resource;
    @NotNull
    private String permission;

    public AccessControlEntry(){

    }

    public AccessControlEntry(UUID userId, String resource, String permission) {
        this.userId = userId;
        this.resource = resource;
        this.permission = permission;
    }

}
