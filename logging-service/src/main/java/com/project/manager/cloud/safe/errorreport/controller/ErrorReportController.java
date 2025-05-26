package com.project.manager.cloud.safe.errorreport.controller;

import com.project.manager.cloud.safe.errorreport.dto.ErrorReportRequestDTO;
import com.project.manager.cloud.safe.errorreport.entity.ErrorReport;
import com.project.manager.cloud.safe.errorreport.service.ErrorReportService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/error-reports")
public class ErrorReportController {

    @Autowired
    private ErrorReportService service;

    @GetMapping
    public ResponseEntity<List<ErrorReport>> getAll() {
        return service.getAll();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid ErrorReportRequestDTO data) {
        return service.create(data);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable UUID id, @RequestBody @Valid ErrorReportRequestDTO data) {
        return service.update(id, data);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        return service.delete(id);
    }
}
