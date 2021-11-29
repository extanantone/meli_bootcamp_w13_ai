package com.SocialMeli.Sprint1SocialMeli.service;

import com.SocialMeli.Sprint1SocialMeli.DTO.*;
import com.SocialMeli.Sprint1SocialMeli.Exception.NotExistOrderExeption;
import com.SocialMeli.Sprint1SocialMeli.Exception.NotFoundUsuarioException;
import com.SocialMeli.Sprint1SocialMeli.Exception.UserNoFollowExeption;
import com.SocialMeli.Sprint1SocialMeli.Exception.UserduplicateFollowExeption;
import com.SocialMeli.Sprint1SocialMeli.Model.Comprador;
import com.SocialMeli.Sprint1SocialMeli.Model.Producto;
import com.SocialMeli.Sprint1SocialMeli.Model.Publicacion;
import com.SocialMeli.Sprint1SocialMeli.Model.Vendedor;
import com.SocialMeli.Sprint1SocialMeli.Repository.ISocialMeliRepository;
import com.SocialMeli.Sprint1SocialMeli.Service.SocialMeliSeviceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ExtendWith(MockitoExtension.class)
public class SocialMeliServiceTest {

    //Mock
    @Mock
    ISocialMeliRepository repo;

    @InjectMocks
    SocialMeliSeviceImpl service;

    //TEST 001
    @Test
    void verifyUserToFollowExists() {

        //Arrange
        int compradorId = 3;
        int vendedorId = 4;
        Comprador comprador = new Comprador(1, "Juan");
        Vendedor vendedor = new Vendedor(2, "Marcos");


        //Act
        Mockito.when(repo.follow(compradorId, vendedorId)).thenReturn(true);
        Mockito.when(repo.getComprador(compradorId)).thenReturn(comprador);
        Mockito.when(repo.getVendedor(vendedorId)).thenReturn(vendedor);
        Mockito.when(repo.existsFollow(compradorId, vendedorId)).thenReturn(false);


        //Assert
        Assertions.assertDoesNotThrow(() -> service.addFollowed(compradorId, vendedorId));
        Mockito.verify(repo, Mockito.atLeast(1)).follow(Mockito.anyInt(), Mockito.anyInt());

    }


    @Test
    void verifyUserSellerToFollowNoExists() {

        //Arrange
        int compradorId = 5;
        int vendedorId = 4;
        Vendedor vendedor = new Vendedor(2, "Marcos");


        //Act

        Mockito.when(repo.getComprador(compradorId)).thenReturn(null);
        Mockito.when(repo.getVendedor(vendedorId)).thenReturn(vendedor);


        //Assert
        Assertions.assertThrows(NotFoundUsuarioException.class,
                () -> service.addFollowed(compradorId, vendedorId));


    }

    @Test
    void verifyUserBuyerToFollowNoExists() {

        //Arrange
        int compradorId = 5;
        int vendedorId = 4;
        Vendedor vendedor = new Vendedor(2, "Marcos");
        Comprador comprador = new Comprador(1, "Juan");


        //Act

        Mockito.when(repo.getComprador(compradorId)).thenReturn(comprador);
        Mockito.when(repo.getVendedor(vendedorId)).thenReturn(null);


        //Assert
        Assertions.assertThrows(NotFoundUsuarioException.class,
                () -> service.addFollowed(compradorId, vendedorId));


    }

    @Test
    void verifyDuplicateUserToFollowExists() {

        //Arrange
        int compradorId = 1;
        int vendedorId = 2;
        Vendedor vendedor = new Vendedor(2, "Marcos");
        Comprador comprador = new Comprador(1, "Juan");
        comprador.setFolloweds(new ArrayList<Integer>(2));

        //Act
        Mockito.when(repo.getComprador(compradorId)).thenReturn(comprador);
        Mockito.when(repo.getVendedor(vendedorId)).thenReturn(vendedor);
        Mockito.when(repo.existsFollow(compradorId, vendedorId)).thenReturn(true);


        //Assert
        Assertions.assertThrows(UserduplicateFollowExeption.class,
                () -> service.addFollowed(compradorId, vendedorId));


    }

