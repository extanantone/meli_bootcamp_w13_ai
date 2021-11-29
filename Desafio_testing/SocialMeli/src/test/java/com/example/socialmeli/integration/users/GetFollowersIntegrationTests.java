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
import static org.springframework.test.util.AssertionErrors.fail;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@SpringBootTest
@AutoConfigureMockMvc
public class GetFollowersIntegrationTests {
    @Autowired
    private MockMvc mockMvc;
    private UsuarioRepository userRepository = new UsuarioRepository();

    public GetFollowersIntegrationTests() throws JsonProcessingException {
        restoreUsersFile();
        //para que se ejecute antes de que se instancie el mockMvc así no carga vacío el .json
    }

    @BeforeEach
    public void cleanUp() {
        this.userRepository.overwriteWith(getUnsortedUserList());
    }

    @Test
    public void getFollowersByNameAscending() throws Exception {
        fail("TODO");
    }

    @Test
    public void getFollowersByNameDescending() throws Exception {
        fail("TODO");
    }

    @Test
    public void getFollowersOfInvalidUser() throws Exception {

        MockHttpServletRequestBuilder getFollowersInvalidRequest = MockMvcRequestBuilders
                .get("/users/{userId}/followers/list", 123);

        this.mockMvc.perform(getFollowersInvalidRequest)
                .andDo(print())
                .andExpect(statusIsNotFound)
                .andExpect(contentIsJson)
                .andExpect(userNotFoundExceptionWasThrown);
    }

    @Test
    public void getFollowersByInvalidSortingCriteriaAndThrow() throws Exception {
        MockHttpServletRequestBuilder getFollowersByInvalidSortingCriteria = MockMvcRequestBuilders
                .get("/users/{userId}/followers/list", 1).param("order", "invalidSortingQuery");

        this.mockMvc.perform(getFollowersByInvalidSortingCriteria)
                .andDo(print())
                .andExpect(statusIsBadRequest)
                .andExpect(contentIsJson)
                .andExpect(invalidSortingCriteriaExceptionWasThrown);
    }
}
