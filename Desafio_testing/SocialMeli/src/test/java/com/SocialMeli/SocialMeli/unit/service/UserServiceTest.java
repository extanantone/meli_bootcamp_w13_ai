package com.SocialMeli.SocialMeli.unit.service;

import com.SocialMeli.SocialMeli.dto.*;
import com.SocialMeli.SocialMeli.entity.Buyer;
import com.SocialMeli.SocialMeli.entity.Seller;
import com.SocialMeli.SocialMeli.entity.User;
import com.SocialMeli.SocialMeli.exception.BadRequestException;
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
import java.util.Map;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    IUserRepository userRepository = new UserRepository();

    @InjectMocks
    UserService userService;

    //----------------------T-0001------------------------
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
    //----------------------------------------------------

    //----------------------T-0002------------------------
    @Test
    void unfollowSellerSuccess(){
        //Arrange
        int userId = 1;
        int sellerId = 3;

        when(userRepository.getUser(1)).thenReturn(new Buyer());
        when(userRepository.getUser(3)).thenReturn(new Seller());

        //Act
        MessageDTOResponse messageDTOResponse = userService.unfollowSeller(userId, sellerId);

        //Assert
        Assertions.assertEquals("Todo Ok", messageDTOResponse.getMessage());
    }

    @Test
    void unfollowSellerThenSellerNotFoundException(){
        //Arrange
        int userId = 1;
        int sellerId = 3;

        //Act & Assert
        Assertions.assertThrows(
                NotFoundException.class, ()->userService.unfollowSeller(userId, sellerId)
        );
    }

    @Test
    void unfollowSellerThenUserNotFoundException(){
        //Arrange
        int userId = 1;
        int sellerId = 3;

        when(userRepository.getUser(3)).thenReturn(new Seller());

        //Act & Assert
        Assertions.assertThrows(
                NotFoundException.class, ()->userService.unfollowSeller(userId, sellerId)
        );
    }
    //---------------------------------------------------

    //----------------------T-0003-----------------------
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
    @Test
    void getFollowedAndOrderFormatException(){
        //Arrange
        int buyerId = 1;
        String order = "NULL";

        when(userRepository.getUser(buyerId)).thenReturn(new Buyer());
        when(userRepository.getFollowed(buyerId)).thenReturn(new HashMap<>());

        //Act & Assert
        Assertions.assertThrows(
                BadRequestException.class, ()->userService.getFollowed(buyerId, order)
        );
    }
    //---------------------------------------------------

    //----------------------T-0004-----------------------
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
    void getFollowedAndOrderNameAscSuccess(){
        //Arrange
        Buyer buyer = new Buyer();
        buyer.setId(1);
        buyer.setUserName("User 1");
        buyer.setFollowed(new HashMap<>());

        Seller seller1 = new Seller();
        seller1.setId(3);
        seller1.setUserName("Vendedor 1");
        seller1.setFollowed(new HashMap<>());
        Seller seller2 = new Seller();
        seller2.setId(4);
        seller2.setUserName("Vendedor 2");
        seller2.setFollowed(new HashMap<>());

        Map<Integer, User> followed = new HashMap<>();
        followed.put(3, seller1);
        followed.put(4, seller2);

        buyer.setFollowed(followed);

        String order = "name_asc";

        when(userRepository.getUser(1)).thenReturn(buyer);
        when(userRepository.getFollowed(1)).thenReturn(followed);

        //Act
        SellersFollowedDTOResponse sellersFollowedDTOResponse = userService.getFollowed(1, order);

        //Assert
        Assertions.assertTrue(
                sellersFollowedDTOResponse.getFollowed().get(0).getUser_name().compareTo(
                        sellersFollowedDTOResponse.getFollowed().get(1).getUser_name()
                ) <= 0
        );
    }

    @Test
    void getFollowedAndOrderNameDescSuccess(){
        //Arrange
        Buyer buyer = new Buyer();
        buyer.setId(1);
        buyer.setUserName("User 1");
        buyer.setFollowed(new HashMap<>());

        Seller seller1 = new Seller();
        seller1.setId(3);
        seller1.setUserName("Vendedor 1");
        seller1.setFollowed(new HashMap<>());
        Seller seller2 = new Seller();
        seller2.setId(4);
        seller2.setUserName("Vendedor 2");
        seller2.setFollowed(new HashMap<>());

        Map<Integer, User> followed = new HashMap<>();
        followed.put(3, seller1);
        followed.put(4, seller2);

        buyer.setFollowed(followed);

        String order = "name_desc";

        when(userRepository.getUser(1)).thenReturn(buyer);
        when(userRepository.getFollowed(1)).thenReturn(followed);

        //Act
        SellersFollowedDTOResponse sellersFollowedDTOResponse = userService.getFollowed(1, order);

        //Assert
        Assertions.assertTrue(
                sellersFollowedDTOResponse.getFollowed().get(0).getUser_name().compareTo(
                        sellersFollowedDTOResponse.getFollowed().get(1).getUser_name()
                ) >= 0
        );
    }
    //---------------------------------------------------


    //--------------------------T-0007-----------------------------
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
    //------------------------------------------------------------

    @Test
    void userFollowHimselfThenBadRequestException(){
        //Arrange
        int sellerId = 3;

        when(userRepository.getUser(sellerId)).thenReturn(new Seller());

        //Act & Assert
        Assertions.assertThrows(
                BadRequestException.class, ()->userService.followSeller(sellerId,sellerId)
        );
    }

    @Test
    void getFollowersThenSellerNotFoundException(){
        //Arrange
        int sellerId = 99;
        String order = "name_asc";
        when(userRepository.getUser(sellerId)).thenReturn(null);

        //Act & Assert
        Assertions.assertThrows(
                NotFoundException.class, ()->userService.getFollowers(sellerId, order)
        );
    }

    @Test
    void getFollowersTheninvalidOrderDirException(){
        //Arrange
        int sellerId = 3;
        String order = "name_invalid";
        when(userRepository.getUser(sellerId)).thenReturn(new Seller());

        //Act & Assert
        Assertions.assertThrows(
                BadRequestException.class, ()->userService.getFollowers(sellerId, order)
        );
    }

    @Test
    void getFollowersTheninvalidOrderException(){
        //Arrange
        int sellerId = 3;
        String order = "order_invalid";
        when(userRepository.getUser(sellerId)).thenReturn(new Seller());

        //Act & Assert
        Assertions.assertThrows(
                BadRequestException.class, ()->userService.getFollowers(sellerId, order)
        );
    }

    @Test
    void getFollowedThenUserNotFound(){
        //Arrange
        int userId = 99;
        String order = "name_asc";

        when(userRepository.getUser(userId)).thenReturn(null);

        //Act & Assert
        Assertions.assertThrows(
                NotFoundException.class, ()->userService.getFollowed(userId, order)
        );
    }

    @Test
    void getFollowedTheninvalidOrderDirException(){
        //Arrange
        int sellerId = 3;
        String order = "name_invalid";
        when(userRepository.getUser(sellerId)).thenReturn(new Seller());

        //Act & Assert
        Assertions.assertThrows(
                BadRequestException.class, ()->userService.getFollowed(sellerId, order)
        );
    }

    @Test
    void getFollowedTheninvalidOrderException(){
        //Arrange
        int sellerId = 3;
        String order = "order_invalid";
        when(userRepository.getUser(sellerId)).thenReturn(new Seller());

        //Act & Assert
        Assertions.assertThrows(
                BadRequestException.class, ()->userService.getFollowed(sellerId, order)
        );
    }
}
