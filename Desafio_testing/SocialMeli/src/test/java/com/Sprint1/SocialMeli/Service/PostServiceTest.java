package com.Sprint1.SocialMeli.Service;

import com.Sprint1.SocialMeli.DTO.PostListDTO;
import com.Sprint1.SocialMeli.DTO.UserFollowersListDTO;
import com.Sprint1.SocialMeli.DTO.UserShortDTO;
import com.Sprint1.SocialMeli.Exceptions.BadRequestExcepcion;
import com.Sprint1.SocialMeli.Exceptions.UserNotFoundException;
import com.Sprint1.SocialMeli.Model.Post;
import com.Sprint1.SocialMeli.Model.Product;
import com.Sprint1.SocialMeli.Model.User;
import com.Sprint1.SocialMeli.Repository.PostRepositoryImpl;
import com.Sprint1.SocialMeli.Repository.UserRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PostServiceTest {

    @Mock
    private UserRepositoryImpl mockUserRepository;
    @Mock
    private PostRepositoryImpl mockPostRepository;

    @InjectMocks
    private PostServiceImpl postService;

    @Test
    void existeOrdenamientoFecha() {
        //Arrange
        String order = "date_asc";

        List<UserShortDTO> listaFolloweds = new ArrayList<>();
        UserShortDTO usuarioDTO1 = new UserShortDTO(1, "UserNameDTO");
        listaFolloweds.add(usuarioDTO1);

        int userId = 10;
        User usuario = new User();
        usuario.setUserId(userId);
        usuario.setFolloweds(listaFolloweds);

        List<Post> listaPosts = new ArrayList<>();
        Post post01 = new Post(1, 1, LocalDate.parse("2021-11-01"), new Product(1, "Product1", "Type1", "Brand1", "Color1", "Notes1"), 100, 50.00, false, 00.00);
        Post post02 = new Post(1, 2, LocalDate.parse("2021-11-15"), new Product(2, "Product2", "Type2", "Brand2", "Color2", "Notes2"), 200, 50.00, false, 00.00);
        Post post03 = new Post(1, 3, LocalDate.parse("2021-11-29"), new Product(3, "Product3", "Type3", "Brand3", "Color3", "Notes3"), 300, 50.00, false, 00.00);
        listaPosts.add(post01); listaPosts.add(post02); listaPosts.add(post03);

        when(mockUserRepository.existeUsuario(userId)).thenReturn(true);
        when(mockUserRepository.obtenerUsuario(userId)).thenReturn(usuario);
        when(mockPostRepository.obtenerPostsPorVendedor(usuarioDTO1.getUserId())).thenReturn(listaPosts);

        //Act
        PostListDTO result = postService.obtenerListadoPostsDeVendedor(userId, order);

        //Assert
        assertAll(
                ()->assertNotNull(result),
                ()->verify(mockPostRepository, atLeastOnce()).obtenerPostsPorVendedor(usuarioDTO1.getUserId())
        );
    }

    @Test
    //Es de esperar que este test falle, ya que en el código original si Order es null,
    //se devuelve la lista de post ordenada de manera ascendente y no lanza excepcion
    void noExisteOrdenamientoFecha() {
        //Arrange
        String order = null;

        List<UserShortDTO> listaFolloweds = new ArrayList<>();
        UserShortDTO usuarioDTO1 = new UserShortDTO(1, "UserNameDTO");
        listaFolloweds.add(usuarioDTO1);

        int userId = 10;
        User usuario = new User();
        usuario.setUserId(userId);
        usuario.setFolloweds(listaFolloweds);

        List<Post> listaPosts = new ArrayList<>();
        Post post01 = new Post(1, 1, LocalDate.parse("2021-11-01"), new Product(1, "Product1", "Type1", "Brand1", "Color1", "Notes1"), 100, 50.00, false, 00.00);
        Post post02 = new Post(1, 2, LocalDate.parse("2021-11-15"), new Product(2, "Product2", "Type2", "Brand2", "Color2", "Notes2"), 200, 50.00, false, 00.00);
        Post post03 = new Post(1, 3, LocalDate.parse("2021-11-29"), new Product(3, "Product3", "Type3", "Brand3", "Color3", "Notes3"), 300, 50.00, false, 00.00);
        listaPosts.add(post01); listaPosts.add(post02); listaPosts.add(post03);

        when(mockUserRepository.existeUsuario(userId)).thenReturn(true);
        when(mockUserRepository.obtenerUsuario(userId)).thenReturn(usuario);
        when(mockPostRepository.obtenerPostsPorVendedor(usuarioDTO1.getUserId())).thenReturn(listaPosts);

        //Act & Assert
        //Expected java.lang.RuntimeException to be thrown, but nothing was thrown.
        assertAll(
                ()->assertThrows(RuntimeException.class, () -> postService.obtenerListadoPostsDeVendedor(userId, order)),
                ()->verify(mockPostRepository, atLeastOnce()).obtenerPostsPorVendedor(usuarioDTO1.getUserId())
        );



    }

    @Test
    void verificaOrdenaminetoFechaAscendente() {
        //Arrange
        String order = "date_asc";

        List<UserShortDTO> listaFolloweds = new ArrayList<>();
        UserShortDTO usuarioDTO1 = new UserShortDTO(1, "UserNameDTO");
        listaFolloweds.add(usuarioDTO1);

        int userId = 10;
        User usuario = new User();
        usuario.setUserId(userId);
        usuario.setFolloweds(listaFolloweds);

        List<Post> listaPosts = new ArrayList<>();
        Post post01 = new Post(1, 1, LocalDate.parse("2021-11-29"), new Product(1, "Product1", "Type1", "Brand1", "Color1", "Notes1"), 100, 50.00, false, 00.00);
        Post post02 = new Post(1, 2, LocalDate.parse("2021-11-27"), new Product(2, "Product2", "Type2", "Brand2", "Color2", "Notes2"), 200, 50.00, false, 00.00);
        Post post03 = new Post(1, 3, LocalDate.parse("2021-11-28"), new Product(3, "Product3", "Type3", "Brand3", "Color3", "Notes3"), 300, 50.00, false, 00.00);
        listaPosts.add(post01); listaPosts.add(post02); listaPosts.add(post03);

        when(mockUserRepository.existeUsuario(userId)).thenReturn(true);
        when(mockUserRepository.obtenerUsuario(userId)).thenReturn(usuario);
        when(mockPostRepository.obtenerPostsPorVendedor(usuarioDTO1.getUserId())).thenReturn(listaPosts);

        //Act
        PostListDTO result = postService.obtenerListadoPostsDeVendedor(userId, order);

        //Assert
        assertAll(
                ()->assertEquals(2, result.getPosts().get(0).getIdPost()),
                ()->assertEquals(3, result.getPosts().get(1).getIdPost()),
                ()->assertEquals(1, result.getPosts().get(2).getIdPost()),
                ()->verify(mockPostRepository, atLeastOnce()).obtenerPostsPorVendedor(usuarioDTO1.getUserId())
        );
    }

    @Test
    void verificaOrdenaminetoFechaDescendente() {
        //Arrange
        String order = "date_desc";

        List<UserShortDTO> listaFolloweds = new ArrayList<>();
        UserShortDTO usuarioDTO1 = new UserShortDTO(1, "UserNameDTO");
        listaFolloweds.add(usuarioDTO1);

        int userId = 10;
        User usuario = new User();
        usuario.setUserId(userId);
        usuario.setFolloweds(listaFolloweds);

        List<Post> listaPosts = new ArrayList<>();
        Post post01 = new Post(1, 1, LocalDate.parse("2021-11-29"), new Product(1, "Product1", "Type1", "Brand1", "Color1", "Notes1"), 100, 50.00, false, 00.00);
        Post post02 = new Post(1, 2, LocalDate.parse("2021-11-27"), new Product(2, "Product2", "Type2", "Brand2", "Color2", "Notes2"), 200, 50.00, false, 00.00);
        Post post03 = new Post(1, 3, LocalDate.parse("2021-11-28"), new Product(3, "Product3", "Type3", "Brand3", "Color3", "Notes3"), 300, 50.00, false, 00.00);
        listaPosts.add(post01); listaPosts.add(post02); listaPosts.add(post03);

        when(mockUserRepository.existeUsuario(userId)).thenReturn(true);
        when(mockUserRepository.obtenerUsuario(userId)).thenReturn(usuario);
        when(mockPostRepository.obtenerPostsPorVendedor(usuarioDTO1.getUserId())).thenReturn(listaPosts);

        //Act
        PostListDTO result = postService.obtenerListadoPostsDeVendedor(userId, order);

        //Assert
        assertAll(
                ()->assertEquals(1, result.getPosts().get(0).getIdPost()),
                ()->assertEquals(3, result.getPosts().get(1).getIdPost()),
                ()->assertEquals(2, result.getPosts().get(2).getIdPost()),
                ()->verify(mockPostRepository, atLeastOnce()).obtenerPostsPorVendedor(usuarioDTO1.getUserId())
        );
    }



    @Test
        //Verifico que de las 5 publicaciones mockeadas (todas dentro de las últimas 2 semanas),
        //el servicio devuelva las 5
    void verificaPostUltimasDosSemanas1() {
        //Arrange
        String order = "date_asc";

        List<UserShortDTO> listaFolloweds = new ArrayList<>();
        UserShortDTO usuarioDTO1 = new UserShortDTO(1, "UserNameDTO");
        listaFolloweds.add(usuarioDTO1);

        int userId = 10;
        User usuario = new User();
        usuario.setUserId(userId);
        usuario.setFolloweds(listaFolloweds);

        List<Post> listaPosts = new ArrayList<>();
        Post post01 = new Post(1, 1, LocalDate.parse("2021-11-25"), new Product(1, "Product1", "Type1", "Brand1", "Color1", "Notes1"), 100, 50.00, false, 00.00);
        Post post02 = new Post(1, 2, LocalDate.parse("2021-11-26"), new Product(2, "Product2", "Type2", "Brand2", "Color2", "Notes2"), 200, 50.00, false, 00.00);
        Post post03 = new Post(1, 3, LocalDate.parse("2021-11-27"), new Product(3, "Product3", "Type3", "Brand3", "Color3", "Notes3"), 300, 50.00, false, 00.00);
        Post post04 = new Post(1, 4, LocalDate.parse("2021-11-28"), new Product(4, "Product4", "Type4", "Brand4", "Color4", "Notes4"), 400, 50.00, false, 00.00);
        Post post05 = new Post(1, 5, LocalDate.parse("2021-11-29"), new Product(5, "Product5", "Type5", "Brand5", "Color5", "Notes5"), 500, 50.00, false, 00.00);
        listaPosts.add(post01); listaPosts.add(post02); listaPosts.add(post03); listaPosts.add(post04); listaPosts.add(post05);

        when(mockUserRepository.existeUsuario(userId)).thenReturn(true);
        when(mockUserRepository.obtenerUsuario(userId)).thenReturn(usuario);
        when(mockPostRepository.obtenerPostsPorVendedor(usuarioDTO1.getUserId())).thenReturn(listaPosts);

        //Act
        PostListDTO result = postService.obtenerListadoPostsDeVendedor(userId, order);

        //Assert
        assertAll(
                ()->assertTrue(result.getPosts().size() == 5),
                ()->verify(mockPostRepository, atLeastOnce()).obtenerPostsPorVendedor(usuarioDTO1.getUserId())
        );
    }

    @Test
        //Verifico que de las 5 publicaciones mockeadas (3 de ellas dentro de las últimas 2 semanas),
        //el servicio devuelva sólo 3
    void verificaPostUltimasDosSemanas2() {
        //Arrange
        String order = "date_asc";

        List<UserShortDTO> listaFolloweds = new ArrayList<>();
        UserShortDTO usuarioDTO1 = new UserShortDTO(1, "UserNameDTO");
        listaFolloweds.add(usuarioDTO1);

        int userId = 10;
        User usuario = new User();
        usuario.setUserId(userId);
        usuario.setFolloweds(listaFolloweds);

        List<Post> listaPosts = new ArrayList<>();
        Post post01 = new Post(1, 1, LocalDate.parse("2021-11-27"), new Product(1, "Product1", "Type1", "Brand1", "Color1", "Notes1"), 100, 50.00, false, 00.00);
        Post post02 = new Post(1, 2, LocalDate.parse("2021-01-01"), new Product(2, "Product2", "Type2", "Brand2", "Color2", "Notes2"), 200, 50.00, false, 00.00);
        Post post03 = new Post(1, 3, LocalDate.parse("2021-11-28"), new Product(3, "Product3", "Type3", "Brand3", "Color3", "Notes3"), 300, 50.00, false, 00.00);
        Post post04 = new Post(1, 4, LocalDate.parse("2021-01-02"), new Product(4, "Product4", "Type4", "Brand4", "Color4", "Notes4"), 400, 50.00, false, 00.00);
        Post post05 = new Post(1, 5, LocalDate.parse("2021-11-29"), new Product(5, "Product5", "Type5", "Brand5", "Color5", "Notes5"), 500, 50.00, false, 00.00);
        listaPosts.add(post01); listaPosts.add(post02); listaPosts.add(post03); listaPosts.add(post04); listaPosts.add(post05);

        when(mockUserRepository.existeUsuario(userId)).thenReturn(true);
        when(mockUserRepository.obtenerUsuario(userId)).thenReturn(usuario);
        when(mockPostRepository.obtenerPostsPorVendedor(usuarioDTO1.getUserId())).thenReturn(listaPosts);

        //Act
        PostListDTO result = postService.obtenerListadoPostsDeVendedor(userId, order);

        //Assert
        assertAll(
                ()->assertTrue(result.getPosts().size() == 3),
                ()->verify(mockPostRepository, atLeastOnce()).obtenerPostsPorVendedor(usuarioDTO1.getUserId())
        );
    }
}
