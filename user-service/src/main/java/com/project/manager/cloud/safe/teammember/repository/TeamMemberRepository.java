package com.project.manager.cloud.safe.teammember.repository;

import com.project.manager.cloud.safe.teammember.entity.TeamMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeamMemberRepository extends JpaRepository<TeamMember, Long> {
    @Override
    Optional<TeamMember> findById(Long id);

}
