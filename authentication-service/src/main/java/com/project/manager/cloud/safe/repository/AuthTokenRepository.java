package com.project.manager.cloud.safe.repository;

import com.project.manager.cloud.safe.entity.AuthToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthTokenRepository extends JpaRepository<AuthToken, Long> {
    @Override
    Optional<AuthToken> findById(Long id);
}
