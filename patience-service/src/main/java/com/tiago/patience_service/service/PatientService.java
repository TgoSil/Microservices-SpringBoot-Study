package com.tiago.patience_service.service;

import java.util.List;

import com.tiago.patience_service.domain.dto.PatientDto;
import com.tiago.patience_service.domain.model.PatientEntity;

public interface PatientService {

    public List<PatientDto> getAllPatients();
    
}
