package com.project.manager.cloud.safe.dto.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.UUID;

public record ApiKeyRequestDTO(UUID id,
                               @NotBlank
                               String key,
                               @NotBlank
                               String label,
                               @NotNull
                               UUID userId,
                               Date createdAt
                               ) {
}
