package com.project.manager.cloud.safe.systemlog.dto;

import com.project.manager.cloud.safe.systemlog.enums.LevelLog;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.UUID;

public record SystemLogRequestDTO(@NotNull
                                  LevelLog level,
                                  @NotBlank
                                  String message,
                                  Date timestamp,
                                  @NotNull
                                  UUID userId
                                  ) {
}
