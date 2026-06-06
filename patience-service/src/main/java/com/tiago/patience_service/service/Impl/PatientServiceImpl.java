package com.tiago.patience_service.service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiago.patience_service.domain.dto.PatientRequestDto;
import com.tiago.patience_service.domain.dto.PatientResponseDto;
import com.tiago.patience_service.domain.model.PatientEntity;
import com.tiago.patience_service.mapper.Mapper;
import com.tiago.patience_service.repository.PatientRepository;
import com.tiago.patience_service.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private final PatientRepository patientRepository;

    @Autowired
    private final Mapper<PatientEntity, PatientRequestDto, PatientResponseDto> patientMapper;
    
    public PatientServiceImpl(PatientRepository patientRepository,
                                Mapper<PatientEntity, PatientRequestDto, PatientResponseDto> patientMapper) {
        this.patientRepository = patientRepository;
        this.patientMapper = patientMapper;
    }

    @Override
    public List<PatientResponseDto> getAllPatients() {
        List<PatientEntity> pacientes = patientRepository.findAll();
        return pacientes.stream().map(patientMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public PatientResponseDto createPatient(PatientRequestDto patientRequest) { 
        PatientEntity patientSaved = patientRepository.save(
                        patientMapper.toEntity(patientRequest));
        return patientMapper.toDto(patientSaved);
    }

    

}
