package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    static StudentDAO studentDAO = new StudentDAO();

    private static ObjectWriter writer;
    private StudentDTO student;
    private SubjectDTO maths;
    private SubjectDTO physics;
    private SubjectDTO chemistry;

    @BeforeAll
    public static void setUp(){
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();
    }

    @BeforeEach
    public void setupMethod(){
        this.maths = new SubjectDTO("Maths", 9.0);
        this.physics = new SubjectDTO("Physics", 7.0);
        this.chemistry = new SubjectDTO("Chemistry", 5.0);
        this.student = new StudentDTO(1L, "Juan Pablo", "El alumno Juan Pablo ha obtenido un promedio de 7.00. Puedes mejorar.", 7.0, List.of(maths, physics, chemistry));

        if(!studentDAO.exists(student))
            studentDAO.save(student);
    }

    @Test
    void testGivenValidUserIdGetDiplomaWithAverangeScore() throws Exception {
        //Arrange
        String userJson = writer.writeValueAsString(this.student);

        ResultMatcher expectedStatus = status().isOk();
        ResultMatcher expectedJson = content().json(userJson);
        ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);

        //Act and Assert
        this.mockMvc.perform(get("/analyzeScores/{studentId}", 1))
                .andDo(print())
                .andExpect(expectedStatus)
                .andExpect(expectedContentType)
                .andExpect(expectedJson);
    }
}