    //TEST 002
    @Test
    void VerifyUserToUnfollowingExists() {

        //Arrange
        int compradorId = 3;
        int vendedorId = 4;
        Comprador comprador = new Comprador(1, "Juan");
        Vendedor vendedor = new Vendedor(2, "Marcos");


        //Act
        Mockito.when(repo.unFollow(compradorId, vendedorId)).thenReturn(true);
        Mockito.when(repo.getComprador(compradorId)).thenReturn(comprador);
        Mockito.when(repo.getVendedor(vendedorId)).thenReturn(vendedor);
        Mockito.when(repo.existsFollow(compradorId, vendedorId)).thenReturn(true);

        service.unFollow(compradorId, vendedorId);

        //Assert
        //TODO agregar asset
        Mockito.verify(repo, Mockito.atLeast(1)).unFollow(Mockito.anyInt(), Mockito.anyInt());

    }

    @Test
    void VerifyUserSellerToUnfollowingNoExists() {

        //Arrange
        int compradorId = 3;
        int vendedorId = 4;
        Comprador comprador = new Comprador(1, "Juan");


        //Act
        Mockito.when(repo.getComprador(compradorId)).thenReturn(comprador);
        Mockito.when(repo.getVendedor(vendedorId)).thenReturn(null);


        //Assert
        Assertions.assertThrows(NotFoundUsuarioException.class,
                () -> service.unFollow(compradorId, vendedorId));


    }

    @Test
    void VerifyUserBuyerToUnfollowingNoExists() {

        //Arrange
        int compradorId = 5;
        int vendedorId = 4;
        Vendedor vendedor = new Vendedor(2, "Marcos");


        //Act

        Mockito.when(repo.getComprador(compradorId)).thenReturn(null);


        //Assert
        Assertions.assertThrows(NotFoundUsuarioException.class,
                () -> service.unFollow(compradorId, vendedorId));


    }


    @Test
    void verifyUserToFollowNoExists() {

        //Arrange
        int compradorId = 1;
        int vendedorId = 2;
        Vendedor vendedor = new Vendedor(2, "Marcos");
        Comprador comprador = new Comprador(1, "Juan");
        comprador.setFolloweds(new ArrayList<Integer>(2));

        //Act
        Mockito.when(repo.getComprador(compradorId)).thenReturn(comprador);
        Mockito.when(repo.getVendedor(vendedorId)).thenReturn(vendedor);
        Mockito.when(repo.existsFollow(compradorId, vendedorId)).thenReturn(false);


        //Assert
        Assertions.assertThrows(UserNoFollowExeption.class,
                () -> service.unFollow(compradorId, vendedorId));


    }


    //TEST 003 y TEST 004

    @Test
    void VerifyTypeOfAlphabeticalOrderAscExists() {
        //Arrange
        String order = "Name_asc";
        int vendedorId = 4;
        Vendedor vendedor = new Vendedor(2, "Marcos");
        List<Integer> followers = new ArrayList<>();
        followers.add(1);
        followers.add(2);
        followers.add(3);
        vendedor.setFollowers(followers);

        Comprador comprador1 = new Comprador(1, "Juan");
        Comprador comprador2 = new Comprador(2, "Brian");
        Comprador comprador3 = new Comprador(3, "Camila");

        List<Comprador> compradorList = new ArrayList<>();
        compradorList.add(comprador2);
        compradorList.add(comprador3);
        compradorList.add(comprador1);

        VendedorFollowersListDTO vendedorFollowersListDTO1 = new VendedorFollowersListDTO();

        List<CompradorIdNameDTO> compradorIdNameDTO = compradorList.stream()
                .map(co -> new CompradorIdNameDTO(co.getUserID(), co.getUserName()))
                .collect(Collectors.toList());

        vendedorFollowersListDTO1.setFollowers(compradorIdNameDTO);
        vendedorFollowersListDTO1.setUserId(vendedor.getUserID());
        vendedorFollowersListDTO1.setUserName(vendedor.getUserName());


        Mockito.when(repo.getVendedor(vendedorId)).thenReturn(vendedor);
        Mockito.when(repo.getComprador(1)).thenReturn(comprador1);
        Mockito.when(repo.getComprador(2)).thenReturn(comprador2);
        Mockito.when(repo.getComprador(3)).thenReturn(comprador3);

        //Act
        VendedorFollowersListDTO vendedorFollowesList = service.vendedorFollowesList(vendedorId, order);

        //Assert
        Assertions.assertEquals(vendedorFollowersListDTO1, vendedorFollowesList);

    }


