package com.project.manager.cloud.safe.team.controller;

import com.project.manager.cloud.safe.team.dto.TeamRequestDTO;
import com.project.manager.cloud.safe.team.entity.Team;
import com.project.manager.cloud.safe.team.service.TeamService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/teams")
public class TeamController {

    @Autowired
    private TeamService service;

    @GetMapping
    public ResponseEntity<List<Team>> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Team> getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid TeamRequestDTO dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable UUID id, @RequestBody @Valid TeamRequestDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        return service.delete(id);
    }
}
