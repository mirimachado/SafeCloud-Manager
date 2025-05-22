package com.project.manager.cloud.safe.repository;

import com.project.manager.cloud.safe.entity.AccessControlEntry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AccessControlEntryRepository extends JpaRepository<AccessControlEntry, UUID> {
    @Override
    Optional<AccessControlEntry> findById(UUID id);
    Optional<AccessControlEntry> findByUserIdAndResourceAndPermission(UUID userId, String resource, String permission);

}
