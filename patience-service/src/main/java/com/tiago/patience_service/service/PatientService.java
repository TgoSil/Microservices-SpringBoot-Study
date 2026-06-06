package com.tiago.patience_service.service;

import java.util.List;

import com.tiago.patience_service.domain.dto.PatientRequestDto;
import com.tiago.patience_service.domain.dto.PatientResponseDto;
import com.tiago.patience_service.domain.model.PatientEntity;

public interface PatientService {

    public List<PatientResponseDto> getAllPatients();

    public PatientResponseDto createPatient(PatientRequestDto patientRequest);
    
}
