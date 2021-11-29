package com.example.SocialMeli.services;

import com.example.SocialMeli.dto.UserDTO;
import com.example.SocialMeli.entities.User;
import com.example.SocialMeli.exception.UserNotFoundException;
import com.example.SocialMeli.repository.UserRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserServiceImpl service;

    User u = new User(1L, "ftagliero");
    User u2 = new User(2L, "juangomez");


    //T-0001
    /*
    Verificar que el usuario a seguir exista.
     */
    @Test
    void testUserIdToFollowExist() {
        // Mocks
        when(userRepository.getById(1)).thenReturn(u);
        when(userRepository.getById(2)).thenReturn(u2);

        // act y assert
        Assertions.assertDoesNotThrow(() -> service.saveFollow(2,1));

        verify(userRepository, atLeastOnce()).getById(1);
    }

    //T-0001
    /*
    El usuario no existe y se lanza la exception UserNotFoundException.
     */
    @Test
    void testUserIdToFollowNotExist() {
        //Mocks
        when(userRepository.getById(1)).thenReturn(u);
        when(userRepository.getById(12)).thenReturn(null);
        Assertions.assertThrows(UserNotFoundException.class, () -> service.saveFollow(1,12));
        verify(userRepository, atLeastOnce()).getById(1);
    }

    @Test
    void testUserIdToUnfollowExist() {
        //Mocks
        u.getSeguidores().add(2L);
        u2.getSeguidos().add(1L);
        when(userRepository.getById(1)).thenReturn(u);
        when(userRepository.getById(2)).thenReturn(u2);

        Assertions.assertTrue(service.unfollow(2,1));
    }

    @Test
    void testUserIdToUnfollowDoesntExist() {
        when(userRepository.getById(1)).thenReturn(u);
        when(userRepository.getById(12)).thenReturn(null);
        Assertions.assertThrows(UserNotFoundException.class, () -> service.unfollow(1,12));
    }

    //T-0004
    /*
    Verificar que el tipo de ordenamiento alfabético ascendente funcione correctamente.
     */
    @Test
    void testWhithAlphabeticOrderAsc() {
        List<User> followers = new ArrayList<>(){{
            add(new User(1L,"Franco"));
            add(new User(2L, "Nahuel"));
            add(new User(3L, "Agustin"));
        }};
        List<UserDTO> expected = new ArrayList<>() {{
            add(new UserDTO(3, "Agustin"));
            add(new UserDTO(1, "Franco"));
            add(new UserDTO(2, "Nahuel"));
        }};
        when(userRepository.getFollowers(1)).thenReturn(followers);
        when(userRepository.getById(1)).thenReturn(u);
        Assertions.assertEquals(expected, service.listFollowers(1,"name_asc").getFollowers());
    }

    //T-0004
    /*
    Verificar que el tipo de ordenamiento alfabetico descendiente funcione correctamente.
     */
    @Test
    void testWithAlphabetOrderDesc() {
        List<User> followers = new ArrayList<>(){{
            add(new User(1L,"Franco"));
            add(new User(2L, "Nahuel"));
            add(new User(3L, "Agustin"));
        }};
        List<UserDTO> expected = new ArrayList<>() {{
            add(new UserDTO(2, "Nahuel"));
            add(new UserDTO(1, "Franco"));
            add(new UserDTO(3, "Agustin"));
        }};
        when(userRepository.getFollowers(1)).thenReturn(followers);
        when(userRepository.getById(1)).thenReturn(u);
        Assertions.assertEquals(expected, service.listFollowers(1,"name_desc").getFollowers());
    }


    //T-0007
    /*
    Verificar la cantidad de seguidores de un usuario es correcta.
     */
    @Test
    void testCountOfFollowers() {
        u.getSeguidores().addAll(List.of(1L,2L,3L));
        when(userRepository.getById(1)).thenReturn(u);
        Assertions.assertEquals(3, service.countFollowers(1).getFollowers_count());
    }

    //T-0007
    /*
    Verificar que cuando se quiere obtener la cantidad de followers en un usuario existente devuelva UserNotFoundException.
     */
    @Test
    void testCountOfFollowersWithUserThatNotExist() {
        when(userRepository.getById(5)).thenReturn(null);
        Assertions.assertThrows(UserNotFoundException.class, () -> service.countFollowers(5));
    }

}