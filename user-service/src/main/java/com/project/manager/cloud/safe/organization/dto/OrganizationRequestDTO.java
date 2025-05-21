package com.project.manager.cloud.safe.organization.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.Date;

public record OrganizationRequestDTO(
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
