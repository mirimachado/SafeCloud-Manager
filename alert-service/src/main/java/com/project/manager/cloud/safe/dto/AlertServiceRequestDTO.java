package com.project.manager.cloud.safe.dto;

import com.project.manager.cloud.safe.enums.SeverityAlerts;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

public record AlertServiceRequestDTO(
        UUID id,
        @NotBlank
        String message,

                                     @NotNull
        SeverityAlerts severity,

                                     @NotNull
        Boolean resolved,

                                     LocalDateTime resolvedAt,
                                     String resolutionNote,
                                     String source,
                                     String category,
                                     String context,
                                     String assignedTo,

                                     @NotBlank
        String code,

                                     String relatedEntityId,
                                     String relatedEntityType,
                                     Integer priority) {

}


