package com.project.manager.cloud.safe.dto.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

public record AccessControlEntryRequestDTO(
        UUID id,

        @NotNull
        UUID userId,

        @NotBlank
        String resource,

        @NotBlank
        String permission,

        UUID roleId,

        UUID grantedBy,

        LocalDateTime expiresAt,

        Boolean active,

        String conditions,

        String notes
) {}
