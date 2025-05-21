package com.project.manager.cloud.safe.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record DiscoveryServerRequestDTO(
        @NotBlank
        String serviceName,
        String endpoint,
        LocalDateTime lastSeen) {
}
