package unit;

import com.SocialMeli.Sprint1SocialMeli.DTO.*;
import com.SocialMeli.Sprint1SocialMeli.Exception.NotFoundCompradorException;
import com.SocialMeli.Sprint1SocialMeli.Exception.NotFoundVendedorException;
import com.SocialMeli.Sprint1SocialMeli.Exception.NotValidParamException;
import com.SocialMeli.Sprint1SocialMeli.Model.Comprador;
import com.SocialMeli.Sprint1SocialMeli.Model.Producto;
import com.SocialMeli.Sprint1SocialMeli.Model.Publicacion;
import com.SocialMeli.Sprint1SocialMeli.Model.Vendedor;
import com.SocialMeli.Sprint1SocialMeli.Repository.SocialMeliRepositoryImpl;
import com.SocialMeli.Sprint1SocialMeli.Service.SocialMeliSeviceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)

public class SocialMeliServiceTest {

    @Mock
    SocialMeliRepositoryImpl repository;

    @InjectMocks
    SocialMeliSeviceImpl service;


    //T-0001 SE CUMPLE
    @Test
    public void validateFollowedTest()
    {
        // Arrange
        Vendedor vendedor = new Vendedor(1,"vendedor1");
        Comprador comprador = new Comprador(2,"comprador1");

        //Mock
        Mockito.when(repository.getComprador(2)).thenReturn(comprador);
        Mockito.when(repository.getVendedor(1)).thenReturn(vendedor);

        //Act
        service.serviceFollow(comprador.getUserID(),vendedor.getUserID());
        comprador.addFollowed(1);
        vendedor.addFollower(2);

        //Verify
        Assertions.assertEquals(comprador.getFolloweds().get(0),1);
        Assertions.assertEquals(vendedor.getFollowers().get(0),2);

        Mockito.verify(repository, Mockito.atLeastOnce()).getComprador(Mockito.anyInt());
        Mockito.verify(repository, Mockito.atLeastOnce()).getVendedor(Mockito.anyInt());


    }
    //T-0001 NO SE CUMPLE
    @Test
    public void validateNotFollowedTest()
    {
        // Arrange
        Vendedor vendedor = new Vendedor(1,"vendedor1");
        Comprador comprador = new Comprador(2,"comprador1");

        //Mock
        Mockito.when(repository.getComprador(2)).thenReturn(comprador);
        Mockito.when(repository.getVendedor(1)).thenReturn(vendedor);

        //Act
        service.serviceFollow(comprador.getUserID(),vendedor.getUserID());

        // Assert ACT & verificar uso de mock
        Assertions.assertThrows(NotFoundCompradorException.class,() -> service.serviceFollow(20,1));
        Assertions.assertThrows(NotFoundVendedorException.class,() -> service.serviceFollow(2,10));
        Assertions.assertThrows(NotFoundVendedorException.class,() -> service.validarVendedor(10));
        Assertions.assertThrows(NotFoundCompradorException.class,() -> service.validarComprador(20));

        Mockito.verify(repository, Mockito.atLeastOnce()).getComprador(Mockito.anyInt());
        Mockito.verify(repository, Mockito.atLeastOnce()).getVendedor(Mockito.anyInt());

    }

