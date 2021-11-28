package com.example.socialmeli.integration;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

public class MockMvcUtils {

    public static ResultMatcher statusIsOk = status().isOk();
    public static ResultMatcher statusIsNotFound = status().isNotFound();
    public static ResultMatcher statusIsBadRequest = status().isBadRequest();
    public static ResultMatcher contentIsJson = content().contentType(MediaType.APPLICATION_JSON);
    public static MockHttpServletRequestBuilder makeManuelFollowAzul = MockMvcRequestBuilders
            .post("/users/{userId}/follow/{userIdToFollow}", 1, 2);

}
