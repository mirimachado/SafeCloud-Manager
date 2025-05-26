package com.project.manager.cloud.safe.filemetadata.service;

import com.project.manager.cloud.safe.filemetadata.dto.FileMetaDataRequestDTO;
import com.project.manager.cloud.safe.filemetadata.entity.FileMetaData;
import com.project.manager.cloud.safe.filemetadata.repository.FileMetaDataRepository;
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
public class FileMetaDataService {

    private final FileMetaDataRepository repository;

    @Transactional
    public ResponseEntity<?> create(FileMetaDataRequestDTO dto) {
        if (dto.file() == null || dto.key().isBlank() || dto.value().isBlank()) {
            return ResponseEntity.badRequest().body("Campos obrigatórios estão ausentes");
        }

        FileMetaData metaData = FileMetaData.builder()
                .file(dto.file())
                .key(dto.key())
                .value(dto.value())
                .build();

        repository.save(metaData);
        return ResponseEntity.status(HttpStatus.CREATED).body(metaData);
    }

    public ResponseEntity<?> findById(UUID id) {
        Optional<FileMetaData> optional = repository.findById(id);
        return optional.<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Metadado não encontrado"));
    }

    public ResponseEntity<List<FileMetaData>> findAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @Transactional
    public ResponseEntity<?> update(UUID id, FileMetaDataRequestDTO dto) {
        Optional<FileMetaData> optional = repository.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Metadado não encontrado");
        }

        FileMetaData metaData = optional.get();
        metaData.setFile(dto.file());
        metaData.setKey(dto.key());
        metaData.setValue(dto.value());

        repository.save(metaData);
        return ResponseEntity.ok(metaData);
    }

    @Transactional
    public ResponseEntity<?> delete(UUID id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Metadado não encontrado");
        }

        repository.deleteById(id);
        return ResponseEntity.ok("Metadado excluído com sucesso");
    }
}
