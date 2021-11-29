package com.bootcamp.SocialMeli.service;

import com.bootcamp.SocialMeli.DTO.*;
import com.bootcamp.SocialMeli.Exception.InvalidSocialException;
import com.bootcamp.SocialMeli.Exception.NotFoundException;
import com.bootcamp.SocialMeli.Mapper.SocialMapper;
import com.bootcamp.SocialMeli.Model.DetallePublicacion;
import com.bootcamp.SocialMeli.Model.Publicacion;
import com.bootcamp.SocialMeli.Model.Seguidor;
import com.bootcamp.SocialMeli.Model.Usuario;
import com.bootcamp.SocialMeli.Repository.SocialRepository;
import com.bootcamp.SocialMeli.Service.SocialService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@ExtendWith(MockitoExtension.class)
public class SocialServiceTest {

    @Mock
    SocialRepository socialRepository;

    @InjectMocks
    SocialService socialService;

    @AfterEach
    public void resetMocks(){
        Mockito.reset(socialRepository);
    }

    //Arange
    List<Seguidor> seguido;
    int userId=1;
    int userId2=2;
    int userToFollow=3;
    int userToUnFollow=4;
    Usuario user;
    Usuario user2;
    Usuario userFollow;
    Usuario userUnFollow;
    Seguidor follow;
    Seguidor follow2;
    List<UsuarioDTO> userDTO;
    List<Seguidor> seguidor;
    SeguidoresDTO followersDTO;
    DetallePublicacion det1;
    Publicacion pub1;
    DetallePublicacion det2;
    Publicacion pub2;
    DetallePublicacion det3;
    Publicacion pub3;
    List<PublicacionDTO> publicacion;
    List<Publicacion> publicList;
    PublicUserDTO pubuserDTO;



    @BeforeEach
    public void inicializa(){
        //Lista inicial de seguidores
        this.seguido = new ArrayList<>();
        seguido.add(new Seguidor(1,3));
        seguido.add(new Seguidor(1,4));
        seguido.add(new Seguidor(2,3));
        seguido.add(new Seguidor(2,4));
        //crea usuarios
        this.user= new Usuario();
        user.setUserId(userId);
        user.setUserName("Bootcamp");

        this.user2= new Usuario();
        user2.setUserId(userId2);
        user2.setUserName("Pepe");

        this.userFollow=new Usuario();
        userFollow.setUserId(userToFollow);
        userFollow.setUserName("Mario");

        this.userUnFollow=new Usuario();
        userUnFollow.setUserId(userToUnFollow);
        userUnFollow.setUserName("Camilo");
        //inicializa seguidores y usuarios en null
        this.follow=new Seguidor();
        this.follow2=new Seguidor();

        this.seguidor=new ArrayList<>();


        this.followersDTO= new SeguidoresDTO();

        this.userDTO = new ArrayList<>();

        //crea publicaciones
        this.det1= new DetallePublicacion(1,"Camiseta","Ropa","Sport","Azul","Slim");
        this.pub1= new Publicacion(3,1,LocalDate.of(2021,11,26),det1,100,15000.00);
        this.det2= new DetallePublicacion(2,"Camiseta","Ropa","Sport","Rojo","Slim");
        this.pub2= new Publicacion(3,2,LocalDate.of(2021,10,20),det2,100,15000.00);
        this.det3= new DetallePublicacion(3,"Camiseta","Ropa","Sport","Blanco","Slim");
        this.pub3= new Publicacion(3,3,LocalDate.of(2021,11,22),det3,100,15000.00);

        //Asocia publicacion de vendedores seguidos a un usuario que los sigue.
        this.pubuserDTO= new PublicUserDTO();
        pubuserDTO.setUserId(userId);
        pubuserDTO.setPosts(publicacion);
        //añade publicaciones
        this.publicacion= new ArrayList<>();
        publicacion.add(SocialMapper.PublicacionTOPublicacionDTO(pub1));
        publicacion.add(SocialMapper.PublicacionTOPublicacionDTO(pub2));
        publicacion.add(SocialMapper.PublicacionTOPublicacionDTO(pub3));
        this.publicList=new ArrayList<>();
        publicList.add(pub1);
        publicList.add(pub2);
        publicList.add(pub3);
    }
    //T-0001
    @Test
    @DisplayName(value = "Verifica que el vendedor a seguir exista.")
    public void followSellerExist() throws NotFoundException{
        //Mock
        follow.setIdUser(userId);
        follow.setIdUserFollow(userToFollow);
        seguidor.add(follow);
        Mockito.when(socialRepository.getUsuario(userId)).thenReturn(user);
        Mockito.when(socialRepository.getUsuario(userToFollow)).thenReturn(userFollow);
        //Act.
        Assertions.assertDoesNotThrow(()-> socialService.postSeguidor(follow)); //Valida que no salte excepciones
        SeguidorDTO foll=socialService.postSeguidor(follow); //Sigue a un usuario.
        //Assert
        System.out.println("------------------------Follow---------------------------");
        System.out.println(foll);
        Mockito.verify(socialRepository, Mockito.atLeastOnce()).getUsuario(userId);
        Mockito.verify(socialRepository, Mockito.atLeastOnce()).getUsuario(userToFollow);
        Assertions.assertEquals(userToFollow,foll.getIdUserFollow());
    }

