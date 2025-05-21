package com.project.manager.cloud.safe.systemsettings.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Entity(name = "system_settings")
@Table(name = "system_settings")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
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

    public SystemSettings(){

    }

    public SystemSettings(String key, String value, Date updatedAt) {
        this.key = key;
        this.value = value;
        this.updatedAt = updatedAt;
    }


}
