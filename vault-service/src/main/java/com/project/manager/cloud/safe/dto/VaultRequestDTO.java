package com.project.manager.cloud.safe.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

public record VaultRequestDTO(
        @NotNull
        UUID userId,
        @NotBlank
        String dataKey,
        @NotBlank
        String dataValue,
        LocalDateTime createdAt
        ) {
}
