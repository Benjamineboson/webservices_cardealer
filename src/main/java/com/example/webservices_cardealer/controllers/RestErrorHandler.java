package com.example.webservices_cardealer.controllers;

import com.example.webservices_cardealer.entities.validation.EntityValidationError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.stream.Collectors;

@ControllerAdvice
public class RestErrorHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status,
                                                                  WebRequest request) {
        var entityValidationError =  ex.getBindingResult().getFieldErrors().stream()
                .map(fieldError -> EntityValidationError.builder()
                        .field(fieldError.getField())
                        .message(fieldError.getDefaultMessage())
                        .rejectedValue(String.valueOf(fieldError.getRejectedValue()))
                        .build())
                .collect(Collectors.toList());
        return ResponseEntity.status(status).headers(headers).body(entityValidationError);
    }
}