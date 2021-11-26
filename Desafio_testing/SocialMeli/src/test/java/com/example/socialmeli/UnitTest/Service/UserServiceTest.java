package com.example.socialmeli.UnitTest.Service;

import com.example.socialmeli.dto.FollowedDto;
import com.example.socialmeli.dto.FollowersDto;
import com.example.socialmeli.dto.PostCreateDto;
import com.example.socialmeli.dto.UserDto;
import com.example.socialmeli.exception.BadRequestException;
import com.example.socialmeli.model.User;
import com.example.socialmeli.repository.IUserRepository;
import com.example.socialmeli.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    private static List<User> users;

    @InjectMocks
    UserService service;

    @Mock
    IUserRepository repository;

    @BeforeAll
    public static void usersContain(){

        User user1 = new User();
        user1.setUserId(1);
        user1.setUserName("Camilo_vendedor1");

        User user2 = new User();
        user2.setUserId(2);
        user2.setUserName("Andres_vendedor2");

        User user3 = new User();
        user3.setUserId(3);
        user3.setUserName("Pablo_vendedor3");

        users = List.of(user1,user2,user3);
    }



    @Test
    @DisplayName("Verificar que el usuario a seguir no exista (exception)")
    void test101() {
        Integer userId = 1;
        Integer userIdToFollow = 5;

        Mockito.when(repository.findById(userId)).thenReturn(Optional.of(new User()));
        Mockito.when(repository.findById(userIdToFollow)).thenReturn(Optional.empty());



        Assertions.assertThrows(BadRequestException.class,
                () -> service.follower(userId,userIdToFollow)
        );

        Mockito.verify(repository,Mockito.atLeastOnce()).findById(userId);
        Mockito.verify(repository,Mockito.atLeastOnce()).findById(userIdToFollow);
        Mockito.verify(repository,Mockito.never()).follow(any(User.class),any(User.class));


    }

    @Test
    @DisplayName("Verificar que el usuario a dejar de seguir exista")
    void Test201() {



        users.get(0).addFollowed(new UserDto(users.get(1)));

        users.get(1).addFollower(new UserDto(users.get(0)));

        Mockito.when(repository.findById(users.get(0).getUserId())).thenReturn(Optional.of(users.get(0)));
        Mockito.when(repository.findById(users.get(1).getUserId())).thenReturn(Optional.of(users.get(1)));

        Mockito.when(repository.validateFollow(users.get(0),users.get(1))).thenReturn(Optional.of(users.get(0)));

        Mockito.doNothing().when(repository).unFollow(users.get(0),users.get(1));

        service.unfollow(users.get(0).getUserId(),users.get(1).getUserId());


        Mockito.verify(repository,Mockito.atLeastOnce()).findById(users.get(0).getUserId());
        Mockito.verify(repository,Mockito.atLeastOnce()).findById(users.get(1).getUserId());
        Mockito.verify(repository,Mockito.atLeastOnce()).unFollow(users.get(0),users.get(1));

    }

    @Test
    @DisplayName("Verificar que el usuario a dejar de seguir exista (exception)")
    void Test202() {



        Mockito.when(repository.findById(users.get(0).getUserId())).thenReturn(Optional.of(users.get(0)));
        Mockito.when(repository.findById(users.get(1).getUserId())).thenReturn(Optional.of(users.get(1)));

        Mockito.when(repository.validateFollow(users.get(0),users.get(1))).thenReturn(Optional.empty());

        Assertions.assertThrows(BadRequestException.class,
                () -> service.unfollow(users.get(0).getUserId(),users.get(1).getUserId())
        );

        Mockito.verify(repository,Mockito.atLeastOnce()).findById(users.get(0).getUserId());
        Mockito.verify(repository,Mockito.atLeastOnce()).findById(users.get(1).getUserId());
        Mockito.verify(repository,Mockito.never()).unFollow(any(User.class),any(User.class));

    }

    @Test
    @DisplayName("Validar ordenamiento en followed (exception)")
    void test301() {
        String order = "name_novalid";

        Assertions.assertThrows(BadRequestException.class,
                () -> service.followed(users.get(0).getUserId(),order)
        );
        Mockito.verify(repository,Mockito.never()).findById(users.get(0).getUserId());

    }

    @Test
    @DisplayName("Validar ordenamiento en followers (exception)")
    void test302() {
        String order = "name_novalid";


        Assertions.assertThrows(BadRequestException.class,
                () -> service.followers(users.get(0).getUserId(),order)
        );
        Mockito.verify(repository,Mockito.never()).findById(users.get(0).getUserId());

    }

    @Test
    @DisplayName("Validar ordenamiento ascendente en followers")
    void test401() {

        String order = "name_asc";

        List<UserDto> expected = new ArrayList<>(List.of(new UserDto(users.get(1)), new UserDto(users.get(2))));

        expected.sort(Comparator.comparing(UserDto::getUserName));

        testFollowers(order,expected);

    }

    @Test
    @DisplayName("Validar ordenamiento descendente en followers")
    void test402() {

        String order = "name_desc";

        List<UserDto> expected = new ArrayList<>(List.of(new UserDto(users.get(1)), new UserDto(users.get(2))));

        expected.sort(Comparator.comparing(UserDto::getUserName).reversed());

        testFollowers(order,expected);

    }


    void testFollowers (String  order,List<UserDto> expected) {


        users.get(0).addFollower(new UserDto(users.get(1)));
        users.get(0).addFollower(new UserDto(users.get(2)));

        Mockito.when(repository.findById(users.get(0).getUserId())).thenReturn(Optional.of(users.get(0)));
        FollowersDto current = service.followers(users.get(0).getUserId(),order);

        Assertions.assertAll(
                () -> Assertions.assertEquals(users.get(0).getUserId(),current.getUserId()),
                () -> Assertions.assertEquals(users.get(0).getUserName(),current.getUserName()),
                () -> Assertions.assertEquals(expected.get(0).getUserName(),current.getFollowers().get(0).getUserName()),
                () -> Assertions.assertEquals(expected.get(1).getUserName(),current.getFollowers().get(1).getUserName())
        );

    }

    @Test
    @DisplayName("Validar ordenamiento ascendente en followed")
    void test403() {

        String order = "name_asc";

        List<UserDto> expected = new ArrayList<>(List.of(new UserDto(users.get(1)), new UserDto(users.get(2))));

        expected.sort(Comparator.comparing(UserDto::getUserName));

        testFollowed(order,expected);

    }

    @Test
    @DisplayName("Validar ordenamiento descendente en followed")
    void test404() {

        String order = "name_desc";

        List<UserDto> expected = new ArrayList<>(List.of(new UserDto(users.get(1)), new UserDto(users.get(2))));

        expected.sort(Comparator.comparing(UserDto::getUserName).reversed());

        testFollowed(order,expected);

    }



    void testFollowed(String  order, List<UserDto> expected) {

        users.get(0).addFollowed(new UserDto(users.get(1)));
        users.get(0).addFollowed(new UserDto(users.get(2)));

        Mockito.when(repository.findById(users.get(0).getUserId())).thenReturn(Optional.of(users.get(0)));


        FollowedDto current = service.followed(users.get(0).getUserId(),order);

        Assertions.assertAll(
                () -> Assertions.assertEquals(users.get(0).getUserId(),current.getUserId()),
                () -> Assertions.assertEquals(users.get(0).getUserName(),current.getUserName()),
                () -> Assertions.assertEquals(expected.get(0).getUserName(),current.getFollowed().get(0).getUserName()),
                () -> Assertions.assertEquals(expected.get(1).getUserName(),current.getFollowed().get(1).getUserName())
        );


    }


    @Test
    @DisplayName("Validar la cantidad de seguidores de un usuario")
    void test701() {

        users.get(0).addFollower(new UserDto(users.get(1)));
        users.get(0).addFollower(new UserDto(users.get(2)));

        Mockito.when(repository.findById(users.get(0).getUserId())).thenReturn(Optional.of(users.get(0)));


        FollowersDto current = service.followersCount(users.get(0).getUserId());

        Mockito.verify(repository,Mockito.atLeastOnce()).findById(Mockito.any(Integer.class));
        Assertions.assertAll(
                () -> Assertions.assertEquals(2,current.getFollowersCount()),
                () -> Assertions.assertEquals(users.get(0).getUserId(),current.getUserId())
        );

    }


}
