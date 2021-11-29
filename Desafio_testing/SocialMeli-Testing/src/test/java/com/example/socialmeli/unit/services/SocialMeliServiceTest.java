package com.example.socialmeli.unit.services;

import com.example.socialmeli.dto.PostDTO;
import com.example.socialmeli.dto.UserDTO;
import com.example.socialmeli.dto.response.FollowersResponseDTO;
import com.example.socialmeli.dto.response.PostsResponseDTO;
import com.example.socialmeli.exceptions.UserAlreadyInUseException;
import com.example.socialmeli.exceptions.UserNotFoundException;
import com.example.socialmeli.exceptions.UserSelfUseException;
import com.example.socialmeli.model.Post;
import com.example.socialmeli.model.User;
import com.example.socialmeli.repositories.PostRepository;
import com.example.socialmeli.repositories.UsuarioRepository;
import com.example.socialmeli.services.SocialMeliService;
import com.google.common.collect.Comparators;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertFalse;

@ExtendWith(MockitoExtension.class)
class SocialMeliServiceTest {

    @Mock
    private PostRepository mockPostRepository;

    @Mock
    private UsuarioRepository mockUserRepository;

    @InjectMocks
    SocialMeliService service;

    @Test
    void foundUserById() throws UserNotFoundException {
        //Arrange
        User user = new User();
        user.setUserId(1);
        user.setUserName("Sofia Menichelli");

        //Act
        Mockito.when(mockUserRepository.findById(1)).thenReturn(Optional.of(user));
        User userFound = service.getUserById(1);

        //Assert
        Mockito.verify(mockUserRepository, Mockito.atLeastOnce()).findById(Mockito.anyInt());
        Assertions.assertEquals(user, userFound);
    }

    @Test
    void notFoundUserById() {
        //Mock
        Mockito.when(mockUserRepository.findById(2)).thenReturn(Optional.empty());
        //Act && Assert
        Assertions.assertThrows(UserNotFoundException.class, ()->service.getUserById(2));
    }

    //T-0001
    @Test
    @DisplayName("Encontramos el usuario a seguir")
    void findUserToFollow() throws UserNotFoundException, UserAlreadyInUseException, UserSelfUseException {
        //Arrange
        User user = new User();
        user.setUserId(1);
        user.setUserName("Sofia Menichelli");

        User user2 = new User();
        user2.setUserId(2);
        user2.setUserName("Olivia Perez");

        //Act
        Mockito.when(mockUserRepository.findById(2)).thenReturn(Optional.of(user2));
        Mockito.when(mockUserRepository.findById(1)).thenReturn(Optional.of(user));
        service.follow(1,2);

        //Act && Assert
        Mockito.verify(mockUserRepository, Mockito.atLeastOnce()).findById(2);

    }

    //T-0001
    @Test
    @DisplayName("No existe el usuario a seguir")
    void UserToFollowDoesNotExist() {
        User user = new User();
        user.setUserId(1);
        user.setUserName("Sofia Menichelli");
        //Act
        Mockito.when(mockUserRepository.findById(1)).thenReturn(Optional.of(user));
        Mockito.when(mockUserRepository.findById(2)).thenReturn(Optional.empty());
        //Act && Assert
        Assertions.assertThrows(UserNotFoundException.class, ()->service.follow(1,2));
    }
    //T-0002
    @Test
    @DisplayName("Encontramos el usuario a dejar de seguir")
    void findUserToUnfollow() throws UserNotFoundException, UserAlreadyInUseException, UserSelfUseException {
        //Arrange
        User user = new User();
        user.setUserId(1);
        user.setUserName("Sofia Menichelli");

        User user2 = new User();
        user2.setUserId(2);
        user2.setUserName("Olivia Perez");

        //Act
        Mockito.when(mockUserRepository.findById(2)).thenReturn(Optional.of(user2));
        Mockito.when(mockUserRepository.findById(1)).thenReturn(Optional.of(user));
        service.follow(1,2);

        //Act && Assert
        Mockito.verify(mockUserRepository, Mockito.atLeastOnce()).findById(2);

    }
    //T-0002

