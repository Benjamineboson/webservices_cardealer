package com.example.webservices_cardealer.controllers;

import com.example.webservices_cardealer.entities.Tires;
import com.example.webservices_cardealer.repositories.TiresRepository;
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
public class TiresControllerTest {

    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
   private TiresRepository tiresRepository;

    @BeforeEach
    public void setUp(WebApplicationContext webApplicationContext, RestDocumentationContextProvider restDocumentation) {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .apply(documentationConfiguration(restDocumentation))
                .apply(SecurityMockMvcConfigurers.springSecurity())
                .build();
    }

    @Test
    @WithMockUser(value = "admin",roles = {"ADMIN"})
    void findAllTires() throws Exception{
        given(tiresRepository.findAll()).willReturn(List.of(Tires.builder().build()));

        mockMvc.perform(get("/api/v1/dealer/tires")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(document("v1/tires-get-all"));
    }

    @Test
    @WithMockUser(value = "admin",roles = {"ADMIN"})
    void findTiresById() throws Exception {
        given(tiresRepository.findById(any())).willReturn(Optional.of(Tires.builder().build()));

        mockMvc.perform(get("/api/v1/dealer/tires/{id}", UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(document("v1/tires-get-one",
                        pathParameters(
                                parameterWithName("id").description("UUID string of desired tires to get.")
                        ),
                        responseFields(
                                fieldWithPath("tiresId").description("Tires ID"),
                                fieldWithPath("brand").description("Tires brand"),
                                fieldWithPath("dimension").description("Tires dimensions"),
                                fieldWithPath("tireType").description("Type of Tires"),
                                fieldWithPath("yearModel").description("Year of creation")
                        )));
    }

    @Test
    @WithMockUser(value = "admin",roles = {"ADMIN"})
    void saveTires() throws Exception {
        var tires = getValidTires();
        tires.setTiresId(null);
        String tiresJson = objectMapper.writeValueAsString(tires);

        given(tiresRepository.save(any())).willReturn(Tires.builder().build());
        ConstrainedFields fields = new ConstrainedFields(Tires.class);

        mockMvc.perform(post("/api/v1/dealer/tires")
                .contentType(MediaType.APPLICATION_JSON)
                .content(tiresJson))
                .andExpect(status().isCreated())
                .andDo(document("v1/tires-new",
                        requestFields(
                                fields.withPath("tiresId").ignored(),
                                fields.withPath("brand").description("Tires brand"),
                                fields.withPath("dimension").description("Tires dimensions"),
                                fields.withPath("tireType").description("Type of Tires"),
                                fields.withPath("yearModel").description("Year of creation")

                        ),
                        responseFields(
                                fieldWithPath("tiresId").description("Tires ID"),
                                fieldWithPath("brand").description("Tires brand"),
                                fieldWithPath("dimension").description("Tires dimensions"),
                                fieldWithPath("tireType").description("Type of Tires"),
                                fieldWithPath("yearModel").description("Year of creation")
                        )));
    }

    @Test
    @WithMockUser(value = "admin",roles = {"ADMIN"})
    void updateTires() throws Exception {
        var tires = getValidTires();
        String tiresJson = objectMapper.writeValueAsString(tires);
        ConstrainedFields fields = new ConstrainedFields(Tires.class);
        given(tiresRepository.existsById(any())).willReturn(true);

        mockMvc.perform(put("/api/v1/dealer/tires/{id}", UUID.randomUUID().toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(tiresJson))
                .andExpect(status().isNoContent())
                .andDo(document("v1/tires-update",
                        pathParameters(
                                parameterWithName("id").description("UUID string of desired tires to update.")
                        ),
                        requestFields(
                                fields.withPath("tiresId").ignored(),
                                fields.withPath("brand").description("Tires brand"),
                                fields.withPath("dimension").description("Tires dimensions"),
                                fields.withPath("tireType").description("Type of Tires"),
                                fields.withPath("yearModel").description("Year of creation")
                        )));
    }

    @Test
    @WithMockUser(value = "admin",roles = {"ADMIN"})
    void deleteTires() throws Exception {
        given(tiresRepository.existsById(any())).willReturn(true);
        mockMvc.perform(delete("/api/v1/dealer/tires/{id}",UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent())
                .andDo(document("v1/tires-delete", pathParameters(
                        parameterWithName("id").description("UUID string of desired tires to delete.")
                )));
    }

    Tires getValidTires() {
        return Tires.builder()
                .tiresId(UUID.randomUUID().toString())
                .brand("Bridgestone")
                .dimension("180/60 R18 90H")
                .tireType("Summer")
                .yearModel("2020")
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