    @Test
    @DisplayName(value = "Verifica que el vendedor a seguir no exista.")
    public void followSellerNoExist() throws NotFoundException{
        //Mock
        follow.setIdUser(userId);
        follow.setIdUserFollow(userToFollow);
        seguidor.add(follow);
        Mockito.when(socialRepository.getUsuario(userId)).thenReturn(user);
        Mockito.when(socialRepository.getUsuario(userToFollow)).thenThrow(NotFoundException.class);
        //Act y accert
        Assertions.assertThrows(NotFoundException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                socialService.postSeguidor(follow);
            }
        });  // valida que exista la excepción
    }
    //T-0002
    @Test
    @DisplayName(value = "Verifica que el vendedor a dejar de seguir si sea seguido con anterioridad.")
    public void unFollowSellerNoFollwer() {
        //Mock
        follow.setIdUser(userId2);
        follow.setIdUserFollow(userToUnFollow);
        seguidor.add(follow);
        Mockito.when(socialRepository.getUsuario(userId2)).thenReturn(user2);
        Mockito.when(socialRepository.getUsuario(userToUnFollow)).thenThrow(InvalidSocialException.class);
        //Act y assert
        Assertions.assertThrows(InvalidSocialException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                SeguidorDTO unFoll=socialService.unFollow(follow); //Deja de seguir a un usuario.
                Assertions.assertNull(unFoll);
            }
        });  // valida que exista la excepción
    }

    @Test
    @DisplayName(value = "Verifica que el vendedor a dejar de seguir exista.")
    public void unFollowSellerExist() throws NotFoundException{
        //Mock
        follow.setIdUser(userId2);
        follow.setIdUserFollow(userToUnFollow);
        seguidor.add(follow);
        Mockito.when(socialRepository.getUsuario(userId2)).thenReturn(user2);
        Mockito.when(socialRepository.getUsuario(userToUnFollow)).thenReturn(userUnFollow);
        Mockito.when(socialRepository.Follow(follow)).thenReturn(follow);
        //Act.
        socialService.postSeguidor(follow);
        socialRepository.Follow(follow);
        SeguidorDTO unfoll=socialService.unFollow(follow); //Sigue a un usuario.

        //Assert
        Mockito.verify(socialRepository, Mockito.atLeastOnce()).getUsuario(userId2);
        Mockito.verify(socialRepository, Mockito.atLeastOnce()).getUsuario(userToUnFollow);
        Mockito.verify(socialRepository, Mockito.atLeastOnce()).Follow(follow);
        Assertions.assertNull(unfoll);
    }

    @Test
    @DisplayName(value = "Verifica que el vendedor a dejar de seguir no exista.")
    public void unFollowSellerNoExist() throws NotFoundException{
        //Mock
        follow.setIdUser(userId2);
        follow.setIdUserFollow(userToUnFollow);
        seguidor.add(follow);
        Mockito.when(socialRepository.getUsuario(userId2)).thenReturn(user);
        Mockito.when(socialRepository.getUsuario(userToUnFollow)).thenThrow(NotFoundException.class);
        //Act y accert
        Assertions.assertThrows(NotFoundException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                socialService.unFollow(follow);
            }
        });  // valida que exista la excepción
    }
    //T-0003
    @Test
    @DisplayName(value = "Genera excepción al intentar traer un listado cuando el ordenamiento debe ser null")
    void followersOrderByNull(){
        //Arrange
        follow2.setIdUser(userId2);
        follow2.setIdUserFollow(userToFollow);
        seguidor.add(follow2);
        followersDTO.setUserId(userFollow.getUserId());
        followersDTO.setUserName(userFollow.getUserName());
        userDTO.add(SocialMapper.UsuarioToUsuarioDTO(user));
        userDTO.add(SocialMapper.UsuarioToUsuarioDTO(user2));
        followersDTO.setFollowers(userDTO);
        follow.setIdUser(userId);
        follow.setIdUserFollow(userToFollow);
        seguidor.add(follow);

        Mockito.when(socialRepository.getSeguidor()).thenReturn(seguidor);
        Mockito.when(socialRepository.getUsuario(userToFollow)).thenReturn(userFollow);
        Mockito.when(socialRepository.getUsuario(userId)).thenReturn(user);
        Mockito.when(socialRepository.getUsuario(userId2)).thenReturn(user2);
        //Act and Assert
        Assertions.assertThrows(NullPointerException.class, new Executable() {

            @Override
            public void execute() throws Throwable {
                socialService.getOrderFollow(userId,null);
            }
        });
    }
    //T-0004
    @Test
    @DisplayName(value = "Trae listado de seguidores ordenados por nombre ascendientemente")
    public void followersOrderByNameAsc(){
        //Arrange
        follow2.setIdUser(userId2);
        follow2.setIdUserFollow(userToFollow);
        seguidor.add(follow2);
        followersDTO.setUserId(userFollow.getUserId());
        followersDTO.setUserName(userFollow.getUserName());
        userDTO.add(SocialMapper.UsuarioToUsuarioDTO(user));
        userDTO.add(SocialMapper.UsuarioToUsuarioDTO(user2));
        followersDTO.setFollowers(userDTO);
        follow.setIdUser(userId);
        follow.setIdUserFollow(userToFollow);
        seguidor.add(follow);



        Mockito.when(socialRepository.getSeguidor()).thenReturn(seguidor);
        Mockito.when(socialRepository.getUsuario(userToFollow)).thenReturn(userFollow);
        Mockito.when(socialRepository.getUsuario(userId)).thenReturn(user);
        Mockito.when(socialRepository.getUsuario(userId2)).thenReturn(user2);
        //Act
        SeguidoresDTO expect = socialService.getOrderFollow(userFollow.getUserId(),"name_asc");
        //Assert
        System.out.println("\n----------------------followersOrderByNameAsc--------------------------");
        System.out.println(expect);
        Assertions.assertTrue(expect.getFollowers().get(0).getUserName().compareTo(expect.getFollowers().get(1).getUserName())<=0);
    }

    @Test
    @DisplayName(value = "Trae listado de seguidores ordenados por nombre descendientemente")
    public void followersOrderByNameDesc(){
        //Arrange
        followersDTO.setUserId(userFollow.getUserId());
        followersDTO.setUserName(userFollow.getUserName());
        userDTO.add(SocialMapper.UsuarioToUsuarioDTO(user));
        userDTO.add(SocialMapper.UsuarioToUsuarioDTO(user2));
        followersDTO.setFollowers(userDTO);
        follow.setIdUser(userId);
        follow.setIdUserFollow(userToFollow);
        seguidor.add(follow);
        follow2.setIdUser(userId2);
        follow2.setIdUserFollow(userToFollow);
        seguidor.add(follow2);

        Mockito.when(socialRepository.getSeguidor()).thenReturn(seguidor);
        Mockito.when(socialRepository.getUsuario(userToFollow)).thenReturn(userFollow);
        Mockito.when(socialRepository.getUsuario(userId)).thenReturn(user);
        Mockito.when(socialRepository.getUsuario(userId2)).thenReturn(user2);
        //Act
        SeguidoresDTO expect = socialService.getOrderFollow(userFollow.getUserId(),"name_desc");
        //Assert
        System.out.println("\n-----------------------followersOrderByNameDesc--------------------------");
        System.out.println(expect);
        Assertions.assertTrue(expect.getFollowers().get(0).getUserName().compareTo(expect.getFollowers().get(1).getUserName())>=0);
    }

    @Test
    @DisplayName(value = "Trae listado de seguidos ordenados por nombre ascendientemente")
    public void followedOrderByNameAsc(){
        //Arrange
        followersDTO.setUserId(user.getUserId());
        followersDTO.setUserName(user.getUserName());
        userDTO.add(SocialMapper.UsuarioToUsuarioDTO(userFollow));
        userDTO.add(SocialMapper.UsuarioToUsuarioDTO(userUnFollow));
        followersDTO.setFollowers(userDTO);
        follow.setIdUser(userId);
        follow.setIdUserFollow(userToFollow);
        seguidor.add(follow);
        follow2.setIdUser(userId);
        follow2.setIdUserFollow(userToUnFollow);
        seguidor.add(follow2);


        //Mocks
        Mockito.when(socialRepository.getSeguidor()).thenReturn(seguidor);
        Mockito.when(socialRepository.getUsuario(userToFollow)).thenReturn(userFollow);
        Mockito.when(socialRepository.getUsuario(userId)).thenReturn(user);
        Mockito.when(socialRepository.getUsuario(userToUnFollow)).thenReturn(user2);

        //Act
        SeguidoresDTO expect = socialService.getOrderFollowed(userId,"name_asc");
        //Assert
        System.out.println("\n-----------------------followedOrderByNameAsc----------------------------");
        System.out.println(expect);
        Assertions.assertTrue(expect.getFollowers().get(0).getUserName().compareTo(expect.getFollowers().get(1).getUserName())<=0);
    }
    @Test
    @DisplayName(value = "Trae listado de seguidores ordenados por nombre descendientemente")
    public void followedOrderByNameDesc(){
        //Arrange
        followersDTO.setUserId(user.getUserId());
        followersDTO.setUserName(user.getUserName());
        userDTO.add(SocialMapper.UsuarioToUsuarioDTO(userFollow));
        userDTO.add(SocialMapper.UsuarioToUsuarioDTO(userUnFollow));
        followersDTO.setFollowers(userDTO);
        follow.setIdUser(userId);
        follow.setIdUserFollow(userToFollow);
        seguidor.add(follow);
        follow2.setIdUser(userId);
        follow2.setIdUserFollow(userToUnFollow);
        seguidor.add(follow2);


        //Mocks
        Mockito.when(socialRepository.getSeguidor()).thenReturn(seguidor);
        Mockito.when(socialRepository.getUsuario(userToFollow)).thenReturn(userFollow);
        Mockito.when(socialRepository.getUsuario(userId)).thenReturn(user);
        Mockito.when(socialRepository.getUsuario(userToUnFollow)).thenReturn(user2);

        //Act
        SeguidoresDTO expect = socialService.getOrderFollowed(userId,"name_desc");
        //Assert
        System.out.println("\n-----------------------followedOrderByNameAsc--------------------------");
        System.out.println(expect);
        Assertions.assertTrue(expect.getFollowers().get(0).getUserName().compareTo(expect.getFollowers().get(1).getUserName())>=0);
    }
    //T-0005 y T-0006
    @Test
    @DisplayName(value="Trae listado de publicaciones ordenadas por fecha asc")
    public void getPublicOrderByFechaAsc(){
        //Arrange
        follow.setIdUser(userId);
        follow.setIdUserFollow(userToFollow);
        seguidor.add(follow);
        //Mocks
        Mockito.when(socialRepository.getUsuario(userId)).thenReturn(user);
        Mockito.when(socialRepository.getUsuario(userToFollow)).thenReturn(userFollow);
        Mockito.when(socialRepository.getSeguidor()).thenReturn(seguidor);
        Mockito.when(socialRepository.getPublicacion(pub1.getIdPost())).thenReturn(pub1);
        Mockito.when(socialRepository.getPublicacion(pub2.getIdPost())).thenReturn(pub2);
        Mockito.when(socialRepository.getPublicacion(pub3.getIdPost())).thenReturn(pub3);
        Mockito.when(socialRepository.getPublicaciones(userToFollow)).thenReturn(publicList);
        //Act
        PublicUserDTO expected = socialService.getPubliOrderByFecha(userId,"date_asc");
        //Assert
        System.out.println("\n--------------------------publicOrderByFechaAsc-----------------------------");
        System.out.println(expected);
        Assertions.assertTrue(expected.getPosts().get(0).getDate().compareTo(expected.getPosts().get(1).getDate())<0);
    }

    @Test
    @DisplayName(value="Trae listado de publicaciones ordenadas por fecha desc")
    public void getPublicOrderByFechaDesc(){
        //Arrange
        follow.setIdUser(userId);
        follow.setIdUserFollow(userToFollow);
        seguidor.add(follow);
        //Mocks
        Mockito.when(socialRepository.getUsuario(userId)).thenReturn(user);
        Mockito.when(socialRepository.getUsuario(userToFollow)).thenReturn(userFollow);
        Mockito.when(socialRepository.getSeguidor()).thenReturn(seguidor);
        Mockito.when(socialRepository.getPublicacion(pub1.getIdPost())).thenReturn(pub1);
        Mockito.when(socialRepository.getPublicacion(pub2.getIdPost())).thenReturn(pub2);
        Mockito.when(socialRepository.getPublicacion(pub3.getIdPost())).thenReturn(pub3);
        Mockito.when(socialRepository.getPublicaciones(userToFollow)).thenReturn(publicList);
        //Act
        PublicUserDTO expected = socialService.getPubliOrderByFecha(userId,"date_desc");
        //Assert
        System.out.println("\n-------------------------publicOrderByFechaDesc----------------------------");
        System.out.println(expected);
        Assertions.assertTrue(expected.getPosts().get(0).getDate().compareTo(expected.getPosts().get(1).getDate())>0);
    }
    //T-0007
    @Test
    void followerCount(){
        //Arrange
        follow.setIdUser(userId);
        follow.setIdUserFollow(userToFollow);
        seguidor.add(follow);
        follow2.setIdUser(userId2);
        follow2.setIdUserFollow(userToFollow);
        seguidor.add(follow2);
        //Cuenta los seguidores
        SeguidoresCountDTO expec=new SeguidoresCountDTO(userFollow.getUserId(),userFollow.getUserName(),2);
        //Mocks
        Mockito.when(socialRepository.getSeguidor()).thenReturn(seguidor);
        Mockito.when(socialRepository.getUsuario(userToFollow)).thenReturn(userFollow);
        Mockito.when(socialRepository.getUsuario(userId)).thenReturn(user);
        Mockito.when(socialRepository.getUsuario(userId2)).thenReturn(user2);
        //Act
        SeguidoresCountDTO current = socialService.getSequidores(userFollow.getUserId());
        //Assert
        System.out.println("\n----------------------------followersCount-------------------------------");
        System.out.println(current);
        Assertions.assertEquals(expec.getFollowersCount(),current.getFollowersCount());
    }
    //T-0008
    @Test
    @DisplayName(value="Trae listado de publicaciones ordenadas por fecha desc filtrando las dos ultimas semanas")
    public void getPublicOrderByRecentFec(){
        //Arrange
        follow.setIdUser(userId);
        follow.setIdUserFollow(userToFollow);
        seguidor.add(follow);
        //Mocks
        Mockito.when(socialRepository.getUsuario(userId)).thenReturn(user);
        Mockito.when(socialRepository.getUsuario(userToFollow)).thenReturn(userFollow);
        Mockito.when(socialRepository.getSeguidor()).thenReturn(seguidor);
        Mockito.when(socialRepository.getPublicacion(pub1.getIdPost())).thenReturn(pub1);
        Mockito.when(socialRepository.getPublicacion(pub2.getIdPost())).thenReturn(pub2);  //Esta tiene fecha de octubre
        Mockito.when(socialRepository.getPublicacion(pub3.getIdPost())).thenReturn(pub3);
        Mockito.when(socialRepository.getPublicaciones(userToFollow)).thenReturn(publicList);
        //Act
        PublicUserDTO expected = socialService.getPublicacionesRecientes(userId,"date_desc");
        PublicUserDTO current = socialService.getPubliOrderByFecha(userId,"date_desc");

        //Assert
        System.out.println("---------------------------Publicaciones iniciales-------------------------------");
        System.out.println("Tamaño del arreglo: "+current.getPosts().size());
        System.out.println(current);
        System.out.println("\n---------------------------Publicaciones filtradas-------------------------------");
        System.out.println("Tamaño del arreglo: "+expected.getPosts().size());
        System.out.println(expected);

        Assertions.assertTrue(expected.getPosts().get(0).getDate().compareTo(expected.getPosts().get(1).getDate())>0);
        Assertions.assertNotEquals(expected.getPosts().size(),current.getPosts().size());
    }
}
