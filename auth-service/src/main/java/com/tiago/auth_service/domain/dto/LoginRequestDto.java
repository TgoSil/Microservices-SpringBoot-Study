package com.tiago.auth_service.domain.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginRequestDto {

    @NotBlank(message = "O campo 'email' não pode estar vazio")
    @Email(message = "'Email' deve ser um email válido")
    private String email;

    @NotBlank(message = "O campo 'senha' não pode estar vazio")
    @Size(min = 8, message = "A senha deve ter no mínimo 8 caracteres")
    private String password;

}
