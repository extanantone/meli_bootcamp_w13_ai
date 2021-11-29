package com.example.socialmeli.integration;

import com.example.socialmeli.dto.user.FollowerDTO;
import com.example.socialmeli.service.repository.user.UserRepository;
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
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Map;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserIntegrationTest
{
    @Autowired
    MockMvc mockMvc;

    @Autowired
    UserRepository userRepository;

    private static ObjectMapper mapper;

    @BeforeAll
    public static void setUp() throws NoSuchFieldException, IllegalAccessException
    {
        // Not a good practice to have a static variable but I didn´t wanted to change the initial code
        // ToDo split responsability between id generation and user generation
        mapper = new ObjectMapper();
        ObjectWriter writer = mapper
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
    }

    @BeforeEach
    void setTest()
    {
        userRepository.deleteAll();
    }
    //US 0001

    @Test
    public void testFollowUsersGivenAValidFollowerIdAndFollowedId() throws Exception
    {
        FollowerDTO user2 = new FollowerDTO();
        user2.setUserName("BComprador 2");
        user2.setUserId(2);

        Map user2JSON = mapper.convertValue(user2, Map.class);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 1, 2))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.user_id").value(1))
                .andExpect(jsonPath("$.user_name").value("AComprador 1"))
                .andExpect(jsonPath("$.followed", Matchers.containsInAnyOrder(user2JSON)));
    }

    @Test
    void testFollowUserGivenAnInvalidFollowerIdButCorrectUserIdToFollow() throws Exception
    {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 22, 1))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.name").value("Acción no valida"))
                .andExpect(jsonPath("$.description").value("Error: Usuario no encontrado"));
    }

    @Test
    void testFollowUserGivenAValidFollowerIdButInvalidUserIdToFollow() throws Exception
    {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 1, 22))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.name").value("Acción no valida"))
                .andExpect(jsonPath("$.description").value("Error: Usuario no encontrado"));
    }

    @Test
    public void testUnfollowUsersGivenAValidUserIdAndUserToUnfollowIdAndAlreadyFollowing() throws Exception
    {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 1, 2));

        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToFollow}", 1, 2))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.user_id").value(1))
                .andExpect(jsonPath("$.user_name").value("AComprador 1"))
                .andExpect(jsonPath("$.followed").isEmpty());
        System.out.println();
    }

    @Test
    void testUnfollowUserGivenAValidFollowerIdAndInvalidUserIdToUnfollow() throws Exception
    {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToFollow}", 1, 22))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.name").value("Acción no valida"))
                .andExpect(jsonPath("$.description").value("Error: Usuario no encontrado"));
    }

    @Test
    void testUnfollowUserGivenAValidFollowerIdAndValidUserIdToUnfollowButNotFollowing() throws Exception
    {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToFollow}", 1, 2))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.name").value("Acción no valida"))
                .andExpect(jsonPath("$.description").value("Error: No puedes dejar de seguir a este usuario"));
    }

    @Test
    void testFollowersCountWithValidUserId() throws Exception
    {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 2, 1));
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 3, 1));

        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", 1))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.user_id").value(1))
                .andExpect(jsonPath("$.user_name").value("AComprador 1"))
                .andExpect(jsonPath("$.followers_count").value(2));
    }

    @Test
    void testFollowerCountWithInvalidUserId() throws Exception
    {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", 22))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.name").value("Acción no valida"))
                .andExpect(jsonPath("$.description").value("Error: Usuario no encontrado"));
    }

    @Test
    void testFollowersListWithValidId() throws Exception
    {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 2, 1));
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 3, 1));

        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", 1))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.user_id").value(1))
                .andExpect(jsonPath("$.user_name").value("AComprador 1"))
                .andExpect(jsonPath("$.followers.length()").value(2));
    }

    @Test
    void testFollowersListWithInvalidId() throws Exception
    {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", 221))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.name").value("Acción no valida"))
                .andExpect(jsonPath("$.description").value("Error: Usuario no encontrado"));
    }

    @Test
    void testFollowedListWithValidId() throws Exception
    {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 1, 2));
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 1, 3));

        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", 1))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.user_id").value(1))
                .andExpect(jsonPath("$.user_name").value("AComprador 1"))
                .andExpect(jsonPath("$.followed.length()").value(2));
    }

    @Test
    void testFollowedListWithInvalidId() throws Exception
    {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", 221))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.name").value("Acción no valida"))
                .andExpect(jsonPath("$.description").value("Error: Usuario no encontrado"));
    }
}
