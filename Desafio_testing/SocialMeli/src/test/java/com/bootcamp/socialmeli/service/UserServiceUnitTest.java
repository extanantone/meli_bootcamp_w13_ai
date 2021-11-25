package com.bootcamp.socialmeli.service;

import com.bootcamp.socialmeli.exceptions.NotFoundException;
import com.bootcamp.socialmeli.model.User;
import com.bootcamp.socialmeli.repository.IUserRepository;
import com.bootcamp.socialmeli.util.TestUtilsGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
class UserServiceUnitTest {

    @Mock
    IUserRepository repository;

    @InjectMocks
    UserService service;

    @BeforeEach
    private void setUp() {

    }

    @Test
    public void whenFollowedUserExistsFollow() {
        User followerUser = TestUtilsGenerator.getVanillaUser(1, "follower");
        User followedUser = TestUtilsGenerator.getVanillaUser(2, "followed");

        Mockito.when(repository.getUser(1)).thenReturn(followerUser);
        Mockito.when(repository.getUser(2)).thenReturn(followedUser);
        service.followUser(1, 2);

        assertAll(
                () -> assertTrue(followedUser.getFollowers().contains(followerUser)),
                () -> assertTrue(followerUser.getFollowed().contains(followedUser))
        );
    }

    @Test
    public void whenFollowedUserDoesntExistsThrowException() {
        User followerUser = TestUtilsGenerator.getVanillaUser(1, "follower");

        Mockito.when(repository.getUser(1)).thenReturn(followerUser);
        Mockito.when(repository.getUser(2)).thenReturn(null);

        assertThrows(NotFoundException.class,() -> {
            service.followUser(1, 2);
        });
    }

    @Test
    public void whenUnfollowedUserExistsFollow() {
        User followerUser = TestUtilsGenerator.getVanillaUser(1, "follower");
        User followedUser = TestUtilsGenerator.getVanillaUser(2, "followed");

        Mockito.when(repository.getUser(1)).thenReturn(followerUser);
        Mockito.when(repository.getUser(2)).thenReturn(followedUser);
        service.followUser(1, 2);
        assertAll(
                () -> assertTrue(followedUser.getFollowers().contains(followerUser)),
                () -> assertTrue(followerUser.getFollowed().contains(followedUser))
        );
        service.unfollowUser(1, 2);

        assertAll(
                () -> assertFalse(followedUser.getFollowers().contains(followerUser)),
                () -> assertFalse(followerUser.getFollowed().contains(followedUser))
        );
    }

    @Test
    public void whenUnfollowedUserDoesntExistsThrowException() {
        User followerUser = TestUtilsGenerator.getVanillaUser(1, "follower");

        Mockito.when(repository.getUser(1)).thenReturn(followerUser);
        Mockito.when(repository.getUser(2)).thenReturn(null);

        assertThrows(NotFoundException.class,() -> {
            service.unfollowUser(1, 2);
        });
    }


}