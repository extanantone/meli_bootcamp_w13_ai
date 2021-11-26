package com.example.socialmeli.unit.service.user;

import com.example.socialmeli.dto.user.FollowedListDTO;
import com.example.socialmeli.dto.user.FollowerCountDTO;
import com.example.socialmeli.dto.user.FollowerDTO;
import com.example.socialmeli.dto.user.FollowerListDTO;
import com.example.socialmeli.exception.BadRequestException;
import com.example.socialmeli.mapper.FollowerMapper;
import com.example.socialmeli.model.User;
import com.example.socialmeli.unit.repository.user.IUserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ExtendWith(MockitoExtension.class)
class UserServiceTest
{

    @Mock
    IUserRepository userRepository;

    @Mock
    FollowerMapper followerMapper;

    @InjectMocks
    UserService userService;

    // T-0001
    //("Verificar que el usuario a seguir exista. (US-0001)")

    Map<Integer, User> userMap = null;
    User follower = null;
    User followed = null;

    @BeforeEach
    void initEach()
    {
        // Arrange
        follower = new User("Follower");
        followed = new User("Followed");
        userMap = new HashMap<>();
        userMap.put(follower.getUserId(), follower);
        userMap.put(followed.getUserId(), followed);
    }

    @Test
    void followsSuccesfullyAnExistingUser()
    {
        // Arrange
        // Act & Mock
        Mockito.when(userRepository.usersMap()).thenReturn(userMap);
        userService.follow(follower.getUserId(), followed.getUserId());
        // Assert
        Mockito.verify(userRepository, Mockito.times(1)).usersMap();
        Assertions.assertAll(
                () -> Assertions.assertTrue(follower.getFollowed().contains(followed)),
                () -> Assertions.assertTrue(followed.getFollowers().contains(follower)),
                () -> Assertions.assertEquals(1, followed.getFollowers().size())
        );
    }

    @Test
    void followsUnsuccesfullyAnAlreadyFollowingUser()
    {
        // Arrange
        follower.follow(followed);
        // Act & Mock
        Mockito.when(userRepository.usersMap()).thenReturn(userMap);
        // Assert
        Assertions.assertThrows(BadRequestException.class,
                () -> userService.follow(follower.getUserId(), followed.getUserId()));
        Mockito.verify(userRepository, Mockito.times(1)).usersMap();
    }

    @Test
    void followsUnsuccesfullyAnNotExistingUser()
    {
        // Arrange
        // Act & Mock
        Mockito.when(userRepository.usersMap()).thenReturn(userMap);
        // Assert
        Assertions.assertThrows(BadRequestException.class,
                () -> userService.follow(follower.getUserId(), follower.getUserId() - 1));
        Mockito.verify(userRepository, Mockito.times(1)).usersMap();
    }

    @Test
    void followsUnsuccesfullyHimself()
    {
        // Arrange
        // Act & Mock
        Mockito.when(userRepository.usersMap()).thenReturn(userMap);
        // Assert
        Assertions.assertThrows(BadRequestException.class,
                () -> userService.follow(follower.getUserId(), follower.getUserId()));
        Mockito.verify(userRepository, Mockito.times(1)).usersMap();
    }

    // T-0002
    //  Verificar que el usuario a dejar de seguir exista. (US-0007)

    @Test
    void unfollowSuccesfullyAnAlreadyFollowingUser()
    {
        // Arrange
        follower.follow(followed);
        // Act & Mock
        Mockito.when(userRepository.usersMap()).thenReturn(userMap);
        // Assert
        userService.unfollow(follower.getUserId(), followed.getUserId());
        Mockito.verify(userRepository, Mockito.times(1)).usersMap();
        Assertions.assertAll(
                () -> Assertions.assertFalse(follower.getFollowed().contains(followed)),
                () -> Assertions.assertFalse(followed.getFollowers().contains(follower)),
                () -> Assertions.assertEquals(0, followed.getFollowers().size())
        );
    }

    @Test
    void unfollowUnSuccesfullyAnExistingButNotAlreadyFollowingUser()
    {
        // Arrange
        // Act & Mock
        Mockito.when(userRepository.usersMap()).thenReturn(userMap);
        // Assert
        Assertions.assertThrows(BadRequestException.class,
                () -> userService.unfollow(follower.getUserId(), follower.getUserId()));
        Mockito.verify(userRepository, Mockito.times(1)).usersMap();
    }

    @Test
    void unfollowUnSuccesfullyAnNotExistingUser()
    {
        // Arrange
        // Act & Mock
        Mockito.when(userRepository.usersMap()).thenReturn(userMap);
        // Assert
        Assertions.assertThrows(BadRequestException.class,
                () -> userService.unfollow(follower.getUserId(), follower.getUserId() - 1));
        Mockito.verify(userRepository, Mockito.times(1)).usersMap();
    }

