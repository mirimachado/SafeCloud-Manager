package com.project.manager.cloud.safe.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;


import java.util.Date;
import java.util.UUID;

@Entity(name = "access_token")
@Table(name = "access_token")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Builder
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



}
