package com.SocialMeli.SocialMeli.unit.service;

import com.SocialMeli.SocialMeli.dto.SellerCountFollowersDTOResponse;
import com.SocialMeli.SocialMeli.entity.Seller;
import com.SocialMeli.SocialMeli.exception.NotFoundException;
import com.SocialMeli.SocialMeli.repository.IUserRepository;
import com.SocialMeli.SocialMeli.repository.UserRepository;
import com.SocialMeli.SocialMeli.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;

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
}
