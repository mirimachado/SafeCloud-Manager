package com.project.manager.cloud.safe.systemsettings.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record SystemSettingsRequestDTO(
        UUID id,
        @NotNull @NotBlank String key,
        @NotNull @NotBlank String value
) {
}
