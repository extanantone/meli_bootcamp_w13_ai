package com.socialMeli.SocialMeli.Controller;

import com.socialMeli.SocialMeli.controller.ApplicationController;
import com.socialMeli.SocialMeli.exception.userExceptions.NotFoundUserException;
import com.socialMeli.SocialMeli.model.Post;
import com.socialMeli.SocialMeli.model.ProductDetails;
import com.socialMeli.SocialMeli.model.User;
import com.socialMeli.SocialMeli.postDTO.PostFollowedDTO;
import com.socialMeli.SocialMeli.service.PostService;
import com.socialMeli.SocialMeli.service.UserService;
import com.socialMeli.SocialMeli.userDto.FollowedListDTO;
import com.socialMeli.SocialMeli.userDto.FollowersListDTO;
import com.socialMeli.SocialMeli.userDto.UserFollowDTO;
import com.socialMeli.SocialMeli.userDto.UserFollowersCountDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;

@ExtendWith(MockitoExtension.class)
public class ApplicationControllerTest {
    @Mock
    UserService userService;

    @Mock
    PostService postService;

    @InjectMocks
    ApplicationController applicationController;

    static UserFollowDTO userFollowDTO;
    static UserFollowersCountDTO userFollowersCountDTO;
    static FollowersListDTO followersListDTO;
    static FollowedListDTO followedListDTO;


    @BeforeAll
    private static void initialize(){
        userFollowDTO=new UserFollowDTO(new User(1,"usuario1"));
        userFollowersCountDTO=new UserFollowersCountDTO(1,"usuario1",2 );
        followersListDTO=new FollowersListDTO(1,"usuario1");
        followedListDTO =new FollowedListDTO(1,"usuario1");

    }

    //T-0001

    @Test
    void followExistingUser(){
        //arrange
        Integer user_id=1;
        Integer user_to_follow_id=2;

        //act
        Mockito.when(userService.follow(user_id,user_to_follow_id)).thenReturn(userFollowDTO);
        applicationController.follow(user_id,user_to_follow_id);

        //assert
        Mockito.verify(userService, Mockito.atLeastOnce()).follow(user_id,user_to_follow_id);
    }

    @Test
    void followUnexistingUser(){
        //arrange
        Integer user_id=1;
        Integer user_to_follow_id=2;

        //act
        Mockito.when(userService.follow(user_id,user_to_follow_id)).thenThrow(new NotFoundUserException());

        //assert
        Assertions.assertThrows(NotFoundUserException.class,() -> applicationController.follow(user_id,user_to_follow_id));
        Mockito.verify(userService, Mockito.atLeastOnce()).follow(user_id,user_to_follow_id);

    }

    //T-0002

    @Test
    void unfollowExistingUser(){
        //arrange
        Integer user_id=1;
        Integer user_to_unfollow_id=2;

        //act
        Mockito.when(userService.unfollow(user_id,user_to_unfollow_id)).thenReturn(userFollowDTO);

        //assert
        Assertions.assertEquals(new ResponseEntity<>(Optional.of(userFollowDTO),HttpStatus.OK), applicationController.unfollow(user_id,user_to_unfollow_id));
        Mockito.verify(userService, Mockito.atLeastOnce()).unfollow(user_id,user_to_unfollow_id);
    }

    @Test
    void unfollowUnexistingUser(){
        //arrange
        Integer user_id=1;
        Integer user_to_follow_id=2;

        //act
        Mockito.when(userService.unfollow(user_id,user_to_follow_id)).thenThrow(new NotFoundUserException());

        //assert
        Assertions.assertThrows(NotFoundUserException.class,() -> applicationController.unfollow(user_id,user_to_follow_id));
        Mockito.verify(userService, Mockito.atLeastOnce()).unfollow(user_id,user_to_follow_id);
    }

    //T-0003 y T-0004
    //El valor del order por defecto es ascendente en caso de que no se le agregue el orden por RequestParams o el order sea uno no valido.
    @Test
    void getUsersFollowersWithOrder(){
        //arrange
        String order1="name_asc";
        String order2="name_desc";
        Integer user_id=1;

        //act
        Mockito.when(userService.listFollowers(user_id,"name_asc")).thenReturn(followersListDTO);
        Mockito.when(userService.listFollowers(user_id,"name_desc")).thenReturn(followersListDTO);
        applicationController.followersList(1,"name_asc");
        applicationController.followersList(1,"name_desc");

        //assert
        Mockito.verify(userService, Mockito.atLeastOnce()).listFollowers(user_id,"name_asc");
        Mockito.verify(userService, Mockito.atLeastOnce()).listFollowers(user_id,"name_desc");
    }

    @Test
    void getUsersFollowedWithOrder(){
        //arrange
        String order1="name_asc";
        String order2="name_desc";
        Integer user_id=1;

        //act
        Mockito.when(userService.listFollowed(user_id,"name_asc")).thenReturn(followedListDTO);
        Mockito.when(userService.listFollowed(user_id,"name_desc")).thenReturn(followedListDTO);
        applicationController.followedList(1,"name_asc");
        applicationController.followedList(1,"name_desc");

        //assert
        Mockito.verify(userService, Mockito.atLeastOnce()).listFollowed(user_id,"name_asc");
        Mockito.verify(userService, Mockito.atLeastOnce()).listFollowed(user_id,"name_desc");
    }

    //T-0005 y T-0006
    //El valor del order por defecto es ascendente en caso de que no se le agregue el orden por RequestParams o el order sea uno no valido.
    @Test
    void getProductsFollowedListWithOrder(){
        //arrange
        Integer user_id=1;
        String order1="date_asc";
        String order2="date_desc";
        HashMap<Integer, User> list_users;
        PostFollowedDTO postFollowedDTO;

        User user1= new User(1,"usuario1");
        list_users = new HashMap<>();
        list_users.put(1,user1);

        LocalDate date1 = LocalDate.of(2021,11,25);

        List<Post> posts=new ArrayList<>();

        ProductDetails productDetails = new ProductDetails(1,"producto1","Prueba","marca","verde","ninguna");
        Post post1 = new Post(2,1,date1,productDetails,1,10.0);

        posts.add(post1);

        postFollowedDTO=new PostFollowedDTO(1, posts);

        //act
        Mockito.when(userService.getList_users()).thenReturn(list_users);
        Mockito.when(postService.productListFollowed(list_users,user_id,order2)).thenReturn(postFollowedDTO);
        Mockito.when(postService.productListFollowed(list_users,user_id)).thenReturn(postFollowedDTO);

        applicationController.productListFollowed(1,order1);
        applicationController.productListFollowed(1,order2);

        //assert
        Mockito.verify(postService, Mockito.atLeastOnce()).productListFollowed(list_users,user_id);
        Mockito.verify(postService, Mockito.atLeastOnce()).productListFollowed(list_users,user_id,order2);
    }

    //T-0007
    @Test
    void countUserFollowers(){
        //arrange
        Integer user_id=1;

        //act
        Mockito.when(userService.countFollowers(user_id)).thenReturn(new UserFollowersCountDTO(user_id,"usuario1",2));
        ResponseEntity<Optional> result =applicationController.followersCount(user_id);

        //assert
        Assertions.assertEquals(HttpStatus.OK,result.getStatusCode());
        Mockito.verify(userService,Mockito.atLeastOnce()).countFollowers(user_id);
    }


    //T-0008
    //el repo hace el filtro

}