    //T-0002 SE CUMPLE
    @Test
    public void validateUnFollowedTest()
    {
        // Arrange
        Vendedor vendedor = new Vendedor(1,"vendedor1");
        Comprador comprador = new Comprador(2,"comprador1");
        comprador.addFollowed(1);
        vendedor.addFollower(2);

        //Mock
        Mockito.when(repository.getComprador(2)).thenReturn(comprador);
        Mockito.when(repository.getVendedor(1)).thenReturn(vendedor);

        //Act
        service.serviceUnFollow(comprador.getUserID(),vendedor.getUserID());
        comprador.deleteFollowed(1);
        vendedor.deleteFollower(2);

        // Assert & verificar uso de mock

        Assertions.assertTrue(comprador.getFolloweds().isEmpty());
        Assertions.assertTrue(vendedor.getFollowers().isEmpty());
        Assertions.assertThrows(IndexOutOfBoundsException.class,() -> comprador.getFolloweds().get(0));
        Assertions.assertThrows(IndexOutOfBoundsException.class,() -> vendedor.getFollowers().get(0));

        Mockito.verify(repository, Mockito.atLeastOnce()).getComprador(Mockito.anyInt());
        Mockito.verify(repository, Mockito.atLeastOnce()).getVendedor(Mockito.anyInt());

    }
    //T-0002 NO SE CUMPLE
    @Test
    public void validateNotUnFollowedTest()
    {
        // Arrange
        Vendedor vendedor = new Vendedor(1,"vendedor1");
        Comprador comprador = new Comprador(2,"comprador1");
        comprador.addFollowed(1);
        vendedor.addFollower(2);

        //Mock
        Mockito.when(repository.getComprador(2)).thenReturn(comprador);
        Mockito.when(repository.getVendedor(1)).thenReturn(vendedor);

        //Act
        service.serviceUnFollow(comprador.getUserID(),vendedor.getUserID());

        // Assert & verificar uso de mock
        Assertions.assertThrows(NotFoundVendedorException.class,() -> service.serviceUnFollow(2,10));
        Assertions.assertThrows(NotFoundCompradorException.class,() -> service.serviceUnFollow(20,1));
        Assertions.assertThrows(NotFoundCompradorException.class,() -> service.validarComprador(20));
        Assertions.assertThrows(NotFoundVendedorException.class,() -> service.validarVendedor(10));

        Mockito.verify(repository, Mockito.atLeastOnce()).getComprador(Mockito.anyInt());
        Mockito.verify(repository, Mockito.atLeastOnce()).getVendedor(Mockito.anyInt());

    }
    //T-0003 SE CUMPLE
    @Test public void validationOrderNameTest()
    {
        // Arrange
        Vendedor vendedor = new Vendedor(1,"vendedor1");
        Comprador comprador = new Comprador(2,"comprador1");

        vendedor.addFollower(2);
        comprador.addFollowed(1);

        //Mock
        Mockito.when(repository.getComprador(2)).thenReturn(comprador);
        Mockito.when(repository.getVendedor(1)).thenReturn(vendedor);

        //Act
        service.serviceCompradorListFollowed(2, "name_asc");
        service.serviceVendedorListFollowers(1,"name_desc");
        service.serviceCompradorListFollowed(2, "name_desc");
        service.serviceVendedorListFollowers(1,"name_asc");

        // Assert & verificar uso de mock
        Mockito.verify(repository, Mockito.atLeastOnce()).getComprador(Mockito.anyInt());
        Mockito.verify(repository, Mockito.atLeastOnce()).getVendedor(Mockito.anyInt());

    }

    //T-0003 NO SE CUMPLE
    @Test public void validationNotOrderNameTest()
    {
        // Arrange
        Vendedor vendedor = new Vendedor(1,"vendedor1");
        Comprador comprador = new Comprador(2,"comprador1");
        vendedor.addFollower(2);
        comprador.addFollowed(1);

        //Mock
        Mockito.when(repository.getComprador(2)).thenReturn(comprador);
        Mockito.when(repository.getVendedor(1)).thenReturn(vendedor);

        // Assert Act & verificar uso de mock
        Assertions.assertThrows(NotValidParamException.class,() -> service.serviceCompradorListFollowed(2, "name_asc****"));
        Assertions.assertThrows(NotValidParamException.class,() -> service.serviceVendedorListFollowers(1,"name_desc***"));
        Assertions.assertThrows(NotValidParamException.class,() -> service.serviceCompradorListFollowed(2, "name_desc***"));
        Assertions.assertThrows(NotValidParamException.class,() -> service.serviceVendedorListFollowers(1,"name_asc***"));
        Mockito.verify(repository, Mockito.atLeastOnce()).getComprador(Mockito.anyInt());
        Mockito.verify(repository, Mockito.atLeastOnce()).getVendedor(Mockito.anyInt());

    }

