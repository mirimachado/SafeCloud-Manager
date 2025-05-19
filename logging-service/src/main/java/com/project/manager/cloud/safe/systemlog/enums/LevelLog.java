package com.project.manager.cloud.safe.systemlog.enums;

public enum LevelLog{

    INFO("INFO"),
    WARN("WARN"),
    ERROR("ERROR");

    private String role;

    LevelLog(String role) {
        this.role = role;
    }
}
