package com.project.manager.cloud.safe.controller;

import com.project.manager.cloud.safe.dto.SharedLibsRequestDTO;
import com.project.manager.cloud.safe.entity.SharedLibs;
import com.project.manager.cloud.safe.service.SharedLibsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/shared_libs")
public class SharedLibsController {

    @Autowired
    private SharedLibsService service;

    @GetMapping
    public ResponseEntity<List<SharedLibs>> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SharedLibs> getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid SharedLibsRequestDTO dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable UUID id, @RequestBody @Valid SharedLibsRequestDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        return service.delete(id);
    }
}
