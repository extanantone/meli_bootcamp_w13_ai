package controller;

import com.SocialMeli.SocialMeli.controller.UserController;
import com.SocialMeli.SocialMeli.dto.SellersDTO;
import com.SocialMeli.SocialMeli.dto.UserDTO;
import com.SocialMeli.SocialMeli.repository.UserRepository;
import com.SocialMeli.SocialMeli.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import util.TestUtilGenerator;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    // mock
    @Mock
    UserService serviceMock;

    @InjectMocks
    UserController controller;


    @Test
    void userFollowedCalled(){
        // Arrange
        Integer user_id = 1;
        Integer user_id_to_follow = 2;

        // Act
        controller.followUser(user_id, user_id_to_follow);

        // Assert
        verify(serviceMock, atLeastOnce()).followUser(user_id, user_id_to_follow);

    }

    @Test
    void userUnfollowedCalled(){
        // Arrange
        Integer user_id = 1;
        Integer user_id_to_follow = 2;

        // Act
        controller.unfollowUser(user_id, user_id_to_follow);

        // Assert
        verify(serviceMock, atLeastOnce()).unfollowUser(user_id, user_id_to_follow);

    }

    // Siempre va a retornar el usuario sin importar si le envìa o no el order
    // al igual si el usuario escribe mal el order
    @Test
    void checkingSortedAlphaTypeSellers(){
        // Arrange
        String order = "name_asc";
        Integer user_id = 1;

        // Act
        controller.followersListSorted(user_id,order);

        // Assert
        verify(serviceMock, atLeastOnce()).followersListSorted(user_id,order);

    }
}
