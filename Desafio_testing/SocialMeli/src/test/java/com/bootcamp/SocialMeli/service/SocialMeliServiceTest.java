package com.bootcamp.SocialMeli.service;

import com.bootcamp.SocialMeli.dto.FollowedListDTO;
import com.bootcamp.SocialMeli.dto.FollowerListDTO;
import com.bootcamp.SocialMeli.dto.UserDTO;
import com.bootcamp.SocialMeli.entity.Buyer;
import com.bootcamp.SocialMeli.entity.Post;
import com.bootcamp.SocialMeli.entity.Seller;
import com.bootcamp.SocialMeli.exception.BadRequestException;
import com.bootcamp.SocialMeli.exception.ExceptionSellerNotExist;
import com.bootcamp.SocialMeli.repository.UserRepositoryImpl;
import org.junit.jupiter.api.*;
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

    @Nested
    @DisplayName("T-0003")
    class T0003{
        @DisplayName("T-0003 el tipo de ordenamiento alfabético ascendente existe US-0008")
        @Test
        public void orderAscByNameFollowersExistTest(){
            int userId = 4;
            String order = "name_asc";

            user4.getFollowers().add(user1);
            user4.getFollowers().add(user2);

            when(mockUserRepository.findSellerById(userId)).thenReturn(user4);

            //Act
            assertDoesNotThrow(
                    () -> userService.followers(userId, order));

            //Assert
            verify(mockUserRepository, atLeastOnce()).findSellerById(userId);
            verify(mockUserRepository, never()).findBuyerById(userId);

        }

        @DisplayName("T-0003 el tipo de ordenamiento alfabético descendente existe US-0008")
        @Test
        public void orderDescByNameFollowersExistTest(){
            int userId = 4;
            String order = "name_desc";

            user4.getFollowers().add(user1);
            user4.getFollowers().add(user2);

            when(mockUserRepository.findSellerById(userId)).thenReturn(user4);

            //Act
            assertDoesNotThrow(
                    () -> userService.followers(userId, order));
            //Assert
            verify(mockUserRepository, atLeastOnce()).findSellerById(userId);
            verify(mockUserRepository, never()).findBuyerById(userId);
        }

        @Disabled("No se implementó en el proyecto inicial de SocialMeli US-0008")
        @DisplayName("T-0003 el tipo de ordenamiento alfabético No existe US-0008 ")
        @Test
        public void orderByNameFollowersNotExistTest(){
            int userId = 4;

            user4.getFollowers().add(user1);
            user4.getFollowers().add(user2);

            when(mockUserRepository.findSellerById(userId)).thenReturn(user4);

            //Act
            assertThrows(BadRequestException.class,
                    ()->userService.followers(userId,null));

            //Assert

            verify(mockUserRepository, atLeastOnce()).findSellerById(userId);

        }

    }

    @Nested
    @DisplayName("T-0004")
    class T0004 {
        @DisplayName("T-0004 ordenamiento ListFollowers por defecto ascendente por nombre")
        @Test
        void orderDefaultListFollowersTest() {
            int userId = 4;

            user4.getFollowers().add(user1); //Leon Comprador -> Sigue a Pedro Vendedor
            user4.getFollowers().add(user2); //Juan Comprador -> Sigue a Pedro Vendedor

            ArrayList<UserDTO> ListFollowers = new ArrayList<>();
            ListFollowers.add(new UserDTO(user2.getUserId(), user2.getUserName()));
            ListFollowers.add(new UserDTO(user1.getUserId(), user1.getUserName()));
            FollowerListDTO expected = new FollowerListDTO();
            expected.setFollowers(ListFollowers);
            expected.setUser_id(userId);
            expected.setUser_name(user4.getUserName());

            when(mockUserRepository.findSellerById(userId)).thenReturn(user4);

            //Act
            FollowerListDTO actual = userService.followers(userId, null);

            //Assert
            assertEquals(expected,actual);
            verify(mockUserRepository, atLeastOnce()).findSellerById(userId);
            verify(mockUserRepository, never()).findBuyerById(userId);
        }
        @DisplayName("T-0004 ordenamiento ListFollowers descendente por nombre")
        @Test
        void orderDescListFollowersTest() {
            int userId = 4;
            String order = "name_desc";

            user4.getFollowers().add(user1); //Leon Comprador -> Sigue a Pedro Vendedor
            user4.getFollowers().add(user2); //Juan Comprador -> Sigue a Pedro Vendedor

            ArrayList<UserDTO> ListFollowers = new ArrayList<>();

            ListFollowers.add(new UserDTO(user1.getUserId(), user1.getUserName()));
            ListFollowers.add(new UserDTO(user2.getUserId(), user2.getUserName()));

            FollowerListDTO expected = new FollowerListDTO();
            expected.setFollowers(ListFollowers);
            expected.setUser_id(userId);
            expected.setUser_name(user4.getUserName());

            when(mockUserRepository.findSellerById(userId)).thenReturn(user4);

            //Act
            FollowerListDTO actual = userService.followers(userId, order);

            //Assert
            assertEquals(expected,actual);
            verify(mockUserRepository, atLeastOnce()).findSellerById(userId);
            verify(mockUserRepository, never()).findBuyerById(userId);
        }

        @DisplayName("T-0004 ordenamiento ListFollowers ascendente por nombre")
        @Test
        void orderAscListFollowersTest() {
            int userId = 4;
            String order = "name_asc";

            user4.getFollowers().add(user1); //Leon Comprador -> Sigue a Pedro Vendedor
            user4.getFollowers().add(user2); //Juan Comprador -> Sigue a Pedro Vendedor

            ArrayList<UserDTO> ListFollowers = new ArrayList<>();

            ListFollowers.add(new UserDTO(user2.getUserId(), user2.getUserName()));
            ListFollowers.add(new UserDTO(user1.getUserId(), user1.getUserName()));

            FollowerListDTO expected = new FollowerListDTO();
            expected.setFollowers(ListFollowers);
            expected.setUser_id(userId);
            expected.setUser_name(user4.getUserName());

            when(mockUserRepository.findSellerById(userId)).thenReturn(user4);

            //Act
            FollowerListDTO actual = userService.followers(userId, order);

            //Assert
            assertEquals(expected,actual);
            verify(mockUserRepository, atLeastOnce()).findSellerById(userId);
            verify(mockUserRepository, never()).findBuyerById(userId);
        }

        @DisplayName("T-0004 ordenamiento ListFollowed por defecto ascendente por nombre ")
        @Test
        void orderDefaultListFollowedTest() {
            int userId = 1;

            user1.getFollowed().add(user3);
            user1.getFollowed().add(user4);

            ArrayList<UserDTO> ListFollowed = new ArrayList<>();

            ListFollowed.add(new UserDTO(user3.getUserId(), user3.getUserName()));
            ListFollowed.add(new UserDTO(user4.getUserId(), user4.getUserName()));

            FollowedListDTO expected = new FollowedListDTO();
            expected.setFollowed(ListFollowed);
            expected.setUser_id(userId);
            expected.setUser_name(user1.getUserName());

            when(mockUserRepository.findBuyerById(userId)).thenReturn(user1);

            //Act
            FollowedListDTO actual = userService.followed(userId, null);

            //Assert
            assertEquals(expected,actual);
            verify(mockUserRepository, atLeastOnce()).findBuyerById(userId);
            verify(mockUserRepository, never()).findSellerById(userId);

        }

        @DisplayName("T-0004 ordenamiento ListFollowed  ascendente por nombre ")
        @Test
        void orderAscListFollowedTest() {
            int userId = 1;
            String order = "name_asc";

            user1.getFollowed().add(user3);
            user1.getFollowed().add(user4);

            ArrayList<UserDTO> ListFollowed = new ArrayList<>();

            ListFollowed.add(new UserDTO(user3.getUserId(), user3.getUserName()));
            ListFollowed.add(new UserDTO(user4.getUserId(), user4.getUserName()));

            FollowedListDTO expected = new FollowedListDTO();
            expected.setFollowed(ListFollowed);
            expected.setUser_id(userId);
            expected.setUser_name(user1.getUserName());

            when(mockUserRepository.findBuyerById(userId)).thenReturn(user1);

            //Act
            FollowedListDTO actual = userService.followed(userId, order);

            //Assert
            assertEquals(expected,actual);
            verify(mockUserRepository, atLeastOnce()).findBuyerById(userId);
            verify(mockUserRepository, never()).findSellerById(userId);
        }

        @DisplayName("T-0004 ordenamiento ListFollowed  descendente por nombre ")
        @Test
        void orderDescListFollowedTest() {
            int userId = 1;
            String order = "name_desc";

            user1.getFollowed().add(user3);
            user1.getFollowed().add(user4);

            ArrayList<UserDTO> ListFollowed = new ArrayList<>();

            ListFollowed.add(new UserDTO(user4.getUserId(), user4.getUserName()));
            ListFollowed.add(new UserDTO(user3.getUserId(), user3.getUserName()));

            FollowedListDTO expected = new FollowedListDTO();
            expected.setFollowed(ListFollowed);
            expected.setUser_id(userId);
            expected.setUser_name(user1.getUserName());

            when(mockUserRepository.findBuyerById(userId)).thenReturn(user1);

            //Act
            FollowedListDTO actual = userService.followed(userId, order);

            //Assert
            assertEquals(expected,actual);
            //assertArrayEquals(expected.getFollowed().toArray(),actual.getFollowed().toArray());
            verify(mockUserRepository, atLeastOnce()).findBuyerById(userId);
            verify(mockUserRepository, never()).findSellerById(userId);
        }
    }

    @Nested
    @DisplayName("T-0005")
    class T0005{
        @DisplayName("T-0005 el tipo de ordenamiento alfabético ascendente existe US-0009")
        @Test
        public void orderAscByNameFollowedExistTest(){
            int userId = 1;
            String order = "name_asc";

            user1.getFollowed().add(user3);
            user1.getFollowed().add(user4);

            when(mockUserRepository.findBuyerById(userId)).thenReturn(user1);

            //Act and Assert
            assertDoesNotThrow(
                    () -> userService.followed(userId, order));
            verify(mockUserRepository, atLeastOnce()).findBuyerById(userId);
            verify(mockUserRepository, never()).findSellerById(userId);

        }

        @DisplayName("T-0005 el tipo de ordenamiento alfabético descendente existe US-0009")
        @Test
        public void orderDescByNameFollowedExistTest(){
            int userId = 1;
            String order = "name_desc";

            user1.getFollowed().add(user3);
            user1.getFollowed().add(user4);

            when(mockUserRepository.findBuyerById(userId)).thenReturn(user1);

            //Act and Assert
            assertDoesNotThrow(
                    () -> userService.followed(userId, order));

            verify(mockUserRepository, atLeastOnce()).findBuyerById(userId);
            verify(mockUserRepository, never()).findSellerById(userId);

        }

        @Disabled("No se implementó en el proyecto inicial de SocialMeli US-0009")
        @DisplayName("T-0005 el tipo de ordenamiento alfabético No existe US-0009 ")
        @Test
        public void orderByNameFollowedNotExistTest(){
            int userId = 1;

            user1.getFollowed().add(user3);
            user1.getFollowed().add(user4);

            when(mockUserRepository.findBuyerById(userId)).thenReturn(user1);

            //Act and Assert
            assertThrows(BadRequestException.class,
                    ()->userService.followed(userId,null));
            verify(mockUserRepository, atLeastOnce()).findBuyerById(userId);
        }

    }



}

