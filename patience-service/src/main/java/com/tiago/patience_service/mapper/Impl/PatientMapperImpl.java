package com.tiago.patience_service.mapper.Impl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tiago.patience_service.domain.dto.PatientRequestDto;
import com.tiago.patience_service.domain.dto.PatientResponseDto;
import com.tiago.patience_service.domain.model.PatientEntity;
import com.tiago.patience_service.mapper.Mapper;

@Component
public class PatientMapperImpl implements Mapper<PatientEntity, PatientRequestDto, PatientResponseDto>{
    @Autowired
    public ModelMapper modelMapper;

    public PatientMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public PatientResponseDto toDto(PatientEntity entity) {
        return modelMapper.map(entity, PatientResponseDto.class);
    }

    @Override
    public PatientEntity toEntity(PatientRequestDto request) {
        return modelMapper.map(request, PatientEntity.class);
    }

    
}
