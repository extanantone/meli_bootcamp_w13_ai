package com.example.socialmeli.integration;

import static com.example.socialmeli.TestUtilsPreload.*;
import static com.example.socialmeli.integration.MockMvcUtils.*;
import com.fasterxml.jackson.core.JsonProcessingException;
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
public class UsersControllerTests {
    @Autowired
    private MockMvc mockMvc;

    public UsersControllerTests() throws JsonProcessingException {
        restoreUsersFile();
        //para que se ejecute antes que se instancie el mockMvc, para que no se cargue vacío el .json
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

        ResultMatcher userNotFoundExceptionWasThrown = jsonPath("$.name").value("UserNotFoundException");

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

        ResultMatcher userSelfUseExceptionWasThrown = jsonPath("$.name").value("UserSelfUseException");

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

        ResultMatcher userAlreadyInUseExceptionWasThrown = jsonPath("$.name")
                .value("UserAlreadyInUseException");


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
