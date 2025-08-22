package com.project.manager.cloud.safe.entity;

import com.project.manager.cloud.safe.enums.UserRole;
import com.project.manager.cloud.safe.organization.entity.Organization;
import com.project.manager.cloud.safe.teammember.entity.TeamMember;
import com.project.manager.cloud.safe.usersettings.entity.UserSettings;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity(name = "users")
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotBlank
    @Size(min = 2, max = 100)
    private String name;
    @NotNull
    @Enumerated(EnumType.STRING)
    private UserRole role;
    @NotEmpty
    private String email;
    @NotBlank
    @Size(min = 8)
    private String password;

    private Boolean active = true;

    @Column(unique = true)
    private String token;
    @ManyToOne
    @JoinColumn(name = "organization_id")
    private Organization organization;

    @OneToMany(mappedBy = "user")
    private List<TeamMember> teamMemberships;

    @NotEmpty
    @Column(unique = true)
    private String username;

    //@OneToMany(mappedBy = "user")
    //private List<Auditlog> auditLogs;

    //@OneToMany(mappedBy = "user")
    //private List<AuthToken> authTokens;

    @OneToMany(mappedBy = "user")
    private List<UserSettings> settings;

    @CreationTimestamp
    private LocalDateTime timestampCreatedAt;

    @UpdateTimestamp
    private LocalDateTime timestampUpdatedAt;



    public User(String token,
                String password,
                String email,
                UserRole role,
                String name) {

        this.token = token;
        this.active = true;
        this.password = password;
        this.email = email;
        this.role = role;
        this.name = name;
    }


}