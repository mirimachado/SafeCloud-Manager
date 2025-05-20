package com.project.manager.cloud.safe.repository;

import com.project.manager.cloud.safe.entity.Dashboard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DashboardRepository extends JpaRepository<Dashboard, Long> {
    @Override
    Optional<Dashboard> findById(Long id);
}
