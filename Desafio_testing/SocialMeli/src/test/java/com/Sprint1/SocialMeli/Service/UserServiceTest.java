package com.Sprint1.SocialMeli.Service;

import com.Sprint1.SocialMeli.DTO.UserFollowersCountDTO;
import com.Sprint1.SocialMeli.DTO.UserFollowersListDTO;
import com.Sprint1.SocialMeli.DTO.UserShortDTO;
import com.Sprint1.SocialMeli.Exceptions.BadRequestExcepcion;
import com.Sprint1.SocialMeli.Exceptions.UserNotFoundException;
import com.Sprint1.SocialMeli.Model.User;
import com.Sprint1.SocialMeli.Repository.UserRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepositoryImpl mockUserRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void existeUsuarioASeguir() {
        //Arrange
        int userId = 1;
        int userIdToFollow = 2;
        User usuario = new User();
        usuario.setUserId(userIdToFollow);
        usuario.setIsSeller(true);

        when(mockUserRepository.existeUsuario(userId)).thenReturn(true);
        when(mockUserRepository.existeUsuario(userIdToFollow)).thenReturn(true);
        when(mockUserRepository.existeFollowed(userId, userIdToFollow)).thenReturn(false);
        when(mockUserRepository.obtenerUsuario(userIdToFollow)).thenReturn(usuario);
        when(mockUserRepository.agregarFollowed(userId, userIdToFollow)).thenReturn(true);

        //Act
        Boolean result = userService.agregarFollowed(userId, userIdToFollow);

        //Assert
        assertAll(
                ()->assertTrue(result),
                ()->verify(mockUserRepository, atLeastOnce()).agregarFollowed(userId, userIdToFollow)
        );
    }

    @Test
    void esMismoUsuario() {
        //Arrange
        int userId = 1;
        int userIdToFollow = 1;
        User usuario = new User();
        usuario.setUserId(userIdToFollow);
        usuario.setIsSeller(true);

        when(mockUserRepository.existeUsuario(userId)).thenReturn(true);
        when(mockUserRepository.existeUsuario(userIdToFollow)).thenReturn(true);
        when(mockUserRepository.obtenerUsuario(userIdToFollow)).thenReturn(usuario);

        //Act Assert
        assertThrows(BadRequestExcepcion.class, () -> userService.agregarFollowed(userId, userIdToFollow));
    }

    @Test
    void noExisteUsuarioASeguir() {
        //Arrange
        int userId = 1;
        int userIdToFollow = 2;

        when(mockUserRepository.existeUsuario(userId)).thenReturn(true);
        when(mockUserRepository.existeUsuario(userIdToFollow)).thenReturn(false);

        //Act Assert
        //TODO: BORRAR:
        //assertAll(
        //        ()->assertThrows(UserNotFoundException.class, () -> userService.agregarFollowed(userId, userIdToFollow)),
        //        ()->verify(mockUserRepository, atLeastOnce()).agregarFollowed(userId, userIdToFollow)
        //);

        assertThrows(UserNotFoundException.class, () -> userService.agregarFollowed(userId, userIdToFollow));
    }

    @Test
    void existeUsuarioADejarDeSeguir() {
        //Arrange
        int userId = 1;
        int userIdToUnfollow = 2;

        when(mockUserRepository.existeUsuario(userId)).thenReturn(true);
        when(mockUserRepository.existeUsuario(userIdToUnfollow)).thenReturn(true);
        when(mockUserRepository.existeFollowed(userId, userIdToUnfollow)).thenReturn(true);
        when(mockUserRepository.quitarFollowed(userId, userIdToUnfollow)).thenReturn(true);

        //Act
        Boolean result = userService.quitarFollowed(userId, userIdToUnfollow);

        //Assert
        assertAll(
                ()->assertTrue(result),
                ()->verify(mockUserRepository, atLeastOnce()).quitarFollowed(userId, userIdToUnfollow)
        );
    }

    @Test
    void noExisteUsuarioADejarDeSeguir() {
        //Arrange
        int userId = 1;
        int userIdToFollow = 2;

        when(mockUserRepository.existeUsuario(userId)).thenReturn(true);
        when(mockUserRepository.existeUsuario(userIdToFollow)).thenReturn(false);

        //Act Assert
        assertThrows(UserNotFoundException.class, () -> userService.quitarFollowed(userId, userIdToFollow));
    }

    @Test
    void existeOrdenamientoNombre() {
        //Arrange
        int userId = 1;
        String order = "name_asc";
        User usuario = new User();
        usuario.setUserId(userId);
        usuario.setIsSeller(true);
        List<UserShortDTO> listaSeguidores = new ArrayList<>();
        UserShortDTO usuarioDTO1 = new UserShortDTO(1, "AUserName");
        UserShortDTO usuarioDTO2 = new UserShortDTO(2, "MUserName");
        UserShortDTO usuarioDTO3 = new UserShortDTO(3, "ZUserName");
        listaSeguidores.add(usuarioDTO1); listaSeguidores.add(usuarioDTO2); listaSeguidores.add(usuarioDTO3);

        when(mockUserRepository.existeUsuario(userId)).thenReturn(true);
        when(mockUserRepository.obtenerUsuario(userId)).thenReturn(usuario);
        when(mockUserRepository.obtenerListaSeguidores(userId)).thenReturn(listaSeguidores);

        //Act
        UserFollowersListDTO result = userService.obtenerUserFollowersList(userId, order);

        //Assert
        assertAll(
                ()->assertNotNull(result),
                ()->verify(mockUserRepository, atLeastOnce()).obtenerListaSeguidores(userId)
        );
    }

    @Test
    //Es de esperar que este test falle, ya que en el código original si Order es null,
    //se devuelve la lista de seguidores tal como llega desde el Repository y no lanza excepcion
    void noExisteOrdenamientoNombre() {
        //Arrange
        int userId = 1;
        String order = null;
        User usuario = new User();
        usuario.setUserId(userId);
        usuario.setIsSeller(true);
        List<UserShortDTO> listaSeguidores = new ArrayList<>();
        UserShortDTO usuarioDTO1 = new UserShortDTO(1, "AUserName");
        UserShortDTO usuarioDTO2 = new UserShortDTO(2, "MUserName");
        UserShortDTO usuarioDTO3 = new UserShortDTO(3, "ZUserName");
        listaSeguidores.add(usuarioDTO1); listaSeguidores.add(usuarioDTO2); listaSeguidores.add(usuarioDTO3);

        when(mockUserRepository.existeUsuario(userId)).thenReturn(true);
        when(mockUserRepository.obtenerUsuario(userId)).thenReturn(usuario);
        when(mockUserRepository.obtenerListaSeguidores(userId)).thenReturn(listaSeguidores);

        //Act & Assert
        //Expected java.lang.RuntimeException to be thrown, but nothing was thrown.
        assertAll(
                ()->assertThrows(RuntimeException.class, () -> userService.obtenerUserFollowersList(userId, order)),
                ()->verify(mockUserRepository, atLeastOnce()).obtenerListaSeguidores(userId)
        );
    }

    @Test
    void verificaOrdenaminetoAscendente() {
        //Arrange
        int userId = 1;
        String order = "name_asc";
        User usuario = new User();
        usuario.setUserId(userId);
        usuario.setUserName("Andres");
        usuario.setIsSeller(true);

        UserShortDTO usuarioDTO1 = new UserShortDTO(1, "MUserName");
        UserShortDTO usuarioDTO2 = new UserShortDTO(2, "ZUserName");
        UserShortDTO usuarioDTO3 = new UserShortDTO(3, "AUserName");

        List<UserShortDTO> listaSeguidores = new ArrayList<>();
        listaSeguidores.add(usuarioDTO1); listaSeguidores.add(usuarioDTO2); listaSeguidores.add(usuarioDTO3);

        when(mockUserRepository.existeUsuario(userId)).thenReturn(true);
        when(mockUserRepository.obtenerUsuario(userId)).thenReturn(usuario);
        when(mockUserRepository.obtenerListaSeguidores(userId)).thenReturn(listaSeguidores);

        //Act
        UserFollowersListDTO result = userService.obtenerUserFollowersList(userId, order);

        //Assert
        assertAll(
                ()->assertEquals("AUserName", result.getFollowers().get(0).getUserName()),
                ()->assertEquals("MUserName", result.getFollowers().get(1).getUserName()),
                ()->assertEquals("ZUserName", result.getFollowers().get(2).getUserName()),
                ()->verify(mockUserRepository, atLeastOnce()).obtenerListaSeguidores(userId)
        );
    }

    @Test
    void verificaOrdenaminetoDescendente() {
        //Arrange
        int userId = 1;
        String order = "name_desc";
        User usuario = new User();
        usuario.setUserId(userId);
        usuario.setUserName("Andres");
        usuario.setIsSeller(true);

        UserShortDTO usuarioDTO1 = new UserShortDTO(1, "MUserName");
        UserShortDTO usuarioDTO2 = new UserShortDTO(2, "AUserName");
        UserShortDTO usuarioDTO3 = new UserShortDTO(3, "ZUserName");

        List<UserShortDTO> listaSeguidores = new ArrayList<>();
        listaSeguidores.add(usuarioDTO1); listaSeguidores.add(usuarioDTO2); listaSeguidores.add(usuarioDTO3);

        when(mockUserRepository.existeUsuario(userId)).thenReturn(true);
        when(mockUserRepository.obtenerUsuario(userId)).thenReturn(usuario);
        when(mockUserRepository.obtenerListaSeguidores(userId)).thenReturn(listaSeguidores);

        //Act
        UserFollowersListDTO result = userService.obtenerUserFollowersList(userId, order);

        //Assert
        assertAll(
                ()->assertEquals("ZUserName", result.getFollowers().get(0).getUserName()),
                ()->assertEquals("MUserName", result.getFollowers().get(1).getUserName()),
                ()->assertEquals("AUserName", result.getFollowers().get(2).getUserName()),
                ()->verify(mockUserRepository, atLeastOnce()).obtenerListaSeguidores(userId)
        );
    }

    @Test
    void verificaCantSeguidores() {
        //Arrange
        int cantSeguidores = 3;
        int userId = 1;
        User usuario = new User();
        usuario.setUserId(userId);
        usuario.setIsSeller(true);

        when(mockUserRepository.existeUsuario(userId)).thenReturn(true);
        when(mockUserRepository.obtenerUsuario(userId)).thenReturn(usuario);
        when(mockUserRepository.obtenerCantSeguidores(userId)).thenReturn(cantSeguidores);

        //Act
        UserFollowersCountDTO result = userService.obtenerUserFollowersCount(userId);

        //Assert
        assertAll(
                ()->assertEquals(cantSeguidores, result.getFollowersCount()),
                ()->verify(mockUserRepository, atLeastOnce()).obtenerCantSeguidores(userId)
        );
    }
}
