package com.project.manager.cloud.safe.file.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Date;

@Entity(name = "file")
@Table(name = "file")
@EqualsAndHashCode(of = "id")
@CrossOrigin
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String type;
    @NotNull
    private Long size;
    private Date uploadDate;
    @NotNull
    private Long ownerId;

    public File(){

    }

    public File(String name, String type, Long size, Date uploadDate, Long ownerId) {
        this.name = name;
        this.type = type;
        this.size = size;
        this.uploadDate = uploadDate;
        this.ownerId = ownerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }
}
