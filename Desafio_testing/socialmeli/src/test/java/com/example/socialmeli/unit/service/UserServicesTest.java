package com.example.socialmeli.unit.service;

import com.example.socialmeli.Models.User;
import com.example.socialmeli.dto.DTOResponses.DTOEmptyJsonResponse;
import com.example.socialmeli.exceptions.OrderNoFound;
import com.example.socialmeli.exceptions.UserNoFound;
import com.example.socialmeli.repository.IUserRepository;
import com.example.socialmeli.services.UserServices;
import com.example.socialmeli.unit.utils.UtilsUserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServicesTest {



    @Mock
    IUserRepository mockRepository;

    @InjectMocks
    UserServices services;

    @BeforeEach
    void zinit(){
        User.setNumberUser(0);
    }

    @AfterEach
    void after(){
        Mockito.reset(mockRepository);
    }

    @Test
    void followUserThatExist(){

        User user1 = new User("Lina");
        User user2 = new User("Carlos");

        when(mockRepository.getUserbyId(1)).thenReturn(user1);
        when(mockRepository.getUserbyId(2)).thenReturn(user2);
        DTOEmptyJsonResponse response = new DTOEmptyJsonResponse();

        assertEquals(response , services.followUser(1, 2));
        verify(mockRepository, atLeast(1)).getUserbyId(user1.getUserId());
        verify(mockRepository, atLeast(1)).getUserbyId(user2.getUserId());
    }

    @Test
    void followUserThatNoExist(){
        User user1 = new User("Lina");
        Integer userDontExist = 3;

        when(mockRepository.getUserbyId(user1.getUserId())).thenReturn(user1);
        when(mockRepository.getUserbyId(userDontExist)).thenReturn(null);

        assertThrows(UserNoFound.class, () -> services.followUser(1, 3));
        verify(mockRepository, atLeast(1)).getUserbyId(user1.getUserId());
        verify(mockRepository, atLeast(1)).getUserbyId(userDontExist);
    }

    @Test
    void UnfollowUserThatExist(){
        User user1 = new User("Lina");
        User user2 = new User("Carlos");


        when(mockRepository.getUserbyId(user1.getUserId())).thenReturn(user1);
        when(mockRepository.getUserbyId(user2.getUserId())).thenReturn(user2);
        services.followUser(1, 2);

        DTOEmptyJsonResponse response = new DTOEmptyJsonResponse();
        assertEquals(response, services.unFollow(1, 2));
        verify(mockRepository, atLeast(1)).getUserbyId(user1.getUserId());
        verify(mockRepository, atLeast(1)).getUserbyId(user2.getUserId());
    }

    @Test
    void UnfollowUserThatNoExist(){
        User user1 = new User("Lina");
        Integer userDontExist = 3;


        when(mockRepository.getUserbyId(user1.getUserId())).thenReturn(user1);
        when(mockRepository.getUserbyId(userDontExist)).thenReturn(null);


        assertThrows(UserNoFound.class, () -> services.unFollow(user1.getUserId(), userDontExist));
        verify(mockRepository, atLeast(1)).getUserbyId(user1.getUserId());
        verify(mockRepository, atLeast(1)).getUserbyId(userDontExist);
    }


    @Test
    void checkOrderAlphaExist(){
        Integer id = 2;
        when(mockRepository.getUserbyId(id)).thenReturn(UtilsUserService.getUser2());
        // check list followers list and check sort
        assertEquals("Francisco", services.getListFollowers(id,"name_asc").getFollowers().get(0).getUser_name());
        assertEquals("Lina", services.getListFollowers(id,"name_desc").getFollowers().get(0).getUser_name());

        // check list followees list and check sort
        assertEquals("Francisco", services.getListFollowed(id,"name_asc").getFollowees().get(0).getUser_name());
        assertEquals("Lina", services.getListFollowed(id,"name_desc").getFollowees().get(0).getUser_name());
    }

    @Test
    void checkOrderAlphaNotExist(){
        Integer id = 2;

        when(mockRepository.getUserbyId(id)).thenReturn(UtilsUserService.getUser2());

        // check order that not exist in followers
        assertThrows(OrderNoFound.class, () ->services.getListFollowers(id,"xxxx").getFollowers().get(0).getUser_name());
        assertThrows(OrderNoFound.class, () -> services.getListFollowers(id,"666").getFollowers().get(0).getUser_name());

        // check order that not exist in followees
        assertThrows(OrderNoFound.class, () ->services.getListFollowed(id,"xxxx").getFollowees().get(0).getUser_name());
        assertThrows(OrderNoFound.class, () -> services.getListFollowed(id,"666").getFollowees().get(0).getUser_name());

    }

    @Test
    void CheckAmountFollowers(){
       //currenlly user 2 has 2 followers, check 4 because is a uset that dont have any follower and followee
        Integer idWithTwoFollowers = 2;
        Integer idWithOutAnyFollower = 4;

        when(mockRepository.getUserbyId(idWithTwoFollowers)).thenReturn(UtilsUserService.getUser2());
        when(mockRepository.getUserbyId(idWithOutAnyFollower)).thenReturn(UtilsUserService.getUser4());

        assertEquals(2, services.getAmountFollowers(idWithTwoFollowers).getFollowers_count());
        assertEquals(0, services.getAmountFollowers(idWithOutAnyFollower).getFollowers_count());

    }

    @Test
    void CheckAmountFollowersError(){
        Integer idWithTwoFollowers = 2;
        Integer idWithOutAnyFollower = 4;

        when(mockRepository.getUserbyId(idWithTwoFollowers)).thenReturn(UtilsUserService.getUser2());
        when(mockRepository.getUserbyId(idWithOutAnyFollower)).thenReturn(UtilsUserService.getUser4());

        assertNotEquals(2, services.getAmountFollowers(idWithOutAnyFollower).getFollowers_count());
        assertNotEquals(0, services.getAmountFollowers(idWithTwoFollowers).getFollowers_count());

    }


}
