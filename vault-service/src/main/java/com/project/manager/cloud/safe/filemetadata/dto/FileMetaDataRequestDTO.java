package com.project.manager.cloud.safe.filemetadata.dto;

import com.project.manager.cloud.safe.file.entity.File;
import jakarta.validation.constraints.NotBlank;

public record FileMetaDataRequestDTO(File file,
                                     @NotBlank
                                     String key,
                                     @NotBlank
                                     String value
                                     ) {
}