    @Test
    @DisplayName("No existe el usuario a dejar de seguir")
    void UserToUnfollowDoesNotExist() {
        User user = new User();
        user.setUserId(1);
        user.setUserName("Sofia Menichelli");
        //Act
        Mockito.when(mockUserRepository.findById(1)).thenReturn(Optional.of(user));
        Mockito.when(mockUserRepository.findById(2)).thenReturn(Optional.empty());

        //Act && Assert
        Assertions.assertThrows(UserNotFoundException.class, ()->service.follow(1,2));
    }

    //T-0003
    @Test
    @DisplayName("Lanzamos un error, cuando el order esta en null, aunque no falle")
    void getFollowersWhithoutOrder() {
        Assertions.assertThrows(NullPointerException.class, () -> service.getFollowers(1,null));
    }
    //T-0004
    @Test
    void getFollowersByOrderAscCorrectly() throws UserNotFoundException {
        User user2 = new User();
        user2.setUserId(2);
        user2.setUserName("Olivia Perez");
        User user1 = new User();
        user1.setUserId(1);
        user1.setUserName("Sofia Perez");
        User user3 = new User();
        user3.setUserId(3);
        user3.setUserName("Javier Perez");

        user3.setFollowersId(Arrays.asList(1,2));

        Mockito.when(mockUserRepository.findById(2)).thenReturn(Optional.of(user2));

        FollowersResponseDTO followersListDto = service.getFollowers (2, "name_asc");
        System.out.println(followersListDto.getFollowers());
        Comparator<UserDTO> comparator = Comparator.comparing(UserDTO::getUserName);

        Assertions.assertTrue(Comparators.isInOrder(followersListDto.getFollowers(), comparator));
    }
    @Test
    void getFollowersByOrderAscIncorrectly() throws UserNotFoundException {
        User user2 = new User();
        user2.setUserId(2);
        user2.setUserName("Olivia Perez");
        User user1 = new User();
        user1.setUserId(1);
        user1.setUserName("Sofia Perez");
        User user3 = new User();
        user3.setUserId(3);
        user3.setUserName("Javier Perez");

        user3.setFollowersId(Arrays.asList(1,2));

        Mockito.when(mockUserRepository.findById(3)).thenReturn(Optional.of(user3));
        Mockito.when(mockUserRepository.findById(1)).thenReturn(Optional.of(user1));
        Mockito.when(mockUserRepository.findById(2)).thenReturn(Optional.of(user2));

        FollowersResponseDTO followersListDto = service.getFollowers(3, "name_asc");
        System.out.println(followersListDto.getFollowers());
        Comparator<UserDTO> comparator = Comparator.comparing(UserDTO::getUserName).reversed();

        assertFalse(Comparators.isInOrder(followersListDto.getFollowers(), comparator));
    }
    @Test
    void getFollowersByOrderDescCorrectly() throws UserNotFoundException {
        User user2 = new User();
        user2.setUserId(2);
        user2.setUserName("Olivia Perez");
        User user1 = new User();
        user1.setUserId(1);
        user1.setUserName("Sofia Perez");
        User user3 = new User();
        user3.setUserId(3);
        user3.setUserName("Javier Perez");

        user3.setFollowersId(Arrays.asList(1,2));

        Mockito.when(mockUserRepository.findById(2)).thenReturn(Optional.of(user2));

        FollowersResponseDTO followersListDto = service.getFollowers (2, "name_desc");
        System.out.println(followersListDto.getFollowers());
        Comparator<UserDTO> comparator = Comparator.comparing(UserDTO::getUserName).reversed();

        Assertions.assertTrue(Comparators.isInOrder(followersListDto.getFollowers(), comparator));
    }
    @Test
    void getFollowersByOrderDescIncorrectly() throws UserNotFoundException {
        User user2 = new User();
        user2.setUserId(2);
        user2.setUserName("Olivia Perez");
        User user1 = new User();
        user1.setUserId(1);
        user1.setUserName("Sofia Perez");
        User user3 = new User();
        user3.setUserId(3);
        user3.setUserName("Javier Perez");

        user3.setFollowersId(Arrays.asList(1,2));

        Mockito.when(mockUserRepository.findById(3)).thenReturn(Optional.of(user3));
        Mockito.when(mockUserRepository.findById(1)).thenReturn(Optional.of(user1));
        Mockito.when(mockUserRepository.findById(2)).thenReturn(Optional.of(user2));

        FollowersResponseDTO followersListDto = service.getFollowers(3, "name_desc");
        System.out.println(followersListDto.getFollowers());
        Comparator<UserDTO> comparator = Comparator.comparing(UserDTO::getUserName);

        assertFalse(Comparators.isInOrder(followersListDto.getFollowers(), comparator));
    }
    //T-0005
    @Test
    @DisplayName("Lanzamos un error, cuando el order esta en null, aunque no falle")
    void getPostWhithoutOrder() {
        Assertions.assertThrows(NullPointerException.class, () -> service.getFollowedPostList(1, null));
    }

