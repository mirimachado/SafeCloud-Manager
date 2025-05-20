package com.project.manager.cloud.safe.file.repository;

import com.project.manager.cloud.safe.file.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FileRepository extends JpaRepository<File, Long> {

    @Override
    Optional<File> findById(Long id);
}
