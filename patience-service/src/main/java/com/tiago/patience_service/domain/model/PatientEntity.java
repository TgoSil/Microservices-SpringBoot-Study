package com.tiago.patience_service.domain.model;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PatientEntity {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private UUID id;

    @NotNull
    private String nome;

    @NotNull
    @Email
    @Column(unique = true)
    private String email;

    @NotNull
    private String endereco;

    @NotNull
    private LocalDate dataDeNascimento;

    @NotNull
    private LocalDate dataRegistro;
}
