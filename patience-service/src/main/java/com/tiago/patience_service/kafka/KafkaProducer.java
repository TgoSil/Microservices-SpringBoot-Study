package com.tiago.patience_service.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.tiago.patience_service.domain.model.PatientEntity;

import patient.events.PatientEvent;

@Service
public class KafkaProducer {
    private final KafkaTemplate<String, byte[]> kafkaTemplate;

    private static final Logger log = LoggerFactory.getLogger(KafkaProducer.class);

    public KafkaProducer(KafkaTemplate<String, byte[]> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendEvent(PatientEntity patient) {
        PatientEvent event = PatientEvent.newBuilder()
        .setPatientId(patient.getId().toString())
        .setName(patient.getName())
        .setEmail(patient.getEmail())
        .setEventType("PATIENT_CREATED")
        .build();

        try {
            kafkaTemplate.send("patient", event.toByteArray());
            log.info("PacientCreated event enviado com sucesso ");
        } catch (Exception e) {
            log.error("Erro enviando PatientCreated event: {}", event);
        }
    }
}
