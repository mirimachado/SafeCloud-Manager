package com.project.manager.cloud.safe.organization.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.Date;
import java.util.UUID;

public record OrganizationRequestDTO(UUID id,
        @NotBlank
        String name,
                                     Date createdAt,
                                     Date updatedAt,
                                     String logoUrl,
                                     @NotBlank
        String contactEmail,
                                     @NotBlank
        String contactPhone,
                                     String description) {
}