    @Test
    void VerifyTypeOfAlphabeticalOrderDescExists() {
        //Arrange
        String order = "Name_desc";
        int vendedorId = 4;
        Vendedor vendedor = new Vendedor(2, "Marcos");
        List<Integer> followers = new ArrayList<>();
        followers.add(1);
        followers.add(2);
        followers.add(3);
        vendedor.setFollowers(followers);

        Comprador comprador1 = new Comprador(1, "Juan");
        Comprador comprador2 = new Comprador(2, "Brian");
        Comprador comprador3 = new Comprador(3, "Camila");

        List<Comprador> compradorList = new ArrayList<>();
        compradorList.add(comprador1);
        compradorList.add(comprador3);
        compradorList.add(comprador2);

        VendedorFollowersListDTO vendedorFollowersListDTO1 = new VendedorFollowersListDTO();

        List<CompradorIdNameDTO> compradorIdNameDTO = compradorList.stream()
                .map(co -> new CompradorIdNameDTO(co.getUserID(), co.getUserName()))
                .collect(Collectors.toList());

        vendedorFollowersListDTO1.setFollowers(compradorIdNameDTO);
        vendedorFollowersListDTO1.setUserId(vendedor.getUserID());
        vendedorFollowersListDTO1.setUserName(vendedor.getUserName());

        //Act
        Mockito.when(repo.getVendedor(vendedorId)).thenReturn(vendedor);
        Mockito.when(repo.getComprador(1)).thenReturn(comprador1);
        Mockito.when(repo.getComprador(2)).thenReturn(comprador2);
        Mockito.when(repo.getComprador(3)).thenReturn(comprador3);


        //Assert
        VendedorFollowersListDTO vendedorFollowesList = service.vendedorFollowesList(vendedorId, order);
        Assertions.assertEquals(vendedorFollowersListDTO1, vendedorFollowesList);

    }


    @Test
    void VerifyTypeOfAlphabeticalOrderNoExists() {
        //Arrange
        String order = "";
        int vendedorId = 4;
        Vendedor vendedor = new Vendedor(2, "Marcos");
        List<Integer> followers = new ArrayList<>();
        followers.add(1);
        followers.add(2);
        followers.add(3);
        vendedor.setFollowers(followers);

        Comprador comprador1 = new Comprador(1, "Juan");
        Comprador comprador2 = new Comprador(2, "Brian");
        Comprador comprador3 = new Comprador(3, "Camila");

        List<Comprador> compradorList = new ArrayList<>();
        compradorList.add(comprador1);
        compradorList.add(comprador3);
        compradorList.add(comprador2);

        VendedorFollowersListDTO vendedorFollowersListDTO1 = new VendedorFollowersListDTO();

        List<CompradorIdNameDTO> compradorIdNameDTO = compradorList.stream()
                .map(co -> new CompradorIdNameDTO(co.getUserID(), co.getUserName()))
                .collect(Collectors.toList());

        vendedorFollowersListDTO1.setFollowers(compradorIdNameDTO);
        vendedorFollowersListDTO1.setUserId(vendedor.getUserID());
        vendedorFollowersListDTO1.setUserName(vendedor.getUserName());

        //Act
        Mockito.when(repo.getVendedor(vendedorId)).thenReturn(vendedor);
        Mockito.when(repo.getComprador(1)).thenReturn(comprador1);
        Mockito.when(repo.getComprador(2)).thenReturn(comprador2);
        Mockito.when(repo.getComprador(3)).thenReturn(comprador3);


        //Assert

        Assertions.assertThrows(NotExistOrderExeption.class, () -> service.vendedorFollowesList(Mockito.anyInt(), Mockito.anyString()));


    }

