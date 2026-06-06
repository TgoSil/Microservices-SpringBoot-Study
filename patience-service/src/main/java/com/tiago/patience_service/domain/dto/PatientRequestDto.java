package com.tiago.patience_service.domain.dto;
import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientRequestDto {

    @NotBlank(message = "Nome não pode ser vazio")
    @Size(max = 100, message = "Nome não pode passar de 100 caracteres")
    private String name;

    @NotBlank(message = "Email não pode ser vazio")
    private String email;

    @NotBlank(message = "Endereço não pode ser vazio")
    private String address;

    @NotNull(message = "Data de nascimento não pode ser vazio")
    private LocalDate date_of_birth;

    @NotNull(message = "Data de registro não pode ser nulo")
    private LocalDate registered_date;


}
