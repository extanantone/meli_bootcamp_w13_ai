package com.meli.obtenerdiploma.integration;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTestObtenerDiploma {

    @Autowired
    MockMvc mockMvc;

    private static ObjectWriter writer;

    static StudentDAO studentDAO = new StudentDAO();


    SubjectDTO kahoot;
    SubjectDTO musica;
    SubjectDTO poo;

    StudentDTO student;


    @BeforeAll
    public static void setUp() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();
    }

    @BeforeEach
    public void beforEach() {
        kahoot = new SubjectDTO("Kahoot", 1.0);
        musica = new SubjectDTO("Musica", 9.0);
        poo =    new SubjectDTO("POO",    2.0);

        student =new StudentDTO(1L, "Anibal","El alumno Anibal ha obtenido un promedio de 4,00. Puedes mejorar.", 4.0, List.of(kahoot, musica, poo) );

        if( ! studentDAO.exists( student ) )
            studentDAO.save( student );

    }

    @Test
    public void testGivenValidUserIdGetDiplomaWithAverangeScores() throws Exception {

        String jsonKahoot = writer.writeValueAsString(kahoot);
        String jsonMusica = writer.writeValueAsString(musica);
        String jsonPoo =    writer.writeValueAsString(poo);

        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/analyzeScores/{studentID}", 1))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.studentName").value("Anibal"))
                .andExpect(jsonPath("$.averageScore").value(4))
                .andExpect(jsonPath("$.subjects.length()").value(3))
                .andExpect(jsonPath("$.subjects", Matchers.containsInAnyOrder(jsonPoo, jsonMusica, jsonKahoot)));
    }


}
