package com.socialMeli.SocialMeli.Repository;

import com.socialMeli.SocialMeli.exception.userExceptions.AlreadyFollowedUserException;
import com.socialMeli.SocialMeli.exception.userExceptions.FollowItselfException;
import com.socialMeli.SocialMeli.exception.userExceptions.NotFollowingUserException;
import com.socialMeli.SocialMeli.exception.userExceptions.NotFoundUserException;
import com.socialMeli.SocialMeli.model.User;
import com.socialMeli.SocialMeli.repository.UserRepository;
import com.socialMeli.SocialMeli.repository.UserRepositoryImp;
import com.socialMeli.SocialMeli.service.UserServiceImp;
import com.socialMeli.SocialMeli.userDto.UserFollowDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.HashMap;

@ExtendWith(MockitoExtension.class)
public class UserRepositoryTest {


    UserRepositoryImp userRepository;
    UserFollowDTO userFollowDTO;

    @BeforeEach
    private void initialize(){
        userRepository = new UserRepositoryImp();
        userRepository.loadUsers();
        userFollowDTO = new UserFollowDTO(new User(1,"usuario1"));
    }

    //T-0001

    @Test
    void followExistingUser(){
        //arrange
        Integer user_id=1;
        Integer user_to_follow_id=2;
        User user = userRepository.getList_users().get(user_id);
        userFollowDTO.setFollowing(Arrays.asList(2));

        //assert
        Assertions.assertIterableEquals(userFollowDTO.getFollowing(), userRepository.follow(user_id,user_to_follow_id).getFollowing());
    }

    @Test
    void followAlreadyFollowedUser(){
        //arrange
        Integer user_id=1;
        Integer user_to_follow_id=2;

        //act
        userRepository.follow(user_id,user_to_follow_id);

        //assert
        Assertions.assertThrows(AlreadyFollowedUserException.class,() -> userRepository.follow(user_id,user_to_follow_id));
    }

    //T-0002

    @Test
    void unfollowExistingUser(){
        //arrange
        Integer user_id=1;
        Integer user_to_follow_id=2;
        User user1 = userRepository.getList_users().get(1);
        user1.getFollowing().add(2);

        //act
        UserFollowDTO userDTO = userRepository.unfollow(user_id,user_to_follow_id);

        //assert
        Assertions.assertIterableEquals(userFollowDTO.getFollowing(), userDTO.getFollowing());
    }

    @Test
    void unfollowNotFollowedUser(){
        //arrange
        Integer user_id=1;
        Integer user_to_follow_id=2;

        //assert
        Assertions.assertThrows(NotFollowingUserException.class,() -> userRepository.unfollow(user_id,user_to_follow_id));
    }
}
