package com.bootcamp.SocialMeli.unit.service.usuario;

import com.bootcamp.SocialMeli.dto.usuario.FollowedListDTO;
import com.bootcamp.SocialMeli.dto.usuario.FollowerCountDTO;
import com.bootcamp.SocialMeli.dto.usuario.FollowerListDTO;
import com.bootcamp.SocialMeli.dto.usuario.UsuarioDTO;
import com.bootcamp.SocialMeli.exception.BadRequestException;
import com.bootcamp.SocialMeli.mapper.UsuarioMapper;
import com.bootcamp.SocialMeli.model.Usuario;
import com.bootcamp.SocialMeli.repository.usuario.IUsuarioRepository;
import com.bootcamp.SocialMeli.service.usuario.UsuarioService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class UsuarioServiceTests {
    @Mock
    IUsuarioRepository repository;

    @InjectMocks
    UsuarioService service = new UsuarioService(repository, new UsuarioMapper());

    @Test
    public void followWithExistentUserToExistentUser() {
        Integer userIdFollower = 10;
        Integer userIdFollowed = 20;

        Usuario follower = new Usuario();
        follower.setUserId(userIdFollower);
        follower.setFollowed(new ArrayList<>());

        Usuario followed = new Usuario();
        followed.setUserId(userIdFollowed);
        followed.setFollowers(new ArrayList<>());

        Mockito.when(repository.encontrarUsuario(userIdFollower)).thenReturn(true);
        Mockito.when(repository.encontrarUsuario(userIdFollowed)).thenReturn(true);

        Mockito.when(repository.devolverUsuario(userIdFollower)).thenReturn(follower);
        Mockito.when(repository.devolverUsuario(userIdFollowed)).thenReturn(followed);

        service.realizarFollow(userIdFollower, userIdFollowed);

        verify(repository, atLeastOnce()).insertarFollower(userIdFollower, userIdFollowed);
        verify(repository, atLeastOnce()).insertarFollowed(userIdFollower, userIdFollowed);
    }

    @Test
    public void followWithExistentUserToNonExistentUser() throws BadRequestException {
        Integer userIdFollower = 10;
        Integer userIdFollowed = 20;

        Usuario follower = new Usuario();
        follower.setUserId(userIdFollower);
        follower.setFollowed(new ArrayList<>());

        Mockito.when(repository.encontrarUsuario(userIdFollower)).thenReturn(true);
        Mockito.when(repository.encontrarUsuario(userIdFollowed)).thenReturn(false);

        Assertions.assertThrows(BadRequestException.class, () -> service.realizarFollow(userIdFollower, userIdFollowed));
    }

    @Test
    public void unfollowWithExistentUserToExistentUser() {
        Integer userIdFollower = 10;
        Integer userIdFollowed = 20;

        Usuario follower = new Usuario();
        follower.setUserId(userIdFollower);

        Usuario followed = new Usuario();
        followed.setUserId(userIdFollowed);

        follower.setFollowed(List.of(followed));
        followed.setFollowers(List.of(follower));

        Mockito.when(repository.encontrarUsuario(userIdFollower)).thenReturn(true);
        Mockito.when(repository.encontrarUsuario(userIdFollowed)).thenReturn(true);

        Mockito.when(repository.devolverUsuario(userIdFollower)).thenReturn(follower);
        Mockito.when(repository.devolverUsuario(userIdFollowed)).thenReturn(followed);

        service.realizarUnfollow(userIdFollower, userIdFollowed);

        verify(repository, atLeastOnce()).eliminarFollower(userIdFollower, userIdFollowed);
        verify(repository, atLeastOnce()).eliminarFollowed(userIdFollower, userIdFollowed);
    }

    @Test
    public void unfollowWithExistentUserToNonExistentUser() throws BadRequestException {
        Integer userIdFollower = 10;
        Integer userIdFollowed = 20;

        Usuario follower = new Usuario();
        follower.setUserId(userIdFollower);
        follower.setFollowed(new ArrayList<>());

        Mockito.when(repository.encontrarUsuario(userIdFollower)).thenReturn(true);
        Mockito.when(repository.encontrarUsuario(userIdFollowed)).thenReturn(false);

        Assertions.assertThrows(BadRequestException.class, () -> service.realizarUnfollow(userIdFollower, userIdFollowed));
    }

    @Test
    public void checkFollowersListIsSorting() {
        Integer userIdFollowed = 20;
        String order = "name_asc";

        ArrayList<Usuario> followers = new ArrayList<>();
        Usuario follower = new Usuario();
        follower.setUserId(10);
        follower.setUserName("Ana");
        followers.add(follower);

        Usuario followed = new Usuario();
        followed.setUserId(userIdFollowed);
        followed.setFollowers(followers);
        ArrayList<UsuarioDTO> followersDTO = new ArrayList<>();
        followersDTO.add(new UsuarioDTO(follower.getUserId(), follower.getUserName()));

        FollowerListDTO expected = new FollowerListDTO();
        expected.setFollowers(followersDTO);
        expected.setUserId(followed.getUserId());
        expected.setUserName(followed.getUserName());

        Mockito.when(repository.encontrarUsuario(userIdFollowed)).thenReturn(true);
        Mockito.when(repository.devolverUsuario(userIdFollowed)).thenReturn(followed);

        FollowerListDTO result = service.listaFollowers(userIdFollowed, order);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void checkFollowersListIsNotSorting() {
        Integer userIdFollowed = 20;
        String order = "NOT ORDER";

        ArrayList<Usuario> followers = new ArrayList<>();
        Usuario follower = new Usuario();
        follower.setUserId(10);
        follower.setUserName("Ana");
        followers.add(follower);

        Usuario followed = new Usuario();
        followed.setUserId(userIdFollowed);
        followed.setFollowers(followers);
        ArrayList<UsuarioDTO> followersDTO = new ArrayList<>();
        followersDTO.add(new UsuarioDTO(follower.getUserId(), follower.getUserName()));

        FollowerListDTO expected = new FollowerListDTO();
        expected.setFollowers(followersDTO);
        expected.setUserId(followed.getUserId());
        expected.setUserName(followed.getUserName());

        Mockito.when(repository.encontrarUsuario(userIdFollowed)).thenReturn(true);
        Mockito.when(repository.devolverUsuario(userIdFollowed)).thenReturn(followed);

        Assertions.assertThrows(BadRequestException.class, () -> service.listaFollowers(userIdFollowed, order));
        //EL TEST ESTÁ BIEN, PERO EL CÓDIGO NO MANEJA ESTE ERROR, POR ENDE NUNCA TIRA EL THROW
    }

    @Test
    public void checkFollowedListIsSorting() {
        Integer userIdFollower = 20;
        String order = "name_asc";

        ArrayList<Usuario> followeds = new ArrayList<>();
        Usuario followed = new Usuario();
        followed.setUserId(10);
        followed.setUserName("Ana");
        followeds.add(followed);

        Usuario follower = new Usuario();
        follower.setUserId(userIdFollower);
        follower.setFollowed(followeds);
        ArrayList<UsuarioDTO> followedsDTO = new ArrayList<>();
        followedsDTO.add(new UsuarioDTO(followed.getUserId(), followed.getUserName()));

        FollowedListDTO expected = new FollowedListDTO();
        expected.setFollowed(followedsDTO);
        expected.setUserId(follower.getUserId());
        expected.setUserName(follower.getUserName());

        Mockito.when(repository.encontrarUsuario(userIdFollower)).thenReturn(true);
        Mockito.when(repository.devolverUsuario(userIdFollower)).thenReturn(follower);

        FollowedListDTO result = service.listaFollowed(userIdFollower, order);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void checkFollowedListIsNotSorting() {
        Integer userIdFollower = 20;
        String order = "name_asc";

        ArrayList<Usuario> followeds = new ArrayList<>();
        Usuario followed = new Usuario();
        followed.setUserId(10);
        followed.setUserName("Ana");
        followeds.add(followed);

        Usuario follower = new Usuario();
        follower.setUserId(userIdFollower);
        follower.setFollowed(followeds);
        ArrayList<UsuarioDTO> followedsDTO = new ArrayList<>();
        followedsDTO.add(new UsuarioDTO(followed.getUserId(), followed.getUserName()));

        FollowedListDTO expected = new FollowedListDTO();
        expected.setFollowed(followedsDTO);
        expected.setUserId(follower.getUserId());
        expected.setUserName(follower.getUserName());

        Mockito.when(repository.encontrarUsuario(userIdFollower)).thenReturn(true);
        Mockito.when(repository.devolverUsuario(userIdFollower)).thenReturn(follower);

        Assertions.assertThrows(BadRequestException.class, () -> service.listaFollowed(userIdFollower, order));
        //EL TEST ESTÁ BIEN, PERO EL CÓDIGO NO MANEJA ESTE ERROR, POR ENDE NUNCA TIRA EL THROW
    }

    @Test
    public void checkFollowersListIsSortByNameAsc() {
        Integer userIdFollowed = 20;
        String order = "name_asc";

        ArrayList<Usuario> followers = new ArrayList<>();
        Usuario follower = new Usuario();
        follower.setUserId(10);
        follower.setUserName("Ana");
        followers.add(follower);

        Usuario follower2 = new Usuario();
        follower2.setUserId(11);
        follower2.setUserName("María");
        followers.add(follower2);

        Usuario followed = new Usuario();
        followed.setUserId(userIdFollowed);
        followed.setFollowers(followers);

        ArrayList<UsuarioDTO> followersDTO = new ArrayList<>();
        followersDTO.add(new UsuarioDTO(follower.getUserId(), follower.getUserName()));
        followersDTO.add(new UsuarioDTO(follower2.getUserId(), follower2.getUserName()));

        FollowerListDTO expected = new FollowerListDTO();
        expected.setFollowers(followersDTO);
        expected.setUserId(followed.getUserId());
        expected.setUserName(followed.getUserName());

        Mockito.when(repository.encontrarUsuario(userIdFollowed)).thenReturn(true);
        Mockito.when(repository.devolverUsuario(userIdFollowed)).thenReturn(followed);

        FollowerListDTO result = service.listaFollowers(userIdFollowed, order);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void checkFollowersListIsSortByNameDesc() {
        Integer userIdFollowed = 20;
        String order = "name_desc";

        ArrayList<Usuario> followers = new ArrayList<>();
        Usuario follower = new Usuario();
        follower.setUserId(10);
        follower.setUserName("María");
        followers.add(follower);

        Usuario follower2 = new Usuario();
        follower2.setUserId(11);
        follower2.setUserName("Ana");
        followers.add(follower2);

        Usuario followed = new Usuario();
        followed.setUserId(userIdFollowed);
        followed.setFollowers(followers);

        ArrayList<UsuarioDTO> followersDTO = new ArrayList<>();
        followersDTO.add(new UsuarioDTO(follower.getUserId(), follower.getUserName()));
        followersDTO.add(new UsuarioDTO(follower2.getUserId(), follower2.getUserName()));

        FollowerListDTO expected = new FollowerListDTO();
        expected.setFollowers(followersDTO);
        expected.setUserId(followed.getUserId());
        expected.setUserName(followed.getUserName());

        Mockito.when(repository.encontrarUsuario(userIdFollowed)).thenReturn(true);
        Mockito.when(repository.devolverUsuario(userIdFollowed)).thenReturn(followed);

        FollowerListDTO result = service.listaFollowers(userIdFollowed, order);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void checkFollowedListIsSortByNameAsc() {
        Integer userIdFollower = 20;
        String order = "name_asc";

        ArrayList<Usuario> followeds = new ArrayList<>();
        Usuario followed = new Usuario();
        followed.setUserId(10);
        followed.setUserName("Ana");
        followeds.add(followed);

        Usuario followed2 = new Usuario();
        followed2.setUserId(10);
        followed2.setUserName("María");
        followeds.add(followed2);

        Usuario follower = new Usuario();
        follower.setUserId(userIdFollower);
        follower.setFollowed(followeds);
        ArrayList<UsuarioDTO> followedsDTO = new ArrayList<>();
        followedsDTO.add(new UsuarioDTO(followed.getUserId(), followed.getUserName()));
        followedsDTO.add(new UsuarioDTO(followed2.getUserId(), followed2.getUserName()));

        FollowedListDTO expected = new FollowedListDTO();
        expected.setFollowed(followedsDTO);
        expected.setUserId(follower.getUserId());
        expected.setUserName(follower.getUserName());

        Mockito.when(repository.encontrarUsuario(userIdFollower)).thenReturn(true);
        Mockito.when(repository.devolverUsuario(userIdFollower)).thenReturn(follower);


        FollowedListDTO result = service.listaFollowed(userIdFollower, order);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void checkFollowedListIsSortByNameDesc() {
        Integer userIdFollower = 20;
        String order = "name_desc";

        ArrayList<Usuario> followeds = new ArrayList<>();
        Usuario followed = new Usuario();
        followed.setUserId(10);
        followed.setUserName("María");
        followeds.add(followed);

        Usuario followed2 = new Usuario();
        followed2.setUserId(10);
        followed2.setUserName("Ana");
        followeds.add(followed2);

        Usuario follower = new Usuario();
        follower.setUserId(userIdFollower);
        follower.setFollowed(followeds);
        ArrayList<UsuarioDTO> followedsDTO = new ArrayList<>();
        followedsDTO.add(new UsuarioDTO(followed.getUserId(), followed.getUserName()));
        followedsDTO.add(new UsuarioDTO(followed2.getUserId(), followed2.getUserName()));

        FollowedListDTO expected = new FollowedListDTO();
        expected.setFollowed(followedsDTO);
        expected.setUserId(follower.getUserId());
        expected.setUserName(follower.getUserName());

        Mockito.when(repository.encontrarUsuario(userIdFollower)).thenReturn(true);
        Mockito.when(repository.devolverUsuario(userIdFollower)).thenReturn(follower);


        FollowedListDTO result = service.listaFollowed(userIdFollower, order);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void checkFollowersCountIsCounting(){
        Integer userIdFollowed = 20;

        ArrayList<Usuario> followers = new ArrayList<>();
        Usuario follower = new Usuario();
        follower.setUserId(10);
        follower.setUserName("María");
        followers.add(follower);

        Usuario follower2 = new Usuario();
        follower2.setUserId(11);
        follower2.setUserName("Ana");
        followers.add(follower2);

        Usuario followed = new Usuario(userIdFollowed, "Juan", new ArrayList<>(), followers, new ArrayList<>());

        FollowerCountDTO expected = new FollowerCountDTO(followed.getUserId(), followed.getUserName(), followers.size());

        Mockito.when(repository.encontrarUsuario(userIdFollowed)).thenReturn(true);
        Mockito.when(repository.devolverUsuario(userIdFollowed)).thenReturn(followed);

        FollowerCountDTO result = service.cantidadFollowers(followed.getUserId());

        Assertions.assertEquals(expected.getFollowersCount(), result.getFollowersCount());
    }
}
