package com.bootcamp.socialmeli.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class SocialMeliIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    private static ObjectWriter writer;

    MockHttpServletRequestBuilder request;

    @BeforeAll
    public static void setUp() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();

    }

    @BeforeEach
    public void setUpBeforeEach() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void whenUserExistsReturn() throws Exception {
        ResultMatcher expectedStatus = status().isOk();
        ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(
                "/users/{userId}",
                1
        );

        mockMvc.perform(request).andExpectAll(
                expectedStatus,
                jsonPath("$.username").value("juan_perez"),
                expectedContentType
        );
    }

    @Test
    public void whenUserDoesntExistThrow404() throws Exception {
        ResultMatcher expectedStatus = status().isNotFound();
        ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(
                "/users/{userId}",
                999
        );

        mockMvc.perform(request).andExpectAll(
                expectedStatus,
                expectedContentType
        );
    }

    @Test
    public void checkFollow() throws Exception {
        ResultMatcher expectedStatus = status().isOk();
        ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(
                "/users/{followerId}/follow/{followedId}",
                1, 2
        );

        mockMvc.perform(request).andExpect(expectedStatus);

        request = MockMvcRequestBuilders.get(
                "/users/{followedId}/followers/count",
                2
        );

        mockMvc.perform(request).andExpectAll(
                expectedContentType,
                jsonPath("$.count").value(1),
                expectedStatus
        );

        //Undo changes
        request = MockMvcRequestBuilders.post(
                "/users/{followerId}/unfollow/{followedId}",
                1, 2
        );
        mockMvc.perform(request);
    }

    @Test
    public void whenFollowedAlreadyThrow400() throws Exception {
        ResultMatcher expectedStatus = status().isOk();
        ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);

        request = MockMvcRequestBuilders.post(
                "/users/{followerId}/follow/{followedId}",
                1, 2
        );

        mockMvc.perform(request).andExpectAll(expectedStatus);

        expectedStatus = status().isBadRequest();

        request = MockMvcRequestBuilders.post(
                "/users/{followerId}/follow/{followedId}",
                1, 2
        );

        mockMvc.perform(request).andExpectAll(
                expectedStatus,
                expectedContentType
        );

        //Undo changes
        request = MockMvcRequestBuilders.post(
                "/users/{followerId}/unfollow/{followedId}",
                1, 2
        );
        mockMvc.perform(request);
    }

    @Test
    public void checkUnfollow() throws Exception {
        ResultMatcher expectedStatus = status().isOk();
        ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);

        request = MockMvcRequestBuilders.post(
                "/users/{followerId}/follow/{followedId}",
                1, 2
        );

        mockMvc.perform(request).andExpect(expectedStatus);

        request = MockMvcRequestBuilders.post(
                "/users/{followerId}/unfollow/{followedId}",
                1, 2
        );

        mockMvc.perform(request).andExpect(expectedStatus);

        request = MockMvcRequestBuilders.get(
                "/users/{followedId}/followers/count",
                2
        );

        mockMvc.perform(request).andExpectAll(
                expectedContentType,
                jsonPath("$.count").value(0),
                expectedStatus
        );
    }

    @Test
    public void whenUnfollowNotFollowedThrow400() throws Exception {
        ResultMatcher expectedStatus = status().isBadRequest();
        ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);

        request = MockMvcRequestBuilders.post(
                "/users/{followerId}/unfollow/{followedId}",
                1, 2
        );

        mockMvc.perform(request).andExpectAll(
                expectedStatus,
                expectedContentType
        );
    }

}
