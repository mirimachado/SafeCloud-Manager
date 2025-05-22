package com.project.manager.cloud.safe.controller;

import com.project.manager.cloud.safe.dto.requests.AccessControlEntryRequestDTO;
import com.project.manager.cloud.safe.service.AccessControlEntryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/access_control_entry")
public class AccessControlEntryController {
    @Autowired
    private AccessControlEntryService accessControlEntryService;

    @GetMapping
    public ResponseEntity getAccessControlEntry(){
        return accessControlEntryService.getAccessControlEntry();

    }

    @PostMapping
    public ResponseEntity createAccessControlEntry(@RequestBody @Valid AccessControlEntryRequestDTO data) {
        return accessControlEntryService.createAccessControlEntry(data);
    }

    @PutMapping()
    public ResponseEntity updateAccessControlEntry(@RequestBody @Valid AccessControlEntryRequestDTO data) {
        return accessControlEntryService.createAccessControlEntry(data);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAccessControlEntry(@PathVariable UUID id) {
        return accessControlEntryService.deleteAccessControlEntry(id);
    }


}
