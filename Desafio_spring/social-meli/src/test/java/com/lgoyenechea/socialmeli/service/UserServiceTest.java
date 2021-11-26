package com.lgoyenechea.socialmeli.service;

import com.google.common.collect.Comparators;
import com.lgoyenechea.socialmeli.dto.*;
import com.lgoyenechea.socialmeli.exception.UserNotFollowException;
import com.lgoyenechea.socialmeli.exception.UserNotFoundException;
import com.lgoyenechea.socialmeli.model.User;
import com.lgoyenechea.socialmeli.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    UserRepository mockUserRepository;

    @InjectMocks
    UserService userService;

    final String NAME_ASC_ORDER = "name_asc";
    final String NAME_DESC_ORDER = "name_desc";

    User user1;
    User user2;
    User user3;

    @BeforeEach
    void setUp() {
        user1 = new User();
        user2 = new User();
        user3 = new User();
        user1.setName("AUser");
        user2.setName("BUser");
        user3.setName("CUser");
    }

    @Test
    void givenCorrectUserId_whenFollow_usersExistsAndFollow() {
        when(mockUserRepository.getById(1L)).thenReturn(user1);
        when(mockUserRepository.getById(2L)).thenReturn(user2);

        UserFollowDTO userFollowDto = userService.follow(1L, 2L);
        verify(mockUserRepository, times(1)).getById(1L);
        verify(mockUserRepository, times(1)).getById(2L);

        assertEquals(mockUserRepository.getById(1L).getId(), userFollowDto.getUser().getUserId());
        assertEquals(mockUserRepository.getById(2L).getId(), userFollowDto.getUserFollowed().getUserId());
        assertEquals(mockUserRepository.getById(1L).getName(), userFollowDto.getUser().getUserName());
        assertEquals(mockUserRepository.getById(2L).getName(), userFollowDto.getUserFollowed().getUserName());
        assertEquals(mockUserRepository.getById(1L).getFollowed().get(0), userFollowDto.getUserFollowed().getUserId());
    }

    @Test
    void givenIncorrectUserId_whenFollow_userToFollowDoesNotExists_throwsUserNotFoundException() {
        when(mockUserRepository.getById(1L)).thenReturn(user1);
        when(mockUserRepository.getById(2L)).thenReturn(null);

        assertThrows(UserNotFoundException.class, () -> userService.follow(1L, 2L));
        verify(mockUserRepository, times(1)).getById(1L);
        verify(mockUserRepository, times(1)).getById(2L);
    }

    @Test
    void givenCorrectUserId_whenCountFollowers_correctSize() {
        user2.getFollowers().add(1L);
        when(mockUserRepository.getById(2L)).thenReturn(user2);
        UserFollowersCountDTO userFollowersCountDto = userService.followersCount(2L);
        verify(mockUserRepository, times(1)).getById(2L);
        assertEquals(userFollowersCountDto.getFollowersCount(), mockUserRepository.getById(2L).getFollowers().size());
    }

    @Test
    void givenIncorrectUserId_whenCountFollowers_trowsUserNotFoundException() {
        when(mockUserRepository.getById(1L)).thenReturn(null);

        assertThrows(UserNotFoundException.class, () -> userService.followersCount(1L));
        verify(mockUserRepository, times(1)).getById(1L);
    }

    @Test
    void givenCorrectUserId_whenUnfollow_userToUnfollowExistsAndUnfollow() {
        when(mockUserRepository.getById(1L)).thenReturn(user1);
        when(mockUserRepository.getById(2L)).thenReturn(user2);

        UserFollowDTO userFollowDto = userService.follow(1L, 2L);
        assertEquals(mockUserRepository.getById(1L).getFollowed().get(0), userFollowDto.getUserFollowed().getUserId());

        UserUnfollowDTO userUnfollowDto = userService.unfollow(1L, 2L);
        assertTrue(mockUserRepository.getById(1L).getFollowed().isEmpty());

        verify(mockUserRepository, atLeast(2)).getById(1L);
        verify(mockUserRepository, atLeast(2)).getById(2L);
    }

    @Test
    void givenIncorrectUserId_whenUnfollow_userToUnfollowDoesNotExists_throwsUserNotFoundException() {
        when(mockUserRepository.getById(1L)).thenReturn(user1);
        when(mockUserRepository.getById(2L)).thenReturn(null);

        assertThrows(UserNotFoundException.class, () -> userService.unfollow(1L, 2L));
        verify(mockUserRepository, times(1)).getById(1L);
        verify(mockUserRepository, times(1)).getById(2L);
    }

    @Test
    void givenIncorrectUserId_whenUnfollow_usersDoNotFollowEachOther_throwsUserNotFollowException() {
        when(mockUserRepository.getById(1L)).thenReturn(user1);
        when(mockUserRepository.getById(2L)).thenReturn(user2);

        assertThrows(UserNotFollowException.class, () -> userService.unfollow(1L, 2L));
        verify(mockUserRepository, times(1)).getById(1L);
        verify(mockUserRepository, times(1)).getById(2L);
    }

    @Test
    void givenCorrectId_whenFollowersList_thenListOrderAsc() {
        user2.getFollowers().add(1L);
        user2.getFollowers().add(3L);

        when(mockUserRepository.getById(1L)).thenReturn(user1);
        when(mockUserRepository.getById(2L)).thenReturn(user2);
        when(mockUserRepository.getById(3L)).thenReturn(user3);

        UserFollowersListDTO followersListDto = userService.followersList(2L, NAME_ASC_ORDER);
        Comparator<UserDTO> comparator = Comparator.comparing(UserDTO::getUserName);

        assertTrue(Comparators.isInOrder(followersListDto.getFollowers(), comparator));
    }

    @Test
    void givenCorrectId_whenFollowersList_thenListOrderDesc() {
        user2.getFollowers().add(1L);
        user2.getFollowers().add(3L);

        when(mockUserRepository.getById(1L)).thenReturn(user1);
        when(mockUserRepository.getById(2L)).thenReturn(user2);
        when(mockUserRepository.getById(3L)).thenReturn(user3);

        UserFollowersListDTO followersListDto = userService.followersList(2L, NAME_DESC_ORDER);
        Comparator<UserDTO> comparator = Comparator.comparing(UserDTO::getUserName);

        assertFalse(Comparators.isInOrder(followersListDto.getFollowers(), comparator));
    }

    @Test
    void givenCorrectId_whenFollowedList_thenListOrderAsc() {
        user1.getFollowed().add(2L);
        user1.getFollowed().add(3L);

        when(mockUserRepository.getById(1L)).thenReturn(user1);
        when(mockUserRepository.getById(2L)).thenReturn(user2);
        when(mockUserRepository.getById(3L)).thenReturn(user3);

        UserFollowedListDTO followersListDto = userService.followedList(1L, NAME_ASC_ORDER);
        Comparator<UserDTO> comparator = Comparator.comparing(UserDTO::getUserName);

        assertTrue(Comparators.isInOrder(followersListDto.getFollowed(), comparator));
    }

    @Test
    void givenCorrectId_whenFollowedList_thenListOrderDesc() {
        user1.getFollowed().add(2L);
        user1.getFollowed().add(3L);

        when(mockUserRepository.getById(1L)).thenReturn(user1);
        when(mockUserRepository.getById(2L)).thenReturn(user2);
        when(mockUserRepository.getById(3L)).thenReturn(user3);

        UserFollowedListDTO followersListDto = userService.followedList(1L, NAME_DESC_ORDER);
        Comparator<UserDTO> comparator = Comparator.comparing(UserDTO::getUserName);

        assertFalse(Comparators.isInOrder(followersListDto.getFollowed(), comparator));
    }

    @Test
    void givenIncorrectUserId_whenFollowersList_throwsUserNotFoundException() {
        when(mockUserRepository.getById(1L)).thenReturn(null);

        assertThrows(UserNotFoundException.class, () -> userService.followersList(1L, NAME_ASC_ORDER));
        verify(mockUserRepository, times(1)).getById(1L);
    }

    @Test
    void givenIncorrectUserId_whenFollowed_throwsUserNotFoundException() {
        when(mockUserRepository.getById(1L)).thenReturn(null);

        assertThrows(UserNotFoundException.class, () -> userService.followedList(1L, NAME_ASC_ORDER));
        verify(mockUserRepository, times(1)).getById(1L);
    }
}