    //T-0004 SE CUMPLE
    @Test public void listOrderTest() {

        // Arrange
        Vendedor vendedor = new Vendedor(1,"vendedor1"); // Creo vendedor
        Vendedor vendedor2 = new Vendedor(2,"vendedor2"); // Creo vendedor
        Comprador comprador = new Comprador(3,"comprador1"); // Creo comprador
        Comprador comprador2 = new Comprador(4,"comprador2"); // Creo comprador

        vendedor.addFollower(3);//vendedor id 1 le agrego seguidor
        vendedor.addFollower(4);//vendedor id 1 le agrego seguidor

        comprador.addFollowed(1);//comprador id 3 le agrego un seguido
        comprador.addFollowed(2);//comprador id 3 le agrego un seguido

        List<UsuarioDTO> listComp3asc = new ArrayList<>(); // Lista ordenada asc de Seguidos que voy a esperar como resultado
        listComp3asc.add(new UsuarioDTO(1,"vendedor1"));
        listComp3asc.add(new UsuarioDTO(2,"vendedor2"));
        SeguidosDTO comp3asc= new SeguidosDTO(3,"comprador1", listComp3asc);

        List<UsuarioDTO> listComp3desc = new ArrayList<>(); // Lista ordenada desc de Seguidos que voy a esperar como resultado
        listComp3desc.add(new UsuarioDTO(2,"vendedor2"));
        listComp3desc.add(new UsuarioDTO(1,"vendedor1"));
        SeguidosDTO comp3desc= new SeguidosDTO(3,"comprador1", listComp3desc);

        List<UsuarioDTO> listVend1asc = new ArrayList<>(); // Lista ordenada asc de Seguidores que voy a esperar como resultado
        listVend1asc.add(new UsuarioDTO(3,"comprador1"));
        listVend1asc.add(new UsuarioDTO(4,"comprador2"));
        SeguidoresDTO vend1asc= new SeguidoresDTO(1,"vendedor1", listVend1asc);

        List<UsuarioDTO> listVend1desc = new ArrayList<>(); // Lista ordenada desc de Seguidores que voy a esperar como resultado
        listVend1desc.add(new UsuarioDTO(4,"comprador2"));
        listVend1desc.add(new UsuarioDTO(3,"comprador1"));
        SeguidoresDTO vend1desc= new SeguidoresDTO(1,"vendedor1", listVend1desc);

        //Mock
        Mockito.when(repository.getComprador(3)).thenReturn(comprador);
        Mockito.when(repository.getVendedor(1)).thenReturn(vendedor);
        Mockito.when(repository.getComprador(4)).thenReturn(comprador2);
        Mockito.when(repository.getVendedor(2)).thenReturn(vendedor2);

       //Act
        SeguidosDTO comp3ascReal = service.serviceCompradorListFollowed(3, "name_asc");
        SeguidoresDTO vend1ascReal =  service.serviceVendedorListFollowers(1,"name_asc");
        SeguidosDTO comp3descReal = service.serviceCompradorListFollowed(3, "name_desc");
        SeguidoresDTO vend1descReal =  service.serviceVendedorListFollowers(1,"name_desc");

       // Assert & verificar uso de mock
        Assertions.assertEquals(comp3asc,comp3ascReal); // Comparo las listas que me devolvio el metodo a testear VS a las creadas al incio del test
        Assertions.assertEquals(comp3desc,comp3descReal);
        Assertions.assertEquals(vend1asc,vend1ascReal);
        Assertions.assertEquals(vend1desc,vend1descReal);

        Mockito.verify(repository, Mockito.atLeastOnce()).getComprador(Mockito.anyInt());
        Mockito.verify(repository, Mockito.atLeastOnce()).getVendedor(Mockito.anyInt());

    }

