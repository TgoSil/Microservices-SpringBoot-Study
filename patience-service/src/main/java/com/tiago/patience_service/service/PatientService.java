package com.tiago.patience_service.service;

import java.util.List;
import java.util.UUID;

import com.tiago.patience_service.domain.dto.PatientRequestDto;
import com.tiago.patience_service.domain.dto.PatientResponseDto;


public interface PatientService {

    public List<PatientResponseDto> getAllPatients();

    public PatientResponseDto createPatient(PatientRequestDto patientRequest);
    
    public PatientResponseDto updatePatient(UUID id, PatientRequestDto patientRequest);

}
