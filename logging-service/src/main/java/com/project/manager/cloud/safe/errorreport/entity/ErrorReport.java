package com.project.manager.cloud.safe.errorreport.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Date;

@Entity(name = "errorreport")
@Table(name = "errorreport")
@EqualsAndHashCode(of = "id")
@CrossOrigin
public class ErrorReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private Long userId;
    @NotNull
    private String errorMessage;
    @NotNull
    private String stackTrace;
    private Date createdAt;

    public ErrorReport(){

    }

    public ErrorReport(Long userId, String errorMessage, String stackTrace, Date createdAt) {
        this.userId = userId;
        this.errorMessage = errorMessage;
        this.stackTrace = stackTrace;
        this.createdAt = createdAt;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
