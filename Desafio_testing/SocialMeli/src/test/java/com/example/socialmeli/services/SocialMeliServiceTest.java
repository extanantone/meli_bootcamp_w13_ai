package com.example.socialmeli.services;

import com.example.socialmeli.dto.UserDTO;
import com.example.socialmeli.dto.response.CountFollowersResponseDTO;
import com.example.socialmeli.dto.response.FollowersResponseDTO;
import com.example.socialmeli.exceptions.UserAlreadyInUseException;
import com.example.socialmeli.exceptions.UserNotFoundException;
import com.example.socialmeli.exceptions.UserSelfUseException;
import com.example.socialmeli.model.User;
import com.example.socialmeli.repositories.PostRepository;
import com.example.socialmeli.repositories.UsuarioRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class SocialMeliServiceTest {
    @Mock
    UsuarioRepository usuarioRepository;
    @Mock
    PostRepository postRepository;
    @InjectMocks
    SocialMeliService socialMeliService;

    @AfterEach
    public void resetMock() {
        Mockito.reset(usuarioRepository);
        Mockito.reset(postRepository);
    }

    @Test
    @DisplayName("Verificar que el usuario a seguir exista")
    public void verifyThatTheUserToFollowExists() {
        //Arrange
        User follower = new User();
        follower.setUserId(1);
        follower.setUserName("Bl3nker");
        User followed = new User();
        followed.setUserId(2);
        followed.setUserName("Minujin");

        //When
        Mockito.when(usuarioRepository.findById(1)).thenReturn(Optional.of(follower));
        Mockito.when(usuarioRepository.findById(2)).thenReturn(Optional.of(followed));

        //Assert & Act
        assertDoesNotThrow(() -> socialMeliService.follow(1, 2));
        Mockito.verify(usuarioRepository, Mockito.times(1)).findById(1);
        Mockito.verify(usuarioRepository, Mockito.times(1)).findById(2);
        assertEquals(followed.getFollowersId().size(), 1);
    }

    @Test
    @DisplayName("Verificar que el usuario a seguir NO exista")
    public void verifyThatTheUserToFollowNotExists() {
        //Arrange
        User follower = new User();
        follower.setUserId(1);
        follower.setUserName("Bl3nker");

        //When
        Mockito.when(usuarioRepository.findById(1)).thenReturn(Optional.of(follower));
        Mockito.when(usuarioRepository.findById(2)).thenReturn(Optional.empty());

        //Assert && Act
        assertThrows(UserNotFoundException.class, () -> socialMeliService.follow(1, 2));
        Mockito.verify(usuarioRepository, Mockito.times(1)).findById(1);
        Mockito.verify(usuarioRepository, Mockito.times(1)).findById(2);
    }

    @Test
    @DisplayName("Verificar que el usuario a dejar de seguir exista")
    public void VerifyThatTheUserToUnfollowExists() throws UserNotFoundException, UserAlreadyInUseException, UserSelfUseException {
        //Arrange
        User user = new User();
        user.setUserId(1);
        user.setUserName("Bl3nker");
        User userToUnfollow = new User();
        userToUnfollow.setUserId(2);
        userToUnfollow.setUserName("Minujin");

        //When
        Mockito.when(usuarioRepository.findById(1)).thenReturn(Optional.of(user));
        Mockito.when(usuarioRepository.findById(2)).thenReturn(Optional.of(userToUnfollow));
        socialMeliService.follow(1, 2);

        //Act && Assert
        Mockito.verify(usuarioRepository, Mockito.atLeastOnce()).findById(2);
    }

    @Test
    @DisplayName("Verificar que el usuario a dejar de seguir no exista")
    public void VerifyThatTheUserToUnfollowNotExists() {
        //Arrange
        User follower = new User();
        follower.setUserId(1);
        follower.setUserName("Bl3nker");

        //Act
        Mockito.when(usuarioRepository.findById(1)).thenReturn(Optional.of(follower));
        Mockito.when(usuarioRepository.findById(2)).thenReturn(Optional.empty());

        //Act && Assert
        Assertions.assertThrows(UserNotFoundException.class, () -> socialMeliService.follow(1, 2));
    }

    @Test
    @DisplayName("Verificar que el tipo de ordenamiento alfabético exista")
    public void verifyThatTheAlphabeticalOrderingTypeExists() {
        Assertions.assertThrows(UserNotFoundException.class,
                () -> socialMeliService.getFollowers(1, null));
    }

    @Test
    @DisplayName("Verificar el correcto ordenamiento ascendente por nombre")
    public void verifyCorrectAscendingOrderingByName() throws UserNotFoundException {
        String order = "name_asc";
        Integer userId = 1;
        Integer follower1 = 2;
        Integer follower2 = 3;

        UserDTO followerDto = new UserDTO();
        followerDto.setUserId(follower1);
        followerDto.setUserName("Blenki");

        UserDTO followerDto2 = new UserDTO();
        followerDto2.setUserId(follower2);
        followerDto2.setUserName("Minujin");

        List<UserDTO> followersDTOs = new ArrayList<>();
        followersDTOs.add(followerDto);
        followersDTOs.add(followerDto2);

        FollowersResponseDTO expectativa = new FollowersResponseDTO();
        expectativa.setUserId(userId);
        expectativa.setUserName("Blenki");
        expectativa.setFollowers(followersDTOs);

        List<Integer> followersId = new ArrayList<>();
        followersId.add(follower1);
        followersId.add(follower2);
        User userMock = new User(userId, "Blenki", followersId);
        User followerMockOne = new User(follower1, "Blenki", new ArrayList<>());
        User followerMockTwo = new User(follower2, "Minujin", new ArrayList<>());

        // When
        Mockito.when(usuarioRepository.findById(userId)).thenReturn(Optional.of(userMock));
        Mockito.when(usuarioRepository.findById(follower1)).thenReturn(Optional.of(followerMockOne));
        Mockito.when(usuarioRepository.findById(follower2)).thenReturn(Optional.of(followerMockTwo));

        //Act
        FollowersResponseDTO realidad = socialMeliService.getFollowers(userId, order);

        //Assert
        Mockito.verify(usuarioRepository, Mockito.atLeast(4)).findById(Mockito.anyInt());
        Assertions.assertEquals(expectativa, realidad);
    }

    @Test
    @DisplayName("Verificar el correcto ordenamiento descendente por nombre")
    public void verifyCorrectDescendingOrderingByName() throws UserNotFoundException {

        String order = "name_des";
        Integer userId = 1;
        Integer follower1 = 2;
        Integer follower2 = 3;

        UserDTO followerDto = new UserDTO();
        followerDto.setUserId(follower1);
        followerDto.setUserName("Blenki");

        UserDTO followerDto2 = new UserDTO();
        followerDto2.setUserId(follower2);
        followerDto2.setUserName("Minujin");

        List<UserDTO> followersDTOs = new ArrayList<>();
        followersDTOs.add(followerDto);
        followersDTOs.add(followerDto2);

        FollowersResponseDTO expectativa = new FollowersResponseDTO();
        expectativa.setUserId(userId);
        expectativa.setUserName("Blenki");
        expectativa.setFollowers(followersDTOs);

        List<Integer> followersId = new ArrayList<>();
        followersId.add(follower1);
        followersId.add(follower2);
        User userMock = new User(userId, "Blenki", followersId);
        User followerMockOne = new User(follower1, "Blenki", new ArrayList<>());
        User followerMockTwo = new User(follower2, "Minujin", new ArrayList<>());

        // When
        Mockito.when(usuarioRepository.findById(userId)).thenReturn(Optional.of(userMock));
        Mockito.when(usuarioRepository.findById(follower1)).thenReturn(Optional.of(followerMockOne));
        Mockito.when(usuarioRepository.findById(follower2)).thenReturn(Optional.of(followerMockTwo));

        //Act
        FollowersResponseDTO realidad = socialMeliService.getFollowers(userId, order);

        //Assert
        Mockito.verify(usuarioRepository, Mockito.atLeast(4)).findById(Mockito.anyInt());
        Assertions.assertEquals(expectativa, realidad);

    }

    @Test
    @DisplayName("Verificar que el tipo de ordenamiento por fecha exista")
    public void verifyThatTheTypeOfSortingByDateExists(){


    }

    @Test
    @DisplayName("Verificar que la cantidad de seguidores de un determinado usuario sea correcta")
    public void countFollowers() throws UserNotFoundException {

        User follower = new User();
        follower.setUserId(3);
        follower.setUserName("Bl3nker");

        Mockito.when(usuarioRepository.findById(3)).thenReturn(Optional.of(follower));
        List<Integer> seguidores = new ArrayList<>() {{
            {
                {
                    {
                        add(2);
                        add(4);
                        add(1);
                        add(5);
                        add(6);
                    }
                }
            }
        }};
        follower.setFollowersId(seguidores);
        CountFollowersResponseDTO followerCountDTO = socialMeliService.countFollowers(3);

        assertEquals(seguidores.size(), followerCountDTO.getFollowersCount());
        Mockito.verify(usuarioRepository, Mockito.atLeastOnce()).findById(3);
    }
}
