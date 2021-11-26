package com.bootcamp.SocialMeli.unit.service.publicacion;

import com.bootcamp.SocialMeli.dto.producto.ProductoDTO;
import com.bootcamp.SocialMeli.dto.publicacion.PublicacionDTO;
import com.bootcamp.SocialMeli.dto.publicacion.PublicacionFollowedDTO;
import com.bootcamp.SocialMeli.dto.usuario.FollowedListDTO;
import com.bootcamp.SocialMeli.dto.usuario.UsuarioDTO;
import com.bootcamp.SocialMeli.exception.BadRequestException;
import com.bootcamp.SocialMeli.mapper.ProductoMapper;
import com.bootcamp.SocialMeli.mapper.PublicacionMapper;
import com.bootcamp.SocialMeli.model.Producto;
import com.bootcamp.SocialMeli.model.Publicacion;
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

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    }

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
}


