package com.project.manager.cloud.safe.team.repository;

import com.project.manager.cloud.safe.team.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeamRepository extends JpaRepository<Team, Long> {
    @Override
    Optional<Team> findById(Long id);
}
