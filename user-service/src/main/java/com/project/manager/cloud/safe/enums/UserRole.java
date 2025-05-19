package com.project.manager.cloud.safe.enums;

public enum UserRole {

    OPERACIONAL("OPERACIONAL"),
    MEMBER("MEMBER"),
    ADMIN("ADMIN"),
    USER("USER");

    private String role;

    UserRole(String role) {
        this.role = role;
    }
}
