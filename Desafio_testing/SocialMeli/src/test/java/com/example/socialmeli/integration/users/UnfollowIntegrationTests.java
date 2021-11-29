package com.example.socialmeli.integration.users;

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

import static com.example.socialmeli.TestUtilsGet.getUnsortedUserList;
import static com.example.socialmeli.TestUtilsPreload.restoreUsersFile;
import static com.example.socialmeli.integration.MockMvcUtils.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@SpringBootTest
@AutoConfigureMockMvc
public class UnfollowIntegrationTests {
    @Autowired
    private MockMvc mockMvc;
    private UsuarioRepository userRepository;

    public UnfollowIntegrationTests() throws JsonProcessingException {
        restoreUsersFile();
        this.userRepository = new UsuarioRepository();
    }

    @BeforeEach
    public void cleanUp() {
        this.userRepository.overwriteWith(getUnsortedUserList());
    }

    @Test
    public void unfollowUserGivenValidUserIds() throws Exception {

        String manuelJsonMatcher = "$.followers[?(@.user_id == \"1\")][?(@.user_name == \"Manuel\")]";

        ResultMatcher manuelIsNotFollowingAzul = jsonPath(manuelJsonMatcher).doesNotExist();

        MockHttpServletRequestBuilder getAzulFollowersRequest = MockMvcRequestBuilders
                .get("/users/{userId}/followers/list", 2);

        this.mockMvc.perform(makeManuelFollowAzul);
        this.mockMvc.perform(makeManuelUnfollowAzul)
                .andDo(print())
                .andExpect(statusIsOk);

        this.mockMvc.perform(getAzulFollowersRequest)
                .andDo(print())
                .andExpect(contentIsJson)
                .andExpect(manuelIsNotFollowingAzul);
    }

    @Test
    public void unfollowUserGivenSameUserIdAndThrow() throws Exception {


        MockHttpServletRequestBuilder followSameUserId = MockMvcRequestBuilders
                .post("/users/{userId}/unfollow/{userIdToUnfollow}", 1, 1);

        this.mockMvc.perform(followSameUserId)
                .andDo(print())
                .andExpect(statusIsBadRequest)
                .andExpect(contentIsJson)
                .andExpect(userSelfUseExceptionWasThrown);


    }

    @Test
    public void unfollowUserGivenUserNotBeingFollowedAndThrow() throws Exception {

        this.mockMvc.perform(makeManuelUnfollowAzul)
                .andDo(print())
                .andExpect(statusIsBadRequest)
                .andExpect(contentIsJson)
                .andExpect(userAlreadyInUseExceptionWasThrown);


    }
}
