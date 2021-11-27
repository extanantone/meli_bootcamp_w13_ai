package com.socialmeli.socialmeli.integration;

import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTestUserController {
    @Autowired
    MockMvc mockMvc;


    @Test
    public void testNewFollowWithCorrectIdUsersAndTestGetFollowers() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.post("/users/1/follow/2"))
                .andDo(print())
                .andExpect(status().isOk())
        ;
    }

    @Test
    public void test() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/users/1/followers/count"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user_name").value("BuyerOne"))
        ;
    }
}
