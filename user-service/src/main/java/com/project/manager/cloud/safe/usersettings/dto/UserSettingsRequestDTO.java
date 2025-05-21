package com.project.manager.cloud.safe.usersettings.dto;

import com.project.manager.cloud.safe.entity.User;
import jakarta.validation.constraints.NotBlank;

public record UserSettingsRequestDTO(User user,
                                     @NotBlank
                                     String theme,
                                     @NotBlank
                                     String language) {
}
