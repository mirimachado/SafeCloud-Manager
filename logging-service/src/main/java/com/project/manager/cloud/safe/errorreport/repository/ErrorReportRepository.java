package com.project.manager.cloud.safe.errorreport.repository;

import com.project.manager.cloud.safe.errorreport.entity.ErrorReport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ErrorReportRepository extends JpaRepository<ErrorReport, UUID> {
    @Override
    Optional<ErrorReport> findById(UUID id);

}
