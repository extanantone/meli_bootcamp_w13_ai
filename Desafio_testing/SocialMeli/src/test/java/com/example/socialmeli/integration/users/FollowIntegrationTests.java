package com.example.socialmeli.integration.users;

import static com.example.socialmeli.TestUtilsGet.getUnsortedUserList;
import static com.example.socialmeli.TestUtilsPreload.*;
import static com.example.socialmeli.integration.MockMvcUtils.*;

import com.example.socialmeli.repositories.UsuarioRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@SpringBootTest
@AutoConfigureMockMvc
public class FollowIntegrationTests {
    @Autowired
    private MockMvc mockMvc;
    private UsuarioRepository userRepository;

    public FollowIntegrationTests() throws JsonProcessingException {
        restoreUsersFile();
        this.userRepository = new UsuarioRepository();
    }

    @BeforeEach
    public void cleanUp() {
        this.userRepository.overwriteWith(getUnsortedUserList());
    }

    @Test
    public void followUserGivenValidUserIds() throws Exception {

        String manuelJsonMatcher = "$.followers[?(@.user_id == \"1\")][?(@.user_name == \"Manuel\")]";

        ResultMatcher manuelIsFollowingAzul = jsonPath(manuelJsonMatcher).exists();

        MockHttpServletRequestBuilder getAzulFollowersRequest = MockMvcRequestBuilders
                .get("/users/{userId}/followers/list", 2);

        this.mockMvc.perform(makeManuelFollowAzul)
                .andDo(print())
                .andExpect(statusIsOk);

        this.mockMvc.perform(getAzulFollowersRequest)
                .andDo(print())
                .andExpect(contentIsJson)
                .andExpect(manuelIsFollowingAzul);
    }

    @Test
    public void followUserGivenInvalidUserIdsAndThrow() throws Exception {

        MockHttpServletRequestBuilder followInvalidUserId = MockMvcRequestBuilders
                .post("/users/{userId}/follow/{userIdToFollow}", 123, 2);

        this.mockMvc.perform(followInvalidUserId)
                .andDo(print())
                .andExpect(statusIsNotFound)
                .andExpect(contentIsJson)
                .andExpect(userNotFoundExceptionWasThrown);

    }

    @Test
    public void followUserGivenSameUserIdAndThrow() throws Exception {

        MockHttpServletRequestBuilder followSameUserId = MockMvcRequestBuilders
                .post("/users/{userId}/follow/{userIdToFollow}", 1, 1);

        this.mockMvc.perform(followSameUserId)
                .andDo(print())
                .andExpect(statusIsBadRequest)
                .andExpect(contentIsJson)
                .andExpect(userSelfUseExceptionWasThrown);


    }

    @Test
    public void followUserGivenAlreadyFollowedUserAndThrow() throws Exception {


        MockHttpServletRequestBuilder redundantFollowRequest = MockMvcRequestBuilders
                .post("/users/{userId}/follow/{userIdToFollow}", 1, 2);

        this.mockMvc.perform(makeManuelFollowAzul);

        this.mockMvc.perform(makeManuelFollowAzul)
                .andDo(print())
                .andExpect(statusIsBadRequest)
                .andExpect(contentIsJson)
                .andExpect(userAlreadyInUseExceptionWasThrown);


    }
}
