package com.project.manager.cloud.safe.teammember.controller;

import com.project.manager.cloud.safe.teammember.dto.TeamMemberRequestDTO;
import com.project.manager.cloud.safe.teammember.entity.TeamMember;
import com.project.manager.cloud.safe.teammember.service.TeamMemberService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/team_members")
public class TeamMemberController {

    @Autowired
    private TeamMemberService service;

    @GetMapping
    public ResponseEntity<List<TeamMember>> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeamMember> getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid TeamMemberRequestDTO dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable UUID id, @RequestBody @Valid TeamMemberRequestDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        return service.delete(id);
    }
}
