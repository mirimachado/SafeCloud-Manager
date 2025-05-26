package com.project.manager.cloud.safe.repository;

import com.project.manager.cloud.safe.entity.DiscoveryServer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface DiscoveryServerRepository extends JpaRepository<DiscoveryServer, UUID> {

    @Override
    Optional<DiscoveryServer> findById(UUID id);
}
