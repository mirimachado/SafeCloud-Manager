package com.project.manager.cloud.safe.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

public record AuditlogRequestDTO(
        UUID id,
        @NotNull UUID userId,
        @NotBlank String action,
        @NotNull LocalDateTime timestamp,
        @NotBlank String details,
        String ipAddress,
        String userAgent,
        String entityAffected,
        String entityId,
        String method,
        String module,
        String errorMessage
) {
}


