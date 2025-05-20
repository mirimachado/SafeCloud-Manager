package com.project.manager.cloud.safe.repository;

import com.project.manager.cloud.safe.entity.Backup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BackupRepository extends JpaRepository<Backup, Long> {
    @Override
    Optional<Backup> findById(Long id);
}
