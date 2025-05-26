package com.project.manager.cloud.safe.repository;

import com.project.manager.cloud.safe.entity.Backup;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;
import java.util.UUID;

public interface BackupRepository extends JpaRepository<Backup, UUID> {
    @Override
    Optional<Backup> findById(UUID id);
    Optional<Backup> findByHashChecksum(String hashChecksum);
}
