package com.example.webservices_cardealer.entities.validation;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EntityValidationError {
    private String field;
    private String message;
    private String rejectedValue;
}
