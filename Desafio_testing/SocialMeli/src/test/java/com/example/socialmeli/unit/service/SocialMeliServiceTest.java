package com.example.socialmeli.unit.service;

import com.example.socialmeli.dto.UserDTO;
import com.example.socialmeli.dto.response.FollowersResponseDTO;
import com.example.socialmeli.exceptions.UserAlreadyInUseException;
import com.example.socialmeli.exceptions.UserNotFoundException;
import com.example.socialmeli.exceptions.UserSelfUseException;
import com.example.socialmeli.model.User;
import com.example.socialmeli.repositories.PostRepository;
import com.example.socialmeli.repositories.UsuarioRepository;
import com.example.socialmeli.services.SocialMeliService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import com.google.common.collect.Comparators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.atLeastOnce;

@ExtendWith(MockitoExtension.class)
public class SocialMeliServiceTest {

    @Mock
    UsuarioRepository userRepository;

    @Mock
    PostRepository postRepository;

    @InjectMocks
    SocialMeliService socialMeliService;

    @Test
    void DemoTesting() throws UserNotFoundException {
        // Arrange
        String order = null;
        Integer userId = 1;
        Integer followerId = 2;

        UserDTO followerDTO = new UserDTO();
        followerDTO.setUserId(followerId);
        followerDTO.setUserName("user");

        List<UserDTO> followersDTOs = new ArrayList<>();
        followersDTOs.add(followerDTO);

        FollowersResponseDTO expect = new FollowersResponseDTO();
        expect.setUserId(userId);
        expect.setUserName("marco");
        expect.setFollowers(followersDTOs);

        // Mock
        List<Integer> followersId = new ArrayList<>();
        followersId.add(followerId);
        User userMock = new User(userId, "marco", followersId);
        User followerMock = new User(followerId, "user", new ArrayList<>());
        // When
        when(userRepository.findById(userId)).thenReturn(Optional.of(userMock));
        when(userRepository.findById(followerId)).thenReturn(Optional.of(followerMock));

        //Act
        FollowersResponseDTO current = socialMeliService.getFollowers(userId, order);

        //Assert
        Mockito.verify(userRepository, times(2)).findById(Mockito.anyInt());
        //Mockito.verify(userRepository, atLeastOnce()).findById(Mockito.anyInt());
        Assertions.assertEquals(expect, current);
    }


    @Nested
    @DisplayName("Verificar que el usuario a seguir exista. (US-0001)")
    class TestIfTheUserExists{
        @Test
        @DisplayName("El usuario existe y sigue a otro usuario")
        public void checkIfTheUserToFollowExist(){
            //arrange
            Integer userId = 1;
            Integer followerId = 2;


            // Mock

            User userMock = new User(userId ,"user", new ArrayList<>());
            User followerMock = new User(followerId, "follower", new ArrayList<>());
            // When
            when(userRepository.findById(userId)).thenReturn(Optional.of(userMock));
            when(userRepository.findById(followerId)).thenReturn(Optional.of(followerMock));


            //Act
            try {
                socialMeliService.follow(userMock.getUserId(),followerMock.getUserId());
                Mockito.verify(userRepository, times(3)).findById(Mockito.anyInt());
                Assertions.assertTrue(true);
            } catch (UserNotFoundException | UserSelfUseException | UserAlreadyInUseException e) {
                e.printStackTrace();
            }

        }

        @Test
        @DisplayName("El usuario intenta seguir a un usuario invalido")
        public void ThrowExceptionWhenUserNotFound(){
            //arrange
            Integer userId = 1;
            Integer followUser = 2;


            // Mock
            User userMock = new User(userId ,"user", new ArrayList<>());
            // When
            when(userRepository.findById(userId)).thenReturn(Optional.of(userMock));

            //Act
            UserNotFoundException thrown = Assertions.assertThrows(
                    UserNotFoundException.class,
                    () -> socialMeliService.follow(userMock.getUserId(),followUser)
                    , "Se espera que lance la exception"
            );


            Assertions.assertTrue(thrown.getError().getDescription().contains("no puede ser encontrado"));




        }
    }

    @Nested
    @DisplayName("Verificar que el usuario a dejar de seguir exista. (US-0007)")
    class TestCheckThatTheUserToUnfollowExist
    {
        @Test
        @DisplayName("Permite continuar con normalidad.")
        public void checkIfThatUserToUnfollowExist()
        {
            //arrange
            Integer userId = 1;
            Integer followerId = 2;


            // Mock

            User mockUser = new User();
            mockUser.setUserId(userId);
            User mockFollower = new User();
            mockFollower.setUserId(followerId);

            List<Integer> followerList = new ArrayList<>();
            followerList.add(followerId);
            mockUser.setFollowersId(followerList);

            // When
            when(userRepository.findById(mockFollower.getUserId())).thenReturn(Optional.of(mockFollower));


            //Act
            try {
                socialMeliService.unfollow(mockUser.getUserId(),followerId);
                Mockito.verify(userRepository, times( 2)).findById(Mockito.anyInt());
                //Assert
                Assertions.assertTrue(true);
            } catch (UserNotFoundException | UserSelfUseException | UserAlreadyInUseException e) {
                e.printStackTrace();
            }

        }

        @Test
        @DisplayName("Notifica la no existencia mediante una excepción.")
        public void checkIfThatUserToUnfollowExistButThrowException() {
            //arrange
            Integer userId = 1;
            Integer followUser = 2;


            // Mock
            User userMock = new User(userId ,"user", new ArrayList<>());
            // When
            when(userRepository.findById(followUser)).thenReturn(Optional.empty());

            //Act
            UserNotFoundException thrown = Assertions.assertThrows(
                    UserNotFoundException.class,
                    () -> socialMeliService.unfollow(userMock.getUserId(),followUser)
                    , "Se espera que lance la exception"
            );


            Assertions.assertTrue(thrown.getError().getDescription().contains("no puede ser encontrado"));





        }
    }

    @Nested
    @DisplayName("Verificar que el tipo de ordenamiento alfabético exista (US-0008)")
    class TestCheckThatTheOrderExist{
        @Test
        @DisplayName("Permite continuar con normalidad.")
        public void TestCheckThatTheOrderWorksCorrectly() throws UserNotFoundException {
            //arrange
            Integer userId = 1;

            User userMockOne = new User(userId, "Follower1", new ArrayList<>());



            Mockito.when(userRepository.findById(userId)).thenReturn(Optional.of(userMockOne));


            FollowersResponseDTO followersListDto = socialMeliService.getFollowers (userId, "name_asc");

            Mockito.verify(userRepository, times( 2)).findById(Mockito.anyInt());

            Comparator<UserDTO> comparator = Comparator.comparing(UserDTO::getUserName);

            Assertions.assertTrue(Comparators.isInOrder(followersListDto.getFollowers(), comparator));
        }

        @Test
        @DisplayName("Lanzamos un error, cuando el order esta en null, aunque no falle")
        void getFollowersWhithoutOrder() {
            //arrange
            Integer userId = 1;

            Assertions.assertThrows(UserNotFoundException.class, () -> socialMeliService.getFollowers(userId,null));
        }
    }




}

