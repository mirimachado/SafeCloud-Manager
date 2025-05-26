package com.project.manager.cloud.safe.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

public record BackupRequestDTO(
        UUID id,
        @NotNull UUID userId,
        @NotBlank String filePath,
        @NotBlank String fileName,
        @NotNull Long fileSize,
        @NotBlank String fileType,
        @NotBlank String storageLocation,
        @NotBlank String status,
        @NotBlank String hashChecksum,
        LocalDateTime expiresAt,
        LocalDateTime lastVerifiedAt,
        String notes
) {}
