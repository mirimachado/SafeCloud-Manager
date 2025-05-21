package com.project.manager.cloud.safe.systemsettings.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.Date;

public record SystemSettingsRequestDTO(@NotBlank
                                       String key,
                                       @NotBlank
                                       String value,
                                       Date updatedAt
                                       ) {
}
