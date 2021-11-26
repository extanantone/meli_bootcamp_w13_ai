package com.example.socialmeli.integration;

import com.example.socialmeli.model.User;
import com.example.socialmeli.repositories.PostRepository;
import com.example.socialmeli.repositories.UsuarioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class SocialMeliIntegrationTest {
    @Autowired
    MockMvc mockMvc;

    static UsuarioRepository usuarioRepository = new UsuarioRepository();
    static PostRepository postRepository = new PostRepository();

    private static ObjectWriter writer;
    private static ObjectMapper mapper;

    User user1;
    User user2;
//    SubjectDTO poo;
//
//    StudentDTO student;


    @BeforeAll
    public static void setUp() {
        mapper = new ObjectMapper();
        writer = mapper
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
    }

    @BeforeEach
    public void beForEach() {
        user1 = new User();
        user1.setUserId(1);
        user1.setUserName("Juan");

        user2 = new User();
        user1.setUserId(2);
        user1.setUserName("Pedro");

        if (usuarioRepository.findById(user1.getUserId()) == null) {
            usuarioRepository.addUser(user1);
        }
        if (usuarioRepository.findById(user2.getUserId()) == null) {
            usuarioRepository.addUser(user2);
        }
    }

    @Test
    void followUser() throws Exception {
        this.mockMvc.perform(
                        post("/users/1/follow/2")
                )
                .andDo(print()).andExpect(status().isOk());
    }
    @Test
    void badRequestFollowUser() throws Exception {
        this.mockMvc.perform(
                        post("/users/1/follow/22")
                )
                .andDo(print()).andExpect(status().isNotFound());
    }

    @Test
    void countFollowUser() throws Exception {
        this.mockMvc.perform(
                        get("/users/2/followers/count")
                )
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id").exists())
                .andExpect(jsonPath("$.user_name").exists())
                .andExpect(jsonPath("$.followers_count").value(1));
    }

    @Test
    void badCountFollowUser() throws Exception {
        this.mockMvc.perform(
                        get("/users/22/followers/count")
                )
                .andDo(print()).andExpect(status().isNotFound());
    }

    @Test
    void followersListEmpty() throws Exception {
        this.mockMvc.perform(
                        get("/users/1/followers/list")
                )
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id").exists())
                .andExpect(jsonPath("$.user_name").exists())
                .andExpect(jsonPath("$.followers").isEmpty());
    }

    @Test
    void followersList() throws Exception {
        this.mockMvc.perform(
                        get("/users/2/followers/list")
                )
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id").exists())
                .andExpect(jsonPath("$.user_name").exists())
                .andExpect(jsonPath("$.followers").isNotEmpty());
    }
}
