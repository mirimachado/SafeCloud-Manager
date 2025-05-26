package com.project.manager.cloud.safe.notificationconfig.dto;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record NotificationConfigRequestDTO(
        @NotNull UUID userId,
        @NotNull Boolean emailEnabled,
        @NotNull Boolean smsEnabled,
        @NotNull Boolean pushEnabled
) {
}
