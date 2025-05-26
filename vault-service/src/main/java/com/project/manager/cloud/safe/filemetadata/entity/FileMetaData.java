package com.project.manager.cloud.safe.filemetadata.entity;

import com.project.manager.cloud.safe.file.entity.File;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.UUID;

@Entity(name = "file_meta_data")
@Table(name = "file_meta_data")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Builder
public class FileMetaData {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @OneToOne
    @JoinColumn(name = "file_id")
    private File file;
    @NotNull
    private String key;
    @NotNull
    private String value;

}
