package com.bootcamp.SocialMeli.unit.service;

import com.bootcamp.SocialMeli.dto.response.SuccessDTO;
import com.bootcamp.SocialMeli.exception.*;
import com.bootcamp.SocialMeli.model.Producto;
import com.bootcamp.SocialMeli.model.Publicacion;
import com.bootcamp.SocialMeli.model.Usuario;
import com.bootcamp.SocialMeli.repository.ISocialMeliRepository;
import com.bootcamp.SocialMeli.service.SocialMeliService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SocialMeliServiceTest {

    @Mock
    private ISocialMeliRepository mockRepository;

    @InjectMocks
    private SocialMeliService service;

    private static Usuario userAlan, userNico, sellerEdwin;
    private static Producto camisetaBoca;
    private static Publicacion pubEdwin;

    @BeforeEach
    public void setup(){
        userAlan = new Usuario();
        userAlan.setUserId(1);
        userAlan.setUserName("Alan Varela");

        userNico = new Usuario();
        userNico.setUserId(3);
        userNico.setUserName("Nicolas Orsini");

        sellerEdwin = new Usuario();
        sellerEdwin.setUserId(2);
        sellerEdwin.setUserName("Edwin Cardona");
        camisetaBoca = new Producto(2, "Camiseta Boca Juniors", "Camiseta deportiva", "Adidas", "Blue and Yellow", "Camiseta jugador oficial, talle XL");
        pubEdwin = new Publicacion(5, LocalDate.now(), 1234.0, camisetaBoca, 111);
        sellerEdwin.getPublicaciones().add(pubEdwin);

    }
//Arrange

    //Act

    //Assert

    //Verificar que el usuario a seguir exista.
    @Test
    void followExistingUserThatNotfollowBefore(){
        //Arrange
        Integer idSeguidor = 1;
        Integer idVendedor = 2;
        SuccessDTO msjExpected = new SuccessDTO("Followed successfully");

        //Act  SuccessDTO followVendedor(Integer idSeguidor, Integer idVendedor){
        when(mockRepository.buscarUsuario(idSeguidor)).thenReturn(userAlan);
        when(mockRepository.buscarUsuario(idVendedor)).thenReturn(sellerEdwin);
        SuccessDTO msjCurrent = this.service.followVendedor(idSeguidor,idVendedor);

        //Assert
        Assertions.assertAll(
                () -> Assertions.assertTrue(userAlan.getVendedoresSeguidos().contains(sellerEdwin)),
                () -> Assertions.assertTrue(sellerEdwin.getSeguidores().contains(userAlan)),
                () -> Assertions.assertEquals(msjExpected.getClass(), msjCurrent.getClass()),
                () -> Assertions.assertEquals(msjExpected.getMensaje(), msjCurrent.getMensaje())
        );

        verify(mockRepository, atLeast(2)).buscarUsuario(any());
    }

    @Test
    void followWithUserFollowerNotFoundThenUserNotFoundException(){
        //Arrange
        Integer idSeguidor = 1111;
        Integer idVendedor = 2;

        //Act and Assert
        when(mockRepository.buscarUsuario(idSeguidor)).thenReturn(null);
        when(mockRepository.buscarUsuario(idVendedor)).thenReturn(sellerEdwin);
        Assertions.assertThrows(UserNotFoundException.class, () -> this.service.followVendedor(idSeguidor,idVendedor));

        verify(mockRepository, atLeast(2)).buscarUsuario(any());
    }

    @Test
    void followWithSellerFollowedNotFoundThenUserNotFoundException(){
        //Arrange
        Integer idSeguidor = 1;
        Integer idVendedor = 2222;

        //Act and Assert
        when(mockRepository.buscarUsuario(idSeguidor)).thenReturn(userAlan);
        when(mockRepository.buscarUsuario(idVendedor)).thenReturn(null);
        Assertions.assertThrows(UserNotFoundException.class, () -> this.service.followVendedor(idSeguidor,idVendedor));

        verify(mockRepository, atLeast(2)).buscarUsuario(any());
    }

    @Test
    void followAlreadyFollowedUserThenAlreadyFollowException(){
        //Arrange
        Integer idSeguidor = 1;
        Integer idVendedor = 2;
        userAlan.getVendedoresSeguidos().add(sellerEdwin);
        sellerEdwin.getSeguidores().add(userAlan);

        //Act and Assert
        when(mockRepository.buscarUsuario(idSeguidor)).thenReturn(userAlan);
        when(mockRepository.buscarUsuario(idVendedor)).thenReturn(sellerEdwin);
        Assertions.assertThrows(AlreadyFollowException.class, () -> this.service.followVendedor(idSeguidor, idVendedor));

        verify(mockRepository, atLeast(2)).buscarUsuario(any());
    }

    @Test
    void followNotSellerUserThenUserNotSellerException(){
        //Arrange
        Integer idSeguidor1 = 1;
        Integer idSeguidor2 = 3;

        //Act and Assert
        when(mockRepository.buscarUsuario(idSeguidor1)).thenReturn(userAlan);
        when(mockRepository.buscarUsuario(idSeguidor2)).thenReturn(userNico);
        Assertions.assertThrows(UserNotSellerException.class, () -> this.service.followVendedor(idSeguidor1, idSeguidor2));

        verify(mockRepository, atLeast(2)).buscarUsuario(any());
    }

    @Test
    void followYourselfThenEqualsUserSellerException(){
        //Arrange
        Integer idSeguidor = 1;

        //Act and Assert
        when(mockRepository.buscarUsuario(idSeguidor)).thenReturn(userAlan);
        Assertions.assertThrows(EqualsUserSellerException.class, () -> this.service.followVendedor(idSeguidor, idSeguidor));

        verify(mockRepository, atLeast(2)).buscarUsuario(idSeguidor);
    }

    @Test
    void unfollowExistingUserThatfollowedBefore(){
        //Arrange
        Integer idSeguidor = 1;
        Integer idVendedor = 2;
        userAlan.getVendedoresSeguidos().add(sellerEdwin);
        sellerEdwin.getSeguidores().add(userAlan);
        SuccessDTO msjExpected = new SuccessDTO("Unfollowed successfully");

        //Act
        when(mockRepository.buscarUsuario(idSeguidor)).thenReturn(userAlan);
        when(mockRepository.buscarUsuario(idVendedor)).thenReturn(sellerEdwin);
        SuccessDTO msjCurrent = this.service.unfollowVendedor(idSeguidor,idVendedor);

        //Assert
        Assertions.assertAll(
                () -> Assertions.assertFalse(userAlan.getVendedoresSeguidos().contains(sellerEdwin)),
                () -> Assertions.assertFalse(sellerEdwin.getSeguidores().contains(userAlan)),
                () -> Assertions.assertEquals(msjExpected.getClass(), msjCurrent.getClass()),
                () -> Assertions.assertEquals(msjExpected.getMensaje(), msjCurrent.getMensaje())
        );

        verify(mockRepository, atLeast(2)).buscarUsuario(any());
    }

    @Test
    void unfollowWithUserFollowerNotFoundThenUserNotFoundException(){
        //Arrange
        Integer idSeguidor = 1111;
        Integer idVendedor = 2;

        //Act and Assert
        when(mockRepository.buscarUsuario(idSeguidor)).thenReturn(null);
        when(mockRepository.buscarUsuario(idVendedor)).thenReturn(sellerEdwin);
        Assertions.assertThrows(UserNotFoundException.class, () -> this.service.unfollowVendedor(idSeguidor,idVendedor));

        verify(mockRepository, atLeast(2)).buscarUsuario(any());
    }

    @Test
    void unfollowWithSellerFollowedNotFoundThenUserNotFoundException(){
        //Arrange
        Integer idSeguidor = 1;
        Integer idVendedor = 2222;

        //Act and Assert
        when(mockRepository.buscarUsuario(idSeguidor)).thenReturn(userAlan);
        when(mockRepository.buscarUsuario(idVendedor)).thenReturn(null);
        Assertions.assertThrows(UserNotFoundException.class, () -> this.service.unfollowVendedor(idSeguidor,idVendedor));

        verify(mockRepository, atLeast(2)).buscarUsuario(any());
    }

    @Test
    void unfollowNotFollowedUserThenNotFollowException(){
        //Arrange
        Integer idSeguidor = 1;
        Integer idVendedor = 2;

        //Act and Assert
        when(mockRepository.buscarUsuario(idSeguidor)).thenReturn(userAlan);
        when(mockRepository.buscarUsuario(idVendedor)).thenReturn(sellerEdwin);
        Assertions.assertThrows(NotFollowException.class, () -> this.service.unfollowVendedor(idSeguidor, idVendedor));

        verify(mockRepository, atLeast(2)).buscarUsuario(any());
    }

    @Test
    void unfollowYourselfThenEqualsUserSellerException(){
        //Arrange
        Integer idSeguidor = 1;

        //Act and Assert
        when(mockRepository.buscarUsuario(idSeguidor)).thenReturn(userAlan);
        Assertions.assertThrows(EqualsUserSellerException.class, () -> this.service.unfollowVendedor(idSeguidor, idSeguidor));

        verify(mockRepository, atLeast(2)).buscarUsuario(idSeguidor);
    }

}
