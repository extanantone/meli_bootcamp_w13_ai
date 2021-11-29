package com.bootcamp.SocialMeli.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

//BONUS
@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTestUsuario {
    @Autowired
    MockMvc mockMvc;

    private static ObjectWriter writer;

    @BeforeAll
    public static void setUp() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
    }


    @Test
    public void testGivenValidUserFollowedIdGetFollowersCount() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/users/{user_id}/followers/count", 7))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value("7"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testGivenInValidUserFollowedIdWhenGetFollowersCountGetException() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/users/{user_id}/followers/count",   10))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void testGivenValidUserFollowedIdGetFollowersList() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/users/{user_id}/followers/list", 7))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value("7"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testGivenInValidUserFollowedIdWhenGetFollowersListtGetException() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/users/{user_id}/followers/list", 10))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void testGivenValidUserFollowerIdGetFollowedList() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/users/{user_id}/followed/list", 9))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value("9"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testGivenInValidUserFollowerIdWhenGetFollowedListtGetException() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/users/{user_id}/followed/list", 10))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
}