    @Test
    void VerifyTypeOfAlphabeticalOrderUserNotExits() {

        //Arrange
        String order = "";
        int vendedorId = 4;
        Vendedor vendedor = new Vendedor(2, "Marcos");


        //Act
        Mockito.when(repo.getVendedor(vendedorId)).thenReturn(null);


        //Assert
        Assertions.assertThrows(NotFoundUsuarioException.class, () -> service.vendedorFollowesList(vendedorId, Mockito.anyString()));


    }

    //TEST 005

    @Test
    void checkSortingByDateNotExistsComprador() {
        //Arrange
        String order = "Date_desc";
        int compradorId = 1;
        Comprador comprador = new Comprador(1, "Juan");


        //Act
        Mockito.when(repo.getComprador(compradorId)).thenReturn(null);



        //Assert
        Assertions.assertThrows(NotFoundUsuarioException.class, () -> service.postByVendedorOfComprador(compradorId, order) );

    }



    @Test
    void checkSortingByDateDescExists() {
        //Arrange
        String order = "Date_desc";
        int compradorId = 1;
        Comprador comprador = new Comprador(1, "Juan");
        List<Integer> followeds = new ArrayList<>();
        followeds.add(1);
        comprador.setFolloweds(followeds);
        List<Publicacion> publicaciones = new ArrayList<>();

        Vendedor vendedor1 = new Vendedor(1, "Marcos");
        vendedor1.setPosts(publicaciones);
        Producto pro = new Producto(1, "Silla Gamer", "Gamer", "Racer", "rojo/Morado", "Special Edition");
        Publicacion publicacion1 = new Publicacion(1, 1, 50.0, LocalDate.now().minusDays(2), pro, false, 0);
        Publicacion publicacion2 = new Publicacion(2, 1, 50.0, LocalDate.now().minusDays(5), pro, false, 0);
        Publicacion publicacion3 = new Publicacion(3, 1, 150.0, LocalDate.now().minusDays(10), pro, false, 0);
        Publicacion publicacion4 = new Publicacion(4, 1, 150.0, LocalDate.now().minusDays(12), pro, false, 0);

        publicaciones.add(publicacion1);
        publicaciones.add(publicacion2);
        publicaciones.add(publicacion3);
        publicaciones.add(publicacion4);

        List<PublicacionSinUserIdDTO> publicacionSinUserIdDTO = publicaciones.stream()
                .map(p -> new PublicacionSinUserIdDTO(p.getPostId(), p.getCategory(), p.getPrice(), p.getDate(),
                        new ProductoDTO(p.getDetail().getProductId(), p.getDetail().getProductName(), p.getDetail().getType(), p.getDetail().getBrand(), p.getDetail().getColor(), p.getDetail().getNotes())))
                .collect(Collectors.toList());

        CompradorPublicacionesVendedorListDTO compradorPublicacionesVendedorListDTO = new CompradorPublicacionesVendedorListDTO(compradorId, publicacionSinUserIdDTO);
        //Act
        Mockito.when(repo.getComprador(compradorId)).thenReturn(comprador);
        Mockito.when(repo.getVendedor(1)).thenReturn(vendedor1);


        //Assert
        CompradorPublicacionesVendedorListDTO postList = service.postByVendedorOfComprador(compradorId, order);
        Assertions.assertEquals(compradorPublicacionesVendedorListDTO, postList);

    }

