package com.tiago.patience_service.domain.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientDto {

    private String id;

    private String nome;

    private String email;

    private String endereco;

    private LocalDate dataDeNascimento;

    
}
