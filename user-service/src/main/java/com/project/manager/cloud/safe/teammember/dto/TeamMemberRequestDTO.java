package com.project.manager.cloud.safe.teammember.dto;

import com.project.manager.cloud.safe.entity.User;
import com.project.manager.cloud.safe.enums.UserRole;
import com.project.manager.cloud.safe.team.entity.Team;
import jakarta.validation.constraints.NotBlank;

public record TeamMemberRequestDTO(Team team,
                                   User user,
                                   UserRole role,
                                   @NotBlank
                                   String description) {
}
