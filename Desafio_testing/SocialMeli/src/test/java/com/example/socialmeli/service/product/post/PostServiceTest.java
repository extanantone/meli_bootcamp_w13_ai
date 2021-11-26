package com.example.socialmeli.service.product.post;

import com.example.socialmeli.dto.post.PostDTO;
import com.example.socialmeli.dto.post.PostFollowedDTO;
import com.example.socialmeli.dto.user.FollowerDTO;
import com.example.socialmeli.exception.BadRequestException;
import com.example.socialmeli.model.Post;
import com.example.socialmeli.model.Product;
import com.example.socialmeli.model.User;
import com.example.socialmeli.repository.product.post.PostRepository;
import com.example.socialmeli.repository.user.UserRepository;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PostServiceTest
{
    @Mock
    PostRepository postRepository;

    @Mock
    UserRepository userRepository;

    @InjectMocks
    PostService postService;

    Map<Integer, User> userMap = null;
    User follower = null;
    User followed = null;
    List<Post> postList = null;
    Post post1 = null;
    Post post2 = null;
    Post post3 = null;
    Post post4 = null;

    @BeforeEach
    void setUp()
    {
        follower = new User("Follower");
        followed = new User("Followed");
        userMap = new HashMap<>();
        userMap.put(follower.getUserId(), follower);
        userMap.put(followed.getUserId(), follower);
        Product blackChair = new Product(1, "Black chair", "Office", "Razer", "Black", "Good as new");
        post1 = new Post(followed.getUserId(), 1, LocalDate.of(2021, 11, 11), blackChair, 10, 100000, false, 0 );
        post2 = new Post(followed.getUserId(), 2, LocalDate.of(2021, 11, 12), blackChair, 10, 100000, false, 0 );
        post3 = new Post(followed.getUserId(), 3, LocalDate.of(2021, 11, 10), blackChair, 10, 100000, false, 0 );
        post4 = new Post(followed.getUserId(), 4, LocalDate.of(2021, 11, 13), blackChair, 10, 100000, false, 0 );
        postList = List.of(post1, post2, post3, post4);
    }
    //T-0005
    //Verificar que el tipo de ordenamiento por fecha exista (US-0009)
    @Test
    void listRecentFollowedPostsWithOrder()
    {
        // Arrange
        ModelMapper modelMapper = new ModelMapper();
        Type listType = new TypeToken<List<PostDTO>>(){}.getType();
        List<PostDTO> expectedDTO = modelMapper.map(postList, listType);
        // Act & Mock
        Mockito.when(userRepository.usersMap()).thenReturn(userMap);
        Mockito.when(postRepository.findFollowedTwoWeeksBeforeOrderByDateAsc(follower.getUserId())).thenReturn(postList);
        PostFollowedDTO result = postService.listRecentFollowedPosts(follower.getUserId(), "date_asc");
        // Assert
        Mockito.verify(userRepository, Mockito.times(1)).usersMap();
        Mockito.verify(postRepository, Mockito.times(1)).findFollowedTwoWeeksBeforeOrderByDateAsc(Mockito.anyInt());
        Assertions.assertAll(
                () -> Assertions.assertEquals(result.getPosts().size(), 4),
                () -> Assertions.assertEquals(expectedDTO, result.getPosts())
        );
    }

    @Test
    void listRecentFollowedPostsWithoutOrder()
    {
        // Arrange
        ModelMapper modelMapper = new ModelMapper();
        Type listType = new TypeToken<List<PostDTO>>()
        {
        }.getType();
        List<PostDTO> expectedDTO = modelMapper.map(postList, listType);
        // Act & Mock
        Mockito.when(userRepository.usersMap()).thenReturn(userMap);
        Mockito.when(postRepository.findFollowedTwoWeeksBeforeOrderByDateAsc(follower.getUserId())).thenReturn(postList);
        // Assert
        Assertions.assertThrows(BadRequestException.class, () -> postService.listRecentFollowedPosts(follower.getUserId(), null));
        Mockito.verify(userRepository, Mockito.times(1)).usersMap();
        Mockito.verify(postRepository, Mockito.times(1)).findFollowedTwoWeeksBeforeOrderByDateAsc(Mockito.anyInt());
    }
}