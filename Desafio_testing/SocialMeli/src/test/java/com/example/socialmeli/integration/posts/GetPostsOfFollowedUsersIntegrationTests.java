package com.example.socialmeli.integration.posts;

import com.example.socialmeli.repositories.PostRepository;
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

import static com.example.socialmeli.TestUtilsFileHandling.emptyPostsFile;
import static com.example.socialmeli.TestUtilsGet.getUnsortedUserList;
import static com.example.socialmeli.TestUtilsPreload.restoreUsersFile;
import static com.example.socialmeli.integration.MockMvcUtils.*;
import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@SpringBootTest
@AutoConfigureMockMvc
public class GetPostsOfFollowedUsersIntegrationTests {
    @Autowired
    private MockMvc mockMvc;
    private UsuarioRepository userRepository = new UsuarioRepository();
    private PostRepository postRepository = new PostRepository();

    public GetPostsOfFollowedUsersIntegrationTests() throws JsonProcessingException {
        restoreUsersFile();
        emptyPostsFile();
    }

    @BeforeEach
    public void cleanUp() {
        this.userRepository.overwriteWith(getUnsortedUserList());
        this.postRepository.reset();
    }

    @Test
    public void getPostsOfFollowedUsersByDateAscending() throws Exception {
        fail("TODO");
    }

    @Test
    public void getPostsOfFollowedUsersByDateDescending() throws Exception {
        fail("TODO");
    }

    @Test
    public void getPostsOfUsersFollowedByInvalidUserIdAndThrow() throws Exception {

        MockHttpServletRequestBuilder getPostsOfFollowedUserByInvalidUserId = MockMvcRequestBuilders
                .get("/products/followed/{userId}/list", 123);

        this.mockMvc.perform(getPostsOfFollowedUserByInvalidUserId)
                .andDo(print())
                .andExpect(statusIsNotFound)
                .andExpect(contentIsJson)
                .andExpect(userNotFoundExceptionWasThrown);
    }



    @Test
    public void getPostOfFollowedUsersByInvalidSortingCriteria() throws Exception {
        MockHttpServletRequestBuilder getPromoPostsWithInvalidSortingCriteria = MockMvcRequestBuilders
                .get("/products/followed/{userId}/list", 1).param("order", "invalidSortingQuery");

        this.mockMvc.perform(getPromoPostsWithInvalidSortingCriteria)
                .andDo(print())
                .andExpect(statusIsBadRequest)
                .andExpect(contentIsJson)
                .andExpect(invalidSortingCriteriaExceptionWasThrown);
    }
}
