package com.project.manager.cloud.safe.file.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.UUID;

public record FileRequestDTO(@NotBlank
                             String name,
                             @NotBlank
                             String type,
                             @NotNull
                             Long size,
                             Date uploadDate,
                             @NotNull
                             UUID ownerId
                             ) {
}
