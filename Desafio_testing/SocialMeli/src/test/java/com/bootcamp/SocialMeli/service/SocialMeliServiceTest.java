package com.bootcamp.SocialMeli.service;

import com.bootcamp.SocialMeli.entity.Buyer;
import com.bootcamp.SocialMeli.entity.Post;
import com.bootcamp.SocialMeli.entity.Seller;
import com.bootcamp.SocialMeli.exception.ExceptionSellerNotExist;
import com.bootcamp.SocialMeli.repository.UserRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SocialMeliServiceTest {

    private Buyer user1, user2;
    private Seller user3, user4;
    private List<Post> posts;

    @Mock
    private UserRepositoryImpl mockUserRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    public void setUp() {
        this.user1 = new Buyer(1, "Leon Comprador");
        this.user2 = new Buyer(2, "Juan Comprador");
        this.user3 = new Seller(3, "Manuel Vendedor");
        this.user4 = new Seller(4, "Pedro Vendedor");
        this.posts = new ArrayList<>();

    }

    @Nested
    @DisplayName("T-0001")
    class T0001 {
        @DisplayName("T-0001 Usuario a seguir existe")
        @Test
        public void userToFollowExistTest() {
            //Arrange
            int userId = 1;
            int userToFollowId = 3;
            user1.getFollowed().add(user3);
            user3.getFollowers().add(user1);

            when(mockUserRepository.findBuyerById(userId)).thenReturn(user1);
            when(mockUserRepository.findSellerById(userToFollowId)).thenReturn(user3);
            when(mockUserRepository.follow(user1,user3)).thenReturn(true);

            //Act
            assertDoesNotThrow(() -> userService.follow(userId, userToFollowId));
            //Assert
            assertEquals(1, user1.getFollowed().size());
            assertEquals(1, user3.getFollowers().size());
            assertTrue(user1.getFollowed().contains(user3));
            assertTrue(user3.getFollowers().contains(user1));
            verify(mockUserRepository, atLeastOnce()).findBuyerById(userId);
            verify(mockUserRepository, atLeastOnce()).findSellerById(userToFollowId);
            verify(mockUserRepository, (times(1))).follow(user1,user3);
        }

        @DisplayName("T-0001 Usuario a seguir No existe")
        @Test
        public void userToFollowNotExistTest() {
            //Arrange
            int userId = 1;
            int userToFollowId = 5;

            //Act
            when(mockUserRepository.findBuyerById(userId)).thenReturn(user1);
            when(mockUserRepository.findSellerById(userToFollowId)).thenThrow(ExceptionSellerNotExist.class);

            //Assert
            assertThrows(ExceptionSellerNotExist.class,
                    ()-> userService.follow(userId,userToFollowId), "Usuario no existe");
            verify(mockUserRepository, atLeastOnce()).findBuyerById(userId);
            verify(mockUserRepository, atLeastOnce()).findSellerById(userToFollowId);
        }
    }

    @Nested
    @DisplayName("T-0002")
    class T0002 {
        @DisplayName("T-0002 Usuario a dejar de seguir existe")
        @Test
        public void userToUnFollowExistTest() {
            //Arrange
            int userId = 1;
            int userToUnFollowId = 3;
            user1.getFollowed().add(user3);
            user3.getFollowers().add(user1);

            when(mockUserRepository.findBuyerById(userId)).thenReturn(user1);
            when(mockUserRepository.findSellerById(userToUnFollowId)).thenReturn(user3);
            when(mockUserRepository.unFollow(user1, user3)).thenReturn(true);
            //Act
            assertDoesNotThrow(() -> userService.unFollow(userId, userToUnFollowId));
            //Assert

            verify(mockUserRepository, atLeastOnce()).findBuyerById(userId);
            verify(mockUserRepository, atLeastOnce()).findSellerById(userToUnFollowId);
            verify(mockUserRepository, (times(1))).unFollow(user1, user3);

        }

        @DisplayName("T-0002 Usuario a dejar de seguir no existe")
        @Test
        public void userToUnFollowNotExistTest() {
            //Arrange
            int userId = 1;
            int userToFollowId = 5;

            //Act
            when(mockUserRepository.findBuyerById(userId)).thenReturn(user1);
            when(mockUserRepository.findSellerById(userToFollowId)).thenThrow(ExceptionSellerNotExist.class);

            //Assert
            assertThrows(ExceptionSellerNotExist.class,
                    () -> userService.unFollow(userId, userToFollowId), "Usuario no existe");

            verify(mockUserRepository, atLeastOnce()).findBuyerById(userId);
            verify(mockUserRepository, atLeastOnce()).findSellerById(userToFollowId);
        }
    }



}

