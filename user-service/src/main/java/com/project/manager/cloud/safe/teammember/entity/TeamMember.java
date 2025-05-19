package com.project.manager.cloud.safe.teammember.entity;

import com.project.manager.cloud.safe.enums.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import org.springframework.web.bind.annotation.CrossOrigin;

@Entity(name = "teammember")
@Table(name = "teammember")
@EqualsAndHashCode(of = "id")
@CrossOrigin
public class TeamMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private Long teamId;
    @NotNull
    private Long userId;
    @NotNull
    private UserRole role;

    public TeamMember(){

    }

    public TeamMember(Long teamId, Long userId, UserRole role) {
        this.teamId = teamId;
        this.userId = userId;
        this.role = role;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
