package com.project.manager.cloud.safe.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

public record NotificationRequestDTO(
        @NotBlank
        String title,
        @NotBlank
        String message,
        @NotNull
        UUID userId,
        LocalDateTime sentAt
        ) {
}
