package com.project.manager.cloud.safe.systemsettings.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Date;

@Entity(name = "systemsettings")
@Table(name = "systemsettings")
@EqualsAndHashCode(of = "id")
@CrossOrigin
public class SystemSettings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
