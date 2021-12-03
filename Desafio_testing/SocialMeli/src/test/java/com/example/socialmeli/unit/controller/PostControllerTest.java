package com.example.socialmeli.unit.controller;


import com.example.socialmeli.controllers.PostsController;
import com.example.socialmeli.controllers.UsersController;
import com.example.socialmeli.dto.PostDTO;
import com.example.socialmeli.exceptions.InvalidPromoException;
import com.example.socialmeli.exceptions.PostAlreadyExistException;
import com.example.socialmeli.exceptions.UserNotFoundException;
import com.example.socialmeli.model.Post;
import com.example.socialmeli.services.SocialMeliService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;

import static com.example.socialmeli.TestUtilsGet.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PostControllerTest {
    @Mock
    SocialMeliService socialMeliServiceMock;

    @InjectMocks
    PostsController postsController;

    @AfterEach
    public void resetMocks() {
        reset(socialMeliServiceMock);
    }

    @Test
    void post() throws UserNotFoundException, InvalidPromoException,
            PostAlreadyExistException {
        PostDTO newPost = getMesa();

        postsController.loadPost(newPost);

        verify(socialMeliServiceMock, atLeastOnce()).pushPost(newPost);

    }
}
