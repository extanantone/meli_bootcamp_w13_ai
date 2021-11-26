package com.lgoyenechea.socialmeli.controller;

import com.lgoyenechea.socialmeli.dto.*;
import com.lgoyenechea.socialmeli.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    @Mock
    ProductService mockProductService;

    @InjectMocks
    ProductController productController;

    @Test
    void givenCorrectPostCreation_whenNewProductPost_thenOk() {
        PostDTO dto = new PostDTO();
        when(mockProductService.save(any())).thenReturn(dto);
        ResponseEntity<PostDTO> response = productController.newProductPost(new PostCreationDTO());
        verify(mockProductService, times(1)).save(any());
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    @Test
    void givenCorrectUserId_whenFollowedPostsList_thenOk() {
        UserFollowedPostsListDTO dto = new UserFollowedPostsListDTO();
        when(mockProductService.followedPostsList(any(), any())).thenReturn(dto);
        ResponseEntity<UserFollowedPostsListDTO> response =
                productController.followedPostsList(1L, "date_asc");
        verify(mockProductService, times(1)).followedPostsList(any(), any());
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    @Test
    void givenCorrectPostWithPromoCreation_whenNewProductWithPromoPost_thenOk() {
        PostPromoDTO dto = new PostPromoDTO();
        when(mockProductService.saveWithPromo(any())).thenReturn(dto);
        ResponseEntity<PostPromoDTO> response = productController.newProductWithPromoPost(new PostCreationPromoDTO());
        verify(mockProductService, times(1)).saveWithPromo(any());
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    @Test
    void givenCorrectUserId_whenPromoPostCount_thenOk() {
        UserPromoPostCountDTO dto = new UserPromoPostCountDTO();
        when(mockProductService.postsPromoCount(any())).thenReturn(dto);
        ResponseEntity<UserPromoPostCountDTO> response = productController.promoPostCount(1L);
        verify(mockProductService, times(1)).postsPromoCount(any());
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    @Test
    void postsPromoList() {
        UserPostsPromoListDTO dto = new UserPostsPromoListDTO();
        when(mockProductService.postsPromoList(any())).thenReturn(dto);
        ResponseEntity<UserPostsPromoListDTO> response = productController.postsPromoList(1L);
        verify(mockProductService, times(1)).postsPromoList(any());
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }
}