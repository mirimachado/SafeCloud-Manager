package com.project.manager.cloud.safe.repository;

import com.project.manager.cloud.safe.entity.ConfigServer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ConfigServerRepository extends JpaRepository<ConfigServer, UUID> {
    @Override
    Optional<ConfigServer> findById(UUID id);

}
