package com.project.manager.cloud.safe.config.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.UUID;

@Entity(name = "configuration")
@Table(name = "configuration")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Config {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
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

}
