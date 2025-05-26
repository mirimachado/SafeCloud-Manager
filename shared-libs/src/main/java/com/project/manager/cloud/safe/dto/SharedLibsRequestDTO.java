package com.project.manager.cloud.safe.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record SharedLibsRequestDTO(UUID id,

        @NotBlank
        String name,

                                   @NotBlank
        String version
) {}
