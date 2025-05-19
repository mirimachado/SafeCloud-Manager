package com.project.manager.cloud.safe.systemlog.entity;

import com.project.manager.cloud.safe.systemlog.enums.LevelLog;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Date;

@Entity(name = "systemlog")
@Table(name = "systemlog")
@EqualsAndHashCode(of = "id")
@CrossOrigin
public class SystemLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private LevelLog level;
    @NotNull
    private String message;
    private Date timestamp;
    @NotNull
    private Long userId;

    public SystemLog(){

    }

    public SystemLog(LevelLog level, String message, Date timestamp, Long userId) {
        this.level = level;
        this.message = message;
        this.timestamp = timestamp;
        this.userId = userId;
    }

    public LevelLog getLevel() {
        return level;
    }

    public void setLevel(LevelLog level) {
        this.level = level;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
