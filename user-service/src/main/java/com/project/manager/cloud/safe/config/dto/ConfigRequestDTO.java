package com.project.manager.cloud.safe.config.dto;

public record ConfigRequestDTO(String key,
                               String value,
                               Boolean system) {
}
