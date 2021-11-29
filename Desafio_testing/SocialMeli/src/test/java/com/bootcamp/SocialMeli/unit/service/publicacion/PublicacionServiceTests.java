package com.bootcamp.SocialMeli.unit.service.publicacion;

import com.bootcamp.SocialMeli.dto.producto.ProductoDTO;
import com.bootcamp.SocialMeli.dto.publicacion.*;
import com.bootcamp.SocialMeli.dto.usuario.FollowedListDTO;
import com.bootcamp.SocialMeli.dto.usuario.UsuarioDTO;
import com.bootcamp.SocialMeli.exception.BadRequestException;
import com.bootcamp.SocialMeli.mapper.ProductoMapper;
import com.bootcamp.SocialMeli.mapper.PublicacionMapper;
import com.bootcamp.SocialMeli.model.Producto;
import com.bootcamp.SocialMeli.model.Publicacion;
import com.bootcamp.SocialMeli.model.Usuario;
import com.bootcamp.SocialMeli.repository.publicacion.IPublicacionRepository;
import com.bootcamp.SocialMeli.repository.usuario.IUsuarioRepository;
import com.bootcamp.SocialMeli.service.publicacion.PublicacionService;
import com.bootcamp.SocialMeli.service.usuario.IUsuarioService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

@MockitoSettings(strictness = Strictness.LENIENT)
@ExtendWith(MockitoExtension.class)
public class PublicacionServiceTests {
    @Mock
    IPublicacionRepository repository;
    @Mock
    IUsuarioRepository repositoryUser;
    @Mock
    IUsuarioService usuarioService;

    @InjectMocks
    PublicacionService service = new PublicacionService(repository, repositoryUser, usuarioService, new PublicacionMapper(new ProductoMapper()));


