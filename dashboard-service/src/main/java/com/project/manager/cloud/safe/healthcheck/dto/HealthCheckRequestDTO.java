package com.project.manager.cloud.safe.healthcheck.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.Date;

public record HealthCheckRequestDTO(@NotBlank
                                    String serviceName,
                                    @NotBlank
                                    String status,
                                    Date checkedAt
                                    ) {
}
