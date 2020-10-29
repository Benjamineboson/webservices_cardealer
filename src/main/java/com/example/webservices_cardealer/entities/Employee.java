package com.example.webservices_cardealer.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class Employee implements Serializable {

    private static final long serialVersionUID = -4711394998133225957L;
    @Id
    private String employeeId;
    private String firstname;
    private String lastname;
    @Past
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    private LocalDate birthdate;
    @Pattern(regexp = "([0-9]){2,4}-([0-9]){5,8}", message = "Phone number not valid")
    private String phone;
    @Email
    private String email;
    @Indexed(unique = true)
    private String username;
    @NotBlank(message = "Password must contain a value")
    @JsonIgnore
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private List<String> acl;
}
