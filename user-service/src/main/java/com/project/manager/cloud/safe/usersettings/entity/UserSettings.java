package com.project.manager.cloud.safe.usersettings.entity;

import com.project.manager.cloud.safe.entity.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Entity(name = "user_settings")
@Table(name = "user_settings")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class UserSettings {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @NotNull
    private String theme;
    @NotNull
    private String language;

    public UserSettings(){

    }

    public UserSettings(String theme, String language) {
        this.theme = theme;
        this.language = language;
    }

}
