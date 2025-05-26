package com.project.manager.cloud.safe.repository;

import com.project.manager.cloud.safe.entity.ApiKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ApiKeyRepository extends JpaRepository<ApiKey, UUID> {
    @Override
    Optional<ApiKey> findById(UUID id);
    Optional<ApiKey> findByKey(String key);

}
