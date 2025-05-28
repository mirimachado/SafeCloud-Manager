package com.project.manager.cloud.safe.repository;

import com.project.manager.cloud.safe.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByEmailIgnoreCase(String email);

    Optional<User> findByToken(String token);

    Optional<User> findByNameIgnoreCase(String name);

    Optional<User> findByEmailIgnoreCaseAndIdNot(String email, UUID id);

    Optional<User> findByTokenAndIdNot(String token, UUID id);

    Optional<User> findByNameIgnoreCaseAndIdNot(String name, UUID id);

    Optional<User> findByUsername(String username);
}
