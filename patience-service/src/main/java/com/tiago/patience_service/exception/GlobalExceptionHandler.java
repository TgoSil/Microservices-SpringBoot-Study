package com.tiago.patience_service.exception;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(
        GlobalExceptionHandler.class);


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleValidationExceptions(
        MethodArgumentNotValidException exception) {

            Map<String, String> errors = new HashMap<>();
            exception.getBindingResult().getFieldErrors().forEach(erro -> errors.put(erro.getField(), erro.getDefaultMessage()));

            return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<Map<String,String>> handleEmailAlreadyExistsException(
        EmailAlreadyExistsException exception) {

            log.warn("Email já está em uso {}", exception.getMessage());
            Map<String,String> erros = new HashMap<>();
            erros.put("message:", exception.getMessage());

            return ResponseEntity.badRequest().body(erros);
        }

}
