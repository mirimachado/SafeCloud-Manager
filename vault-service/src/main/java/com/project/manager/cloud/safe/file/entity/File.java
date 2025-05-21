package com.project.manager.cloud.safe.file.entity;

import com.project.manager.cloud.safe.filemetadata.entity.FileMetaData;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Entity(name = "file")
@Table(name = "file")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
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

    public File(){

    }

    public File(String name, String type, Long size, Date uploadDate, UUID ownerId) {
        this.name = name;
        this.type = type;
        this.size = size;
        this.uploadDate = uploadDate;
        this.ownerId = ownerId;
    }

}
