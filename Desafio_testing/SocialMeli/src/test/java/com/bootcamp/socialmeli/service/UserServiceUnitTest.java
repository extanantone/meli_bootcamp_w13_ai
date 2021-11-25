package com.bootcamp.socialmeli.service;

import com.bootcamp.socialmeli.dto.UserDTO;
import com.bootcamp.socialmeli.exceptions.NotFoundException;
import com.bootcamp.socialmeli.mapper.IMapper;
import com.bootcamp.socialmeli.mapper.Mapper;
import com.bootcamp.socialmeli.model.User;
import com.bootcamp.socialmeli.repository.IProductRepository;
import com.bootcamp.socialmeli.repository.IUserRepository;
import com.bootcamp.socialmeli.util.TestUtilsGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
class UserServiceUnitTest {

    @Mock
    IUserRepository repository;

    @InjectMocks
    UserService service;

    IMapper mapper;


    @BeforeEach
    private void setUp() {
        this.mapper = new Mapper(null);
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

    @Test
    public void whenInvalidOrderThrowException() {
        String order = "invalid";
        String[] names = {"Beto", "Charlie", "Ana", "Daniela"};
        List<UserDTO> users = new ArrayList<>();
        for (int i=0; i<names.length; i++) {
            users.add(mapper.userToUserDTO(TestUtilsGenerator.getVanillaUser(i, names[i])));
        }

        // This test won't pass
        assertThrows(RuntimeException.class, () -> {
            service.orderUsersByName(users, order);
        });
    }

    @Test
    public void whenValidAscOrderSortUsers() {
        String[] names = {"Beto", "Charlie", "Ana", "Daniela"};
        List<UserDTO> users = new ArrayList<>();
        for (int i=0; i<names.length; i++) {
            users.add(mapper.userToUserDTO(TestUtilsGenerator.getVanillaUser(i, names[i])));
        }
        List<String> expectedSortedUsernames = Arrays.stream(names).sorted().collect(Collectors.toList());
        String order = "asc";

        List<String> actualSortedUsernames = service.orderUsersByName(users, order).stream()
                .map(u -> u.getUsername()).collect(Collectors.toList());

        assertAll(() -> {
            for (int i=0; i<names.length; i++) {
                assertEquals(expectedSortedUsernames.get(i), actualSortedUsernames.get(i));
            }
        });
    }
}