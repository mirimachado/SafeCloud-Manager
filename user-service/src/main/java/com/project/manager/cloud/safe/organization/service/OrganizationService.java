package com.project.manager.cloud.safe.organization.service;

import com.project.manager.cloud.safe.organization.dto.OrganizationRequestDTO;
import com.project.manager.cloud.safe.organization.entity.Organization;
import com.project.manager.cloud.safe.organization.repository.OrganizationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.regex.Pattern;

@Service
public class OrganizationService {

    @Autowired
    private OrganizationRepository repository;

    private final Pattern emailPattern = Pattern.compile("^[\\w-.]+@[\\w-]+\\.[a-z]{2,}$", Pattern.CASE_INSENSITIVE);

    public ResponseEntity<List<Organization>> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    public ResponseEntity<Organization> getById(UUID id) {
        Optional<Organization> optional = repository.findById(id);
        return optional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @Transactional
    public ResponseEntity<?> create(OrganizationRequestDTO dto) {

        // Validar campos obrigatórios (name, contactEmail, contactPhone)
        if (dto.name() == null || dto.name().isBlank()) {
            return ResponseEntity.badRequest().body("Nome é obrigatório");
        }
        if (dto.contactEmail() == null || dto.contactEmail().isBlank()) {
            return ResponseEntity.badRequest().body("Email de contato é obrigatório");
        }
        if (dto.contactPhone() == null || dto.contactPhone().isBlank()) {
            return ResponseEntity.badRequest().body("Telefone de contato é obrigatório");
        }

        // Validar formato email
        if (!emailPattern.matcher(dto.contactEmail()).matches()) {
            return ResponseEntity.badRequest().body("Email de contato inválido");
        }

        // Validar datas
        if (dto.createdAt() == null) {
            return ResponseEntity.badRequest().body("Data de criação é obrigatória");
        }
        if (dto.updatedAt() == null) {
            return ResponseEntity.badRequest().body("Data de atualização é obrigatória");
        }
        if (dto.updatedAt().before(dto.createdAt())) {
            return ResponseEntity.badRequest().body("Data de atualização não pode ser anterior à data de criação");
        }

        // Verificar se já existe organização com o mesmo nome (case insensitive)
        if (repository.findByNameIgnoreCase(dto.name()).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Já existe uma organização com esse nome");
        }

        Organization organization = Organization.builder()
                .name(dto.name())
                .createdAt(dto.createdAt())
                .updatedAt(dto.updatedAt())
                .logoUrl(dto.logoUrl())
                .contactEmail(dto.contactEmail())
                .contactPhone(dto.contactPhone())
                .description(dto.description())
                .build();

        repository.save(organization);

        return ResponseEntity.status(HttpStatus.CREATED).body(organization);
    }

    @Transactional
    public ResponseEntity<?> update(UUID id, OrganizationRequestDTO dto) {
        Optional<Organization> optional = repository.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Organização não encontrada");
        }

        // Validar campos obrigatórios (name, contactEmail, contactPhone)
        if (dto.name() == null || dto.name().isBlank()) {
            return ResponseEntity.badRequest().body("Nome é obrigatório");
        }
        if (dto.contactEmail() == null || dto.contactEmail().isBlank()) {
            return ResponseEntity.badRequest().body("Email de contato é obrigatório");
        }
        if (dto.contactPhone() == null || dto.contactPhone().isBlank()) {
            return ResponseEntity.badRequest().body("Telefone de contato é obrigatório");
        }

        // Validar formato email
        if (!emailPattern.matcher(dto.contactEmail()).matches()) {
            return ResponseEntity.badRequest().body("Email de contato inválido");
        }

        // Validar datas
        if (dto.createdAt() == null) {
            return ResponseEntity.badRequest().body("Data de criação é obrigatória");
        }
        if (dto.updatedAt() == null) {
            return ResponseEntity.badRequest().body("Data de atualização é obrigatória");
        }
        if (dto.updatedAt().before(dto.createdAt())) {
            return ResponseEntity.badRequest().body("Data de atualização não pode ser anterior à data de criação");
        }

        // Verificar se já existe outra organização com o mesmo nome (ignorando a atual)
        if (repository.findByNameIgnoreCaseAndIdNot(dto.name(), id).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Já existe outra organização com esse nome");
        }

        Organization organization = optional.get();

        organization.setName(dto.name());
        organization.setCreatedAt(dto.createdAt());
        organization.setUpdatedAt(dto.updatedAt());
        organization.setLogoUrl(dto.logoUrl());
        organization.setContactEmail(dto.contactEmail());
        organization.setContactPhone(dto.contactPhone());
        organization.setDescription(dto.description());

        repository.save(organization);

        return ResponseEntity.ok(organization);
    }

    @Transactional
    public ResponseEntity<?> delete(UUID id) {
        Optional<Organization> optional = repository.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Organização não encontrada");
        }

        repository.deleteById(id);
        return ResponseEntity.ok("Organização deletada com sucesso");
    }
}
