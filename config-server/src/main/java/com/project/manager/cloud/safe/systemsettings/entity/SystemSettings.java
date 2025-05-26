package com.project.manager.cloud.safe.systemsettings.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Entity(name = "system_settings")
@Table(name = "system_settings")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Builder
public class SystemSettings {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotNull
    private String key;
    @NotNull
    private String value;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;



}
