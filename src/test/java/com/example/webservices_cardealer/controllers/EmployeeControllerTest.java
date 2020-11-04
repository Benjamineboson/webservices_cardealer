package com.example.webservices_cardealer.controllers;

import com.example.webservices_cardealer.entities.Employee;
import com.example.webservices_cardealer.repositories.EmployeeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.constraints.ConstraintDescriptions;
import org.springframework.restdocs.payload.FieldDescriptor;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.StringUtils;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.restdocs.snippet.Attributes.key;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(RestDocumentationExtension.class)
public class EmployeeControllerTest {

    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private EmployeeRepository employeeRepository;

    @BeforeEach
    public void setUp(WebApplicationContext webApplicationContext, RestDocumentationContextProvider restDocumentation) {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .apply(documentationConfiguration(restDocumentation))
                .apply(SecurityMockMvcConfigurers.springSecurity())
                .build();
    }

    @Test
    @WithMockUser(value = "admin", roles = "ADMIN")
    void findAllEmployees() throws Exception {
        given(employeeRepository.findAll()).willReturn(List.of(Employee.builder().build()));

        mockMvc.perform(get("/api/v1/dealer/employees")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(document("v1/employees-get-all"));
    }

    @Test
    @WithMockUser(value = "admin", roles = "ADMIN")
    void findEmployeeById() throws Exception {
        given(employeeRepository.findById(any())).willReturn(Optional.of(Employee.builder().build()));

        mockMvc.perform(get("/api/v1/dealer/employees/{id}", UUID.randomUUID().toString())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(document("v1/employees-get-one",
                        pathParameters(
                                parameterWithName("id").description("UUID string of desired car to get.")
                        ),
                        responseFields(
                                fieldWithPath("employeeId").type("UUDI").description("Employee Id"),
                                fieldWithPath("firstname").description("Firstname of the Employee"),
                                fieldWithPath("lastname").description("Lastname of the Employee"),
                                fieldWithPath("birthdate").description("Birthdate of the Employee"),
                                fieldWithPath("phone").description("Employees phone number"),
                                fieldWithPath("email").description("Employees email address"),
                                fieldWithPath("username").description("Employees username"),
                                fieldWithPath("acl").description("List of employees authorities")
                        )));
    }

    @Test
    @WithMockUser(value = "admin", roles = "ADMIN")
    void saveEmployee() throws Exception {
        var employee = getValidEmployee();
        employee.setEmployeeId(null);
        String employeeJson = objectMapper.writeValueAsString(employee);
        employeeJson = employeeJson.replace("}", ",\"password\":\"" + employee.getPassword() + "\"}");

        given(employeeRepository.save(any())).willReturn(Employee.builder().build());

        ConstrainedFields fields = new ConstrainedFields(Employee.class);

        mockMvc.perform(post("/api/v1/dealer/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content(employeeJson))
                .andExpect(status().isCreated())
                .andDo(document("v1/employee-new",
                        requestFields(
                                fields.withPath("employeeId").ignored(),
                                fields.withPath("firstname").description("Firstname of the Employee"),
                                fields.withPath("lastname").description("Lastname of the Employee"),
                                fields.withPath("birthdate").description("Birthdate of the Employee"),
                                fields.withPath("phone").description("Employees phone number"),
                                fields.withPath("email").description("Employees email address"),
                                fields.withPath("username").description("Employees username"),
                                fields.withPath("password").description("Employees password"),
                                fields.withPath("acl").description("List of employees authorities")
                        ),
                        responseFields(
                                fieldWithPath("employeeId").description("Employee Id"),
                                fieldWithPath("firstname").description("Firstname of the Employee"),
                                fieldWithPath("lastname").description("Lastname of the Employee"),
                                fieldWithPath("birthdate").description("Birthdate of the Employee").type(LocalDate.class),
                                fieldWithPath("phone").description("Employees phone number"),
                                fieldWithPath("email").description("Employees email address"),
                                fieldWithPath("username").description("Employees username"),
                                fieldWithPath("acl").description("List of employees authorities")
                        )));
    }

    @Test
    @WithMockUser(value = "admin", roles = "ADMIN")
    void updateEmployee() throws Exception {
        var employee = getValidEmployee();
        employee.setEmployeeId(null);
        String employeeJson = objectMapper.writeValueAsString(employee);
        employeeJson = employeeJson.replace("}", ",\"password\":\"" + employee.getPassword() + "\"}");

        given(employeeRepository.existsById(any())).willReturn(true);

        ConstrainedFields fields = new ConstrainedFields(Employee.class);

        mockMvc.perform(put("/api/v1/dealer/employees/{id}", UUID.randomUUID().toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(employeeJson))
                .andExpect(status().isNoContent())
                .andDo(document("v1/employee-update",
                        pathParameters(
                                parameterWithName("id").description("UUID string of desired car to get.")
                        ),
                        requestFields(
                                fields.withPath("employeeId").ignored(),
                                fields.withPath("firstname").description("Firstname of the Employee"),
                                fields.withPath("lastname").description("Lastname of the Employee"),
                                fields.withPath("birthdate").description("Birthdate of the Employee"),
                                fields.withPath("phone").description("Employees phone number"),
                                fields.withPath("email").description("Employees email address"),
                                fields.withPath("username").description("Employees username"),
                                fields.withPath("password").description("Employees password"),
                                fields.withPath("acl").description("List of employees authorities")
                        )));
    }

    @Test
    @WithMockUser(value = "admin", roles = "ADMIN")
    void deleteEmployee() throws Exception {
        given(employeeRepository.existsById(any())).willReturn(true);

        mockMvc.perform(delete("/api/v1/dealer/employees/{id}", UUID.randomUUID().toString())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent())
                .andDo(document("v1/employee-delete",
                        pathParameters(
                                parameterWithName("id").description("UUID string of desired employee to delete.")
                        )));
    }

    Employee getValidEmployee() {
        return Employee.builder()
                .employeeId(UUID.randomUUID().toString())
                .firstname("John")
                .lastname("Doe")
                .birthdate(LocalDate.of(1970, 1,2))
                .phone("070-1234567")
                .email("john@mail.com")
                .username("johnDoe")
                .password("password")
                .acl(List.of("EMPLOYEE"))
                .build();
    }

    private static class ConstrainedFields {

        private final ConstraintDescriptions constraintDescriptions;

        ConstrainedFields(Class<?> input) {
            this.constraintDescriptions = new ConstraintDescriptions(input);
        }

        private FieldDescriptor withPath(String path) {
            return fieldWithPath(path).attributes(key("constraints").value(StringUtils
                    .collectionToDelimitedString(this.constraintDescriptions.descriptionsForProperty(path), ". ")));
        }
    }

}
