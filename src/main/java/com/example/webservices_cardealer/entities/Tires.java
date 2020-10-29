package com.example.webservices_cardealer.entities;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@Builder
public class Tires implements Serializable {
    private static final long serialVersionUID = 2601917834226688642L;

    @Id
    private String tiresId;
    @NotEmpty(message = "Brand cannot be empty")
    @Size(min = 1,max = 20, message = "Brand must be between 1-20 characters")
    private String brand;
    @NotEmpty(message = "Dimension cannot be empty")
    @Size(min = 1,max = 40, message = "Dimension must be between 1-20 characters")
    private String dimension;
    @NotEmpty(message = "Tire type cannot be empty")
    @Size(min = 1,max = 20, message = "Brand must be between 1-20 characters")
    private String tireType;
    @NotEmpty(message = "Year model number cannot be empty")
    @Pattern(regexp = "^\\d{4}$",message = "Invalid year. Valid year: YYYY")
    private String yearModel;
}
