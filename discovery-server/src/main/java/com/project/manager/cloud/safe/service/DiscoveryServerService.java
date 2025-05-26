package com.project.manager.cloud.safe.service;

import com.project.manager.cloud.safe.dto.DiscoveryServerRequestDTO;
import com.project.manager.cloud.safe.entity.DiscoveryServer;
import com.project.manager.cloud.safe.repository.DiscoveryServerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DiscoveryServerService {

    @Autowired
    private DiscoveryServerRepository repository;

    public ResponseEntity<List<DiscoveryServer>> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @Transactional
    public ResponseEntity<?> create(DiscoveryServerRequestDTO data) {
        DiscoveryServer discoveryServer = DiscoveryServer.builder()
                .serviceName(data.serviceName())
                .endpoint(data.endpoint())
                .lastSeen(data.lastSeen() != null ? data.lastSeen() : LocalDateTime.now())
                .build();

        repository.save(discoveryServer);
        return ResponseEntity.ok("Discovery server registrado com sucesso.");
    }

    @Transactional
    public ResponseEntity<?> update(UUID id, DiscoveryServerRequestDTO data) {
        Optional<DiscoveryServer> optional = repository.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Discovery server com id " + id + " não encontrado.");
        }

        DiscoveryServer server = optional.get();
        server.setServiceName(data.serviceName());
        server.setEndpoint(data.endpoint());
        server.setLastSeen(data.lastSeen() != null ? data.lastSeen() : LocalDateTime.now());

        repository.save(server);
        return ResponseEntity.ok("Discovery server atualizado com sucesso.");
    }

    @Transactional
    public ResponseEntity<?> delete(UUID id) {
        Optional<DiscoveryServer> optional = repository.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Discovery server com id " + id + " não encontrado.");
        }

        repository.deleteById(id);
        return ResponseEntity.ok("Discovery server removido com sucesso.");
    }
}
