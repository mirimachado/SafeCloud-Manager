package com.project.manager.cloud.safe.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

public record DashboardRequestDTO(@NotNull
                                  UUID userId,
                                  @NotBlank
                                  String configJson,
                                  LocalDateTime lastUpdated
                                  ) {
}
