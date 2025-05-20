package com.project.manager.cloud.safe.repository;

import com.project.manager.cloud.safe.entity.DiscoveryServer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DiscoveryServerRepository extends JpaRepository<DiscoveryServer, Long> {

    @Override
    Optional<DiscoveryServer> findById(Long id);
}
