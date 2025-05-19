package com.project.manager.cloud.safe.config.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import org.springframework.web.bind.annotation.CrossOrigin;

@Entity(name = "configuration")
@Table(name = "configuration")
@EqualsAndHashCode(of = "id")
@CrossOrigin
public class Config {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String key;
    @NotNull
    private String value;

    private Boolean system;

    public Config(){

    }

    public Config(String key, String value, Boolean system) {
        this.key = key;
        this.value = value;
        this.system = system;
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

    public Boolean getSystem() {
        return system;
    }

    public void setSystem(Boolean system) {
        this.system = system;
    }
}
