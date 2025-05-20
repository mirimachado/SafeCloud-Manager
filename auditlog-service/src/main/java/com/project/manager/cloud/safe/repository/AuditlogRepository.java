package com.project.manager.cloud.safe.repository;

import com.project.manager.cloud.safe.entity.Auditlog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuditlogRepository extends JpaRepository<Auditlog, Long> {

    Optional<Auditlog> findById(Long id);
}
