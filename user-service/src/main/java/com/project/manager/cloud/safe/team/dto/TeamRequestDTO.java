package com.project.manager.cloud.safe.team.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.UUID;

public record TeamRequestDTO(UUID organizationId,
                             @NotBlank
                             String name,
                             @NotNull
                             Date createdAt,
                             @NotNull
                             Date updatedAt,
                             String description) {
}
