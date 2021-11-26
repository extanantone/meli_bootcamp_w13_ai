package com.example.socialmeli.demo.integration.IntegrationTestFollower;


import com.example.socialmeli.demo.exception.UserNotFollowingToUserException;
import com.example.socialmeli.demo.exception.UserNotFoundException;
import com.example.socialmeli.demo.exception.VendorNotFoundException;
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

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTestFollowerController {

    @Autowired
    MockMvc mockMvc;

    private static ObjectWriter writer;


    @BeforeAll
    public static void setUp() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

    }

//US 0001
    @Test
    public void testFollowUsersGivenAValidFollowerIdAndFollowedId() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{user_id}/follow/{user_id_to_follow}",1,3))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testFollowUsersGivenAValidFollowerIdAndInvalidFollowedId() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{user_id}/follow/{user_id_to_follow}",1,5))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(result -> assertEquals(VendorNotFoundException.class, result.getResolvedException().getClass()));
    }

    @Test
    public void testFollowUsersGivenANotValidFollowerIdAndAValidFollowedId() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{user_id}/follow/{user_id_to_follow}",5,3))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(result -> assertEquals(UserNotFoundException.class, result.getResolvedException().getClass()));
    }


    //US 0002
    @Test
    public void testCountUsersFollowersWithAnNotExistentUserId() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{user_id}/followers/count",5))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(result -> assertEquals(UserNotFoundException.class, result.getResolvedException().getClass()));
    }

    @Test
    public void testCountUsersFollowersWithAnExistentUserIdAndACorrectCount() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{user_id}/follow/{user_id_to_follow}",1,3));
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{user_id}/follow/{user_id_to_follow}",2,3));

        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{user_id}/followers/count",3))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_name").value("vendedor1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followers_count").value(2));


    }

    @Test
    public void testCountUsersFollowersWithAnExistentUserIdAnd0Count() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{user_id}/followers/count",3))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_name").value("vendedor1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followers_count").value(0));
    }

    //US 0003
    @Test
    public void testBringListOfFollowersFromAnUserWithAnExistentUserId() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{user_id}/follow/{user_id_to_follow}",1,3));
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{user_id}/follow/{user_id_to_follow}",2,3));
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{user_id}/follow/{user_id_to_follow}",1,4));


        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{user_id}/followers/list",3))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_name").value("vendedor1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followers.length()").value(2));

    }

    @Test
    public void testBringListOfFollowersFromAnUserWithAnUnexistentUserId() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{user_id}/followers/list",6))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(result -> assertEquals(UserNotFoundException.class, result.getResolvedException().getClass()));

    }


    //US 0004
    @Test
    public void testBringListOfFollowedUsersFromAnUserWithAnExistentUserId() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{user_id}/follow/{user_id_to_follow}",1,3));
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{user_id}/follow/{user_id_to_follow}",1,4));


        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{user_id}/followed/list",1))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_name").value("comprador1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followed.length()").value(2));

    }


    //US 0007
    @Test
    public void testUnfollowUserWhichIWasCurrentlyFollowing() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{user_id}/follow/{user_id_to_follow}",1,3));

        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{user_id}/unfollow/{user_id_to_unfollow}",1,3))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testUnfollowUserWhichIWasNotFollowing() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{user_id}/unfollow/{user_id_to_unfollow}",1,4))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(result -> assertEquals(UserNotFollowingToUserException.class, result.getResolvedException().getClass()));
    }

    @Test
    public void testUnfollowUserWhichHasAnUnexistantId() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{user_id}/unfollow/{user_id_to_unfollow}",1,5))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(result -> assertEquals(VendorNotFoundException.class, result.getResolvedException().getClass()));
    }






}
