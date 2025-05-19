package com.project.manager.cloud.safe.usersettings.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import org.springframework.web.bind.annotation.CrossOrigin;

@Entity(name = "usersettings")
@Table(name = "usersettings")
@EqualsAndHashCode(of = "id")
@CrossOrigin
public class UserSettings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    @NotNull
    private String theme;
    @NotNull
    private String language;

    public UserSettings(){

    }

    public UserSettings(Long userId, String theme, String language) {
        this.userId = userId;
        this.theme = theme;
        this.language = language;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
