package com.project.manager.cloud.safe.service;

import com.project.manager.cloud.safe.dto.SharedLibsRequestDTO;
import com.project.manager.cloud.safe.entity.SharedLibs;
import com.project.manager.cloud.safe.repository.SharedLibsRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SharedLibsService {

    @Autowired
    private SharedLibsRepository repository;

    public ResponseEntity<List<SharedLibs>> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    public ResponseEntity<SharedLibs> getById(UUID id) {
        Optional<SharedLibs> optional = repository.findById(id);
        return optional.map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @Transactional
    public ResponseEntity<SharedLibs> create(SharedLibsRequestDTO dto) {
        SharedLibs sharedLib = SharedLibs.builder()
                .name(dto.name())
                .version(dto.version())
                .build();
        repository.save(sharedLib);
        return ResponseEntity.status(HttpStatus.CREATED).body(sharedLib);
    }

    @Transactional
    public ResponseEntity<?> update(UUID id, SharedLibsRequestDTO dto) {
        Optional<SharedLibs> optional = repository.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("SharedLib não encontrado");
        }
        SharedLibs sharedLib = optional.get();
        sharedLib.setName(dto.name());
        sharedLib.setVersion(dto.version());
        repository.save(sharedLib);
        return ResponseEntity.ok(sharedLib);
    }

    @Transactional
    public ResponseEntity<?> delete(UUID id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("SharedLib não encontrado");
        }
        repository.deleteById(id);
        return ResponseEntity.ok("SharedLib deletado com sucesso");
    }
}
