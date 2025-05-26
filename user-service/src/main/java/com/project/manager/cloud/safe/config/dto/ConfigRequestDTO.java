package com.project.manager.cloud.safe.config.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record ConfigRequestDTO(
        UUID id,

        @NotBlank
        String key,

        @NotNull
        String value,

        Boolean system
) {}
