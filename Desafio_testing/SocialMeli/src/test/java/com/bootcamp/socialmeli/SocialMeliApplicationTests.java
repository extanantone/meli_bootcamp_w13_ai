package com.bootcamp.socialmeli;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class SocialMeliApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void successFollowTest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{user_id}/follow/{user_id_to_follow}", 1L, 2L))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value("200"));
    }

    @Test
    void failedUserNotFoundFollowTest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{user_id}/follow/{user_id_to_follow}", 1L, 5L))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.errorCode").value("404"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.errorMessage").value("Usuario no encontrado id: 5"));
    }

    @Test
    void failedUserFollowingItselfTest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{user_id}/follow/{user_id_to_follow}", 1L, 1L))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.errorCode").value("400"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.errorMessage").value("El usuario no puede seguirse a si mismo"));
    }

    @Test
    void successOnNonExistentFollowerTest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{user_id}/unfollow/{user_id_to_follow}", 1L, 2L))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value("200"));
    }

}
