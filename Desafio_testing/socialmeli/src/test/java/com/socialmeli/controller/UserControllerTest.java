package com.socialmeli.controller;

import com.socialmeli.dto.*;
import com.socialmeli.exception.InvalidPostException;
import com.socialmeli.exception.InvalidSellerException;
import com.socialmeli.exception.InvalidUserException;
import com.socialmeli.exception.NotFoundUserException;
import com.socialmeli.model.User;
import com.socialmeli.service.IUserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @Mock
    private IUserService iUserService;

    @InjectMocks
    private UserController userController;

    private ExceptionHandlerController exceptionHandlerController = new ExceptionHandlerController();

    @Test
    public void shouldBeFollowUser(){
        assertDoesNotThrow(()->userController.follow(1,2));
        Mockito.verify(iUserService,Mockito.times(1)).followUser(Mockito.anyInt(),Mockito.anyInt());
    }

    @Test
    public void shouldBeUnfollow(){
        assertDoesNotThrow(()->userController.unfollow(1,2));
        Mockito.verify(iUserService,Mockito.times(1)).unfollowSeller(Mockito.anyInt(),Mockito.anyInt());
    }

    @Test
    public  void shouldBeListSeller(){
        List<UserDto> users = List.of();
        Mockito.when(iUserService.getAllSellers()).thenReturn(users);
        assertEquals(users,userController.getSellers());
        Mockito.verify(iUserService,Mockito.times(1)).getAllSellers();
    }

    @Test
    public void shouldBeListUsers(){
        List<UserDto> users = List.of();
        Mockito.when(iUserService.getAllUsers()).thenReturn(users);
        assertEquals(users,userController.getUsers());
        Mockito.verify(iUserService,Mockito.times(1)).getAllUsers();
    }

    @Test
    public void shouldBeFindFollowedListAsc(){
        FollowedListDto list = new FollowedListDto(1,"Juan", List.of());
        Mockito.when(iUserService.getFollowedListOrderByNameAsc(1)).thenReturn(list);
        assertEquals(list,userController.getFollowed(1,"name_asc"));
        Mockito.verify(iUserService,Mockito.times(1)).getFollowedListOrderByNameAsc(1);
        Mockito.verify(iUserService,Mockito.times(0)).getFollowed(Mockito.anyInt());
        Mockito.verify(iUserService,Mockito.times(0)).getFollowedListOrderByNameDesc(Mockito.anyInt());
    }

    @Test
    public void shouldBeFindFollowedListDesc(){
        FollowedListDto list = new FollowedListDto(1,"Juan", List.of());
        Mockito.when(iUserService.getFollowedListOrderByNameAsc(1)).thenReturn(list);
        assertEquals(list,userController.getFollowed(1,"name_asc"));
        Mockito.verify(iUserService,Mockito.times(1)).getFollowedListOrderByNameAsc(Mockito.anyInt());
        Mockito.verify(iUserService,Mockito.times(0)).getFollowed(Mockito.anyInt());
        Mockito.verify(iUserService,Mockito.times(0)).getFollowedListOrderByNameDesc(1);
    }

    @Test
    public void shouldBeCountFollowers(){
        SellerFollowersCountDto dto =new SellerFollowersCountDto(1,"Juan",0);
        Mockito.when(iUserService.getCountBySeller(1)).thenReturn(dto);
        SellerFollowersCountDto result = userController.getCountSeller(1);
        assertEquals(result,dto);
        Mockito.verify(iUserService,Mockito.times(1)).getCountBySeller(Mockito.anyInt());
    }

    @Test
    public void shouldBeListFollowers(){
        FollowerListDto list = new FollowerListDto(1,"Juan",List.of());
        Mockito.when(iUserService.getFollowerList(1)).thenReturn(list);
        assertEquals(userController.getFollower(1,""),list);
        Mockito.verify(iUserService,Mockito.times(1)).getFollowerList(Mockito.anyInt());
    }

    @Test
    public void shouldBeAddUser(){
        userController.addUser(new UserRequestDto("Juan","Juan@app.com",false));
        Mockito.verify(iUserService,Mockito.times(1)).addUser(Mockito.any(UserRequestDto.class));
    }

    @Test
    public void shouldBeAddPostDto(){
        userController.addPost(new PostDto(1,1,"2021-01-01",null,1,1));
        Mockito.verify(iUserService,Mockito.times(1)).addPost(Mockito.any(PostDto.class));
    }

    @Test
    public void getListOfTwoLastWeeks(){
        ListPostDto dtos = new ListPostDto(1,List.of());
        Mockito.when(iUserService.getListDtoSubscriptionByUser(1)).thenReturn(dtos);
        assertEquals(dtos,userController.getListPostTwoWeeks(1,""));
        Mockito.verify(iUserService,Mockito.times(1)).getListDtoSubscriptionByUser(1);
    }

    @Test
    public void getListOfTwoLastWeeksDateAsc(){
        ListPostDto dtos = new ListPostDto(1,List.of());
        Mockito.when(iUserService.getListDtoSubscriptionByUserAndOrderByDateAsc(1)).thenReturn(dtos);
        assertEquals(dtos,userController.getListPostTwoWeeks(1,"date_asc"));
        Mockito.verify(iUserService,Mockito.times(1)).getListDtoSubscriptionByUserAndOrderByDateAsc(1);
    }

    @Test
    public void getListOfTwoLastWeeksDateDesc(){
        ListPostDto dtos = new ListPostDto(1,List.of());
        Mockito.when(iUserService.getListDtoSubscriptionByUserAndOrderByDateDesc(1)).thenReturn(dtos);
        assertEquals(dtos,userController.getListPostTwoWeeks(1,"date_desc"));
        Mockito.verify(iUserService,Mockito.times(1)).getListDtoSubscriptionByUserAndOrderByDateDesc(1);
    }

    @Test
    public void shouldBeGetPromoPostDiscount(){
        ProductDiscountListDto dto = new ProductDiscountListDto(1,"Juan",List.of());
        Mockito.when(iUserService.getProductDiscountListDto(1)).thenReturn(dto);
        assertEquals(dto,userController.getProductDiscountListDto(1));
        Mockito.verify(iUserService,Mockito.times(1)).getProductDiscountListDto(1);
    }

    @Test
    public void shouldSendUserNotFound(){
        ResponseEntity<?> entity = exceptionHandlerController.handlerNotFoundUser(new NotFoundUserException(""));
        assertTrue(entity.getStatusCode().is4xxClientError());
        assertNotNull(((ErrorDto)entity.getBody()).getMenssage());
    }

    @Test
    public void shouldBeSendBadRequest(){
        ResponseEntity<?> entity = exceptionHandlerController.handlerIvalidSeller(new InvalidSellerException(""));
        ResponseEntity<?> entity1 = exceptionHandlerController.handleInvalidPost(new InvalidPostException(""));
        ResponseEntity<?> entity2 = exceptionHandlerController.handlerInvalidUser(new InvalidUserException(""));
        assertTrue(entity.getStatusCode().is4xxClientError());
        assertTrue(entity1.getStatusCode().is4xxClientError());
        assertTrue(entity2.getStatusCode().is4xxClientError());
    }




}
