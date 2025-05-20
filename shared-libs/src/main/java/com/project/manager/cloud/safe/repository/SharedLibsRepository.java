package com.project.manager.cloud.safe.repository;

import com.project.manager.cloud.safe.entity.SharedLibs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SharedLibsRepository extends JpaRepository<SharedLibs, Long> {
    @Override
    Optional<SharedLibs> findById(Long id);
}
