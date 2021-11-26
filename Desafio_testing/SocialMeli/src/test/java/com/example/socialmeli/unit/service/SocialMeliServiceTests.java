package com.example.socialmeli.unit.service;

import com.example.socialmeli.TestUtilsGenerator;
import com.example.socialmeli.dto.PostDTO;
import com.example.socialmeli.dto.response.CountFollowersResponseDTO;
import com.example.socialmeli.dto.response.FollowersResponseDTO;
import com.example.socialmeli.dto.response.PostsResponseDTO;
import com.example.socialmeli.exceptions.InvalidSortingCriteriaException;
import com.example.socialmeli.exceptions.UserNotFoundException;
import com.example.socialmeli.model.Post;
import com.example.socialmeli.model.User;
import com.example.socialmeli.repositories.PostRepository;
import com.example.socialmeli.repositories.UsuarioRepository;
import com.example.socialmeli.services.SocialMeliService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SocialMeliServiceTests {
    @Mock
    UsuarioRepository usuarioRepositoryMock;
    @Mock
    PostRepository postRepositoryMock;

    @InjectMocks
    SocialMeliService socialMeliService;

    @Test
    public void findByIdTestExistingUser() throws UserNotFoundException {

        User manuel = new User();
        manuel.setUserId(3);
        manuel.setUserName("Manuel Vendedor");
        when(usuarioRepositoryMock.findById(3)).thenReturn(Optional.of(manuel));

        User response = socialMeliService.getUserById(3);

        verify(usuarioRepositoryMock, atLeastOnce()).findById(3);
        assertEquals(response, manuel);

    }

    @Test
    public void findByIdTestNonExistingUser() throws UserNotFoundException {
        when(usuarioRepositoryMock.findById(any())).thenReturn(Optional.empty());

        Throwable exception = assertThrows(UserNotFoundException.class, () -> socialMeliService.getUserById(123));

        verify(usuarioRepositoryMock, atLeastOnce()).findById(123);

    }

    @Test
    public void getFollowersCount() throws UserNotFoundException {

        User manuel = new User();
        manuel.setUserId(3);
        manuel.setUserName("Manuel Vendedor");
        manuel.setFollowersId(List.of(4, 2, 6, 1, 5));

        when(usuarioRepositoryMock.findById(3)).thenReturn(Optional.of(manuel));

        CountFollowersResponseDTO followersCountDTO  = socialMeliService.countFollowers(3);

        assertEquals(5, followersCountDTO.getFollowersCount());

        verify(usuarioRepositoryMock, atLeastOnce()).findById(3);

    }

    //@Test
    //public void oldPostsCheckAge() throws UserNotFoundException, InvalidSortingCriteriaException {

        //User manuel = new User();
        //manuel.setUserId(3);
        //manuel.setUserName("Manuel Vendedor");

        //List<Post> postList = TestUtilsGenerator.getOldPostList();

        //when(usuarioRepositoryMock.findFollowed(4)).thenReturn(List.of(manuel));
        //when(usuarioRepositoryMock.findById(anyInt())).thenReturn(Optional.of(new User()));
        //when(postRepositoryMock.findByUserId(3)).thenReturn(Collections.singletonList(postList));

        //PostsResponseDTO posts  = socialMeliService.getFollowedPostList(4, "date_asc");

        //assertEquals(0, posts.getPosts().size());

        //verify(usuarioRepositoryMock, atLeastOnce()).findFollowed(4);
        //verify(postRepositoryMock, atLeastOnce()).findByUserId(3);

    //}

    //@Test

    //Tuve problemas con dependencias para testear llamado a método estático en MiFactory

    //public void getFollowersInOrder() throws UserNotFoundException, InvalidSortingCriteriaException {

        //User manuel = new User();
        //manuel.setUserId(3);
        //manuel.setUserName("Manuel Vendedor");
        //manuel.setFollowersId(List.of(4, 2, 6, 1, 5));


        //when(usuarioRepositoryMock.findById(3)).thenReturn(Optional.of(manuel));

        //try (MockedStatic<MiFactory> sorterFactoryMock = Mockito.mockStatic(MiFactory.class)) {
            //sorterFactoryMock.when(() -> MiFactory.getInstance(any())).thenReturn((a, b) -> 0);
        //}

        //FollowersResponseDTO followers = socialMeliService.getFollowers(3, "name_asc");

        //verify(sorterFactoryMock, atLeastOnce()).getInstance("name_asc");
        //verify(usuarioRepositoryMock, atLeastOnce()).findById(3);

    //}


}
