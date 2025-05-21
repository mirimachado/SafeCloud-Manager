package com.project.manager.cloud.safe.dto.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

public record AuthTokenRequestDTO(@NotBlank
                                  String token,
                                  @NotNull
                                  UUID userId,
                                  LocalDateTime expiresAt

                                  ) {
}