    @Test
    void checkSortingByDateAscExists() {

        //Arrange
        String order = "Date_asc";
        int compradorId = 1;
        Comprador comprador = new Comprador(1, "Juan");
        List<Integer> followeds = new ArrayList<>();
        followeds.add(1);
        comprador.setFolloweds(followeds);
        List<Publicacion> publicaciones = new ArrayList<>();

        Vendedor vendedor1 = new Vendedor(1, "Marcos");
        vendedor1.setPosts(publicaciones);

        Producto pro = new Producto(1, "Silla Gamer", "Gamer", "Racer", "rojo/Morado", "Special Edition");
        Publicacion publicacion1 = new Publicacion(1, 1, 50.0, LocalDate.now().minusDays(2), pro, false, 0);
        Publicacion publicacion2 = new Publicacion(2, 1, 50.0, LocalDate.now().minusDays(5), pro, false, 0);
        Publicacion publicacion3 = new Publicacion(3, 1, 150.0, LocalDate.now().minusDays(10), pro, false, 0);
        Publicacion publicacion4 = new Publicacion(4, 1, 150.0, LocalDate.now().minusDays(12), pro, false, 0);

        publicaciones.add(publicacion4);
        publicaciones.add(publicacion3);
        publicaciones.add(publicacion2);
        publicaciones.add(publicacion1);

        List<PublicacionSinUserIdDTO> publicacionSinUserIdDTO = publicaciones.stream()
                .map(p -> new PublicacionSinUserIdDTO(p.getPostId(), p.getCategory(), p.getPrice(), p.getDate(),
                        new ProductoDTO(p.getDetail().getProductId(), p.getDetail().getProductName(), p.getDetail().getType(), p.getDetail().getBrand(), p.getDetail().getColor(), p.getDetail().getNotes())))
                .collect(Collectors.toList());

        CompradorPublicacionesVendedorListDTO compradorPublicacionesVendedorListDTO = new CompradorPublicacionesVendedorListDTO(compradorId, publicacionSinUserIdDTO);
        //Act
        Mockito.when(repo.getComprador(compradorId)).thenReturn(comprador);
        Mockito.when(repo.getVendedor(1)).thenReturn(vendedor1);


        //Assert
        CompradorPublicacionesVendedorListDTO postList = service.postByVendedorOfComprador(compradorId, order);
        Assertions.assertEquals(compradorPublicacionesVendedorListDTO, postList);

    }

    @Test
    void checkSortingByDateNoExists() {

        //Arrange
        String order = "";
        int compradorId = 1;
        Comprador comprador = new Comprador(1, "Juan");
        List<Integer> followeds = new ArrayList<>();
        followeds.add(1);
        comprador.setFolloweds(followeds);
        List<Publicacion> publicaciones = new ArrayList<>();

        Vendedor vendedor1 = new Vendedor(1, "Marcos");
        vendedor1.setPosts(publicaciones);

        Producto pro = new Producto(1, "Silla Gamer", "Gamer", "Racer", "rojo/Morado", "Special Edition");
        Publicacion publicacion1 = new Publicacion(1, 1, 50.0, LocalDate.now().minusDays(2), pro, false, 0);
        Publicacion publicacion2 = new Publicacion(2, 1, 50.0, LocalDate.now().minusDays(5), pro, false, 0);
        Publicacion publicacion3 = new Publicacion(3, 1, 150.0, LocalDate.now().minusDays(10), pro, false, 0);
        Publicacion publicacion4 = new Publicacion(4, 1, 150.0, LocalDate.now().minusDays(12), pro, false, 0);

        publicaciones.add(publicacion4);
        publicaciones.add(publicacion2);
        publicaciones.add(publicacion3);
        publicaciones.add(publicacion1);

        List<PublicacionSinUserIdDTO> publicacionSinUserIdDTO = publicaciones.stream()
                .map(p -> new PublicacionSinUserIdDTO(p.getPostId(), p.getCategory(), p.getPrice(), p.getDate(),
                        new ProductoDTO(p.getDetail().getProductId(), p.getDetail().getProductName(), p.getDetail().getType(), p.getDetail().getBrand(), p.getDetail().getColor(), p.getDetail().getNotes())))
                .collect(Collectors.toList());

        CompradorPublicacionesVendedorListDTO compradorPublicacionesVendedorListDTO = new CompradorPublicacionesVendedorListDTO(compradorId, publicacionSinUserIdDTO);
        //Act
        Mockito.when(repo.getComprador(compradorId)).thenReturn(comprador);
        Mockito.when(repo.getVendedor(1)).thenReturn(vendedor1);


        //Assert
        Assertions.assertThrows(NotExistOrderExeption.class, () -> service.postByVendedorOfComprador(compradorId, order));

    }

    //TEST 007
    @Test
    void verifyCorrectNumberOfFollowers() {
        int vendedorId = 1;
        Vendedor vendedor = new Vendedor(1, "Marcos");
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);

