package com.socialMeli.SocialMeli.Service;

import com.socialMeli.SocialMeli.exception.userExceptions.FollowItselfException;
import com.socialMeli.SocialMeli.exception.userExceptions.NotFoundUserException;
import com.socialMeli.SocialMeli.model.User;
import com.socialMeli.SocialMeli.repository.UserRepository;
import com.socialMeli.SocialMeli.service.UserServiceImp;
import com.socialMeli.SocialMeli.userDto.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserServiceImp userService;

    static  User user;
    static UserFollowDTO userFollowDTO;
    static HashMap<Integer, User> list_users;

    @BeforeEach
    private void initialize(){
        User user1= new User(1,"usuario1");
        User user2= new User(2,"usuario2");
        userFollowDTO=new UserFollowDTO(user1);
        list_users = new HashMap<>();
        list_users.put(1,user1);
        list_users.put(2,user2);

    }

    //T-0001

    @Test
    void followExistingUser(){
        //arrange
        Integer user_id=1;
        Integer user_to_follow_id=2;

        //act
        Mockito.when(userRepository.follow(user_id,user_to_follow_id)).thenReturn(userFollowDTO);
        Mockito.when(userRepository.getList_users()).thenReturn(list_users);

        //assert
        Assertions.assertEquals(userFollowDTO,userService.follow(user_id,user_to_follow_id));
        Mockito.verify(userRepository, Mockito.atLeastOnce()).follow(user_id,user_to_follow_id);
    }

    @Test
    void followUnexistingUser(){
        //arrange
        Integer user_id=1;
        Integer user_unexisting_id=3;

        //act
        Mockito.when(userRepository.getList_users()).thenReturn(list_users);

        //assert
        Assertions.assertThrows(NotFoundUserException.class,() -> userService.follow(user_id,user_unexisting_id));
    }

    @Test
    void followSelfUser(){
        //arrange
        Integer user_id=1;
        Integer user_to_follow_id=1;

        //act
        Mockito.when(userRepository.getList_users()).thenReturn(list_users);

        //assert
        Assertions.assertThrows(FollowItselfException.class,() -> userService.follow(user_id,user_to_follow_id));
    }

    //T-0002

    @Test
    void unfollowExistingUser(){
        //arrange
        Integer user_id=1;
        Integer user_to_unfollow_id=2;

        //act
        Mockito.when(userRepository.getList_users()).thenReturn(list_users);
        Mockito.when(userRepository.unfollow(user_id,user_to_unfollow_id)).thenReturn(userFollowDTO);

        //assert
        Assertions.assertEquals(userFollowDTO.getId(), userService.unfollow(user_id,user_to_unfollow_id).getId());
        Mockito.verify(userRepository, Mockito.atLeastOnce()).unfollow(user_id,user_to_unfollow_id);
    }

    @Test
    void unfollowUnexistingUser(){
        //arrange
        Integer user_id=1;
        Integer user_to_unfollow_id=5;

        //act
        Mockito.when(userRepository.getList_users()).thenReturn(list_users);

        //assert
        Assertions.assertThrows(NotFoundUserException.class,() -> userService.unfollow(user_id,user_to_unfollow_id));
    }

    //T-0003 y T-0004
    //El valor del order por defecto es ascendente en caso de que no se le agregue el orden por RequestParams o el order sea uno no valido.

    @Test
    void followersListWithOrder(){
        //arrange
        Integer user_id=1;
        String order1 = "name_asc";
        String order2 = "name_desc";

        UserInfoDTO follower1= new UserInfoDTO(2,"ana diaz");
        UserInfoDTO follower2= new UserInfoDTO(3,"brayan diaz");
        List<UserInfoDTO> followers = new ArrayList<>();
        followers.add(follower1);
        followers.add(follower2);

        FollowersListDTO followersListDTO = new FollowersListDTO(user_id,"usuario1",followers);

        //act
        Mockito.when(userRepository.getList_users()).thenReturn(list_users);
        Mockito.when(userRepository.listFollowers(user_id)).thenReturn(followersListDTO);

        FollowersListDTO list_followers_asc = userService.listFollowers(user_id,order1);
        FollowersListDTO list_followers_desc = userService.listFollowers(user_id,order2);

        //assert
        Assertions.assertEquals("ana diaz",list_followers_asc.getFollowers().get(0).getUser_name());
        Assertions.assertEquals("brayan diaz",list_followers_desc.getFollowers().get(0).getUser_name());
    }

    @Test
    void followedListWithOrder(){
        //arrange
        Integer user_id=1;
        String order1 = "name_asc";
        String order2 = "name_desc";

        UserInfoDTO followed1= new UserInfoDTO(2,"ana diaz");
        UserInfoDTO followed2= new UserInfoDTO(3,"brayan diaz");
        List<UserInfoDTO> followed = new ArrayList<>();
        followed.add(followed1);
        followed.add(followed2);

        FollowedListDTO followedListDTO = new FollowedListDTO(user_id,"usuario1",followed);

        //act
        Mockito.when(userRepository.getList_users()).thenReturn(list_users);
        Mockito.when(userRepository.listFollowed(user_id)).thenReturn(followedListDTO);

        FollowedListDTO list_followed_asc = userService.listFollowed(user_id,order1);
        FollowedListDTO list_followed_desc = userService.listFollowed(user_id,order2);

        //assert
        Assertions.assertEquals("ana diaz",list_followed_asc.getFollowed().get(0).getUser_name());
        Assertions.assertEquals("brayan diaz",list_followed_desc.getFollowed().get(0).getUser_name());
    }

    //T-0007
    @Test
    void countUserFollowers(){
        //arrange
        Integer user_id=1;

        //act
        Mockito.when(userRepository.getList_users()).thenReturn(list_users);
        Mockito.when(userRepository.countFollowers(user_id)).thenReturn(new UserFollowersCountDTO(user_id,"usuario1",2));
        UserFollowersCountDTO result =userService.countFollowers(user_id);

        //assert
        Assertions.assertEquals(2,result.getFollowers_count());
        Mockito.verify(userRepository,Mockito.atLeastOnce()).countFollowers(user_id);
    }


}
