package controller;

import com.SocialMeli.SocialMeli.controller.UserController;
import com.SocialMeli.SocialMeli.dto.SellersDTO;
import com.SocialMeli.SocialMeli.dto.UserDTO;
import com.SocialMeli.SocialMeli.repository.UserRepository;
import com.SocialMeli.SocialMeli.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("Comprobando la llamada a seguir un vendedor")
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
    @DisplayName("Comprobando la llamada para dejar de seguir a un vendedor")
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
    @DisplayName("Con parámetro de order")
    void checkingSortedAlphaTypeSellers(){
        // Arrange
        String order = "name_asc";
        Integer user_id = 1;

        // Act
        controller.followersListSorted(user_id,order);

        // Assert
        verify(serviceMock, atLeastOnce()).followersListSorted(user_id,order);

    }

    @Test
    @DisplayName("Sin parámetro de order")
    void checkingSortedAlphaTypeSellersWithoutOrder(){
        // Arrange
        Integer user_id = 1;

        // Act
        controller.followersListSorted(user_id,null);

        // Assert
        verify(serviceMock, atLeastOnce()).followersListSorted(user_id,null);

    }


    @Test
    @DisplayName("Ordenamiento de fecha con parámetro de order")
    void checkingSortedDateTypeSellers(){
        // Arrange
        String order = "name_asc";
        Integer user_id = 1;

        // Act
        controller.postListParam(user_id,order);

        // Assert
        verify(serviceMock, atLeastOnce()).postList(user_id,order);

    }

    @Test
    @DisplayName("Ordenamiento de fecha sin parámetro de order")
    void checkingSortedDateTypeSellersWithoutOrder(){
        // Arrange
        Integer user_id = 1;

        // Act
        controller.postListParam(user_id,null);

        // Assert
        verify(serviceMock, atLeastOnce()).postList(user_id,null);

    }

    @Test
    @DisplayName("Verificando que la cantidad de seguidores sea la correcta")
    void checkingAmountFollowersFromSellers(){
        // Arrange
        Integer user_id = 0;

        // Act
        controller.followersCount(user_id);

        // Assert
        verify(serviceMock, atLeastOnce()).followersCount(user_id);

    }

    @Test
    @DisplayName("Verificando los últimos posts de un vendedor de las últimas 2 semanas")
    void checkingLastDatePostsByUser(){
        // Arrange
        Integer user_id = 1;
        String order = "date_desc";

        // Act
        controller.postList(user_id);

        // Assert
        verify(serviceMock, atLeastOnce()).postList(user_id,order);

    }
}
