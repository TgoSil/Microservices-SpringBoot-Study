package com.tiago.patience_service.service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiago.patience_service.domain.dto.PatientDto;
import com.tiago.patience_service.domain.model.PatientEntity;
import com.tiago.patience_service.mapper.Mapper;
import com.tiago.patience_service.repository.PatientRepository;
import com.tiago.patience_service.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private final PatientRepository patientRepository;

    @Autowired
    private final Mapper<PatientEntity, PatientDto> patientMapper;
    
    public PatientServiceImpl(PatientRepository patientRepository, Mapper<PatientEntity, PatientDto> patientMapper) {
        this.patientRepository = patientRepository;
        this.patientMapper = patientMapper;
    }

    @Override
    public List<PatientDto> getAllPatients() {
        List<PatientEntity> pacientes = patientRepository.findAll();
        return pacientes.stream().map(patientMapper::toDto).collect(Collectors.toList());
    }

}
