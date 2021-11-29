package com.meli.SocialMeli.unit.controller;

import com.meli.SocialMeli.controller.SocialMeliController;
import com.meli.SocialMeli.dto.MensajeDTO;
import com.meli.SocialMeli.dto.PostDTOResponse;
import com.meli.SocialMeli.dto.ProductDTO;
import com.meli.SocialMeli.dto.PromoDTO;
import com.meli.SocialMeli.model.Post;
import com.meli.SocialMeli.model.Product;
import com.meli.SocialMeli.model.Promo;
import com.meli.SocialMeli.model.User;
import com.meli.SocialMeli.service.SocialMeliService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.LinkedList;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class SocialMeliControllertest {
    @Mock
    SocialMeliService mockService;

    @InjectMocks
    SocialMeliController controller;


    @Test
    public void verifyAddFollow() {
        // arrange
        int userId = 1;
        int userIdFollow = 3;

        // Act
        controller.addFollow(userId, userIdFollow);

        // assert
        verify(mockService, atLeastOnce()).addFollow(userId, userIdFollow);
    }

    @Test
    public void VerifyCountFollowers() {
        // arrange
        int userId = 1;
        // Act
        controller.countFollowers(userId);

        // assert
        verify(mockService, atLeastOnce()).countFollowers(userId);
    }

    @Test
    public void VerifyListFollowers() {
        // arrange
        int userId = 1;
        String order = null;
        // Act
        controller.listFollowers(userId, order);

        // assert
        verify(mockService, atLeastOnce()).listFollowers(userId, order);
    }

    @Test
    public void VerifyListFollowed() {
        // arrange
        int userId = 1;
        String order = null;
        // Act
        controller.listFollowed(userId, order);

        // assert
        verify(mockService, atLeastOnce()).listFollowed(userId, order);
    }

    @Test
    public void VerifyAddPost() {
        //Arrange
        User userId = new User(1, "Gabriela", new LinkedList<User>(), new LinkedList<User>());

        ProductDTO prod = new ProductDTO(1, "Silla Gamer","Silla", "Chip", "Negro","");
        PostDTOResponse post = new PostDTOResponse(userId.getUserId(),1, LocalDate.of(2021, 11, 26),3,1540.0, prod);

        // Act
        controller.addPost(post);

        // assert
        verify(mockService, atLeastOnce()).addPost(post);
    }

    @Test
    public void VerifyListPostFollowed() {
        // arrange
        int userId = 1;
        String order = null;
        // Act
        controller.listPostFollowed(userId, order);

        // assert
        verify(mockService, atLeastOnce()).listPostFollowed(userId, order);
    }

    @Test
    public void verifyUnfollow() {
        // arrange
        int userId = 1;
        int userIdFollow = 3;

        // Act
        controller.unfollow(userId, userIdFollow);

        // assert
        verify(mockService, atLeastOnce()).unfollow(userId, userIdFollow);
    }

    @Test
    public void VerifyAddPromo() {
        //Arrange
        User user = new User(1, "Gabriela", new LinkedList<User>(), new LinkedList<User>());

        ProductDTO prod = new ProductDTO(3, "Silla Gamer 3","Silla", "Chip", "Negro","");
        PromoDTO promo = new PromoDTO(user.getUserId(),3, LocalDate.of(2021, 10, 29),100,2345.0, prod, true, 10.0);

        // Act
        controller.addPromo(promo);

        // assert
        verify(mockService, atLeastOnce()).addPromo(promo);
    }

    @Test
    public void VerifyListPromo() {
        // arrange
        int userId = 1;
        String order = null;
        // Act
        controller.listPromo(userId, order);

        // assert
        verify(mockService, atLeastOnce()).listPromo(userId, order);
    }

    @Test
    public void VerifyCountPromo() {
        // arrange
        int userId = 1;
        // Act
        controller.countPromo(userId);

        // assert
        verify(mockService, atLeastOnce()).countPromos(userId);
    }

}
