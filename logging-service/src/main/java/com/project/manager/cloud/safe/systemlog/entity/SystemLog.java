package com.project.manager.cloud.safe.systemlog.entity;

import com.project.manager.cloud.safe.systemlog.enums.LevelLog;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Entity(name = "system_log")
@Table(name = "system_log")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class SystemLog {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotNull
    private LevelLog level;
    @NotNull
    private String message;
    private Date timestamp;
    @NotNull
    private UUID userId;

    public SystemLog(){

    }

    public SystemLog(LevelLog level, String message, Date timestamp, UUID userId) {
        this.level = level;
        this.message = message;
        this.timestamp = timestamp;
        this.userId = userId;
    }

}
