package com.example.socialmeli.integration;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class MockMvcUtils {

    public static ResultMatcher statusIsOk = status().isOk();
    public static ResultMatcher statusIsNotFound = status().isNotFound();
    public static ResultMatcher statusIsBadRequest = status().isBadRequest();
    public static ResultMatcher contentIsJson = content().contentType(MediaType.APPLICATION_JSON);
    public static ResultMatcher invalidSortingCriteriaExceptionWasThrown = jsonPath("$.name").value("InvalidSortingCriteriaException");
    public static ResultMatcher methodArgumentNotValidExceptionWasThrown = jsonPath("$.name").value("MethodArgumentNotValidException");
    public static ResultMatcher userNotFoundExceptionWasThrown = jsonPath("$.name").value("UserNotFoundException");
    public static ResultMatcher userSelfUseExceptionWasThrown = jsonPath("$.name").value("UserSelfUseException");
    public static ResultMatcher userAlreadyInUseExceptionWasThrown = jsonPath("$.name").value("UserAlreadyInUseException");
    public static MockHttpServletRequestBuilder makeManuelFollowAzul = MockMvcRequestBuilders
            .post("/users/{userId}/follow/{userIdToFollow}", 1, 2);
    public static MockHttpServletRequestBuilder makeManuelUnfollowAzul = MockMvcRequestBuilders
            .post("/users/{userId}/unfollow/{userIdToUnfollow}", 1, 2);
    public static MockHttpServletRequestBuilder getNewPostRequest(String postData) {
        return MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(postData)
                .accept(MediaType.APPLICATION_JSON);
    }
    public static MockHttpServletRequestBuilder getNewPromoPostRequest(String promoPostData) {
        return MockMvcRequestBuilders.post("/products/promo-post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(promoPostData)
                .accept(MediaType.APPLICATION_JSON);
    }
    public static MockHttpServletRequestBuilder getAllProductsPostedByUsersFollowedByManuel = MockMvcRequestBuilders
            .get("/products/followed/{userId}/list", 1);



}
