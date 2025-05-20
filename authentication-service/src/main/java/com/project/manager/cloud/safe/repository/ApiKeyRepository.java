package com.project.manager.cloud.safe.repository;

import com.project.manager.cloud.safe.entity.ApiKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ApiKeyRepository extends JpaRepository<ApiKey, Long> {
    @Override
    Optional<ApiKey> findById(Long id);
}
