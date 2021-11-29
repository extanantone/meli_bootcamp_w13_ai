package com.example.socialmeli.integration.posts;

import com.example.socialmeli.dto.PostDTO;
import com.example.socialmeli.repositories.PostRepository;
import com.example.socialmeli.repositories.UsuarioRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.example.socialmeli.TestUtilsFileHandling.emptyPostsFile;
import static com.example.socialmeli.TestUtilsGet.getUnsortedUserList;
import static com.example.socialmeli.TestUtilsPreload.restoreUsersFile;
import static com.example.socialmeli.integration.MockMvcUtils.*;
import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@SpringBootTest
@AutoConfigureMockMvc
public class GetPromoPostsIntegrationTests {
    @Autowired
    private MockMvc mockMvc;
    private UsuarioRepository userRepository = new UsuarioRepository();
    private PostRepository postRepository = new PostRepository();

    public GetPromoPostsIntegrationTests() throws JsonProcessingException {
        restoreUsersFile();
        emptyPostsFile();
    }

    @BeforeEach
    public void cleanUp() {
        this.userRepository.overwriteWith(getUnsortedUserList());
        this.postRepository.reset();
    }

    @Test
    public void getPromoPostsOfValidUser() throws Exception {
        fail("TODO");
    }

    @Test
    public void getPromoPostsOfNonExistingUserAndThrow() throws Exception {
        MockHttpServletRequestBuilder getPromoPostsOfInvalidUser = MockMvcRequestBuilders
                .get("/products/{userId}/list", 123);

        this.mockMvc.perform(getPromoPostsOfInvalidUser)
                .andDo(print())
                .andExpect(statusIsNotFound)
                .andExpect(contentIsJson)
                .andExpect(userNotFoundExceptionWasThrown);
    }
}
