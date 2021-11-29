package com.example.socialmeli.integration.users;

import com.example.socialmeli.repositories.UsuarioRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.example.socialmeli.TestUtilsGet.getUnsortedUserList;
import static com.example.socialmeli.TestUtilsPreload.restoreUsersFile;
import static com.example.socialmeli.integration.MockMvcUtils.*;
import static org.springframework.test.util.AssertionErrors.fail;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@SpringBootTest
@AutoConfigureMockMvc
public class GetFollowedIntegrationTests {
    @Autowired
    private MockMvc mockMvc;
    private UsuarioRepository userRepository;

    public GetFollowedIntegrationTests() throws JsonProcessingException {
        restoreUsersFile();
        this.userRepository = new UsuarioRepository();
    }

    @BeforeEach
    public void cleanUp() {
        this.userRepository.overwriteWith(getUnsortedUserList());
    }

    @Test
    public void getFollowedByNameAscending() throws Exception {
        fail("TODO");
    }

    @Test
    public void getFollowedByNameDescending() throws Exception {
        fail("TODO");
    }

    @Test
    public void getFollowedOfInvalidUser() throws Exception {
        MockHttpServletRequestBuilder getFollowedInvalidRequest = MockMvcRequestBuilders
                .get("/users/{userId}/followed/list", 123);

        this.mockMvc.perform(getFollowedInvalidRequest)
                .andDo(print())
                .andExpect(statusIsNotFound)
                .andExpect(contentIsJson)
                .andExpect(userNotFoundExceptionWasThrown);
    }

    @Test
    public void getFollowedByInvalidSortingCriteriaAndThrow() throws Exception {
        MockHttpServletRequestBuilder getFollowedByInvalidSortingCriteria = MockMvcRequestBuilders
                .get("/users/{userId}/followed/list", 1).param("order", "invalidSortingQuery");

        this.mockMvc.perform(getFollowedByInvalidSortingCriteria)
                .andDo(print())
                .andExpect(statusIsBadRequest)
                .andExpect(contentIsJson)
                .andExpect(invalidSortingCriteriaExceptionWasThrown);
    }
}
