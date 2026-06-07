package com.tiago.patience_service.mapper.Impl;
import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.tiago.patience_service.domain.dto.PatientRequestDto;
import com.tiago.patience_service.domain.dto.PatientResponseDto;
import com.tiago.patience_service.domain.model.PatientEntity;
import com.tiago.patience_service.mapper.Mapper;

@Component
public class PatientMapperImpl implements Mapper<PatientEntity, PatientRequestDto, PatientResponseDto>{

    @Override
    public PatientResponseDto toDto(PatientEntity entity) {
        PatientResponseDto patientResponse = new PatientResponseDto();
        
        patientResponse.setId(entity.getId().toString());
        patientResponse.setName(entity.getName());
        patientResponse.setEmail(entity.getEmail());
        patientResponse.setAddress(entity.getAddress());
        patientResponse.setDate_of_birth(entity.getDate_of_birth().toString());

        return patientResponse;
    }

    @Override
    public PatientEntity toEntity(PatientRequestDto request) {
        PatientEntity patientEntity = new PatientEntity();
        
        patientEntity.setId(null);
        patientEntity.setName(request.getName());
        patientEntity.setEmail(request.getEmail());
        patientEntity.setAddress(request.getAddress());
        patientEntity.setDate_of_birth(LocalDate.parse(request.getDate_of_birth()));
        // patientEntity.setRegistered_date(LocalDate.parse(request.getRegistered_date()));

        return patientEntity;
    }

    
}
