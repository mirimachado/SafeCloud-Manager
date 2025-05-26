package com.project.manager.cloud.safe.file.service;

import com.project.manager.cloud.safe.file.dto.FileRequestDTO;
import com.project.manager.cloud.safe.file.entity.File;
import com.project.manager.cloud.safe.file.repository.FileRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FileService {

    private final FileRepository repository;

    @Transactional
    public ResponseEntity<?> create(FileRequestDTO dto) {
        if (dto.name().isBlank() || dto.type().isBlank() || dto.size() == null || dto.ownerId() == null) {
            return ResponseEntity.badRequest().body("Campos obrigatórios estão ausentes");
        }

        File file = File.builder()
                .name(dto.name())
                .type(dto.type())
                .size(dto.size())
                .uploadDate(dto.uploadDate())
                .ownerId(dto.ownerId())
                .build();

        repository.save(file);
        return ResponseEntity.status(HttpStatus.CREATED).body(file);
    }

    public ResponseEntity<?> findById(UUID id) {
        Optional<File> file = repository.findById(id);
        return file.<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Arquivo não encontrado"));
    }

    public ResponseEntity<List<File>> findAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @Transactional
    public ResponseEntity<?> update(UUID id, FileRequestDTO dto) {
        Optional<File> optional = repository.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Arquivo não encontrado");
        }

        File file = optional.get();
        file.setName(dto.name());
        file.setType(dto.type());
        file.setSize(dto.size());
        file.setUploadDate(dto.uploadDate());
        file.setOwnerId(dto.ownerId());

        repository.save(file);
        return ResponseEntity.ok(file);
    }

    @Transactional
    public ResponseEntity<?> delete(UUID id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Arquivo não encontrado");
        }

        repository.deleteById(id);
        return ResponseEntity.ok("Arquivo excluído com sucesso");
    }
}