    //T-0005
    @Test
    public void checkPublicationFollowedIsSorting() {
        Integer userIdFollower = 10;
        String order = "date_asc";

        UsuarioDTO followedListed = new UsuarioDTO(20, "María");
        List<UsuarioDTO> listFollowed = new ArrayList<>();
        listFollowed.add(followedListed);

        FollowedListDTO followedListDTO = new FollowedListDTO(userIdFollower, "", listFollowed);

        Publicacion publicacionListed = new Publicacion(followedListed.getUserId(), 1, LocalDate.now(), new Producto(), 2, 100.0, false, 0.0);
        List<Publicacion> listPublicacion = new ArrayList<>();
        listPublicacion.add(publicacionListed);

        PublicacionDTO publicacionDTOListed = new PublicacionDTO(null, publicacionListed.getIdPost(), publicacionListed.getDate(), new ProductoDTO(), publicacionListed.getCategory(), publicacionListed.getPrice());
        List<PublicacionDTO> listPublicacionDTO = new ArrayList<>();
        listPublicacionDTO.add(publicacionDTOListed);

        PublicacionFollowedDTO expected = new PublicacionFollowedDTO(userIdFollower, listPublicacionDTO);

        Mockito.when(repositoryUser.encontrarUsuario(userIdFollower)).thenReturn(true);
        Mockito.when(usuarioService.listaFollowed(userIdFollower, "name_asc")).thenReturn(followedListDTO);
        Mockito.when(repository.devolverPublicaciones(followedListed.getUserId())).thenReturn(listPublicacion);

        PublicacionFollowedDTO result = service.listaPublicacionesFollowed(userIdFollower, order);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void checkPublicationFollowedIsNotSorting() {
        Integer userIdFollower = 10;
        String order = "NOT ORDER";

        UsuarioDTO followedListed = new UsuarioDTO(20, "María");
        List<UsuarioDTO> listFollowed = new ArrayList<>();
        listFollowed.add(followedListed);

        FollowedListDTO followedListDTO = new FollowedListDTO(userIdFollower, "", listFollowed);

        Publicacion publicacionListed = new Publicacion(followedListed.getUserId(), 1, LocalDate.now(), new Producto(), 2, 100.0, false, 0.0);
        List<Publicacion> listPublicacion = new ArrayList<>();
        listPublicacion.add(publicacionListed);

        Mockito.when(repositoryUser.encontrarUsuario(userIdFollower)).thenReturn(true);
        Mockito.when(usuarioService.listaFollowed(userIdFollower, "name_asc")).thenReturn(followedListDTO);
        Mockito.when(repository.devolverPublicaciones(followedListed.getUserId())).thenReturn(listPublicacion);

        Assertions.assertThrows(BadRequestException.class, () -> service.listaPublicacionesFollowed(userIdFollower, order));
        //EL TEST ESTÁ BIEN, PERO EL CÓDIGO NO MANEJA ESTE ERROR, POR ENDE NUNCA TIRA EL THROW
    }

    //T-0006
    @Test
    public void checkPublicationFollowedIsSortByDateAsc() {
        Integer userIdFollower = 10;
        String order = "date_asc";

        UsuarioDTO followedListed = new UsuarioDTO(20, "María");
        List<UsuarioDTO> listFollowed = new ArrayList<>();
        listFollowed.add(followedListed);

        FollowedListDTO followedListDTO = new FollowedListDTO(userIdFollower, "", listFollowed);

        Publicacion publicacionListed = new Publicacion(followedListed.getUserId(), 1, LocalDate.now(), new Producto(), 2, 100.0, false, 0.0);
        Publicacion publicacion2Listed = new Publicacion(followedListed.getUserId(), 1, LocalDate.now().minusDays(1), new Producto(), 2, 100.0, false, 0.0);
        List<Publicacion> listPublicacion = new ArrayList<>();
        listPublicacion.add(publicacion2Listed);
        listPublicacion.add(publicacionListed);

        PublicacionDTO publicacionDTOListed = new PublicacionDTO(null, publicacionListed.getIdPost(), publicacionListed.getDate(), new ProductoDTO(), publicacionListed.getCategory(), publicacionListed.getPrice());
        PublicacionDTO publicacion2DTOListed = new PublicacionDTO(null, publicacionListed.getIdPost(), publicacionListed.getDate().minusDays(1), new ProductoDTO(), publicacionListed.getCategory(), publicacionListed.getPrice());
        List<PublicacionDTO> listPublicacionDTO = new ArrayList<>();
        listPublicacionDTO.add(publicacion2DTOListed);
        listPublicacionDTO.add(publicacionDTOListed);

        PublicacionFollowedDTO expected = new PublicacionFollowedDTO(userIdFollower, listPublicacionDTO);

        Mockito.when(repositoryUser.encontrarUsuario(userIdFollower)).thenReturn(true);
        Mockito.when(usuarioService.listaFollowed(userIdFollower, "name_asc")).thenReturn(followedListDTO);
        Mockito.when(repository.devolverPublicaciones(followedListed.getUserId())).thenReturn(listPublicacion);

        PublicacionFollowedDTO result = service.listaPublicacionesFollowed(userIdFollower, order);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void checkPublicationFollowedIsSortByDateDesc() {
        Integer userIdFollower = 10;
        String order = "date_desc";

        UsuarioDTO followedListed = new UsuarioDTO(20, "María");
        List<UsuarioDTO> listFollowed = new ArrayList<>();
        listFollowed.add(followedListed);

        FollowedListDTO followedListDTO = new FollowedListDTO(userIdFollower, "", listFollowed);

        Publicacion publicacionListed = new Publicacion(followedListed.getUserId(), 1, LocalDate.now(), new Producto(), 2, 100.0, false, 0.0);
        Publicacion publicacion2Listed = new Publicacion(followedListed.getUserId(), 1, LocalDate.now().minusDays(1), new Producto(), 2, 100.0, false, 0.0);
        List<Publicacion> listPublicacion = new ArrayList<>();
        listPublicacion.add(publicacionListed);
        listPublicacion.add(publicacion2Listed);

        PublicacionDTO publicacionDTOListed = new PublicacionDTO(null, publicacionListed.getIdPost(), publicacionListed.getDate(), new ProductoDTO(), publicacionListed.getCategory(), publicacionListed.getPrice());
        PublicacionDTO publicacion2DTOListed = new PublicacionDTO(null, publicacionListed.getIdPost(), publicacionListed.getDate().minusDays(1), new ProductoDTO(), publicacionListed.getCategory(), publicacionListed.getPrice());
        List<PublicacionDTO> listPublicacionDTO = new ArrayList<>();
        listPublicacionDTO.add(publicacionDTOListed);
        listPublicacionDTO.add(publicacion2DTOListed);

        PublicacionFollowedDTO expected = new PublicacionFollowedDTO(userIdFollower, listPublicacionDTO);

        Mockito.when(repositoryUser.encontrarUsuario(userIdFollower)).thenReturn(true);
        Mockito.when(usuarioService.listaFollowed(userIdFollower, "name_asc")).thenReturn(followedListDTO);
        Mockito.when(repository.devolverPublicaciones(followedListed.getUserId())).thenReturn(listPublicacion);

        PublicacionFollowedDTO result = service.listaPublicacionesFollowed(userIdFollower, order);

        Assertions.assertEquals(expected, result);
    }

    //T-0008
    @Test
    public void checkPublicationFollowedIsDoingFilterDate() {
        Integer userIdFollower = 10;
        String order = "date_asc";

        UsuarioDTO followedListed = new UsuarioDTO(20, "María");
        List<UsuarioDTO> listFollowed = new ArrayList<>();
        listFollowed.add(followedListed);

        FollowedListDTO followedListDTO = new FollowedListDTO(userIdFollower, "", listFollowed);

        Publicacion publicacionListed = new Publicacion(followedListed.getUserId(), 1, LocalDate.now(), new Producto(), 2, 100.0, false, 0.0);
        Publicacion publicacion2Listed = new Publicacion(followedListed.getUserId(), 2, LocalDate.now().minusDays(1), new Producto(), 2, 100.0, false, 0.0);
        Publicacion publicacion3Listed = new Publicacion(followedListed.getUserId(), 3, LocalDate.now().minusDays(22), new Producto(), 2, 100.0, false, 0.0);
        List<Publicacion> listPublicacion = new ArrayList<>();
        listPublicacion.add(publicacion3Listed);
        listPublicacion.add(publicacion2Listed);
        listPublicacion.add(publicacionListed);

        PublicacionDTO publicacionDTOListed = new PublicacionDTO(null, publicacionListed.getIdPost(), publicacionListed.getDate(), new ProductoDTO(), publicacionListed.getCategory(), publicacionListed.getPrice());
        PublicacionDTO publicacion2DTOListed = new PublicacionDTO(null, publicacionListed.getIdPost(), publicacionListed.getDate().minusDays(1), new ProductoDTO(), publicacionListed.getCategory(), publicacionListed.getPrice());
        PublicacionDTO publicacion3DTOListed = new PublicacionDTO(null, publicacionListed.getIdPost(), publicacionListed.getDate().minusDays(22), new ProductoDTO(), publicacionListed.getCategory(), publicacionListed.getPrice());
        List<PublicacionDTO> listPublicacionDTO = new ArrayList<>();
        listPublicacionDTO.add(publicacion3DTOListed);
        listPublicacionDTO.add(publicacion2DTOListed);
        listPublicacionDTO.add(publicacionDTOListed);

        PublicacionFollowedDTO expected = new PublicacionFollowedDTO(userIdFollower, listPublicacionDTO);

        Mockito.when(repositoryUser.encontrarUsuario(userIdFollower)).thenReturn(true);
        Mockito.when(usuarioService.listaFollowed(userIdFollower, "name_asc")).thenReturn(followedListDTO);
        Mockito.when(repository.devolverPublicaciones(followedListed.getUserId())).thenReturn(listPublicacion);

        PublicacionFollowedDTO result = service.listaPublicacionesFollowed(userIdFollower, order);

        Assertions.assertEquals(result.getPosts().size(), 2);
        Assertions.assertEquals(result.getPosts().size(), expected.getPosts().size() - 1);


        Assertions.assertTrue(result.getPosts().stream().anyMatch(publicacionDTO -> publicacionDTO.getIdPost().equals(1)));
        Assertions.assertTrue(result.getPosts().stream().anyMatch(publicacionDTO -> publicacionDTO.getIdPost().equals(2)));
        Assertions.assertFalse(result.getPosts().stream().anyMatch(publicacionDTO -> publicacionDTO.getIdPost().equals(3)));
    }

    //BONUS
    @Test
    public void testGivenValidPublicationThenInsertIt() {
        Integer userId = 10;

        Publicacion publicacion = new Publicacion();
        publicacion.setUserId(userId);
        publicacion.setIdPost(11);
        publicacion.setDetail(new Producto(22, "Silla", "Mueble", "Ekko", "Marrón", "Extra reforzada"));

        PublicacionDTO publicacionDTO = new PublicacionDTO();
        publicacionDTO.setUserId(publicacion.getUserId());
        publicacionDTO.setIdPost(publicacion.getIdPost());
        publicacionDTO.setDetail(new ProductoDTO(22, "Silla", "Mueble", "Ekko", "Marrón", "Extra reforzada"));

        Mockito.when(repositoryUser.encontrarUsuario(userId)).thenReturn(true);

        service.realizarPublicacion(publicacionDTO);

        verify(repository, atLeastOnce()).insertarPublicacion(publicacion);
    }

    @Test
    public void testGivenValidPromoPublicationThenInsertIt() {
        Integer userId = 10;

        Publicacion publicacion = new Publicacion();
        publicacion.setUserId(userId);
        publicacion.setIdPost(11);
        publicacion.setHasPromo(true);
        publicacion.setDiscount(0.5);
        publicacion.setDetail(new Producto(22, "Silla", "Mueble", "Ekko", "Marrón", "Extra reforzada"));

        PublicacionPromoDTO publicacionPromoDTO = new PublicacionPromoDTO();
        publicacionPromoDTO.setUserId(publicacion.getUserId());
        publicacionPromoDTO.setIdPost(publicacion.getIdPost());
        publicacionPromoDTO.setHasPromo(publicacion.getHasPromo());
        publicacionPromoDTO.setDiscount(publicacion.getDiscount());
        publicacionPromoDTO.setDetail(new ProductoDTO(22, "Silla", "Mueble", "Ekko", "Marrón", "Extra reforzada"));

        Mockito.when(repository.devolverPublicacion(publicacionPromoDTO.getIdPost())).thenReturn(null);
        Mockito.when(repositoryUser.encontrarUsuario(userId)).thenReturn(true);

        service.realizarPublicacionPromo(publicacionPromoDTO);

        verify(repository, atLeastOnce()).insertarPublicacionPromo(publicacion);
    }

    @Test
    public void testGivenPromoPublicationWithFalseHasPromoThenInsertItAndGetException() {
        Integer userId = 10;

        Publicacion publicacion = new Publicacion();
        publicacion.setUserId(userId);
        publicacion.setIdPost(11);
        publicacion.setHasPromo(false);
        publicacion.setDiscount(0.5);

        PublicacionPromoDTO publicacionPromoDTO = new PublicacionPromoDTO();
        publicacionPromoDTO.setUserId(publicacion.getUserId());
        publicacionPromoDTO.setIdPost(publicacion.getIdPost());
        publicacionPromoDTO.setHasPromo(publicacion.getHasPromo());
        publicacionPromoDTO.setDiscount(publicacion.getDiscount());

        Mockito.when(repositoryUser.encontrarUsuario(userId)).thenReturn(true);

        Assertions.assertThrows(BadRequestException.class, () -> service.realizarPublicacionPromo(publicacionPromoDTO));
    }

    @Test
    public void testGivenPromoPublicationWithNotDiscountThenInsertItAndGetException() {
        Integer userId = 10;

        Publicacion publicacion = new Publicacion();
        publicacion.setUserId(userId);
        publicacion.setIdPost(11);
        publicacion.setHasPromo(true);
        publicacion.setDiscount(0.0);

        PublicacionPromoDTO publicacionPromoDTO = new PublicacionPromoDTO();
        publicacionPromoDTO.setUserId(publicacion.getUserId());
        publicacionPromoDTO.setIdPost(publicacion.getIdPost());
        publicacionPromoDTO.setHasPromo(publicacion.getHasPromo());
        publicacionPromoDTO.setDiscount(publicacion.getDiscount());

        Mockito.when(repositoryUser.encontrarUsuario(userId)).thenReturn(true);

        Assertions.assertThrows(BadRequestException.class, () -> service.realizarPublicacionPromo(publicacionPromoDTO));
    }

    @Test
    public void testGivenValidPromoPublicationGetCount() {
        Integer userId = 10;
        Usuario usuario = new Usuario();
        usuario.setUserId(userId);
        usuario.setUserName("Ana");

        Publicacion publicacion = new Publicacion();
        publicacion.setUserId(userId);
        publicacion.setIdPost(11);
        publicacion.setHasPromo(true);
        publicacion.setDiscount(0.5);
        publicacion.setDate(LocalDate.now());
        publicacion.setDetail(new Producto(22, "Silla", "Mueble", "Ekko", "Marrón", "Extra reforzada"));

        Publicacion publicacion2 = new Publicacion();
        publicacion2.setUserId(userId);
        publicacion2.setIdPost(12);
        publicacion2.setHasPromo(true);
        publicacion2.setDiscount(0.5);
        publicacion2.setDate(LocalDate.now());
        publicacion2.setDetail(new Producto(24, "Silla", "Mueble", "Ekko", "Marrón", "Extra reforzada"));

        List<Publicacion> publicacionList = new ArrayList<>();
        publicacionList.add(publicacion);
        publicacionList.add(publicacion2);

        PublicacionPromoCountDTO publicacionPromoCountDTO;

        Mockito.when(repositoryUser.encontrarUsuario(usuario.getUserId())).thenReturn(true);
        Mockito.when(repository.devolverPublicaciones(usuario.getUserId())).thenReturn(publicacionList);
        Mockito.when(repositoryUser.devolverUsuario(usuario.getUserId())).thenReturn(usuario);

        publicacionPromoCountDTO = service.cantidadPublicacionPromo(usuario.getUserId());

        Assertions.assertEquals(publicacionPromoCountDTO.getPromoProductsCount(), publicacionList.size(), 2);
    }

    @Test
    public void testGivenValidPromoPublicationIdGetList() {
        Integer userId = 10;
        Usuario usuario = new Usuario();
        usuario.setUserId(userId);
        usuario.setUserName("Ana");

        Publicacion publicacion = new Publicacion();
        publicacion.setUserId(userId);
        publicacion.setIdPost(11);
        publicacion.setHasPromo(true);
        publicacion.setDiscount(0.5);
        publicacion.setDate(LocalDate.now());
        publicacion.setDetail(new Producto(22, "Silla", "Mueble", "Ekko", "Marrón", "Extra reforzada"));

        Publicacion publicacion2 = new Publicacion();
        publicacion2.setUserId(userId);
        publicacion2.setIdPost(12);
        publicacion2.setHasPromo(true);
        publicacion2.setDiscount(0.5);
        publicacion2.setDate(LocalDate.now());
        publicacion2.setDetail(new Producto(24, "Silla", "Mueble", "Ekko", "Marrón", "Extra reforzada"));

        List<Publicacion> publicacionList = new ArrayList<>();
        publicacionList.add(publicacion);
        publicacionList.add(publicacion2);

        PublicacionPromoDTO publicacionPromoDTO = new PublicacionPromoDTO();
        publicacionPromoDTO.setUserId(publicacion.getUserId());
        publicacionPromoDTO.setIdPost(publicacion.getIdPost());
        publicacionPromoDTO.setHasPromo(publicacion.getHasPromo());
        publicacionPromoDTO.setDiscount(publicacion.getDiscount());
        publicacionPromoDTO.setDate(publicacion.getDate());
        publicacionPromoDTO.setDetail(new ProductoDTO(24, "Silla", "Mueble", "Ekko", "Marrón", "Extra reforzada"));

        PublicacionPromoDTO publicacionPromoDTO2 = new PublicacionPromoDTO();
        publicacionPromoDTO2.setUserId(publicacion2.getUserId());
        publicacionPromoDTO2.setIdPost(publicacion2.getIdPost());
        publicacionPromoDTO2.setHasPromo(publicacion2.getHasPromo());
        publicacionPromoDTO2.setDiscount(publicacion2.getDiscount());
        publicacionPromoDTO2.setDate(publicacion2.getDate());
        publicacionPromoDTO2.setDetail(new ProductoDTO(24, "Silla", "Mueble", "Ekko", "Marrón", "Extra reforzada"));

        List<PublicacionPromoDTO> publicacionPromoDTOList = new ArrayList<>();
        publicacionPromoDTOList.add(publicacionPromoDTO);
        publicacionPromoDTOList.add(publicacionPromoDTO2);

        PublicacionPromoListDTO expected = new PublicacionPromoListDTO();
        expected.setPosts(publicacionPromoDTOList);

        Mockito.when(repositoryUser.encontrarUsuario(usuario.getUserId())).thenReturn(true);
        Mockito.when(repositoryUser.devolverUsuario(usuario.getUserId())).thenReturn(usuario);
        Mockito.when(repository.devolverPublicaciones(usuario.getUserId())).thenReturn(publicacionList);

        PublicacionPromoListDTO actual = service.listaPublicacionesPromo(usuario.getUserId());

        Assertions.assertEquals(expected.getPosts().size(), actual.getPosts().size(), 2);
    }
}


