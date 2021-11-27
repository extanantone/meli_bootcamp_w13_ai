package com.example.socialmeli.unit.service;

import com.example.socialmeli.TestUtilsGet;
import com.example.socialmeli.dto.PostDTO;
import com.example.socialmeli.dto.UserDTO;
import com.example.socialmeli.dto.response.CountFollowersResponseDTO;
import com.example.socialmeli.dto.response.PostsResponseDTO;
import com.example.socialmeli.exceptions.InvalidSortingCriteriaException;
import com.example.socialmeli.exceptions.UserNotFoundException;
import com.example.socialmeli.model.User;
import com.example.socialmeli.repositories.PostRepository;
import com.example.socialmeli.repositories.UsuarioRepository;
import com.example.socialmeli.services.SocialMeliService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SocialMeliServiceTests {
    @Mock
    UsuarioRepository userRepositoryMock;
    @Mock
    PostRepository postRepositoryMock;

    @InjectMocks
    SocialMeliService socialMeliService;
    private List<PostDTO> userPosts;
    private List<UserDTO> followedList;

    @AfterEach
    public void resetMocks() {
        reset(userRepositoryMock);
        reset(postRepositoryMock);
    }

    @Test
    public void findByIdTestExistingUser() throws UserNotFoundException {

        User manuel = TestUtilsGet.getManuel();
        when(userRepositoryMock.findById(1)).thenReturn(Optional.of(manuel));

        User response = socialMeliService.getUserById(1);

        assertEquals(response, manuel);
        verify(userRepositoryMock, atLeastOnce()).findById(1);
    }

    @Test
    public void findByIdTestNonExistingUser() {
        when(userRepositoryMock.findById(any())).thenReturn(Optional.empty());

        Throwable exception = assertThrows(UserNotFoundException.class, () -> socialMeliService.getUserById(123));

        verify(userRepositoryMock, atLeastOnce()).findById(123);
    }

    @Test
    public void getFollowersCount() throws UserNotFoundException {

        User manuel = TestUtilsGet.getManuel();
        manuel.setFollowersId(List.of(4, 2, 6, 1, 5));

        when(userRepositoryMock.findById(1)).thenReturn(Optional.of(manuel));

        CountFollowersResponseDTO followersCountDTO  = socialMeliService.countFollowers(1);

        assertEquals(5, followersCountDTO.getFollowersCount());
        verify(userRepositoryMock, atLeastOnce()).findById(1);
    }

    @Test
    public void oldPostsCheckAge() throws UserNotFoundException, InvalidSortingCriteriaException {

        User manuel = TestUtilsGet.getManuel();
        User azul = TestUtilsGet.getAzul();

        List postList = TestUtilsGet.getOldPostList();

        when(userRepositoryMock.findFollowed(2)).thenReturn(List.of(manuel));
        when(userRepositoryMock.findById(anyInt())).thenReturn(Optional.of(azul));
        when(postRepositoryMock.findByUserId(1)).thenReturn(postList);

        PostsResponseDTO posts  = socialMeliService.getFollowedPostList(2, null);

        assertEquals(0, posts.getPosts().size());
        verify(userRepositoryMock, atLeastOnce()).findFollowed(2);
        verify(postRepositoryMock, atLeastOnce()).findByUserId(1);

    }

    @Test
    public void recentPostsCheckAge() throws UserNotFoundException, InvalidSortingCriteriaException {

        User manuel = TestUtilsGet.getManuel();
        User azul = TestUtilsGet.getAzul();

        List postList = TestUtilsGet.getRecentPostList();

        when(userRepositoryMock.findFollowed(2)).thenReturn(List.of(manuel));
        when(userRepositoryMock.findById(anyInt())).thenReturn(Optional.of(azul));
        when(postRepositoryMock.findByUserId(1)).thenReturn(postList);

        PostsResponseDTO posts  = socialMeliService.getFollowedPostList(2, null);

        assertEquals(3, posts.getPosts().size());
        verify(userRepositoryMock, atLeastOnce()).findFollowed(2);
        verify(postRepositoryMock, atLeastOnce()).findByUserId(1);
    }

    @Test
    public void mixedAgePostsCheckAge() throws UserNotFoundException, InvalidSortingCriteriaException {

        User manuel = TestUtilsGet.getManuel();
        User azul = TestUtilsGet.getAzul();

        List postList = TestUtilsGet.getPostListWithOneRecentPost();

        when(userRepositoryMock.findFollowed(2)).thenReturn(List.of(manuel));
        when(userRepositoryMock.findById(anyInt())).thenReturn(Optional.of(azul));
        when(postRepositoryMock.findByUserId(1)).thenReturn(postList);

        PostsResponseDTO posts  = socialMeliService.getFollowedPostList(2, null);

        assertEquals(1, posts.getPosts().size());
        verify(userRepositoryMock, atLeastOnce()).findFollowed(2);
        verify(postRepositoryMock, atLeastOnce()).findByUserId(1);
    }

    //@Test

    //public void getFollowersInOrder() throws UserNotFoundException, InvalidSortingCriteriaException {

        //User manuel = new User();
        //manuel.setUserId(3);
        //manuel.setUserName("Manuel Vendedor");
        //manuel.setFollowersId(List.of(4, 2, 6, 1, 5));


        //when(userRepositoryMock.findById(3)).thenReturn(Optional.of(manuel));

        //try (MockedStatic<MiFactory> sorterFactoryMock = Mockito.mockStatic(MiFactory.class)) {
            //sorterFactoryMock.when(() -> MiFactory.getInstance(any())).thenReturn((a, b) -> 0);
        //}

        //FollowersResponseDTO followers = socialMeliService.getFollowers(3, "name_asc");

        //verify(sorterFactoryMock, atLeastOnce()).getInstance("name_asc");
        //verify(userRepositoryMock, atLeastOnce()).findById(3);

    //}


}
