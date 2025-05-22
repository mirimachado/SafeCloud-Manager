package com.project.manager.cloud.safe.service;

import com.project.manager.cloud.safe.dto.requests.AccessControlEntryRequestDTO;
import com.project.manager.cloud.safe.entity.AccessControlEntry;
import com.project.manager.cloud.safe.repository.AccessControlEntryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AccessControlEntryService {

    @Autowired
    private AccessControlEntryRepository repository;

    public ResponseEntity getAccessControlEntry(){
        List<AccessControlEntry> accessControlEntry = repository.findAll();
        return ResponseEntity.ok(accessControlEntry);
    }
    @Transactional
    public ResponseEntity createAccessControlEntry(AccessControlEntryRequestDTO data){
        Optional<AccessControlEntry> accessControlEntry = repository.findByUserIdAndResourceAndPermission(data.id(),
                data.resource(),
                data.permission());

        if (accessControlEntry.isPresent()){
            return ResponseEntity.badRequest().body("Essa permissão já foi concedida para esse recurso e usuário. Tente novamente.");
        }else {
            AccessControlEntry access = AccessControlEntry.builder()
                    .userId(data.userId())
                    .resource(data.resource())
                    .permission(data.permission())
                    .roleId(data.roleId())
                    .grantedBy(data.grantedBy()) //
                    .expiresAt(data.expiresAt())
                    .active(data.active() != null ? data.active() : true)
                    .conditions(data.conditions())
                    .notes(data.notes())
                    .build();

            repository.save(access);
            return ResponseEntity.ok("Controle de Acesso criado com sucesso.");

        }
    }
    @Transactional
    public ResponseEntity<?> updateAccessControlEntry(AccessControlEntryRequestDTO data) {
        Optional<AccessControlEntry> accessControlEntry = repository.findById(data.id());

        accessControlEntry.ifPresent(existingAccessControlEntry -> {
            existingAccessControlEntry.setUserId(data.userId());
            existingAccessControlEntry.setResource(data.resource());
            existingAccessControlEntry.setPermission(data.permission());
            existingAccessControlEntry.setRoleId(data.roleId());
            existingAccessControlEntry.setGrantedBy(data.grantedBy());
            existingAccessControlEntry.setExpiresAt(data.expiresAt());
            existingAccessControlEntry.setActive(data.active() != null ? data.active() : true);
            existingAccessControlEntry.setConditions(data.conditions());
            existingAccessControlEntry.setNotes(data.notes());

            repository.save(existingAccessControlEntry);
        });

        if (accessControlEntry.isPresent()) {
            return ResponseEntity.ok("Controle de Acesso atualizado com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Controle de Acesso com id " + data.id() + " não encontrado.");
        }
    }

    @Transactional
    public ResponseEntity deleteAccessControlEntry(UUID id){
        Optional<AccessControlEntry> accessControlEntry = repository.findById(id);
        if (accessControlEntry.isPresent()) {
            repository.delete(accessControlEntry.get());
            return ResponseEntity.ok("Controle de Acesso deletado com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Controle de Acesso com id" + id + " não encontrado.");
        }


    }
}
