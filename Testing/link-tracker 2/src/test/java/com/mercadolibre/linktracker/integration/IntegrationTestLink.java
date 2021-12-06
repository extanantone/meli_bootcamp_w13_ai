
package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.mercadolibre.linktracker.unit.dto.LinkDTO;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTestLink
{
    @Autowired
    MockMvc mockMvc;

    static StudentDAO studentDAO = new StudentDAO();

    private static ObjectWriter writer;
    private static ObjectMapper mapper;


    @BeforeAll
    public static void setUp()
    {
        mapper = new ObjectMapper();
        writer = mapper
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

    }

    @BeforeEach
    public void beforEach()
    {
        LinkDTO link = new LinkDTO();
    }

    @Test
    public void testGivenValidUserIdGetDiplomaWithAverangeScore() throws Exception
    {

        Map mapKahoot = mapper.convertValue(kahoot, Map.class);
        Map mapMusica = mapper.convertValue(musica, Map.class);
        Map mapPoo = mapper.convertValue(poo, Map.class);


        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 1))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.studentName").value("Anibal"))
                .andExpect(jsonPath("$.averageScore").value(4.0))
                .andExpect(jsonPath("$.subjects.length()").value(3))
                .andExpect(jsonPath("$.subjects", Matchers.containsInAnyOrder(mapPoo, mapMusica, mapKahoot)));
                /*.andExpect(jsonPath("$.subjects[?(@.name == \""+kahoot.getName()+"\"  && @.score == "+kahoot.getScore()+")]").exists())
                .andExpect(jsonPath("$.subjects[?(@.name == \""+musica.getName()+"\"  && @.score == "+kahoot.getScore()+")]").exists())
                .andExpect(jsonPath("$.subjects[?(@.name == \""+poo.getName()   +"\"  && @.score == "+kahoot.getScore()+")]").exists())
                 ;*/

    }

    @Test
    void helloTest() throws Exception
    {
        // Arrange

        String userJson = writer.writeValueAsString(student);
        System.out.println(userJson);

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 1))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(userJson))
                .andExpect(status().isOk());

        // andExpectAll funciona a partir de la version 2.6 de Spring Boot
                /*.andExpectAll(
                        expectedStatus,
                        expectedJson,
                        expectedContentType
                );*/

    }
}