    //T-0005 SE CUMPLE
    @Test
    public void validationOrderDateTest()
    {
        // Arrange
        Vendedor vendedor = new Vendedor(1,"vendedor1");// Creo vendedor
        Comprador comprador = new Comprador(2,"comprador1");// Creo comprador
        vendedor.addFollower(2); //vendedor agregar seguidor
        comprador.addFollowed(1); //comprador agrega seguido

        List<Publicacion> postList = new ArrayList<>(); //Creo lista de Post y agrego post de prueba
        Publicacion p1 = new Publicacion(1,1,1,1,LocalDate.now().minusDays(5),new Producto(1,"p1","t1","b1","c1","n1"));
        Publicacion p2 = new Publicacion(1,2,2,2,LocalDate.now().minusDays(10),new Producto(2,"p2","t2","b2","c2","n2"));
        Publicacion p3 = new Publicacion(1,3,3,3,LocalDate.now().minusDays(20),new Producto(3,"p3","t3","b3","c3","n3"));
        postList.add(p1);
        postList.add(p2);
        postList.add(p3);

        //Mock
        Mockito.when(repository.getComprador(2)).thenReturn(comprador);
        Mockito.when(repository.getPublicaciones()).thenReturn(postList);

        //Act
        service.serviceListadoPublicaciones(2,"date_asc");
        service.serviceListadoPublicaciones(2,"date_desc");

        // Assert & verificar uso de mock
        Mockito.verify(repository, Mockito.atLeastOnce()).getComprador(Mockito.anyInt());
        Mockito.verify(repository, Mockito.atLeastOnce()).getPublicaciones();

        Mockito.verify(repository, Mockito.atLeast(5)).getComprador(Mockito.anyInt());

    }

    //T-0005 NO SE CUMPLE
    @Test
    public void validationNotOrderDateTest()
    {
        // Arrange
        Vendedor vendedor = new Vendedor(1,"vendedor1");
        Comprador comprador = new Comprador(2,"comprador1");
        vendedor.addFollower(2);
        comprador.addFollowed(1);

        //Mock
        Mockito.when(repository.getComprador(2)).thenReturn(comprador);
        /*Mockito.when(repository.getPublicaciones()).thenReturn(postList);*/

        // Assert Act & verificar uso de mock

        Assertions.assertThrows(NotValidParamException.class,() -> service.serviceListadoPublicaciones(2, "date_desc***"));
        Assertions.assertThrows(NotValidParamException.class,() -> service.serviceListadoPublicaciones(2,"date_asc***"));
        Mockito.verify(repository, Mockito.atLeastOnce()).getComprador(Mockito.anyInt());


    }

    //T-0006
    @Test
    public void postListOrderTest()
    {
        // Arrange
        Vendedor vendedor = new Vendedor(1,"vendedor1");
        Comprador comprador = new Comprador(2,"comprador1");
        vendedor.addFollower(2);
        comprador.addFollowed(1);
        List<Publicacion> postList = new ArrayList<>();//Lista Base
        List<Publicacion> postListExpectedAsc = new ArrayList<>();// Lista ordeanada ASC
        List<Publicacion> postListExpectedDesc = new ArrayList<>();// Lista Ordenada DESC

        Publicacion p1 = new Publicacion(1,1,1,1,LocalDate.now().minusDays(5),new Producto(1,"p1","t1","b1","c1","n1"));
        Publicacion p2 = new Publicacion(1,2,2,2,LocalDate.now().minusDays(10),new Producto(2,"p2","t2","b2","c2","n2"));
        Publicacion p3 = new Publicacion(1,3,3,3,LocalDate.now().minusDays(8),new Producto(3,"p3","t3","b3","c3","n3"));

        postList.add(p1);//Lista Base
        postList.add(p2);
        postList.add(p3);

        postListExpectedAsc.add(p2);// Lista ordeanada ASC
        postListExpectedAsc.add(p3);
        postListExpectedAsc.add(p1);

        postListExpectedDesc.add(p1); // Lista Ordenada DESC
        postListExpectedDesc.add(p3);
        postListExpectedDesc.add(p2);


        //Mock
        Mockito.when(repository.getComprador(2)).thenReturn(comprador);
        Mockito.when(repository.getPublicaciones()).thenReturn(postList);

        //Act
        List<PublicacionesDTO> pDToAsc =service.serviceListadoPublicaciones(2,"date_asc");
        List<PublicacionesDTO> pDToDesc =service.serviceListadoPublicaciones(2,"date_desc");

        // Assert & verificar uso de mock
        Assertions.assertEquals(pDToAsc.get(0).getPosts(),postListExpectedAsc);
        Assertions.assertEquals(pDToDesc.get(0).getPosts(),postListExpectedDesc);

        Mockito.verify(repository, Mockito.atLeastOnce()).getComprador(Mockito.anyInt());
        Mockito.verify(repository, Mockito.atLeastOnce()).getPublicaciones();
        //Mockito.verify(repository, Mockito.atLeastOnce()).getVendedor(Mockito.anyInt());

        Mockito.verify(repository, Mockito.atLeast(5)).getComprador(Mockito.anyInt());

    }

