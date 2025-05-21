package com.project.manager.cloud.safe.dto.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record AccessControlEntryRequestDTO(@NotNull
                                           UUID userId,
                                           @NotBlank
                                           String resource,
                                           @NotBlank
                                           String permission

                                           ) {
}
