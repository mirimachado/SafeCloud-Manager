package com.project.manager.cloud.safe.filemetadata.controller;

import com.project.manager.cloud.safe.filemetadata.dto.FileMetaDataRequestDTO;
import com.project.manager.cloud.safe.filemetadata.service.FileMetaDataService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/file_meta_data")
@RequiredArgsConstructor
public class FileMetaDataController {

    private final FileMetaDataService service;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid FileMetaDataRequestDTO dto) {
        return service.create(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return service.findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable UUID id, @RequestBody @Valid FileMetaDataRequestDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        return service.delete(id);
    }
}
