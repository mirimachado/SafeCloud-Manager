package com.project.manager.cloud.safe.repository;

import com.project.manager.cloud.safe.entity.Vault;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface VaultRepository extends JpaRepository<Vault, UUID> {
    @Override
    Optional<Vault> findById(UUID id);

}
