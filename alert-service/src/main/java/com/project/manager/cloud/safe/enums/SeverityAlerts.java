package com.project.manager.cloud.safe.enums;

public enum SeverityAlerts {


    LOW("LOW"),
    MEDIUM("MEDIUM"),
    HIGH("HIGH"),
    CRITICAL("CRITICAL");

    private String severity;

    SeverityAlerts(String severity) {
        this.severity = severity;
    }

}
