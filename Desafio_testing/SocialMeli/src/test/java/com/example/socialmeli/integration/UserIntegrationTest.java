package com.example.socialmeli.integration;

import com.example.socialmeli.dto.user.FollowedListDTO;
import com.example.socialmeli.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class UserIntegrationTest
{
    @Autowired
    MockMvc mockMvc;


    private static ObjectWriter writer;
    private static ObjectMapper mapper;


    FollowedListDTO follower = null;
    FollowedListDTO followed = null;

    @BeforeAll
    public static void setUp() {
        mapper = new ObjectMapper();
        writer = mapper
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

    }

    @BeforeEach
    public void beforeEach() {
        follower = new FollowedListDTO();
        follower = new FollowedListDTO();
    }

    @Test
    public void testGivenValidUserIdAndUserIdToFollowFollowAction() throws Exception {



        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/{userId}/follow/{userIdToFollow}", 1, 2))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.studentName").value("Anibal"))
                .andExpect(jsonPath("$.averageScore").value(4.0))
                .andExpect(jsonPath("$.subjects.length()").value(3))
                .andExpect(jsonPath("$.subjects", Matchers.containsInAnyOrder(follower, followed)));
                /*.andExpect(jsonPath("$.subjects[?(@.name == \""+kahoot.getName()+"\"  && @.score == "+kahoot.getScore()+")]").exists())
                .andExpect(jsonPath("$.subjects[?(@.name == \""+musica.getName()+"\"  && @.score == "+kahoot.getScore()+")]").exists())
                .andExpect(jsonPath("$.subjects[?(@.name == \""+poo.getName()   +"\"  && @.score == "+kahoot.getScore()+")]").exists())
                 ;*/
    }

    /**
     * Este metodo
     * @throws Exception
     */
    @Test
    void testGivenAnInvalidStudentIdThrowExceptionMessage() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 22))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").value("StudentNotFoundException"));
    }

}
