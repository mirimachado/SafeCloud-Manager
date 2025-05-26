package com.project.manager.cloud.safe.team.repository;

import com.project.manager.cloud.safe.team.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface TeamRepository extends JpaRepository<Team, UUID> {
    @Override
    Optional<Team> findById(UUID id);
    boolean existsByNameIgnoreCaseAndOrganizationId(String name, UUID organizationId);
    boolean existsByNameIgnoreCaseAndOrganizationIdAndIdNot(String name, UUID organizationId, UUID id);
}
