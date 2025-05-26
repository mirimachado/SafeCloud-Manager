package com.project.manager.cloud.safe.teammember.repository;

import com.project.manager.cloud.safe.teammember.entity.TeamMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface TeamMemberRepository extends JpaRepository<TeamMember, UUID> {
    @Override
    Optional<TeamMember> findById(UUID id);
    boolean existsByTeamIdAndUserId(UUID teamId, UUID userId);
    boolean existsByTeamIdAndUserIdAndIdNot(UUID teamId, UUID userId, UUID id);
}
