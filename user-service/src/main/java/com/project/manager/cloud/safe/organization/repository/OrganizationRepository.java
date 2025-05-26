package com.project.manager.cloud.safe.organization.repository;

import com.project.manager.cloud.safe.organization.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface OrganizationRepository extends JpaRepository<Organization, UUID> {
    @Override
    Optional<Organization> findById(UUID id);
    Optional<Organization> findByNameIgnoreCase(String name);
    Optional<Organization> findByNameIgnoreCaseAndIdNot(String token, UUID id);
}
