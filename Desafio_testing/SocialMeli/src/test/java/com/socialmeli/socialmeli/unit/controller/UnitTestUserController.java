package com.socialmeli.socialmeli.unit.controller;

import com.socialmeli.socialmeli.controller.UserController;
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
public class UnitTestUserController {
    @Mock
    UserAndPostService mockUserAndPostService;

    @InjectMocks
    UserController userController;
    //T-0003 Verificar que el tipo de ordenamiento alfabético exista (US-0008)
    @Test
    public void testInputOrderExistWithCorrectOrderName() {
        //Ar
        String order = "name_asc";
        int userId = 1;
        UserFollowersListDTO userFollowersListDTO = new UserFollowersListDTO(1,"userName",true);
        when(mockUserAndPostService.listUserFollowex(userId,true,order)).thenReturn(userFollowersListDTO);

        //Ac
        ResponseEntity r = userController.listFollowers(userId,order);

        //As
        verify(mockUserAndPostService, atLeastOnce()).listUserFollowex(userId,true, order);
        Assertions.assertEquals(200,r.getStatusCodeValue());
    }
    @Test
    public void testInputOrderExistWithIncorrectOrderName() {
        //Ar
        String order = "nome__";
        int userId = 1;
        UserFollowersListDTO userFollowersListDTO = new UserFollowersListDTO(1,"userName",true);
        when(mockUserAndPostService.listUserFollowex(userId,true,order)).thenReturn(userFollowersListDTO);

        //Ac
        ResponseEntity r = userController.listFollowers(userId,order);

        //As
        Assertions.assertEquals(200,r.getStatusCodeValue());
    }
}
