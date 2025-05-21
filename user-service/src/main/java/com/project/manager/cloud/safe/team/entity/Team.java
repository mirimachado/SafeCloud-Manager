package com.project.manager.cloud.safe.team.entity;

import com.project.manager.cloud.safe.teammember.entity.TeamMember;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity(name = "team")
@Table(name = "team")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotNull
    private UUID organizationId;
    @NotNull
    private String name;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    private String description;

    @OneToMany(mappedBy = "team")
    private List<TeamMember> members;


    public Team(){

    }

    public Team(UUID organizationId, String name, Date createdAt) {
        this.organizationId = organizationId;
        this.name = name;
        this.createdAt = createdAt;
    }
}
