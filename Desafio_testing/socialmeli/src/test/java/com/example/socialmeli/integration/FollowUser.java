package com.example.socialmeli.integration;

import com.example.socialmeli.exceptions.ActionPrevioslyComplete;
import com.example.socialmeli.exceptions.ActionRedundant;
import com.example.socialmeli.exceptions.UserNoFound;
import com.example.socialmeli.repository.IUserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
public class FollowUser {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    IUserRepository repository;



    @Test
    void shouldFollowUser() throws Exception{
        followUserTest(1,2);
    }



    @Test
    void shouldUnfollowUser() throws Exception{
        unFollowUserTest(1,2);
    }

    @Test
    void NotshouldUnfollowUserNoExist() throws Exception{
        FollowUserTestUserNotExist(1,0);
    }


    private void followUserTest(Integer i, Integer e) throws Exception {
        this.mockMvc.perform(post("/users/"+ i +"/follow/" + e))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("{}"));
    }



    private void unFollowUserTest(Integer i, Integer e) throws Exception {
        this.mockMvc.perform(post("/users/"+ i +"/unfollow/" + e))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("{}"));
    }

    private void FollowUserTestUserNotExist(Integer i, Integer e) throws Exception {
        this.mockMvc.perform(post("/users/"+ i +"/follow/" + e))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue( result.getResolvedException() instanceof UserNoFound));

    }


}
