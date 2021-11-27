package com.example.socialmeli.unit.controller;

import com.example.socialmeli.controllers.PostsController;
import com.example.socialmeli.dto.response.PostsResponseDTO;
import com.example.socialmeli.exceptions.InvalidSortingCriteriaException;
import com.example.socialmeli.exceptions.UserNotFoundException;
import com.example.socialmeli.services.SocialMeliService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.reset;

@ExtendWith(MockitoExtension.class)
public class PostsControllerTests {
    @Mock
    SocialMeliService socialMeliServiceMock;

    @InjectMocks
    PostsController postsController;

    @AfterEach
    public void resetMocks() {
        reset(socialMeliServiceMock);
    }

    @Test
    public void getRecentPostsOfFollowedUsers() throws UserNotFoundException, InvalidSortingCriteriaException {

        when(socialMeliServiceMock.getFollowedPostList(3, null)).thenReturn(new PostsResponseDTO());

        postsController.getFollowedPostList(3, null);

        verify(socialMeliServiceMock, atLeastOnce()).getFollowedPostList(3, null);

    }
}
