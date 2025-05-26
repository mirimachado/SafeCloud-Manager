package com.project.manager.cloud.safe.usersettings.dto;

import com.project.manager.cloud.safe.entity.User;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record UserSettingsRequestDTO(UUID id,
                                     User user,
                                     @NotBlank
                                     String theme,
                                     @NotBlank
                                     String language) {
}
