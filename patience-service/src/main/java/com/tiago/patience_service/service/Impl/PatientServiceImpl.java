package com.tiago.patience_service.service.Impl;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.tiago.patience_service.domain.dto.PatientRequestDto;
import com.tiago.patience_service.domain.dto.PatientResponseDto;
import com.tiago.patience_service.domain.model.PatientEntity;
import com.tiago.patience_service.exception.EmailAlreadyExistsException;
import com.tiago.patience_service.exception.PatientNotFoundException;
import com.tiago.patience_service.grpc.BillingServiceGrpcClient;
import com.tiago.patience_service.mapper.Mapper;
import com.tiago.patience_service.repository.PatientRepository;
import com.tiago.patience_service.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
    private final Mapper<PatientEntity, PatientRequestDto, PatientResponseDto> patientMapper;
    private final BillingServiceGrpcClient billingServiceClient;
    
    public PatientServiceImpl(PatientRepository patientRepository,
        Mapper<PatientEntity, PatientRequestDto, PatientResponseDto> patientMapper,
        BillingServiceGrpcClient billingServiceClient) {
        this.patientRepository = patientRepository;
        this.patientMapper = patientMapper;
        this.billingServiceClient = billingServiceClient;
    }

    @Override
    public List<PatientResponseDto> getAllPatients() {
        List<PatientEntity> pacientes = patientRepository.findAll();
        return pacientes.stream().map(patientMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public PatientResponseDto createPatient(PatientRequestDto patientRequest) { 
        if (patientRepository.existsByEmail(patientRequest.getEmail())) {
            throw new EmailAlreadyExistsException("Email já está sendo usado por outro usuário.");
        }
        PatientEntity patientTemporary = patientMapper.toEntity(patientRequest);
        patientTemporary.setRegistered_date(LocalDate.now());
        PatientEntity patientSaved = patientRepository.save(patientTemporary);
        
        billingServiceClient.createBillingAccount(
            patientSaved.getId().toString(),
            patientSaved.getName(),
            patientSaved.getEmail());
        
        return patientMapper.toDto(patientSaved);
    }

    @Override
    public PatientResponseDto updatePatient(UUID id, PatientRequestDto patientRequest) {
        
        PatientEntity patientEntity = patientRepository.findById(id).orElseThrow(
            () -> new PatientNotFoundException("Id não vinculado à nenhuma conta: " + id));
        
        patientEntity.setName(patientRequest.getName());
        patientEntity.setEmail(patientRequest.getEmail());
        patientEntity.setDate_of_birth(LocalDate.parse(patientRequest.getDate_of_birth()));
        patientEntity.setAddress(patientRequest.getAddress());

        PatientEntity updatedPatient = patientRepository.save(patientEntity);

        return patientMapper.toDto(updatedPatient);
    }

    @Override
    public void deletePatient(UUID id) {
        patientRepository.findById(id).orElseThrow(
            () -> new PatientNotFoundException("Id não vinculado à nenhuma conta: " + id)
        );
        patientRepository.deleteById(id);
    }
    
}
