package com.project.manager.cloud.safe.repository;

import com.project.manager.cloud.safe.entity.AuthToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AuthTokenRepository extends JpaRepository<AuthToken, UUID> {
    @Override
    Optional<AuthToken> findById(UUID id);
}
