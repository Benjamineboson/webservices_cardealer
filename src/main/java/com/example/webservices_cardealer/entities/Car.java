package com.example.webservices_cardealer.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.*;
import java.io.Serializable;

@Builder
@Data
public class Car implements Serializable {
    private static final long serialVersionUID = -1119146907465745507L;
    @Id
    private String carId;
    @Pattern(regexp = "[A-Za-z]{3}[0-9]{2}[A-Za-z0-9]{1}",message = "Invalid registration number")
    @NotEmpty(message = "Registration number cannot be empty")
    private String registrationNumber;
    @Size(min = 1,max = 20, message = "Brand must be between 1-20 characters")
    @NotEmpty(message = "Registration number cannot be empty")
    private String brand;
    @Size(min = 1,max = 20, message = "Model must be between 1-20 characters")
    @NotEmpty(message = "Registration number cannot be empty")
    private String model;
    @NotEmpty(message = "Registration number cannot be empty")
    @Size(min = 1,max = 20, message = "Color must be between 1-20 characters")
    private String color;
    @NotEmpty(message = "Year model cannot be empty")
    @Pattern(regexp = "^\\d{4}$",message = "Invalid year. Valid year: YYYY")
    private String yearModel;
    private Engine engine;
    private Tires tires;
    private boolean isSold;
    private boolean isInStock = true;
    private boolean isReserved;
}