    //T-0007
    @Test
    public void countFollowersTest()
    {
        // Arrange
        Vendedor vendedor = new Vendedor(1,"vendedor1");
        Comprador comprador = new Comprador(2,"comprador1");
        Comprador comprador2 = new Comprador(3,"comprador2");
        vendedor.addFollower(2);
        vendedor.addFollower(3);
        comprador.addFollowed(1);
        comprador2.addFollowed(1);

        //Mock

        Mockito.when(repository.getVendedor(1)).thenReturn(vendedor);

        //Act
        CountSeguidoresDTO countDTO = service.serviceCountVendedorFollowers(1);

        // Assert & verificar uso de mock
        Assertions.assertEquals(countDTO.getFollowers_count(),2);
        Mockito.verify(repository, Mockito.atLeastOnce()).getVendedor(Mockito.anyInt());
    }

    //T-0008
    @Test
    public void postList14DaysOrderTest()
    {
        // Arrange
        Vendedor vendedor = new Vendedor(1,"vendedor1");
        Comprador comprador = new Comprador(2,"comprador1");
        vendedor.addFollower(2);
        comprador.addFollowed(1);

        List<Publicacion> postList = new ArrayList<>(); //Creo lista de Post y agrego post de prueba
        Publicacion p1 = new Publicacion(1,1,1,1,LocalDate.now().minusDays(5),new Producto(1,"p1","t1","b1","c1","n1"));
        Publicacion p2 = new Publicacion(1,2,2,2,LocalDate.now().minusDays(10),new Producto(2,"p2","t2","b2","c2","n2"));
        Publicacion p3 = new Publicacion(1,3,3,3,LocalDate.now().minusDays(20),new Producto(3,"p3","t3","b3","c3","n3"));
        postList.add(p1);
        postList.add(p2);
        postList.add(p3);

        List<Publicacion> postListExpectedAsc = new ArrayList<>();// Lista ordeanada ASC que voy a esperar como resultado
        postListExpectedAsc.add(p2); // Lista ordeanada ASC
        postListExpectedAsc.add(p1);

        List<Publicacion> postListExpectedDesc = new ArrayList<>();// Lista Ordenada DESC que voy a esperar como resultado
        postListExpectedDesc.add(p1); // Lista Ordenada DESC
        postListExpectedDesc.add(p2);

        //Mock
        Mockito.when(repository.getComprador(2)).thenReturn(comprador);
        Mockito.when(repository.getPublicaciones()).thenReturn(postList);

        //Act
        List<PublicacionesDTO> pDToAsc =service.serviceListadoPublicaciones(2,"date_asc");
        List<PublicacionesDTO> pDToDesc =service.serviceListadoPublicaciones(2,"date_desc");

        // Assert & verificar uso de mock
        Assertions.assertEquals(pDToAsc.get(0).getPosts(),postListExpectedAsc); // Comparo lista esperada con lista recibida
        Assertions.assertEquals(pDToDesc.get(0).getPosts(),postListExpectedDesc); // Comparo lista esperada con lista recibida

        Mockito.verify(repository, Mockito.atLeastOnce()).getComprador(Mockito.anyInt());
        Mockito.verify(repository, Mockito.atLeastOnce()).getPublicaciones();


        Mockito.verify(repository, Mockito.atLeast(5)).getComprador(Mockito.anyInt());

    }

}
