package com.project.manager.cloud.safe.systemlog.entity;

import com.project.manager.cloud.safe.systemlog.enums.LevelLog;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Entity(name = "system_log")
@Table(name = "system_log")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Builder
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



}
