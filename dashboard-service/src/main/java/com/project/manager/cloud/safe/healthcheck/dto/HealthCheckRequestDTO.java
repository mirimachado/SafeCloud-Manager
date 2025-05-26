package com.project.manager.cloud.safe.healthcheck.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.Date;
import java.util.UUID;

public record HealthCheckRequestDTO(UUID id,
                                    @NotBlank
                                    String serviceName,
                                    @NotBlank
                                    String status,
                                    Date checkedAt
                                    ) {
}
