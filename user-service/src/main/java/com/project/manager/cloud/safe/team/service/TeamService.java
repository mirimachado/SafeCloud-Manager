package com.project.manager.cloud.safe.team.service;

import com.project.manager.cloud.safe.team.dto.TeamRequestDTO;
import com.project.manager.cloud.safe.team.entity.Team;
import com.project.manager.cloud.safe.team.repository.TeamRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TeamService {

    @Autowired
    private TeamRepository repository;

    public ResponseEntity<List<Team>> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    public ResponseEntity<Team> getById(UUID id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @Transactional
    public ResponseEntity<?> create(TeamRequestDTO dto) {
        if (dto.organizationId() == null) {
            return ResponseEntity.badRequest().body("ID da organização é obrigatório");
        }
        if (dto.name() == null || dto.name().isBlank()) {
            return ResponseEntity.badRequest().body("Nome é obrigatório");
        }
        if (dto.createdAt() == null || dto.updatedAt() == null) {
            return ResponseEntity.badRequest().body("Datas são obrigatórias");
        }
        if (dto.updatedAt().before(dto.createdAt())) {
            return ResponseEntity.badRequest().body("Data de atualização não pode ser anterior à data de criação");
        }

        if (repository.existsByNameIgnoreCaseAndOrganizationId(dto.name(), dto.organizationId())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Já existe um time com esse nome nesta organização");
        }

        Team team = Team.builder()
                .organizationId(dto.organizationId())
                .name(dto.name())
                .createdAt(dto.createdAt())
                .updatedAt(dto.updatedAt())
                .description(dto.description())
                .build();

        repository.save(team);

        return ResponseEntity.status(HttpStatus.CREATED).body(team);
    }

    @Transactional
    public ResponseEntity<?> update(UUID id, TeamRequestDTO dto) {
        Optional<Team> optional = repository.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Time não encontrado");
        }

        if (dto.organizationId() == null) {
            return ResponseEntity.badRequest().body("ID da organização é obrigatório");
        }
        if (dto.name() == null || dto.name().isBlank()) {
            return ResponseEntity.badRequest().body("Nome é obrigatório");
        }
        if (dto.createdAt() == null || dto.updatedAt() == null) {
            return ResponseEntity.badRequest().body("Datas são obrigatórias");
        }
        if (dto.updatedAt().before(dto.createdAt())) {
            return ResponseEntity.badRequest().body("Data de atualização não pode ser anterior à data de criação");
        }

        if (repository.existsByNameIgnoreCaseAndOrganizationIdAndIdNot(dto.name(), dto.organizationId(), id)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Já existe outro time com esse nome nesta organização");
        }

        Team team = optional.get();
        team.setOrganizationId(dto.organizationId());
        team.setName(dto.name());
        team.setCreatedAt(dto.createdAt());
        team.setUpdatedAt(dto.updatedAt());
        team.setDescription(dto.description());

        repository.save(team);

        return ResponseEntity.ok(team);
    }

    @Transactional
    public ResponseEntity<?> delete(UUID id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Time não encontrado");
        }
        repository.deleteById(id);
        return ResponseEntity.ok("Time deletado com sucesso");
    }
}
