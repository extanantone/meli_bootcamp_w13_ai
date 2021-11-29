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

import static com.example.socialmeli.TestUtilsFileHandling.emptyPostsFile;
import static com.example.socialmeli.TestUtilsFileHandling.valueToJson;
import static com.example.socialmeli.TestUtilsGet.getUnsortedUserList;
import static com.example.socialmeli.TestUtilsGet.getZapatillasDTO;
import static com.example.socialmeli.TestUtilsPreload.restoreUsersFile;
import static com.example.socialmeli.integration.MockMvcUtils.*;
import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@SpringBootTest
@AutoConfigureMockMvc
public class NewPostIntegrationTests {
    @Autowired
    private MockMvc mockMvc;
    private UsuarioRepository userRepository = new UsuarioRepository();
    private PostRepository postRepository = new PostRepository();

    public NewPostIntegrationTests() throws JsonProcessingException {
        restoreUsersFile();
        emptyPostsFile();
    }

    @BeforeEach
    public void cleanUp() {
        this.userRepository.overwriteWith(getUnsortedUserList());
        this.postRepository.reset();
    }

    @Test
    public void createValidPost() throws Exception {
        fail("TODO");

    }

    @Test
    public void createPostWithAlreadyExistingIdAndThrow() throws Exception {
        fail("TODO");

    }

    @Test
    public void createPostWithInvalidUserIdAndThrow() throws Exception {
        fail("TODO");
    }

    @Test
    public void createPostWithInvalidDataAndThrow() throws Exception {
        PostDTO invalidDTO = new PostDTO();

        String invalidDTOJson = valueToJson(invalidDTO);

        MockHttpServletRequestBuilder invalidDTORequest = getNewPostRequest(invalidDTOJson);

        this.mockMvc.perform(invalidDTORequest)
                .andDo(print())
                .andExpect(statusIsBadRequest)
                .andExpect(contentIsJson)
                .andExpect(methodArgumentNotValidExceptionWasThrown);
    }
}
