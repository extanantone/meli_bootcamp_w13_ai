package com.bootcamp.SocialMeli.unit.service;

import com.bootcamp.SocialMeli.dto.response.*;
import com.bootcamp.SocialMeli.exception.*;
import com.bootcamp.SocialMeli.mapper.Mapper;
import com.bootcamp.SocialMeli.model.Producto;
import com.bootcamp.SocialMeli.model.Publicacion;
import com.bootcamp.SocialMeli.model.Usuario;
import com.bootcamp.SocialMeli.repository.ISocialMeliRepository;
import com.bootcamp.SocialMeli.service.SocialMeliService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SocialMeliServiceTest {

    @Mock
    private ISocialMeliRepository mockRepository;

    @InjectMocks
    private SocialMeliService service = new SocialMeliService(mockRepository, new Mapper());

    private static Usuario userAlan, userNico, sellerEdwin, sellerLiso, userFrank, userCali, userChelo, sellerToto;
    private static Producto camisetaBoca, samsungFit2, noteDell, zapasNike, noteLenovo, pendriveSanDisk;
    private static Publicacion pubCamisetaBoca, pubSamsungFit2, pubNoteDell, pubZapasNike, pubNoteLenovo, pubSanDisk;

    @BeforeEach
    public void setup(){
        //usuarios
        userAlan = new Usuario(1, "Alan Varela");
        userNico = new Usuario(3, "Nicolas Orsini");
        userFrank = new Usuario(5, "Frank Fabra");
        userCali = new Usuario(6, "Carlos Izquierdoz");
        userChelo = new Usuario(7, "Chelo Weigandt");

        //vendedores
        sellerEdwin = new Usuario(2, "Edwin Cardona");
        sellerLiso = new Usuario(4, "Lisandro Lopez");
        sellerToto = new Usuario(8, "Toto Salvio");

        //productos y publicaciones
        camisetaBoca = new Producto(2, "Camiseta Boca Juniors", "Camiseta deportiva", "Adidas", "Blue and Yellow", "Camiseta jugador oficial, talle XL");
        pubCamisetaBoca = new Publicacion(5, LocalDate.now(), 1234.0, camisetaBoca, 111);
        samsungFit2 = new Producto(4, "Samsung Galaxy Fit 2", "Smartbands and Smartwatches", "Samsung", "Black or Grey", "con Bluetooth, pantalla AMOLED, bateria 15 dias de duracion");
        pubSamsungFit2 = new Publicacion(7, LocalDate.of(2021, 11,20), 444.0, samsungFit2, 132);
        noteDell = new Producto(7, "Notebook Dell", "Notebook", "Dell Inspiron 3505","Grey","AMD Ryzen 5, pantalla 15.6, 8GB de RAM, 256GB SSD, W10 Home");
        pubNoteDell = new Publicacion(9, LocalDate.of(2021, 11, 15), 599.5, noteDell, 101);
        zapasNike = new Producto(11,"Zapatillas deportivas","Running", "Nike", "Black and White","Ideales para salir a correr");
        pubZapasNike = new Publicacion(11, LocalDate.of(2021,11,12), 255.5, zapasNike, 112);
        noteLenovo = new Producto(4, "Notebook Lenovo","Notebook","Lenovo IdeaPad","Blue and Grey","Intel Core I3, pantalla táctil 15.6, 8GB de RAM, 256GB SSD");
        pubNoteLenovo = new Publicacion(15, LocalDate.of(2021,11,13),780.2, noteLenovo,101);
        pendriveSanDisk = new Producto(10, "Pendrive SanDisk", "Pendrives", "SanDisk Ultra Flair", "Grey","capacidad 16GB, 3.0");
        pubSanDisk = new Publicacion(6, LocalDate.of(2021, 10, 5), 100.2, pendriveSanDisk, 99);

        //vinculos vendedores - publicaciones
        sellerEdwin.getPublicaciones().add(pubCamisetaBoca);
        sellerLiso.getPublicaciones().add(pubSamsungFit2);
        sellerLiso.getPublicaciones().add(pubZapasNike);
        sellerToto.getPublicaciones().add(pubNoteDell);
        sellerToto.getPublicaciones().add(pubNoteLenovo);
        sellerToto.getPublicaciones().add(pubSanDisk);

    }

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

        verify(mockRepository, times(2)).buscarUsuario(anyInt());
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

        verify(mockRepository, atLeast(2)).buscarUsuario(anyInt());
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

        verify(mockRepository, atLeast(2)).buscarUsuario(anyInt());
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

        verify(mockRepository, atLeast(2)).buscarUsuario(anyInt());
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

        verify(mockRepository, atLeast(2)).buscarUsuario(anyInt());
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

        verify(mockRepository, atLeast(2)).buscarUsuario(anyInt());
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

        verify(mockRepository, atLeast(2)).buscarUsuario(anyInt());
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

        verify(mockRepository, atLeast(2)).buscarUsuario(anyInt());
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

        verify(mockRepository, atLeast(2)).buscarUsuario(anyInt());
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

    @Test
    @DisplayName("Test seguidores ordenados por nombre ascendente")
    void getFollowersFromExistingSellerOrderByNameAsc(){
        //Arrange
        Integer idVendedor = sellerLiso.getUserId();
        String order = "name_asc";

        sellerLiso.getSeguidores().addAll(List.of(userFrank, userCali, userChelo, userAlan));

        //Act
        when(mockRepository.buscarUsuario(idVendedor)).thenReturn(sellerLiso);
        SeguidoresDTO seguidoresCurrent = service.getSeguidores(idVendedor, order);

        //Assert
        Assertions.assertAll(
                () -> Assertions.assertEquals(sellerLiso.getUserId(), seguidoresCurrent.getUserId()),
                () -> Assertions.assertEquals(sellerLiso.getUserName(), seguidoresCurrent.getUserName()),
                () -> {for(int i = 0; i < seguidoresCurrent.getFollowers().size()-1; i++){
                            String nameMenor = seguidoresCurrent.getFollowers().get(i).getUserName();
                            String nameMayor = seguidoresCurrent.getFollowers().get(i+1).getUserName();
                            Assertions.assertTrue(nameMenor.compareTo(nameMayor) <= 0);
                }}
        );
        verify(mockRepository, atLeastOnce()).buscarUsuario(idVendedor);
    }

    @Test
    @DisplayName("Test seguidores ordenados por nombre descendente")
    void getFollowersFromExistingSellerOrderByNameDesc(){
        //Arrange
        Integer idVendedor = sellerLiso.getUserId();
        String order = "name_desc";

        sellerLiso.getSeguidores().addAll(List.of(userFrank, userAlan, userChelo, userCali, userFrank));

        //Act
        when(mockRepository.buscarUsuario(idVendedor)).thenReturn(sellerLiso);
        SeguidoresDTO seguidoresCurrent = service.getSeguidores(idVendedor, order);

        //Assert
        Assertions.assertAll(
                () -> Assertions.assertEquals(sellerLiso.getUserId(), seguidoresCurrent.getUserId()),
                () -> Assertions.assertEquals(sellerLiso.getUserName(), seguidoresCurrent.getUserName()),
                () -> {for(int i = 0; i < seguidoresCurrent.getFollowers().size()-1; i++){
                    String nameMenor = seguidoresCurrent.getFollowers().get(i).getUserName();
                    String nameMayor = seguidoresCurrent.getFollowers().get(i+1).getUserName();
                    Assertions.assertTrue(nameMenor.compareTo(nameMayor) >= 0);
                }}
        );
        verify(mockRepository, atLeastOnce()).buscarUsuario(idVendedor);
    }

    @Test
    @DisplayName("Test ordenamiento seguidores con parametro invalido")
    void getFollowersOrderByInvalidKeyThenIllegalArgumentException(){
        //Arrange
        Integer idVendedor = sellerLiso.getUserId();
        String orderInvalid = "asc_desc";

        sellerLiso.getSeguidores().addAll(List.of(userAlan, userFrank, userChelo, userCali));

        when(mockRepository.buscarUsuario(idVendedor)).thenReturn(sellerLiso);

        //Act and Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> service.getSeguidores(idVendedor, orderInvalid));
        verify(mockRepository, atLeastOnce()).buscarUsuario(idVendedor);
    }

    @Test
    @DisplayName("Test ordenamiento seguidores con order null")
    void getFollowersWithOrderNullThenIllegalArgumentException(){
        //Arrange
        Integer idVendedor = sellerLiso.getUserId();
        String orderNull = null;

        sellerLiso.getSeguidores().addAll(List.of(userAlan, userFrank, userChelo, userCali));

        when(mockRepository.buscarUsuario(idVendedor)).thenReturn(sellerLiso);

        //Act and Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> service.getSeguidores(idVendedor, orderNull));
        verify(mockRepository, atLeastOnce()).buscarUsuario(idVendedor);
    }

    @Test
    @DisplayName("Test seguidores ordenados con order valido")
    void getFollowersFromExistingSellerWithOrderValid(){
        //Arrange
        Integer idVendedor = sellerLiso.getUserId();
        String order = "name_desc";

        sellerLiso.getSeguidores().addAll(List.of(userFrank, userAlan, userChelo, userCali, userFrank));

        //Act
        when(mockRepository.buscarUsuario(idVendedor)).thenReturn(sellerLiso);
        SeguidoresDTO seguidoresCurrent = service.getSeguidores(idVendedor, order);

        //Assert
        //se testea que no se lance una excepcion y que el tipo devuelto sea el correcto
        Assertions.assertAll(
                () -> Assertions.assertNotNull(seguidoresCurrent),
                () -> Assertions.assertEquals(SeguidoresDTO.class, seguidoresCurrent.getClass())
        );
        verify(mockRepository, atLeastOnce()).buscarUsuario(idVendedor);
    }

    @Test
    @DisplayName("Test vendedores seguidos ordenados por nombre ascendente")
    void getFollowedFromExistingUserOrderByNameAsc(){
        //Arrange
        Integer idSeguidor = userAlan.getUserId();
        String order = "name_asc";
        userAlan.getVendedoresSeguidos().addAll(List.of(sellerEdwin, sellerLiso, sellerToto));

        //Act
        when(mockRepository.buscarUsuario(idSeguidor)).thenReturn(userAlan);
        SeguidosDTO seguidosCurrent = service.getVendedoresSeguidos(idSeguidor, order);

        //Assert
        Assertions.assertAll(
                () -> Assertions.assertEquals(userAlan.getUserId(), seguidosCurrent.getUserId()),
                () -> Assertions.assertEquals(userAlan.getUserName(), seguidosCurrent.getUserName()),
                () -> {for(int i = 0; i < seguidosCurrent.getFollowed().size()-1; i++){
                    String nameMenor = seguidosCurrent.getFollowed().get(i).getUserName();
                    String nameMayor = seguidosCurrent.getFollowed().get(i+1).getUserName();
                    Assertions.assertTrue(nameMenor.compareTo(nameMayor) <= 0);
                }}
        );
        verify(mockRepository, atLeastOnce()).buscarUsuario(idSeguidor);
    }

    @Test
    @DisplayName("Test vendedores seguidos ordenados por nombre descendente")
    void getFollowedFromExistingUserOrderByNameDesc(){
        //Arrange
        Integer idSeguidor = userAlan.getUserId();
        String order = "name_desc";
        userAlan.getVendedoresSeguidos().addAll(List.of(sellerEdwin, sellerToto, sellerLiso, sellerToto));

        //Act
        when(mockRepository.buscarUsuario(idSeguidor)).thenReturn(userAlan);
        SeguidosDTO seguidosCurrent = service.getVendedoresSeguidos(idSeguidor, order);

        //Assert
        Assertions.assertAll(
                () -> Assertions.assertEquals(userAlan.getUserId(), seguidosCurrent.getUserId()),
                () -> Assertions.assertEquals(userAlan.getUserName(), seguidosCurrent.getUserName()),
                () -> {for(int i = 0; i < seguidosCurrent.getFollowed().size()-1; i++){
                    String nameMenor = seguidosCurrent.getFollowed().get(i).getUserName();
                    String nameMayor = seguidosCurrent.getFollowed().get(i+1).getUserName();
                    Assertions.assertTrue(nameMenor.compareTo(nameMayor) >= 0);
                }}
        );
        verify(mockRepository, atLeastOnce()).buscarUsuario(idSeguidor);
    }

    @Test
    @DisplayName("Test ordenamiento vendedores seguidos con parametro invalido")
    void getFollowedOrderByInvalidKeyThenIllegalArgumentException(){
        //Arrange
        Integer idSeguidor = userAlan.getUserId();
        String orderInvalid = "asc_desc";

        userAlan.getVendedoresSeguidos().addAll(List.of(sellerEdwin, sellerToto, sellerLiso));

        when(mockRepository.buscarUsuario(idSeguidor)).thenReturn(userAlan);

        //Act and Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> service.getVendedoresSeguidos(idSeguidor, orderInvalid));
        verify(mockRepository, atLeastOnce()).buscarUsuario(idSeguidor);
    }

    @Test
    @DisplayName("Test ordenamiento vendedores con order null")
    void getFollowedWithOrderNullThenIllegalArgumentException(){
        //Arrange
        Integer idSeguidor = userAlan.getUserId();
        String orderNull = null;

        userAlan.getVendedoresSeguidos().addAll(List.of(sellerEdwin, sellerToto, sellerLiso));

        when(mockRepository.buscarUsuario(idSeguidor)).thenReturn(userAlan);

        //Act and Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> service.getVendedoresSeguidos(idSeguidor, orderNull));
        verify(mockRepository, atLeastOnce()).buscarUsuario(idSeguidor);
    }

    @Test
    @DisplayName("Test vendedores seguidos con order valido")
    void getFollowedFromExistingUserWithOrderValid(){
        //Arrange
        Integer idSeguidor = userAlan.getUserId();
        String order = "name_asc";
        userAlan.getVendedoresSeguidos().addAll(List.of(sellerEdwin, sellerToto, sellerLiso, sellerToto));

        //Act
        when(mockRepository.buscarUsuario(idSeguidor)).thenReturn(userAlan);
        SeguidosDTO seguidosCurrent = service.getVendedoresSeguidos(idSeguidor, order);

        //Assert
        //se testea que no se lance una excepcion y que el tipo devuelto sea el correcto
        Assertions.assertAll(
                () -> Assertions.assertNotNull(seguidosCurrent),
                () -> Assertions.assertSame(SeguidosDTO.class, seguidosCurrent.getClass())
        );
        verify(mockRepository, atLeastOnce()).buscarUsuario(idSeguidor);
    }

    @Test
    void getCantFollowersFromExistingSellerWithFollowers(){
        //Arrange
        Integer idVendedor = sellerLiso.getUserId();
        sellerLiso.getSeguidores().addAll(List.of(userAlan, userFrank, userChelo, userCali));

        //Act
        when(mockRepository.buscarUsuario(idVendedor)).thenReturn(sellerLiso);
        CantSeguidoresDTO cantSeguidoresCurrent = service.getCantSeguidores(idVendedor);

        //Assert
        Assertions.assertAll(
            () -> Assertions.assertEquals(sellerLiso.getUserId(), cantSeguidoresCurrent.getUserId()),
            () -> Assertions.assertEquals(sellerLiso.getUserName(), cantSeguidoresCurrent.getUserName()),
            () -> Assertions.assertEquals(4, cantSeguidoresCurrent.getFollowersCount())
        );
        verify(mockRepository, atLeastOnce()).buscarUsuario(idVendedor);
    }

    @Test
    void getPostsFromSellersFollowedOrderByDateAsc(){
        //Arrange
        Integer idSeguidor = userNico.getUserId();
        String order = "date_asc";

        userNico.getVendedoresSeguidos().addAll(List.of(sellerEdwin, sellerLiso, sellerToto));

        //Act
        when(mockRepository.buscarUsuario(idSeguidor)).thenReturn(userNico);
        PublicacionesDTO publicacionesCurrent = service.getPublicacionesSeguidos(idSeguidor, order);

        //Assert
        Assertions.assertAll(
                () -> Assertions.assertEquals(userNico.getUserId(), publicacionesCurrent.getUserId()),
                () -> {for(int i = 0; i < publicacionesCurrent.getPosts().size()-1; i++){
                        LocalDate fechaMenor = publicacionesCurrent.getPosts().get(i).getDate();
                        LocalDate fechaMayor = publicacionesCurrent.getPosts().get(i+1).getDate();
                        Assertions.assertTrue(fechaMenor.compareTo(fechaMayor) <= 0);
                }}
        );
        verify(mockRepository, atLeastOnce()).buscarUsuario(idSeguidor);
    }

    @Test
    void getPostsFromSellersFollowedOrderByDateDesc(){
        //Arrange
        Integer idSeguidor = userNico.getUserId();
        String order = "date_desc";

        userNico.getVendedoresSeguidos().addAll(List.of(sellerLiso, sellerEdwin, sellerToto, sellerEdwin));

        //Act
        when(mockRepository.buscarUsuario(idSeguidor)).thenReturn(userNico);
        PublicacionesDTO publicacionesCurrent = service.getPublicacionesSeguidos(idSeguidor, order);

        //Assert
        Assertions.assertAll(
                () -> Assertions.assertEquals(userNico.getUserId(), publicacionesCurrent.getUserId()),
                () -> {for(int i = 0; i < publicacionesCurrent.getPosts().size()-1; i++){
                    LocalDate fechaMenor = publicacionesCurrent.getPosts().get(i).getDate();
                    LocalDate fechaMayor = publicacionesCurrent.getPosts().get(i+1).getDate();
                    Assertions.assertTrue(fechaMenor.compareTo(fechaMayor) >= 0);
                }}
        );
        verify(mockRepository, atLeastOnce()).buscarUsuario(idSeguidor);
    }

    @Test
    void getPostsFromSellersFollowedOrderByInvalidKeyThenIllegalArgumentException(){
        //Arrange
        Integer idSeguidor = userNico.getUserId();
        String orderInvalid = "asc_desc";

        userNico.getVendedoresSeguidos().addAll(List.of(sellerEdwin, sellerLiso, sellerToto));

        when(mockRepository.buscarUsuario(idSeguidor)).thenReturn(userNico);

        //Act and Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> service.getPublicacionesSeguidos(idSeguidor, orderInvalid));
        verify(mockRepository, atLeastOnce()).buscarUsuario(idSeguidor);
    }

    @Test
    void getPostFromSellersFollowedWithOrderNullThenIllegalArgumentException(){
        //Arrange
        Integer idSeguidor = userNico.getUserId();
        String orderNull = null;

        userNico.getVendedoresSeguidos().addAll(List.of(sellerEdwin, sellerLiso, sellerToto));

        when(mockRepository.buscarUsuario(idSeguidor)).thenReturn(userNico);

        //Act and Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> service.getPublicacionesSeguidos(idSeguidor, orderNull));
        verify(mockRepository, atLeastOnce()).buscarUsuario(idSeguidor);
    }

    //Verifica que la consulta de publicaciones sean de las últimas dos semanas.
    @Test
    void getPostFromSellersFollowedUntil2WeeksAgo(){
        //Arrange
        Integer idSeguidor = userFrank.getUserId();

        sellerEdwin.getPublicaciones().get(0).setDate(LocalDate.now());
        sellerLiso.getPublicaciones().get(0).setDate(LocalDate.of(2010, 11, 15));
        sellerLiso.getPublicaciones().get(1).setDate(LocalDate.of(2021,11,12));
        sellerToto.getPublicaciones().get(0).setDate(LocalDate.of(2021,11,13));
        sellerToto.getPublicaciones().get(1).setDate(LocalDate.of(2021, 11,20));
        sellerToto.getPublicaciones().get(2).setDate(LocalDate.of(2021, 12, 25));
        userFrank.getVendedoresSeguidos().addAll(List.of(sellerLiso, sellerEdwin, sellerToto));

        //Act
        when(mockRepository.buscarUsuario(idSeguidor)).thenReturn(userFrank);
        PublicacionesDTO publicacionesCurrent = service.getPublicacionesSeguidos(idSeguidor);

        //Assert
        Assertions.assertAll(
                () -> Assertions.assertEquals(userFrank.getUserId(), publicacionesCurrent.getUserId()),
                () -> {for(int i = 0; i < publicacionesCurrent.getPosts().size(); i++){
                    LocalDate fecha = publicacionesCurrent.getPosts().get(i).getDate();
                    LocalDate fechaLimite = LocalDate.now().minusDays(14);
                    //deben ser fechas dentro de las ultimas dos semanas
                    //si hoy es 26/11, las fechas validas van desde el 13/11 al 26/11 (inclusive ambos)
                    Assertions.assertTrue(fecha.isAfter(fechaLimite));
                    //la fecha no puede ser del futuro
                    Assertions.assertTrue(fecha.compareTo(LocalDate.now()) <= 0);
                }}
        );
        verify(mockRepository, atLeastOnce()).buscarUsuario(idSeguidor);
    }

    //TODO ver si falta el 3 o el 5
}
