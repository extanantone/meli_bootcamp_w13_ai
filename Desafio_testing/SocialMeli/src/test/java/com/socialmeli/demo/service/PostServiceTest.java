package com.socialmeli.demo.service;

import com.socialmeli.demo.dto.PostDTO;
import com.socialmeli.demo.dto.UserWithFollowedPostsListDTO;
import com.socialmeli.demo.exceptions.BadRequestException;
import com.socialmeli.demo.mapper.PostMapper;
import com.socialmeli.demo.mapper.UserMapper;
import com.socialmeli.demo.model.Post;
import com.socialmeli.demo.repository.PostRepository;
import com.socialmeli.demo.repository.UserRepository;
import com.socialmeli.demo.util.TestUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.reset;

@ExtendWith(MockitoExtension.class)
public class PostServiceTest {

    @Mock
    PostRepository postRepository;

    @Spy
    PostMapper postMapper;

    @Spy
    UserRepository userRepository;

    @Mock
    UserService userService;

    @InjectMocks
    PostService postService;

    @AfterEach
    public void resetMocks() {
        reset(postRepository);
    }


    //T-0005(se cumple ascendente)
    @Test
    public void checkDateAscendingOrderExistsInGetUserFollowedPosts() {

        //Arrange
        String order = "date_asc";
        UserWithFollowedPostsListDTO expectedResult = new UserWithFollowedPostsListDTO(3, Collections.emptyList());

        //Act
        UserWithFollowedPostsListDTO currentResult = postService.getUserWithFollowedPosts(3, order);

        //Assert
        assertEquals(expectedResult, currentResult);

    }

    //T-0005(se cumple descendente)
    @Test
    public void checkDateDescendingOrderExistsInGetUserFollowedPosts() {

        //Arrange
        String order = "date_desc";
        UserWithFollowedPostsListDTO expectedResult = new UserWithFollowedPostsListDTO(3, Collections.emptyList());

        //Act
        UserWithFollowedPostsListDTO currentResult = postService.getUserWithFollowedPosts(3, order);

        //Assert
        assertEquals(expectedResult, currentResult);

    }

    //T-0005(No se cumple)
    @Test
    public void checkDateOrderDoesntExistsInGetUserFollowedPosts() {

        //Arrange
        String order = "date_desc";
        UserWithFollowedPostsListDTO expectedResult = new UserWithFollowedPostsListDTO(1, Collections.emptyList());

        //Assert
        assertThrows(BadRequestException.class , () ->
                postService.getUserWithFollowedPosts(1, order)
        );
    }

    //T-0006(Se cumple ascendente)
    @Test
    public void checkAscendingOrderIsCorrectInGetUserWithFollowedPost() {

        //Arrange
        String order = "date_asc";

        PostDTO postDTO1 = new PostDTO(2, 1, null, LocalDate.of(2021,11,27),
                null, 100, 1500.5);

        PostDTO postDTO2 = new PostDTO(2, 2, null, LocalDate.of(2021,11,28),
                null, 100, 1500.5);

        List<PostDTO> postDTOS = List.of(postDTO1, postDTO2);

        UserWithFollowedPostsListDTO expectedResult = new UserWithFollowedPostsListDTO(1 ,postDTOS);

        //Act
        UserWithFollowedPostsListDTO currentResult = postService.getUserWithFollowedPosts(1, order);

        //Assert
        assertEquals(expectedResult, currentResult);

    }

    //T-0006(Se cumple descendente)
    @Test
    public void checkDescendingOrderIsCorrectInGetUserWithFollowedPost() {

        //Arrange
        String order = "date_desc";

        PostDTO postDTO1 = new PostDTO(2, 1, null, LocalDate.of(2021,11,27),
                null, 100, 1500.5);

        PostDTO postDTO2 = new PostDTO(2, 2, null, LocalDate.of(2021,11,28),
                null, 100, 1500.5);

        List<PostDTO> postDTOS = List.of(postDTO2, postDTO1);

        UserWithFollowedPostsListDTO expectedResult = new UserWithFollowedPostsListDTO(1 ,postDTOS);

        //Act
        UserWithFollowedPostsListDTO currentResult = postService.getUserWithFollowedPosts(1, order);

        //Assert
        assertEquals(expectedResult, currentResult);

    }

    //T-0008 (Se cumple)
    @Test
    public void checkPostOfAnUserAreOfTheLastTwoWeeks() {
        //Arrange

        PostDTO postDTO1 = new PostDTO(2, 1, null, LocalDate.of(2021,11,27),
                null, 100, 1500.5);

        PostDTO postDTO2 = new PostDTO(2, 2, null, LocalDate.of(2021,11,28),
                null, 100, 1500.5);

        List<PostDTO> postDTOS = List.of(postDTO2, postDTO1);

        UserWithFollowedPostsListDTO expectedResult = new UserWithFollowedPostsListDTO(1 ,postDTOS);

        //Act
        UserWithFollowedPostsListDTO currentResult = postService.getUserWithFollowedPosts(1, "");

        //Assert
        assertAll(
                () -> {
                    for (PostDTO postDTO:expectedResult.getPostDTOS()){
                        assertTrue(currentResult.getPostDTOS().contains(postDTO));
                    }
                },
                () -> assertEquals(expectedResult.getPostDTOS().size(), currentResult.getPostDTOS().size())
        );

    }
}
