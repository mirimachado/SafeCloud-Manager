package com.project.manager.cloud.safe.organization.repository;

import com.project.manager.cloud.safe.organization.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {
    @Override
    Optional<Organization> findById(Long id);
}
