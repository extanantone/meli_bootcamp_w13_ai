package com.example.socialmeli.unit;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import com.example.socialmeli.exceptions.UserNotFoundException;
import com.example.socialmeli.model.User;
import com.example.socialmeli.repositories.UsuarioRepository;
import com.example.socialmeli.services.SocialMeliService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

@ExtendWith(MockitoExtension.class)
public class SocialMeliServiceTest {

  List<User> users;
  User user1, user2,user3, user4;

    @Mock
    private UsuarioRepository mockUserRepository;

    @InjectMocks
    private SocialMeliService service;

    @BeforeEach
    public void setUp(){
        user1 = new User(1,"Leon Comprador", new ArrayList<>());
        user2 = new User(2,"Juan Comprador", new ArrayList<>());
        user3 = new User(3,"Manuel Vendedor", new ArrayList<>());
        user4 = new User(4,"Pedro Vendedor", new ArrayList<>());
        users = Arrays.asList(user1,user2,user3,user4);
    }

    @Nested
    @DisplayName("T-0001 Usuario a seguir")
    class T0001 {
        @DisplayName("T-0001 Usuario a seguir existe")
        @Test
        public void userToFollowExistTest()  {
            //Arrange
            Integer userId = 1;
            Integer userToFollowId = 3;

            when(mockUserRepository.findById(userId)).thenReturn
                    (users.stream()
                            .filter(us -> us.getUserId().equals(userId))
                            .findFirst());
            when(mockUserRepository.findById(userToFollowId)).thenReturn
                    (users.stream()
                            .filter(us -> us.getUserId().equals(userToFollowId))
                            .findFirst());
            //Act
            assertDoesNotThrow(()-> service.follow(userId, userToFollowId)); ;
            //Assert
            assertEquals(1, user3.getFollowersId().size());
            assertTrue(user3.getFollowersId().contains(1));
            verify(mockUserRepository, times(1)).findById(userId);
            verify(mockUserRepository, times(2)).findById(userToFollowId);
        }

        @DisplayName("T-0001 Usuario a seguir No existe")
        @Test
        public void userToFollowNotExistTest() {
            //Arrange
            Integer userId = 1;
            Integer userToFollowId = 5;

            when(mockUserRepository.findById(userId)).thenReturn
                    (users.stream()
                            .filter(us -> us.getUserId().equals(userId))
                            .findFirst());
            when(mockUserRepository.findById(userToFollowId)).thenReturn
                    (users.stream()
                            .filter(us -> us.getUserId().equals(userToFollowId))
                            .findFirst());
            //Assert && Act
            assertThrows(UserNotFoundException.class,
                    () -> service.follow(userId, userToFollowId), "Usuario no Existe");

        }
    }
    @Nested
    @DisplayName("T-0001 Usuario a dejar de seguir")
    class T0002 {
        @DisplayName("T-0002 Usuario a dejar de seguir  existe")
        @Test
        public void userToUnFollowExistTest()  {
            //Arrange
            Integer userId = 1;
            Integer userToUnFollowId = 3;
            user3.getFollowersId().add(userId);

            when(mockUserRepository.findById(userToUnFollowId)).thenReturn
                    (users.stream()
                            .filter(us -> us.getUserId().equals(userToUnFollowId))
                            .findFirst());
            //Act
            assertDoesNotThrow( ()->service.unfollow(userId, userToUnFollowId));

            //Assert
            assertEquals(0, user3.getFollowersId().size());
            assertFalse(user3.getFollowersId().contains(1));
            verify(mockUserRepository, never()).findById(userId);
            verify(mockUserRepository, times(2)).findById(userToUnFollowId);
        }
        @DisplayName("T-0002 Usuario a dejar de seguir No existe")
        @Test
        public void userToUnFollowNotExistTest() {
            //Arrange
            Integer userId = 1;
            Integer userToFollowId = 5;

            when(mockUserRepository.findById(userToFollowId)).thenReturn
                    (users.stream()
                            .filter(us -> us.getUserId().equals(userToFollowId))
                            .findFirst());
            //Assert && Act
            assertThrows(UserNotFoundException.class,
                    () -> service.unfollow(userId, userToFollowId), "Usuario no Existe");

        }
    }
/*
Verificar que el tipo de ordenamiento alfabético exista (US-0008)
 */
    @Test
    public void test(){

    }



}
