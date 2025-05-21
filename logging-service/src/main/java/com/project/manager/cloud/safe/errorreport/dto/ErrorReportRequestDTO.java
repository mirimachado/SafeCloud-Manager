package com.project.manager.cloud.safe.errorreport.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.UUID;

public record ErrorReportRequestDTO(
                                    @NotNull
                                    UUID userId,
                                    @NotBlank
                                    String errorMessage,
                                    @NotBlank
                                    String stackTrace,
                                    Date createdAt
                                    ) {
}
