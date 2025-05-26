package com.project.manager.cloud.safe.file.entity;

import com.project.manager.cloud.safe.filemetadata.entity.FileMetaData;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Entity(name = "file")
@Table(name = "file")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Builder
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotNull
    private String name;
    @NotNull
    private String type;
    @NotNull
    private Long size;
    private Date uploadDate;
    @NotNull
    private UUID ownerId;

    @OneToOne(mappedBy = "file", cascade = CascadeType.ALL)
    private FileMetaData metaData;



}
