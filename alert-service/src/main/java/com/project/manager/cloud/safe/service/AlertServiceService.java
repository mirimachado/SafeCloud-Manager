package com.project.manager.cloud.safe.service;

import com.project.manager.cloud.safe.dto.AlertServiceRequestDTO;
import com.project.manager.cloud.safe.entity.AlertService;
import com.project.manager.cloud.safe.repository.AlertServiceRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AlertServiceService {

    @Autowired
    private AlertServiceRepository repository;

    public ResponseEntity getAlerts(){
        List<AlertService> alertServices = repository.findAll();
        return ResponseEntity.ok(alertServices);
    }
    @Transactional
    public ResponseEntity createAlertService(AlertServiceRequestDTO data){
        Optional<AlertService> alertCode = repository.findByCode(data.code());

        if (alertCode.isPresent()){
            return ResponseEntity.badRequest().body("Esse código já existe. Tente novamente.");
        }else {
            AlertService alert = AlertService.builder()
                    .message(data.message())
                    .severity(data.severity())
                    .resolved(data.resolved())
                    .resolvedAt(data.resolvedAt())
                    .resolutionNote(data.resolutionNote())
                    .source(data.source())
                    .category(data.category())
                    .context(data.context())
                    .assignedTo(data.assignedTo())
                    .code(data.code())
                    .relatedEntityId(data.relatedEntityId())
                    .relatedEntityType(data.relatedEntityType())
                    .priority(data.priority())
                    .build();

            repository.save(alert);
            return ResponseEntity.ok("Alerta criado com sucesso.");

        }
    }
    @Transactional
    public ResponseEntity<?> updateAlertService(AlertServiceRequestDTO data) {
        Optional<AlertService> alert = repository.findById(data.id());

        alert.ifPresent(existingAlert -> {
            existingAlert.setMessage(data.message());
            existingAlert.setSeverity(data.severity());
            existingAlert.setResolved(data.resolved());
            existingAlert.setResolvedAt(data.resolvedAt());
            existingAlert.setResolutionNote(data.resolutionNote());
            existingAlert.setSource(data.source());
            existingAlert.setCategory(data.category());
            existingAlert.setContext(data.context());
            existingAlert.setAssignedTo(data.assignedTo());
            existingAlert.setCode(data.code());
            existingAlert.setRelatedEntityId(data.relatedEntityId());
            existingAlert.setRelatedEntityType(data.relatedEntityType());
            existingAlert.setPriority(data.priority());

            repository.save(existingAlert);
        });

        if (alert.isPresent()) {
            return ResponseEntity.ok("Alerta atualizado com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Alerta com id " + data.id() + " não encontrado.");
        }
    }

    @Transactional
    public ResponseEntity deleteAlertService(UUID id){
        Optional<AlertService> alert = repository.findById(id);
        if (alert.isPresent()) {
            repository.delete(alert.get());
            return ResponseEntity.ok("Alerta deletado com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Alerta com id " + id + " não encontrado.");
        }


    }

}
