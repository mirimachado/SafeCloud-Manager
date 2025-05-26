package com.project.manager.cloud.safe.file.repository;

import com.project.manager.cloud.safe.file.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface FileRepository extends JpaRepository<File, UUID> {

    @Override
    Optional<File> findById(UUID id);
}