    //T-0007
    @Test
    void countFollowers() throws UserNotFoundException {
        //Arrange
        User user = new User();
        user.setUserId(1);
        user.setUserName("Sofia Menichelli");
        user.setFollowersId(Arrays.asList(2,3));
        //Act
        Mockito.when(mockUserRepository.findById(1)).thenReturn(Optional.of(user));
        Integer count = service.countFollowers(1).getFollowersCount();
        //Assert
        Assertions.assertEquals(user.getFollowersId().size(), count);
    }

    //Estuvimos viendo este test con Anibal, La lista de Post Viene vacia.
    @Test
    void getPostByOrderAsc() throws UserNotFoundException {
        //Arrange
        User user2 = new User();
        user2.setUserId(2);
        user2.setUserName("Olivia Perez");
        User user1 = new User();
        user1.setUserId(1);
        user1.setUserName("Sofia Perez");
        User user3 = new User();
        user3.setUserId(3);
        user3.setUserName("Javier Perez");

        user3.setFollowersId(Arrays.asList(1,2));

        Post post = new Post();
        post.setIdPost(1);
        post.setUserId(1);
        Date date = new Date(15-11-2021);
        post.setDate(date);
        Post post2 = new Post();
        post2.setIdPost(2);
        post2.setUserId(1);
        Date date2 = new Date(25-11-2021);
        post2.setDate(date2);
        Post post3 = new Post();
        post3.setIdPost(1);
        post3.setUserId(2);
        Date date3 = new Date(29-11-2021);
        post3.setDate(date3);

        //Act
        Mockito.when(mockUserRepository.findById(1)).thenReturn(Optional.of(user3));

        PostsResponseDTO postList = service.getFollowedPostList(1, "date_asc");
        System.out.println(postList.getPosts());
        Comparator<PostDTO> comparator = Comparator.comparing(PostDTO::getDate);

        //Assert
        Assertions.assertTrue(Comparators.isInOrder(postList.getPosts(), comparator));
    }

    //Estuvimos viendo este test con Anibal, La lista de Post Viene vacia.
    @Test
    void getPostByOrderAscIncorrect() throws UserNotFoundException {
        //Arrange
        User user2 = new User();
        user2.setUserId(2);
        user2.setUserName("Olivia Perez");
        User user1 = new User();
        user1.setUserId(1);
        user1.setUserName("Sofia Perez");
        User user3 = new User();
        user3.setUserId(3);
        user3.setUserName("Javier Perez");

        user3.setFollowersId(Arrays.asList(1,2));

        Post post = new Post();
        post.setIdPost(1);
        post.setUserId(1);
        Date date = new Date(15-11-2021);
        post.setDate(date);
        Post post2 = new Post();
        post2.setIdPost(2);
        post2.setUserId(1);
        Date date2 = new Date(25-11-2021);
        post2.setDate(date2);
        Post post3 = new Post();
        post3.setIdPost(1);
        post3.setUserId(2);
        Date date3 = new Date(29-11-2021);
        post3.setDate(date3);

        //Act
        Mockito.when(mockUserRepository.findById(3)).thenReturn(Optional.of(user3));
        Mockito.when(mockPostRepository.findByUserId(2)).thenReturn(Arrays.asList(post,post2));
        Mockito.when(mockPostRepository.findByUserId(3)).thenReturn(Collections.singletonList(post3));

        PostsResponseDTO postList = service.getFollowedPostList(3, "date_asc");
        System.out.println(postList.getPosts());
        Comparator<PostDTO> comparator = Comparator.comparing(PostDTO::getDate).reversed();

        //Assert
        Assertions.assertFalse(Comparators.isInOrder(postList.getPosts(), comparator));
    }

