package com.project.manager.cloud.safe.systemsettings.service;

import com.project.manager.cloud.safe.systemsettings.dto.SystemSettingsRequestDTO;
import com.project.manager.cloud.safe.systemsettings.entity.SystemSettings;
import com.project.manager.cloud.safe.systemsettings.repository.SystemSettingsRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SystemSettingsService {

    @Autowired
    private SystemSettingsRepository repository;

    public ResponseEntity<List<SystemSettings>> getAllSettings() {
        return ResponseEntity.ok(repository.findAll());
    }

    @Transactional
    public ResponseEntity<?> createSetting(SystemSettingsRequestDTO data) {
        SystemSettings setting = SystemSettings.builder()
                .key(data.key())
                .value(data.value())
                .updatedAt(new Date())
                .build();

        repository.save(setting);
        return ResponseEntity.ok("Configuração criada com sucesso.");
    }

    @Transactional
    public ResponseEntity<?> updateSetting(SystemSettingsRequestDTO data) {
        Optional<SystemSettings> settingOpt = repository.findById(data.id());
        if (settingOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Configuração com id " + data.id() + " não encontrada.");
        }

        SystemSettings setting = settingOpt.get();
        setting.setKey(data.key());
        setting.setValue(data.value());
        setting.setUpdatedAt(new Date());

        repository.save(setting);
        return ResponseEntity.ok("Configuração atualizada com sucesso.");
    }

    @Transactional
    public ResponseEntity<?> deleteSetting(UUID id) {
        Optional<SystemSettings> settingOpt = repository.findById(id);
        if (settingOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Configuração com id " + id + " não encontrada.");
        }

        repository.delete(settingOpt.get());
        return ResponseEntity.ok("Configuração deletada com sucesso.");
    }
}
