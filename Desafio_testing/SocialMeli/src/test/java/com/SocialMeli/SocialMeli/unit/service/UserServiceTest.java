package com.SocialMeli.SocialMeli.unit.service;

import com.SocialMeli.SocialMeli.dto.MessageDTOResponse;
import com.SocialMeli.SocialMeli.dto.PostsByUserDTOResponse;
import com.SocialMeli.SocialMeli.dto.SellerCountFollowersDTOResponse;
import com.SocialMeli.SocialMeli.dto.SellerFollowersDTOResponse;
import com.SocialMeli.SocialMeli.entity.Buyer;
import com.SocialMeli.SocialMeli.entity.Seller;
import com.SocialMeli.SocialMeli.entity.User;
import com.SocialMeli.SocialMeli.exception.BadRequestException;
import com.SocialMeli.SocialMeli.exception.NotFoundException;
import com.SocialMeli.SocialMeli.repository.IUserRepository;
import com.SocialMeli.SocialMeli.repository.UserRepository;
import com.SocialMeli.SocialMeli.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    IUserRepository userRepository = new UserRepository();

    @InjectMocks
    UserService userService;

    @Test
    void getSellerFollowersCountSuccess(){
        //Arrange
        int sellerId = 3;

        Seller seller = new Seller();
        seller.setFollowers(new HashMap<>());
        seller.setId(3);
        seller.setFollowed(new HashMap<>());
        seller.setUserName("Seller");

        when(userRepository.getUser(sellerId)).thenReturn(seller);

        //Act
        SellerCountFollowersDTOResponse sellerCountFollowersDTOResponse = userService.getSellerFollowersCount(sellerId);

        //Assert
        Assertions.assertAll(
                ()->Assertions.assertNotNull(sellerCountFollowersDTOResponse),
                ()->Assertions.assertEquals(0, sellerCountFollowersDTOResponse.getFollowers_count())
        );
    }

    @Test
    void getSellerFollowersCountThenSellerNotFoundException(){
        //Arrange
        int sellerId = 99;

        //Act & Assert
        Assertions.assertThrows(
                NotFoundException.class, ()->userService.getSellerFollowersCount(sellerId)
        );
    }

    @Test
    void followSellerSuccess(){
        //Arrange
        int sellerId = 3;
        int userId = 1;

        when(userRepository.getUser(3)).thenReturn(new Seller());
        when(userRepository.getUser(1)).thenReturn(new Buyer());

        //Act
        MessageDTOResponse messageDTOResponse = userService.followSeller(userId, sellerId);

        //Assert
        Assertions.assertEquals("Todo Ok", messageDTOResponse.getMessage());
    }

    @Test
    void followSellerThenSellerNotFoundException(){
        //Arrange
        int sellerId = 99;
        int userId = 1;

        //Act & Assert
        Assertions.assertThrows(
                BadRequestException.class, ()->userService.followSeller(userId, sellerId)
        );
    }

    @Test
    void followSellerThenUserNotFoundException(){
        //Arrange
        int sellerId = 99;
        int userId = 1;

        when(userRepository.getUser(99)).thenReturn(new Seller());

        //Act & Assert
        Assertions.assertThrows(
                BadRequestException.class, ()->userService.followSeller(userId, sellerId)
        );
    }

    @Test
    void getFollowersAndOrderNameAscSuccess(){
        //Arrange
        Seller seller = new Seller();
        seller.setId(3);
        seller.setFollowed(new HashMap<>());

        Buyer buyer1 = new Buyer();
        buyer1.setId(1);
        buyer1.setUserName("User 1");
        buyer1.setFollowed(new HashMap<>());
        buyer1.getFollowed().put(3, seller);
        Buyer buyer2 = new Buyer();
        buyer2.setId(2);
        buyer2.setUserName("User 2");
        buyer2.setFollowed(new HashMap<>());
        buyer2.getFollowed().put(3, seller);

        Map<Integer, User> followers = new HashMap<>();
        followers.put(1, buyer1);
        followers.put(2, buyer2);

        seller.setFollowers(followers);

        String order = "name_asc";

        when(userRepository.getUser(3)).thenReturn(seller);
        when(userRepository.getFollowers(3)).thenReturn(followers);

        //Act
        SellerFollowersDTOResponse sellerFollowersDTOResponse = userService.getFollowers(3, order);

        //Assert
        Assertions.assertTrue(
                sellerFollowersDTOResponse.getFollowers().get(0).getUser_name().compareTo(
                        sellerFollowersDTOResponse.getFollowers().get(1).getUser_name()
                ) <= 0
        );
    }

    @Test
    void getFollowersAndOrderNameDescSuccess(){
        //Arrange
        Seller seller = new Seller();
        seller.setId(3);
        seller.setFollowed(new HashMap<>());

        Buyer buyer1 = new Buyer();
        buyer1.setId(1);
        buyer1.setUserName("User 1");
        buyer1.setFollowed(new HashMap<>());
        buyer1.getFollowed().put(3, seller);
        Buyer buyer2 = new Buyer();
        buyer2.setId(2);
        buyer2.setUserName("User 2");
        buyer2.setFollowed(new HashMap<>());
        buyer2.getFollowed().put(3, seller);

        Map<Integer, User> followers = new HashMap<>();
        followers.put(1, buyer1);
        followers.put(2, buyer2);

        seller.setFollowers(followers);

        String order = "name_desc";

        when(userRepository.getUser(3)).thenReturn(seller);
        when(userRepository.getFollowers(3)).thenReturn(followers);

        //Act
        SellerFollowersDTOResponse sellerFollowersDTOResponse = userService.getFollowers(3, order);

        //Assert
        Assertions.assertTrue(
                sellerFollowersDTOResponse.getFollowers().get(0).getUser_name().compareTo(
                        sellerFollowersDTOResponse.getFollowers().get(1).getUser_name()
                ) >= 0
        );
    }

    @Test
    void getFollowersAndOrderFormatException(){
        //Arrange
        int sellerId = 3;
        String order = "NULL";

        when(userRepository.getUser(sellerId)).thenReturn(new Seller());
        when(userRepository.getFollowers(sellerId)).thenReturn(new HashMap<>());

        //Act & Assert
        Assertions.assertThrows(
                BadRequestException.class, ()->userService.getFollowers(sellerId, order)
        );
    }
}
