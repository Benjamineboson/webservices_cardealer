package com.example.webservices_cardealer.controllers;

import com.example.webservices_cardealer.entities.Engine;
import com.example.webservices_cardealer.repositories.EngineRepository;
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
public class EngineControllerTest {
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private EngineRepository engineRepository;

    @BeforeEach
    public void setUp(WebApplicationContext webApplicationContext, RestDocumentationContextProvider restDocumentation) {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .apply(documentationConfiguration(restDocumentation))
                .apply(SecurityMockMvcConfigurers.springSecurity())
                .build();
    }

    @Test
    @WithMockUser(value = "admin",roles = {"ADMIN"})
    void findAllEngine() throws Exception {
        given(engineRepository.findAll()).willReturn(List.of(Engine.builder().build()));
        mockMvc.perform(get("/api/v1/dealer/engines")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(document("v1/engines-get-all"));
    }

    @Test
    @WithMockUser(value = "admin",roles = {"ADMIN"})
    void findEngineById() throws Exception {
        given(engineRepository.findById(any())).willReturn(Optional.of(Engine.builder().build()));

        mockMvc.perform(get("/api/v1/dealer/engines/{id}", UUID.randomUUID().toString())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(document("v1/engines-get-one",
                        pathParameters(
                            parameterWithName("id").description("UUID string of desired engine to get.")
                        ),
                        responseFields(
                                fieldWithPath("engineId").description("Engine ID"),
                                fieldWithPath("brand").description("Engine brand"),
                                fieldWithPath("model").description("Engine model"),
                                fieldWithPath("cylinders").description("Number of cylinders"),
                                fieldWithPath("fuelType").description("Type of fuel")
                        )));
    }

    @Test
    @WithMockUser(value = "admin",roles = {"ADMIN"})
    void saveEngine() throws Exception {
        var engine = getValidEngine();
        engine.setEngineId(null);
        String engineJson = objectMapper.writeValueAsString(engine);
        ConstrainedFields fields = new ConstrainedFields(Engine.class);

        given(engineRepository.save(any())).willReturn(Engine.builder().build());

        mockMvc.perform(post("/api/v1/dealer/engines")
                .contentType(MediaType.APPLICATION_JSON)
                .content(engineJson))
                .andExpect(status().isCreated())
                .andDo(document("v1/engine-new",
                        requestFields(
                                fields.withPath("engineId").ignored(),
                                fields.withPath("brand").description("Engine brand"),
                                fields.withPath("model").description("Engine model"),
                                fields.withPath("cylinders").description("Number of cylinders"),
                                fields.withPath("fuelType").description("Type of fuel")
                        ),
                        responseFields(
                                fieldWithPath("engineId").description("Engine ID"),
                                fieldWithPath("brand").description("Engine brand"),
                                fieldWithPath("model").description("Engine model"),
                                fieldWithPath("cylinders").description("Number of cylinders"),
                                fieldWithPath("fuelType").description("Type of fuel")
                        )));
    }

    @Test
    @WithMockUser(value = "admin",roles = {"ADMIN"})
    void updateEngine() throws Exception {
        var engine = getValidEngine();
        String engineJson = objectMapper.writeValueAsString(engine);
        ConstrainedFields fields = new ConstrainedFields(Engine.class);

        given(engineRepository.existsById(any())).willReturn(true);

        mockMvc.perform(put("/api/v1/dealer/engines/{id}",UUID.randomUUID().toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(engineJson))
                .andExpect(status().isNoContent())
                .andDo(document("v1/engine-update",
                        pathParameters(
                                parameterWithName("id").description("UUID string of desired engine to update.")
                        ),
                        requestFields(
                                fields.withPath("engineId").ignored(),
                                fields.withPath("brand").description("Engine brand"),
                                fields.withPath("model").description("Engine model"),
                                fields.withPath("cylinders").description("Number of cylinders"),
                                fields.withPath("fuelType").description("Type of fuel")
                        )));
    }

    @Test
    @WithMockUser(value = "admin",roles = {"ADMIN"})
    void deleteEngine() throws Exception {
        given(engineRepository.existsById(any())).willReturn(true);
        mockMvc.perform(delete("/api/v1/dealer/engines/{id}", UUID.randomUUID().toString())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent())
                .andDo(document("v1/engine-delete" ,
                        pathParameters(
                                parameterWithName("id").description("UUID string of desired engine to delete.")
                        )));
    }
    Engine getValidEngine() {
        return Engine.builder()
                .engineId(UUID.randomUUID().toString())
                .brand("Volvo")
                .model("D4")
                .cylinders("4")
                .fuelType("Diesel")
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
