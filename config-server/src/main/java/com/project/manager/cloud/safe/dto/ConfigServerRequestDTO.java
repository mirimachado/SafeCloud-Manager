package com.project.manager.cloud.safe.dto;

public record ConfigServerRequestDTO(String environment,
                                     String configRepoUrl
                                     ) {
}
