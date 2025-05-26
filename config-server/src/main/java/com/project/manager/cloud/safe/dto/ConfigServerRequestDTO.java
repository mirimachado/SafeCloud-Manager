package com.project.manager.cloud.safe.dto;

import java.util.UUID;

public record ConfigServerRequestDTO(UUID id,
                                     String environment,
                                     String configRepoUrl
                                     ) {
}
