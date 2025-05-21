package com.project.manager.cloud.safe.dto;

import com.project.manager.cloud.safe.enums.SeverityAlerts;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record AlertServiceRequestDTO(@NotBlank
                                     String message,
                                     @NotNull
                                     SeverityAlerts severity,
                                     LocalDateTime timestamp,
                                     LocalDateTime resolvedAt,
                                     String resolutionNote,
                                     String source,
                                     String category,
                                     String context,
                                     String assignedTo,
                                     String code,
                                     String relatedEntityId,
                                     String relatedEntityType,
                                     Integer priority

                                     ) {
}
