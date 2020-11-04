package com.example.webservices_cardealer.controllers;

import com.example.webservices_cardealer.entities.Car;
import com.example.webservices_cardealer.entities.Engine;
import com.example.webservices_cardealer.entities.Tires;
import com.example.webservices_cardealer.repositories.CarRepository;
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

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.restdocs.snippet.Attributes.key;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(RestDocumentationExtension.class)
public class CarControllerTest {

    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private CarRepository carRepository;

    @BeforeEach
    public void setUp(WebApplicationContext webApplicationContext, RestDocumentationContextProvider restDocumentation) {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .apply(documentationConfiguration(restDocumentation))
                .apply(SecurityMockMvcConfigurers.springSecurity())
                .build();
    }

    @Test
    @WithMockUser(value = "admin",roles = {"ADMIN"})
    void findAllCars() throws Exception {
        given(carRepository.findAll()).willReturn(List.of(Car.builder().build()));

        mockMvc.perform(get("/api/v1/dealer/cars").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(document("v1/cars-get-all"));
    }

    @Test
    @WithMockUser(value = "admin",roles = {"ADMIN"})
    void findCarById() throws Exception {
        given(carRepository.findById(any())).willReturn(Optional.of(Car.builder().build()));

        mockMvc.perform(get("/api/v1/dealer/cars/{id}", UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(document("v1/cars-get-one",
                        pathParameters(
                                parameterWithName("id").description("UUID string of desired car to get.")
                        ),
                        responseFields(
                                fieldWithPath("carId").description("Car ID"),
                                fieldWithPath("registrationNumber").description("Car registration number"),
                                fieldWithPath("brand").description("Car brand"),
                                fieldWithPath("model").description("Car model"),
                                fieldWithPath("color").description("Car color"),
                                fieldWithPath("yearModel").description("Year the of creation"),
                                fieldWithPath("engine").description("Car engine type").type(Engine.class),
                                fieldWithPath("tires").description("Car tires type").type(Tires.class),
                                fieldWithPath("sold").description("true/false"),
                                fieldWithPath("inStock").description("true/false"),
                                fieldWithPath("reserved").description("true/false")
                        )));
    }

    @Test
    @WithMockUser(value = "admin",roles = {"ADMIN"})
    void saveCar() throws Exception {
        Car car = getValidCar();
        car.setCarId(null);
        String carJson = objectMapper.writeValueAsString(car);

        given(carRepository.save(any())).willReturn(Car.builder().build());

        ConstrainedFields fields = new ConstrainedFields(Car.class);

        mockMvc.perform(post("/api/v1/dealer/cars")
                .contentType(MediaType.APPLICATION_JSON)
                .content(carJson))
                .andExpect(status().isCreated())
                .andDo(document("v1/car-new",
                        requestFields(
                                fields.withPath("carId").ignored(),
                                fields.withPath("registrationNumber").description("Car registration number"),
                                fields.withPath("brand").description("Car brand"),
                                fields.withPath("model").description("Car brand"),
                                fields.withPath("color").description("Car color"),
                                fields.withPath("yearModel").description("Year of the creation"),
                                fields.withPath("engine").description("Car engine type"),
                                fields.withPath("tires").description("Car tires type"),
                                fields.withPath("sold").description("true/false"),
                                fields.withPath("inStock").description("true/false"),
                                fields.withPath("reserved").description("true/false")
                        ),
                        responseFields(
                                fieldWithPath("carId").description("Car ID"),
                                fieldWithPath("registrationNumber").description("Car registration number"),
                                fieldWithPath("brand").description("Car brand"),
                                fieldWithPath("model").description("Car model"),
                                fieldWithPath("color").description("Car color"),
                                fieldWithPath("yearModel").description("Year the of creation"),
                                fieldWithPath("engine").description("Car engine type").type(Engine.class),
                                fieldWithPath("tires").description("Car tires type").type(Tires.class),
                                fieldWithPath("sold").description("true/false"),
                                fieldWithPath("inStock").description("true/false"),
                                fieldWithPath("reserved").description("true/false")
                        )));
    }

    @Test
    @WithMockUser(value = "admin",roles = {"ADMIN"})
    void updateCar() throws Exception {
        Car car = getValidCar();
        String carJson = objectMapper.writeValueAsString(car);
        ConstrainedFields fields = new ConstrainedFields(Car.class);

        given(carRepository.existsById(any())).willReturn(true);

        mockMvc.perform(put("/api/v1/dealer/cars/{id}", UUID.randomUUID().toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(carJson))
                .andExpect(status().isNoContent())
                .andDo(document("v1/car-update",
                        pathParameters(
                                parameterWithName("id").description("UUID string of desired course to update.")
                        ),
                        requestFields(
                                fields.withPath("carId").ignored(),
                                fields.withPath("registrationNumber").description("Car registration number"),
                                fields.withPath("brand").description("Car brand"),
                                fields.withPath("model").description("Car brand"),
                                fields.withPath("color").description("Car color"),
                                fields.withPath("yearModel").description("Year of the creation"),
                                fields.withPath("engine").description("Car engine type"),
                                fields.withPath("tires").description("Car tires type"),
                                fields.withPath("sold").description("true/false"),
                                fields.withPath("inStock").description("true/false"),
                                fields.withPath("reserved").description("true/false")
                        )));
    }

    @Test
    @WithMockUser(value = "admin",roles = {"ADMIN"})
    void deleteCar() throws Exception {
        given(carRepository.existsById(any())).willReturn(true);
        mockMvc.perform(delete("/api/v1/dealer/cars/{id}", UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent())
                .andDo(document("v1/car-delete", pathParameters(
                        parameterWithName("id").description("UUID string of desired car to delete.")
                )));
    }

    Car getValidCar() {
        return Car.builder()
                .carId(UUID.randomUUID().toString())
                .registrationNumber("ABC123")
                .brand("Volvo")
                .model("V90")
                .color("Black")
                .yearModel("2020")
                .isSold(false)
                .isInStock(true)
                .isReserved(false)
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
