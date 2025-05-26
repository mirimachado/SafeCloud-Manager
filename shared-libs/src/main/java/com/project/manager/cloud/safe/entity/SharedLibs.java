package com.project.manager.cloud.safe.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity(name = "shared_libs")
@Table(name = "shared_libs")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Builder
public class SharedLibs {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    private String version;

    public SharedLibs(String name, String version) {
        this.name = name;
        this.version = version;
    }
}
