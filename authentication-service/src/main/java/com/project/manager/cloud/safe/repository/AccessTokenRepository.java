package com.project.manager.cloud.safe.repository;

import com.project.manager.cloud.safe.entity.AccessToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AccessTokenRepository extends JpaRepository<AccessToken, UUID> {

    Optional<AccessToken> findById(UUID id);
}
