package com.project.manager.cloud.safe.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


import java.util.Date;
import java.util.UUID;

@Entity(name = "access_token")
@Table(name = "access_token")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class AccessToken {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotNull
    private String token;
    @NotNull
    private UUID userId;
    @NotBlank
    private Date expiresAt;
    @NotBlank
    private Date created;

    public AccessToken(){

    }

    public AccessToken(String token, UUID userId, Date expiresAt, Date created) {
        this.token = token;
        this.userId = userId;
        this.expiresAt = expiresAt;
        this.created = created;
    }


}
