package com.socialmeli.socialmeli.unit.controller;

import com.socialmeli.socialmeli.controller.PostController;
import com.socialmeli.socialmeli.controller.UserController;
import com.socialmeli.socialmeli.dto.post.FollowedSellerPostDTO;
import com.socialmeli.socialmeli.dto.user.UserFollowersListDTO;
import com.socialmeli.socialmeli.service.UserAndPostService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UnitTestPostController {
    @Mock
    UserAndPostService mockUserAndPostService;

    @InjectMocks
    PostController postController;
    //T-0003 Verificar que el tipo de ordenamiento alfabético exista (US-0008)
    @Test
    public void testInputOrderExistWithCorrectOrderDate() {
        String order = "date_asc";
        int userId = 1;
        FollowedSellerPostDTO followedSellerPostDTO = new FollowedSellerPostDTO(1);
        when(mockUserAndPostService.followedSellersPost(userId,order)).thenReturn(followedSellerPostDTO);

        //Ac
        ResponseEntity r = postController.followedSellersPost(userId,order);

        //As
        verify(mockUserAndPostService, atLeastOnce()).followedSellersPost(userId, order);
        Assertions.assertEquals(200,r.getStatusCodeValue());
    }
    @Test
    public void testInputOrderExistWithIncorrectOrderName() {
        String order = "dato__";
        int userId = 1;
        FollowedSellerPostDTO followedSellerPostDTO = new FollowedSellerPostDTO(1);
        when(mockUserAndPostService.followedSellersPost(userId,order)).thenReturn(followedSellerPostDTO);

        //Ac
        ResponseEntity r = postController.followedSellersPost(userId,order);

        //As
        verify(mockUserAndPostService, atLeastOnce()).followedSellersPost(userId, order);
        Assertions.assertEquals(200,r.getStatusCodeValue());
    }
}
