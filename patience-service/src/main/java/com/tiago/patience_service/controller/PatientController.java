package com.tiago.patience_service.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tiago.patience_service.domain.dto.PatientRequestDto;
import com.tiago.patience_service.domain.dto.PatientResponseDto;
import com.tiago.patience_service.service.PatientService;

import jakarta.validation.Valid;

@RestController
public class PatientController {

    private final PatientService patientService;
    
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping(path = "patients")
    public ResponseEntity<List<PatientResponseDto>> getAll() {
        return ResponseEntity.ok(patientService.getAllPatients());
    }

    @PostMapping(path = "patients")
    public ResponseEntity<PatientResponseDto> postNewPatient(
                @Valid @RequestBody final PatientRequestDto patientRequest) {      
        PatientResponseDto savedPatient = patientService.createPatient(patientRequest);
        return new ResponseEntity<>(savedPatient, HttpStatus.CREATED);
    }

}
