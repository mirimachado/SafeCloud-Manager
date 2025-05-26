package com.project.manager.cloud.safe.dto.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.UUID;

public record AccessTokenRequestDTO(UUID id,
                                    @NotBlank
                                    String token,
                                    @NotNull
                                    UUID userId,
                                    @NotNull
                                    Date expiresAt,
                                    @NotNull
                                    Date created
                                    ) {
}
