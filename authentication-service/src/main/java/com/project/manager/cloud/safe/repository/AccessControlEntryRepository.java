package com.project.manager.cloud.safe.repository;

import com.project.manager.cloud.safe.entity.AccessControlEntry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccessControlEntryRepository extends JpaRepository<AccessControlEntry, Long> {
    @Override
    Optional<AccessControlEntry> findById(Long id);
}
