package com.project.manager.cloud.safe.filemetadata.repository;

import com.project.manager.cloud.safe.filemetadata.entity.FileMetaData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FileMetaDataRepository extends JpaRepository<FileMetaData, Long> {
    @Override
    Optional<FileMetaData> findById(Long id);
}
