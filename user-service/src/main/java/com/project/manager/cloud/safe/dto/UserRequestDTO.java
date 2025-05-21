package com.project.manager.cloud.safe.dto;

import com.project.manager.cloud.safe.enums.UserRole;
import jakarta.validation.constraints.NotBlank;

public record UserRequestDTO(Long id,
                             @NotBlank
                             String name,
                             UserRole role,
                             @NotBlank
                             String email,
                             @NotBlank
                             String password,
                             String token) {
}
