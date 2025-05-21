package com.project.manager.cloud.safe.organization.entity;

import com.project.manager.cloud.safe.entity.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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

@Entity(name = "organization")
@Table(name = "organization")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotNull
    private String name;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    private Boolean active;

    @OneToMany(mappedBy = "organization")
    private List<User> users;

    private String logoUrl;

    @NotBlank
    private String contactEmail;
    @NotBlank
    private String contactPhone;
    private String description;




    public Organization() {

    }

    public Organization(String name, Date createdAt, Boolean active) {
        this.name = name;
        this.createdAt = createdAt;
        this.active = true;
    }

}
