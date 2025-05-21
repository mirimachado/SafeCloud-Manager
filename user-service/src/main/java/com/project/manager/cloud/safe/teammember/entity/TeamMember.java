package com.project.manager.cloud.safe.teammember.entity;

import com.project.manager.cloud.safe.entity.User;
import com.project.manager.cloud.safe.enums.UserRole;
import com.project.manager.cloud.safe.team.entity.Team;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity(name = "team_member")
@Table(name = "team_member")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class TeamMember {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @NotNull
    private UserRole role;

    private String description;

    public TeamMember(Team team, User user, UserRole role) {
        this.team = team;
        this.user = user;
        this.role = role;
    }
}