        vendedor.setFollowers(integerList);
        VendedorFollowesCountDTO vendedorFollowesCountDTO = new VendedorFollowesCountDTO(vendedor.getUserID(), vendedor.getUserName(), vendedor.getFollowers().size());


        Mockito.when(repo.getVendedor(vendedorId)).thenReturn(vendedor);

        VendedorFollowesCountDTO aux = service.vendedorFollowesCount(vendedorId);
        Assertions.assertEquals(vendedorFollowesCountDTO, aux);

    }

    @Test
    void verifyCorrectNumberOfFollowersNotExistsVendedor() {
        int vendedorId = 1;
        Vendedor vendedor = new Vendedor(1, "Marcos");
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);

        vendedor.setFollowers(integerList);
        VendedorFollowesCountDTO vendedorFollowesCountDTO = new VendedorFollowesCountDTO(vendedor.getUserID(), vendedor.getUserName(), vendedor.getFollowers().size());


        Mockito.when(repo.getVendedor(vendedorId)).thenReturn(null);


        Assertions.assertThrows(NotFoundUsuarioException.class, () -> service.vendedorFollowesCount(vendedorId));

    }


    //TEST 008

    @Test
    void checkPostsLastTwoWeeks() {

        //Arrange
        String order = "Date_asc";
        int compradorId = 1;
        Comprador comprador = new Comprador(1, "Juan");
        List<Integer> followeds = new ArrayList<>();
        followeds.add(1);
        comprador.setFolloweds(followeds);
        List<Publicacion> publicaciones = new ArrayList<>();
        List<Publicacion> publicaciones1 = new ArrayList<>();

        Vendedor vendedor1 = new Vendedor(1, "Marcos");
        vendedor1.setPosts(publicaciones);

        Producto pro = new Producto(1, "Silla Gamer", "Gamer", "Racer", "rojo/Morado", "Special Edition");
        Publicacion publicacion1 = new Publicacion(1, 1, 50.0, LocalDate.now().minusDays(2), pro, false, 0);
        Publicacion publicacion2 = new Publicacion(2, 1, 50.0, LocalDate.now().minusDays(5), pro, false, 0);
        Publicacion publicacion3 = new Publicacion(3, 1, 150.0, LocalDate.now().minusDays(10), pro, false, 0);
        Publicacion publicacion4 = new Publicacion(4, 1, 150.0, LocalDate.now().minusDays(12), pro, false, 0);
        Publicacion publicacion5v = new Publicacion(4, 1, 200.0, LocalDate.now().minusDays(18), pro, false, 0);
        Publicacion publicacion6v = new Publicacion(4, 1, 200.0, LocalDate.now().minusDays(20), pro, false, 0);

        publicaciones.add(publicacion4);
        publicaciones.add(publicacion3);
        publicaciones.add(publicacion2);
        publicaciones.add(publicacion1);
        publicaciones.add(publicacion5v);
        publicaciones.add(publicacion6v);

        publicaciones1.add(publicacion4);
        publicaciones1.add(publicacion3);
        publicaciones1.add(publicacion2);
        publicaciones1.add(publicacion1);


        List<PublicacionSinUserIdDTO> publicacionSinUserIdDTO = publicaciones1.stream()
                .map(p -> new PublicacionSinUserIdDTO(p.getPostId(), p.getCategory(), p.getPrice(), p.getDate(),
                        new ProductoDTO(p.getDetail().getProductId(), p.getDetail().getProductName(), p.getDetail().getType(), p.getDetail().getBrand(), p.getDetail().getColor(), p.getDetail().getNotes())))
                .collect(Collectors.toList());

        CompradorPublicacionesVendedorListDTO compradorPublicacionesVendedorListDTO = new CompradorPublicacionesVendedorListDTO(compradorId, publicacionSinUserIdDTO);
        //Act
        Mockito.when(repo.getComprador(compradorId)).thenReturn(comprador);
        Mockito.when(repo.getVendedor(1)).thenReturn(vendedor1);


        //Assert
        CompradorPublicacionesVendedorListDTO postList = service.postByVendedorOfComprador(compradorId, order);
        Assertions.assertEquals(compradorPublicacionesVendedorListDTO, postList);

    }


}