    @Test
    void getPostByOrderDescIncorrect() throws UserNotFoundException {
        //Arrange
        User user2 = new User();
        user2.setUserId(2);
        user2.setUserName("Olivia Perez");
        User user1 = new User();
        user1.setUserId(1);
        user1.setUserName("Sofia Perez");
        User user3 = new User();
        user3.setUserId(3);
        user3.setUserName("Javier Perez");

        user3.setFollowersId(Arrays.asList(1,2));

        Post post = new Post();
        post.setIdPost(1);
        post.setUserId(1);
        Date date = new Date(15-11-2021);
        post.setDate(date);
        Post post2 = new Post();
        post2.setIdPost(2);
        post2.setUserId(1);
        Date date2 = new Date(25-11-2021);
        post2.setDate(date2);
        Post post3 = new Post();
        post3.setIdPost(1);
        post3.setUserId(2);
        Date date3 = new Date(29-11-2021);
        post3.setDate(date3);

        //Act
        Mockito.when(mockUserRepository.findById(3)).thenReturn(Optional.of(user3));
        Mockito.when(mockPostRepository.findByUserId(2)).thenReturn(Arrays.asList(post,post2));
        Mockito.when(mockPostRepository.findByUserId(3)).thenReturn(Collections.singletonList(post3));

        PostsResponseDTO postList = service.getFollowedPostList(3, "date_desc");
        System.out.println(postList.getPosts());
        Comparator<PostDTO> comparator = Comparator.comparing(PostDTO::getDate);

        //Assert
        Assertions.assertFalse(Comparators.isInOrder(postList.getPosts(), comparator));
    }
    @Test
    void getPostByOrderDescCorrect() throws UserNotFoundException {
        //Arrange
        User user2 = new User();
        user2.setUserId(2);
        user2.setUserName("Olivia Perez");
        User user1 = new User();
        user1.setUserId(1);
        user1.setUserName("Sofia Perez");
        User user3 = new User();
        user3.setUserId(3);
        user3.setUserName("Javier Perez");

        user3.setFollowersId(Arrays.asList(1,2));

        Post post = new Post();
        post.setIdPost(1);
        post.setUserId(1);
        Date date = new Date(15-11-2021);
        post.setDate(date);
        Post post2 = new Post();
        post2.setIdPost(2);
        post2.setUserId(1);
        Date date2 = new Date(25-11-2021);
        post2.setDate(date2);
        Post post3 = new Post();
        post3.setIdPost(1);
        post3.setUserId(2);
        Date date3 = new Date(29-11-2021);
        post3.setDate(date3);

        //Act
        Mockito.when(mockUserRepository.findById(3)).thenReturn(Optional.of(user3));
        Mockito.when(mockPostRepository.findByUserId(2)).thenReturn(Arrays.asList(post,post2));
        Mockito.when(mockPostRepository.findByUserId(3)).thenReturn(Collections.singletonList(post3));

        PostsResponseDTO postList = service.getFollowedPostList(3, "date_desc");
        System.out.println(postList.getPosts());
        Comparator<PostDTO> comparator = Comparator.comparing(PostDTO::getDate).reversed();

        //Assert
        Assertions.assertTrue(Comparators.isInOrder(postList.getPosts(), comparator));
    }

    @Test
    void getUserPostRequest() {
        //Arrange
        //Act
        //Assert
    }

}