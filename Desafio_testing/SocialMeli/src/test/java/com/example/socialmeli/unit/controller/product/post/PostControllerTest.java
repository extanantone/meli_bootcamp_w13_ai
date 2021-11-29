package com.example.socialmeli.unit.controller.product.post;

import com.example.socialmeli.controller.product.post.PostController;
import com.example.socialmeli.dto.post.*;
import com.example.socialmeli.service.service.product.post.PostService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PostControllerTest
{
    @Mock
    PostService postService;

    @InjectMocks
    PostController postController;

    @Test
    void createPost()
    {
        // Arrange
        UserPostDTO expected = new UserPostDTO();
        // Act & Mock
        Mockito.when(postService.create(expected)).thenReturn(expected);
        UserPostDTO result = postController.createPost(expected);
        // Assert
        Mockito.verify(postService, Mockito.atLeastOnce()).create(expected);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void promoPostList()
    {
        // Arrange
        PromoPostListDTO expected = new PromoPostListDTO();
        // Act & Mock
        Mockito.when(postService.promoPostList(1, null)).thenReturn(expected);
        PromoPostListDTO result = postController.promoPostList(1, null);
        // Assert
        Mockito.verify(postService, Mockito.atLeastOnce()).promoPostList(1, null);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void promoPostcount()
    {
        // Arrange
        PromoPostCountDTO expected = new PromoPostCountDTO();
        // Act & Mock
        Mockito.when(postService.promoPostCount(1)).thenReturn(expected);
        PromoPostCountDTO result = postController.promoPostcount(1);
        // Assert
        Mockito.verify(postService, Mockito.atLeastOnce()).promoPostCount(1);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void createPromoPost()
    {
        // Arrange
        UserPromoPostDTO expected = new UserPromoPostDTO();
        // Act & Mock
        Mockito.when(postService.createPromo(expected)).thenReturn(expected);
        UserPromoPostDTO result = postController.createPromoPost(expected);
        // Assert
        Mockito.verify(postService, Mockito.atLeastOnce()).createPromo(expected);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void postList()
    {
        // Arrange
        PostFollowedDTO expected = new PostFollowedDTO();
        // Act & Mock
        Mockito.when(postService.listPosts(1)).thenReturn(expected);
        PostFollowedDTO result = postController.postList(1);
        // Assert
        Mockito.verify(postService, Mockito.atLeastOnce()).listPosts(1);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void recentFollowedProducts()
    {
        // Arrange
        PostFollowedDTO expected = new PostFollowedDTO();
        // Act & Mock
        Mockito.when(postService.listRecentFollowedPosts(1, null)).thenReturn(expected);
        PostFollowedDTO result = postController.recentFollowedProducts(1, null);
        // Assert
        Mockito.verify(postService, Mockito.atLeastOnce()).listRecentFollowedPosts(1, null);
        Assertions.assertEquals(expected, result);
    }
}