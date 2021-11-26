package com.mercadolibre.socialmeli.service;

import com.mercadolibre.socialmeli.dto.UserDTO;
import com.mercadolibre.socialmeli.exception.NotFoundException;
import com.mercadolibre.socialmeli.model.Follow;
import com.mercadolibre.socialmeli.model.User;
import com.mercadolibre.socialmeli.repository.SocialRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class SocialServiceImplTest {

    @Mock
    SocialRepositoryImpl socialRepository;

    @InjectMocks
    SocialServiceImpl socialService;

    private static String EXPECT_EXCEPTONMESSAGE = "No se encontró el usuario";
    @Test
    void userByIdNotFound() {
        //Arrange
        UserDTO user = new UserDTO(1,"Maga");
        //Act
        Mockito.when(socialRepository.findUserById(user.getId())).thenReturn(null);
        Exception exception = assertThrows(NotFoundException.class,
                () -> socialService.getUserById(user.getId()));

        String currentMessage = exception.getMessage();

        Mockito.verify(socialRepository,Mockito.atLeastOnce()).findUserById(user.getId());
        Assertions.assertEquals(EXPECT_EXCEPTONMESSAGE,currentMessage);
    }

    @Test
    public void findUserById(){
        //Arrange
        User user = new User(1,"Maggy");
        UserDTO expect = new UserDTO();
        expect.setId(user.getId());
        expect.setName(user.getName());
        //Act
        Mockito.when(socialRepository.findUserById(1)).thenReturn(user);
        UserDTO currentUser = socialService.getUserById(1);
        //Assert
        Assertions.assertEquals(expect,currentUser);
    }

    @Test
    void unfollowUserByIdWithNotFound() {
        //Arrange
        User user = new User(1,"Maga");
        User userUnfollow = new User(6,"Pepe");

        //Act
        Mockito.when(socialRepository.findUserById(user.getId())).thenReturn(user);
        Mockito.when(socialRepository.findUserById(userUnfollow.getId())).thenReturn(null);
        /* when(socialRepository.findUserById(user.getId())).thenReturn(
                firstReturnValue, secondReturnValue, thirdReturnValue
        ); Esto me sirve si quiero ejecutar una llamada y devolver diferentes cosas en cada una de sus llamadas
        */
       // Mockito.when(socialRepository.unFollowUser(user.getId(),userUnfollow.getId())).thenReturn(true);
        Exception exception = Assertions.assertThrows(NotFoundException.class,
                ()->socialService.unfollowUser(user.getId(),userUnfollow.getId()));
        //Assert
        Mockito.verify(socialRepository,Mockito.times(1))
                .findUserById(user.getId());
        Mockito.verify(socialRepository,Mockito.times(1))
                .findUserById(userUnfollow.getId());
       // Mockito.verify(socialRepository,Mockito.times(1)).unFollowUser(user.getId(),userUnfollow.getId());

        String currentMessage = exception.getMessage();
        Assertions.assertEquals(EXPECT_EXCEPTONMESSAGE,currentMessage);

    }

    @Test
    void unfollowUserById() {
        //Arrange
        User user = new User(1,"Maga");
        User userUnfollow = new User(6,"Pepe");

        //Act
        Mockito.when(socialRepository.findUserById(user.getId())).thenReturn(user);
        Mockito.when(socialRepository.findUserById(userUnfollow.getId())).thenReturn(userUnfollow);
        Mockito.when(socialRepository.unFollowUser(user.getId(),userUnfollow.getId())).thenReturn(true);
        boolean response = socialService.unfollowUser(user.getId(),userUnfollow.getId());
        //Assert
        Mockito.verify(socialRepository,Mockito.times(2))
                .findUserById(Mockito.anyInt());
         Mockito.verify(socialRepository,Mockito.times(1))
                 .unFollowUser(user.getId(),userUnfollow.getId());

        Assertions.assertTrue(response);
    }

    @Test
    void followToUser() {
    }

    @Test
    void followersCount() {
    }

    @Test
    void allFollowers() {
    }

    @Test
    void allFollowed() {
    }

    @Test
    void addPublication() {
    }

    @Test
    void latestPublications() {
    }


    @Test
    void orderingUsersFollowers() {
    }

    @Test
    void orderingUsersFolloweds() {
    }

    @Test
    void sortPublicationsSellers() {
    }
}