    // T-0003
    // Verificar que el tipo de ordenamiento alfabético exista (US-0008)
    @Test
    void followedListWithOrderSpecified()
    {
        // Arrange
        List<User> followedList = List.of(followed);
        ModelMapper modelMapper = new ModelMapper();
        Type listType = new TypeToken<List<FollowerDTO>>(){}.getType();
        List<FollowerDTO> expected = modelMapper.map(followedList, listType);
        follower.follow(followed);
        // Act & Mock
        Mockito.when(userRepository.usersMap()).thenReturn(userMap);
        Mockito.when(userRepository.findFollowedOrderByNameAsc(follower.getUserId())).thenReturn(followedList);
        Mockito.when(followerMapper.userToFollowerDTO(followedList)).thenReturn(expected);
        FollowedListDTO result = userService.followed(follower.getUserId(), "name_asc");
        // Assert
        Mockito.verify(userRepository, Mockito.times(1)).usersMap();
        Mockito.verify(userRepository, Mockito.times(1)).findFollowedOrderByNameAsc(follower.getUserId());
        Mockito.verify(followerMapper, Mockito.times(1)).userToFollowerDTO(followedList);
        Assertions.assertEquals(expected,  result.getFollowed());
    }

    @Test
    void followedListWithoutOrderSpecified()
    {
        // Arrange
        follower.follow(followed);
        List<User> followedList = List.of(followed);
        // Mock
        Mockito.when(userRepository.usersMap()).thenReturn(userMap);
        Mockito.when(userRepository.findFollowedOrderByNameAsc(follower.getUserId())).thenReturn(followedList);
        // Assert
        Assertions.assertThrows(BadRequestException.class,
                () -> userService.followed(follower.getUserId(), null)
        );
    }

    @Test
    void followersListWithOrderSpecified()
    {
        // Arrange
        List<User> followerList = List.of(follower);
        ModelMapper modelMapper = new ModelMapper();
        Type listType = new TypeToken<List<FollowerDTO>>(){}.getType();
        List<FollowerDTO> expected = modelMapper.map(followerList, listType);
        follower.follow(followed);
        // Act & Mock
        Mockito.when(userRepository.usersMap()).thenReturn(userMap);
        Mockito.when(userRepository.findFollowersOrderByNameAsc(followed.getUserId())).thenReturn(followerList);
        Mockito.when(followerMapper.userToFollowerDTO(followerList)).thenReturn(expected);
        FollowerListDTO result = userService.followers(followed.getUserId(), "name_asc");
        // Assert
        Mockito.verify(userRepository, Mockito.times(1)).usersMap();
        Mockito.verify(userRepository, Mockito.times(1)).findFollowersOrderByNameAsc(followed.getUserId());
        Mockito.verify(followerMapper, Mockito.times(1)).userToFollowerDTO(followerList);
        Assertions.assertEquals(expected,  result.getFollowers());
    }

    @Test
    void followerListWithoutOrderSpecified()
    {
        // Arrange
        followed.follow(follower);
        List<User> followerList = List.of(follower);
        Mockito.when(userRepository.usersMap()).thenReturn(userMap);
        Mockito.when(userRepository.findFollowedOrderByNameAsc(followed.getUserId())).thenReturn(followerList);
        // Assert
        Assertions.assertThrows(BadRequestException.class,
                () -> userService.followers(followed.getUserId(), null)
        );
    }

    // T-0007
    //Verificar que la cantidad de seguidores de un determinado usuario sea correcta. (US-0002)

    @Test
    void countFollowersWhenTwoPeopleAreFollowing()
    {
        // Arrange
        User newFollower = new User();
        newFollower.follow(followed);
        follower.follow(followed);
        // Act & Mock
        Mockito.when(userRepository.usersMap()).thenReturn(userMap);
        FollowerCountDTO followerCountDTO = userService.countFollowers(followed.getUserId());
        // Assert
        Mockito.verify(userRepository, Mockito.times(1)).usersMap();
        Assertions.assertAll(
                () -> Assertions.assertEquals(2, followerCountDTO.getFollowersCount()),
                () -> Assertions.assertEquals(2, followed.getFollowers().size())
        );
    }

    @Test
    void countFollowersWhenNoOneIsFollowing()
    {
        // Arrange
        // Act & Mock
        Mockito.when(userRepository.usersMap()).thenReturn(userMap);
        // Assert
        FollowerCountDTO followerCountDTO = userService.countFollowers(followed.getUserId());
        Mockito.verify(userRepository, Mockito.times(1)).usersMap();
        Assertions.assertAll(
                () -> Assertions.assertEquals(0, followerCountDTO.getFollowersCount()),
                () -> Assertions.assertEquals(0, followed.getFollowers().size())
        );
    }


}