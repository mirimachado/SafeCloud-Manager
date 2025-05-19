package com.project.manager.cloud.safe.filemetadata.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import org.springframework.web.bind.annotation.CrossOrigin;

@Entity(name = "filemetadata")
@Table(name = "filemetadata")
@EqualsAndHashCode(of = "id")
@CrossOrigin
public class FileMetaData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String fileId;
    @NotNull
    private String key;
    @NotNull
    private String value;

    public FileMetaData(){

    }


    public FileMetaData(String fileId, String key, String value) {
        this.fileId = fileId;
        this.key = key;
        this.value = value;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
