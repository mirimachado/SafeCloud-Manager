package com.project.manager.cloud.safe.dto;

import com.project.manager.cloud.safe.enums.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.UUID;

public record UserRequestDTO(
        UUID id,
        @NotBlank
        String username,

        @NotBlank(message = "O nome é obrigatório")
        @Size(min = 2, max = 100, message = "O nome deve ter entre 2 e 100 caracteres")
        String name,

        UserRole role,

        @NotBlank(message = "O email é obrigatório")
        @Email(message = "Email inválido")
        String email,

        @NotBlank(message = "A senha é obrigatória")
        @Size(min = 8, message = "A senha deve ter pelo menos 8 caracteres")
        @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^\\w\\s]).+$",
                message = "Senha deve conter letras maiúsculas, minúsculas, números e caracteres especiais")
        String password,

        String token,
        LocalDateTime timestampCreatedAt,
        LocalDateTime timestampUpdatedAt

        ) {}
