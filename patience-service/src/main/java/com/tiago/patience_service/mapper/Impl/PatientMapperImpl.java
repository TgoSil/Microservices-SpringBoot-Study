package com.tiago.patience_service.mapper.Impl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tiago.patience_service.domain.dto.PatientDto;
import com.tiago.patience_service.domain.model.PatientEntity;
import com.tiago.patience_service.mapper.Mapper;

@Component
public class PatientMapperImpl implements Mapper<PatientEntity, PatientDto>{
    @Autowired
    public ModelMapper modelMapper;

    public PatientMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public PatientDto toDto(PatientEntity u) {
        return modelMapper.map(u, PatientDto.class);
    }

    @Override
    public PatientEntity toEntity(PatientDto v) {
        return modelMapper.map(v, PatientEntity.class);
    }
    
}
