package com.project.manager.cloud.safe.teammember.service;

import com.project.manager.cloud.safe.teammember.dto.TeamMemberRequestDTO;
import com.project.manager.cloud.safe.teammember.entity.TeamMember;
import com.project.manager.cloud.safe.teammember.repository.TeamMemberRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TeamMemberService {

    @Autowired
    private TeamMemberRepository repository;

    public ResponseEntity<List<TeamMember>> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    public ResponseEntity<TeamMember> getById(UUID id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @Transactional
    public ResponseEntity<?> create(TeamMemberRequestDTO dto) {
        if (dto.team() == null || dto.user() == null || dto.role() == null || dto.description().isBlank()) {
            return ResponseEntity.badRequest().body("Todos os campos são obrigatórios.");
        }

        // Verifica se já existe um membro com o mesmo usuário no mesmo time
        boolean exists = repository.existsByTeamIdAndUserId(
                dto.team().getId(), dto.user().getId());
        if (exists) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Este usuário já é membro deste time.");
        }

        TeamMember member = TeamMember.builder()
                .team(dto.team())
                .user(dto.user())
                .role(dto.role())
                .description(dto.description())
                .build();

        repository.save(member);
        return ResponseEntity.status(HttpStatus.CREATED).body(member);
    }

    @Transactional
    public ResponseEntity<?> update(UUID id, TeamMemberRequestDTO dto) {
        Optional<TeamMember> optional = repository.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Membro não encontrado");
        }

        if (dto.team() == null || dto.user() == null || dto.role() == null || dto.description().isBlank()) {
            return ResponseEntity.badRequest().body("Todos os campos são obrigatórios.");
        }

        // Verifica se há outro membro com mesmo usuário no time
        boolean conflict = repository.existsByTeamIdAndUserIdAndIdNot(
                dto.team().getId(), dto.user().getId(), id);
        if (conflict) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Este usuário já é membro deste time.");
        }

        TeamMember member = optional.get();
        member.setTeam(dto.team());
        member.setUser(dto.user());
        member.setRole(dto.role());
        member.setDescription(dto.description());

        repository.save(member);
        return ResponseEntity.ok(member);
    }

    @Transactional
    public ResponseEntity<?> delete(UUID id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Membro não encontrado");
        }
        repository.deleteById(id);
        return ResponseEntity.ok("Membro removido com sucesso");
    }
}
