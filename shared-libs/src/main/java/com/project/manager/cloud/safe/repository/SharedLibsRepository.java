package com.project.manager.cloud.safe.repository;

import com.project.manager.cloud.safe.entity.SharedLibs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SharedLibsRepository extends JpaRepository<SharedLibs, UUID> {
    @Override
    Optional<SharedLibs> findById(UUID id);
}
