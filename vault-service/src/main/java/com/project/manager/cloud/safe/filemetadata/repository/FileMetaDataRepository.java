package com.project.manager.cloud.safe.filemetadata.repository;

import com.project.manager.cloud.safe.filemetadata.entity.FileMetaData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface FileMetaDataRepository extends JpaRepository<FileMetaData, UUID> {
    @Override
    Optional<FileMetaData> findById(UUID id);
}
