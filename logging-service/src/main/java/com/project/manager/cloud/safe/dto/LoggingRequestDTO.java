package com.project.manager.cloud.safe.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

public record LoggingRequestDTO(UUID id,

        @NotBlank
        String level,
                                @NotBlank
        String message,
                                @NotNull
        LocalDateTime timestamp,
                                String source
        ) {
}
