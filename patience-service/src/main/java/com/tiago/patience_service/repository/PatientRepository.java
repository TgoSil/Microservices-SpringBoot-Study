package com.tiago.patience_service.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tiago.patience_service.domain.model.PatientEntity;

@Repository
public interface PatientRepository extends JpaRepository<PatientEntity, UUID>{

}
