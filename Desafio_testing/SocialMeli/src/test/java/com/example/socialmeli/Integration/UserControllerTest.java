package com.example.socialmeli.Integration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Follow user")
    void test01() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}",1,2))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Usuario seguido correctamente"));

    }


    @Test
    @DisplayName("Follow con ids iguales")
    void test02() throws Exception {

        Integer userId = 1;



        String message = "Los id's no pueden ser identicos";

        followPostException(userId,userId,message);
    }

    @Test
    @DisplayName("Follow con id de seguidor inexistente")
    void test03() throws Exception {

        Integer userId = 1;
        Integer userIdToFollow = 5;

        String message = "Usuario no encontrado con id:5";

        followPostException(userId,userIdToFollow,message);

    }

    @Test
    @DisplayName("Follow con id de usuario inexistente")
    void test04() throws Exception {

        Integer userId = 5;
        Integer userIdToFollow = 1;

        String message = "Usuario no encontrado con id:5";

        followPostException(userId,userIdToFollow,message);

    }

    private void followPostException(Integer userId, Integer userIdToFollow, String message) throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}",userId,userIdToFollow))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value(message));
    }

    @Test
    @DisplayName("Conteo de followers")
    void test05() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}",1,2));
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}",3,2));

        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{user_id}/followers/count",2))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.followers_count").value(2));


    }

    @Test
    @DisplayName("name")
    void name() {
    }
}
