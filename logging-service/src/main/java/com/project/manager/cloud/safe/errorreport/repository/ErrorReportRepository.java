package com.project.manager.cloud.safe.errorreport.repository;

import com.project.manager.cloud.safe.errorreport.entity.ErrorReport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ErrorReportRepository extends JpaRepository<ErrorReport, Long> {
    @Override
    Optional<ErrorReport> findById(Long id);

}
