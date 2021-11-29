package com.bootcamp.SocialMeli.unit.service.user;

import com.bootcamp.SocialMeli.dto.ResponseDTO;
import com.bootcamp.SocialMeli.dto.user.*;
import com.bootcamp.SocialMeli.exception.InvalidOrderException;
import com.bootcamp.SocialMeli.exception.UserNotFoundException;
import com.bootcamp.SocialMeli.model.User;
import com.bootcamp.SocialMeli.repository.ISocialMeliRepository;
import com.bootcamp.SocialMeli.service.user.UserService;
import com.google.common.collect.Comparators;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.bootcamp.SocialMeli.util.TestUtilsGenerator.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Comparator;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @Mock
    ISocialMeliRepository mockRepository;

    @InjectMocks
    UserService userService;

    private User mateo;
    private User pedro;

    private static final String ORDER_NAME_ASC = "name_asc";
    private static final String ORDER_NAME_DESC = "name_desc";
    private static final String ORDER_NOT_FOUND = "not_found";

    @BeforeEach
    void initializeUsers() {
        mateo = new User(1, "Mateo");
        pedro = new User(2, "Pedro");
    }

    // T-0001
    @Test
    void verifyUserToFollowExists() {
        // Arrange
        ResponseDTO expected = getResponseDTO("performed_action", "Acción Realizada");

        // When
        when(mockRepository.findUser(mateo.getUserId())).thenReturn(Optional.of(mateo));
        when(mockRepository.findUser(pedro.getUserId())).thenReturn(Optional.of(pedro));

        // Act
        ResponseDTO current = userService.follow(mateo.getUserId(), pedro.getUserId());

        // Assert
        verify(mockRepository, times(2)).findUser(anyInt());
        assertEquals(expected, current);
    }

    // T-0001
    @Test
    void verifyUserToFollowNotExists() {
        // When
        when(mockRepository.findUser(mateo.getUserId())).thenReturn(Optional.of(mateo));
        when(mockRepository.findUser(pedro.getUserId())).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(UserNotFoundException.class, () -> userService.follow(mateo.getUserId(), pedro.getUserId()));
        verify(mockRepository, times(2)).findUser(anyInt());
    }

    // T-0002
    @Test
    void verifyUserToUnfollowExists() {
        // Arrange
        follow(mateo, pedro);
        ResponseDTO expected = getResponseDTO("performed_action", "Acción Realizada");

        // When
        when(mockRepository.findUser(mateo.getUserId())).thenReturn(Optional.of(mateo));
        when(mockRepository.findUser(pedro.getUserId())).thenReturn(Optional.of(pedro));

        // Act
        ResponseDTO current = userService.unfollow(mateo.getUserId(), pedro.getUserId());

        // Assert
        verify(mockRepository, times(2)).findUser(anyInt());
        assertEquals(expected, current);
    }

    // T-0002
    @Test
    void verifyUserToUnfollowNotExists() {
        // When
        when(mockRepository.findUser(mateo.getUserId())).thenReturn(Optional.of(mateo));
        when(mockRepository.findUser(pedro.getUserId())).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(UserNotFoundException.class, () -> userService.unfollow(mateo.getUserId(), pedro.getUserId()));
        verify(mockRepository, times(2)).findUser(anyInt());
    }

    // T-0003
    @Test
    void verifyAlphabeticalOrderingTypeOfFollowersListExists() {
        // When
        when(mockRepository.findUser(mateo.getUserId())).thenReturn(Optional.of(mateo));

        // Act & Assert
        assertAll(
                () -> assertDoesNotThrow(() -> userService.followersList(mateo.getUserId(), ORDER_NAME_ASC)),
                () -> assertDoesNotThrow(() -> userService.followersList(mateo.getUserId(), ORDER_NAME_DESC)));
        verify(mockRepository, times(2)).findUser(anyInt());
    }

    // T-0003
    @Test
    void verifyAlphabeticalOrderingTypeOfFollowersListNotExists() {
        // When
        when(mockRepository.findUser(mateo.getUserId())).thenReturn(Optional.of(mateo));

        // Act & Assert
        assertThrows(InvalidOrderException.class, () -> userService.followersList(mateo.getUserId(), ORDER_NOT_FOUND));
        verify(mockRepository, times(1)).findUser(anyInt());
    }

    // T-0003
    @Test
    void verifyAlphabeticalOrderingTypeOfFollowedListExists() {
        // When
        when(mockRepository.findUser(mateo.getUserId())).thenReturn(Optional.of(mateo));

        // Act & Assert
        assertAll(
                () -> assertDoesNotThrow(() -> userService.followedList(mateo.getUserId(), ORDER_NAME_ASC)),
                () -> assertDoesNotThrow(() -> userService.followedList(mateo.getUserId(), ORDER_NAME_DESC)));
        verify(mockRepository, times(2)).findUser(anyInt());
    }

    // T-0003
    @Test
    void verifyAlphabeticalOrderingTypeOfFollowedListNotExists() {
        // When
        when(mockRepository.findUser(mateo.getUserId())).thenReturn(Optional.of(mateo));

        // Act & Assert
        assertThrows(InvalidOrderException.class, () -> userService.followedList(mateo.getUserId(), ORDER_NOT_FOUND));
        verify(mockRepository, times(1)).findUser(anyInt());
    }

    // T-0004
    @Test
    void verifyAscendingOrderingByNameOfFollowersList() {
        // Arrange
        addFollowers(mateo);
        Comparator<UserDTO> comparator = Comparator.comparing(UserDTO::getUserName);

        // When
        when(mockRepository.findUser(mateo.getUserId())).thenReturn(Optional.of(mateo));

        // Act
        UserFollowersListDTO followersListDTO = userService.followersList(mateo.getUserId(), ORDER_NAME_ASC);

        // Assert
        verify(mockRepository, times(1)).findUser(anyInt());
        assertTrue(Comparators.isInOrder(followersListDTO.getFollowers(), comparator));
    }

    // T-0004
    @Test
    void verifyDescendingOrderingByNameOfFollowersList() {
        // Arrange
        addFollowers(mateo);
        Comparator<UserDTO> comparator = Comparator.comparing(UserDTO::getUserName);

        // When
        when(mockRepository.findUser(mateo.getUserId())).thenReturn(Optional.of(mateo));

        // Act
        UserFollowersListDTO followersListDTO = userService.followersList(mateo.getUserId(), ORDER_NAME_DESC);

        // Assert
        verify(mockRepository, times(1)).findUser(anyInt());
        assertFalse(Comparators.isInOrder(followersListDTO.getFollowers(), comparator));
    }

    // T-0004
    @Test
    void verifyAscendingOrderingByNameOfFollowedList() {
        // Arrange
        addFollowed(pedro);
        Comparator<UserDTO> comparator = Comparator.comparing(UserDTO::getUserName);

        // When
        when(mockRepository.findUser(pedro.getUserId())).thenReturn(Optional.of(pedro));

        // Act
        UserFollowedListDTO followedListDTO = userService.followedList(pedro.getUserId(), ORDER_NAME_ASC);

        // Assert
        verify(mockRepository, times(1)).findUser(anyInt());
        assertTrue(Comparators.isInOrder(followedListDTO.getFollowed(), comparator));
    }

    // T-0004
    @Test
    void verifyDescendingOrderingByNameOfFollowedList() {
        // Arrange
        addFollowed(pedro);
        Comparator<UserDTO> comparator = Comparator.comparing(UserDTO::getUserName);

        // When
        when(mockRepository.findUser(pedro.getUserId())).thenReturn(Optional.of(pedro));

        // Act
        UserFollowedListDTO followedListDTO = userService.followedList(pedro.getUserId(), ORDER_NAME_DESC);

        // Assert
        verify(mockRepository, times(1)).findUser(anyInt());
        assertFalse(Comparators.isInOrder(followedListDTO.getFollowed(), comparator));
    }

    // T-0007
    @Test
    void verifyNumberOfFollowersOfAUser() {
        // Arrange
        addFollowers(mateo);

        // When
        when(mockRepository.findUser(mateo.getUserId())).thenReturn(Optional.of(mateo));

        // Act
        UserFollowersCountDTO userFollowersCountDTO = userService.followersCount(mateo.getUserId());

        // Assert
        verify(mockRepository, times(1)).findUser(anyInt());
        assertEquals(mateo.getFollowers().size(), userFollowersCountDTO.getFollowersCount());
    }
}