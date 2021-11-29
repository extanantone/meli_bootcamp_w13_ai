package com.bootcamp.SocialMeli.integration;

import com.bootcamp.SocialMeli.Model.Usuario;
import com.bootcamp.SocialMeli.Repository.SocialRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationSocialMeliTest {

    @Autowired
    private MockMvc mock;

    @Autowired
    private SocialRepository repo;

    @BeforeEach
    public void reset(){
        Usuario.resetId();
        repo.reset();
    }

    @Test
    @DisplayName(value = "Seguir a un usuario existente")
    public void followUserOk() throws Exception {
        mock.perform(MockMvcRequestBuilders.post("/users/1/follow/2")).andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }

    @Test
    @DisplayName(value = "Seguir a un usuario que no existe")
    public void followUserNotExist() throws Exception {
        mock.perform(MockMvcRequestBuilders.post("/users/1/follow/6")).andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    @DisplayName(value = "Intentar seguirse a si mismo")
    public void tryToFollowYourself() throws Exception {
        mock.perform(MockMvcRequestBuilders.post("/users/1/follow/1")).andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    @DisplayName(value = "Intentar seguir un usuario que ya sigue")
    public void tryTofollowUserIsAlreadyFollowing() throws Exception {
        mock.perform(MockMvcRequestBuilders.post("/users/1/follow/3")).andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
        mock.perform(MockMvcRequestBuilders.post("/users/1/follow/3")).andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    @DisplayName(value = "Dejar de seguir un usuario ok")
    public void unFollowUser() throws Exception {
        mock.perform(MockMvcRequestBuilders.put("/users/1/unfollow/4")).andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }


    @Test
    @DisplayName(value = "Intentar dejar de seguir un usuario que no existe")
    public void unFollowUserNoExist() throws Exception {
        mock.perform(MockMvcRequestBuilders.put("/users/1/unfollow/6")).andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}
