package com.project.manager.cloud.safe.errorreport.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Entity(name = "error_report")
@Table(name = "error_report")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Builder
public class ErrorReport {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotNull
    private UUID userId;
    @NotNull
    private String errorMessage;
    @NotNull
    private String stackTrace;
    private Date createdAt;



}
