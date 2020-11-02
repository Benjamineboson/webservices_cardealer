package com.example.webservices_cardealer.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Engine implements Serializable {
    private static final long serialVersionUID = 7276958240792417446L;

    @Id
    private String engineId;
    @NotEmpty(message = "Brand cannot be empty")
    @Size(min = 1,max = 20, message = "Brand must be between 1-20 characters")
    private String brand;
    @NotEmpty(message = "Model cannot be empty")
    @Size(min = 1,max = 20, message = "Model must be between 1-20 characters")
    private String model;
    @NotEmpty(message = "Cylinders cannot be empty")
    @Size(min = 1,max = 20, message = "Cylinders must be between 1-20 characters")
    private String cylinders;
    @NotEmpty(message = "Fuel type cannot be empty")
    @Size(min = 1,max = 20, message = "Fuel must be between 1-20 characters")
    private String fuelType;
}
