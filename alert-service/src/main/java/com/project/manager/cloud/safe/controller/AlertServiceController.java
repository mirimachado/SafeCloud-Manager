package com.project.manager.cloud.safe.controller;

import com.project.manager.cloud.safe.dto.AlertServiceRequestDTO;
import com.project.manager.cloud.safe.service.AlertServiceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/alert_service")
public class AlertServiceController {

    @Autowired
    private AlertServiceService alertServiceService;

    @GetMapping
    public ResponseEntity getAlerts(){
        return alertServiceService.getAlerts();

    }

    @PostMapping
    public ResponseEntity createAlerts(@RequestBody @Valid AlertServiceRequestDTO data) {
        return alertServiceService.createAlertService(data);
    }

    @PutMapping()
    public ResponseEntity updateAlerts(@RequestBody @Valid AlertServiceRequestDTO data) {
        return alertServiceService.updateAlertService(data);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAlerts(@PathVariable UUID id) {
        return alertServiceService.deleteAlertService(id);
    }


}
