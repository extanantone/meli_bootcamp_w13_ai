package com.socialMeli.socialMeli.service;
import com.socialMeli.socialMeli.dto.*;
import com.socialMeli.socialMeli.exception.RepeatedPostException;
import com.socialMeli.socialMeli.exception.UserFollowingAnotherUserTwice;
import com.socialMeli.socialMeli.exception.UserFollowingHimselfException;
import com.socialMeli.socialMeli.exception.UserNotFoundException;
import com.socialMeli.socialMeli.mapper.SocialMeliMapper;
import static java.time.temporal.ChronoUnit.DAYS;
import com.socialMeli.socialMeli.repository.IUsuarioRepository;
import lombok.Getter;
import com.socialMeli.socialMeli.model.Usuario;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
@Getter
@Service
public class UsuarioService implements IUsuarioService {
    SocialMeliMapper socialMeliMapper = new SocialMeliMapper();
    private IUsuarioRepository usuarioRepository;

    public UsuarioService(IUsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void seguirUsuario(int user_id, int user_id_to_follow){
        Usuario usuarioSeguidor = usuarioRepository.obtenerUsuario(user_id);
        Usuario usuarioSeguido = usuarioRepository.obtenerUsuario(user_id_to_follow);
        if (usuarioSeguidor==null||usuarioSeguido==null){
            throw new UserNotFoundException();
        }
        if (usuarioSeguidor.getUser_id()==usuarioSeguido.getUser_id()){
            throw new UserFollowingHimselfException();
        }
        if(usuarioSeguidor.getFollowed().contains(usuarioSeguido)){
            throw new UserFollowingAnotherUserTwice();
        }
        usuarioSeguidor.seguirA(usuarioSeguido);
    }

    public ConteoDeSeguidoresDTO contabilizarSeguidores(int user_id){
        ConteoDeSeguidoresDTO response = this.conteoDeSeguidores(user_id);
        return response;
    }

    public ConteoDeSeguidoresDTO conteoDeSeguidores(int user_id){
            Usuario usuario = usuarioRepository.obtenerUsuario(user_id);
            if(usuario == null){
                throw new UserNotFoundException();
            }
            String nombre = usuario.getUser_name();
            int seguidores = usuario.obtenerNumeroDeSeguidores();
            return new ConteoDeSeguidoresDTO(user_id,nombre,seguidores);
    }

    public SeguidoresUsuarioDTO mostrarSeguidoresDelUsuario(int user_id, String criterio){
        Usuario usuario = usuarioRepository.obtenerUsuario(user_id);
        if(usuario==null){
            throw new UserNotFoundException();
        }
        String nombre = usuario.getUser_name();
        List<Usuario> followers = usuario.getFollowers();
        followers = ordenarPorCriterio(followers,criterio);
        List<UsuarioDto> followersDTO = followers.stream().map(u -> socialMeliMapper.usuarioAUsuarioDTO(u)).collect(Collectors.toList());
        return new SeguidoresUsuarioDTO(user_id,nombre,followersDTO);
    }
/*
    public SeguidoresUsuarioDTO mostrarSeguidores(int user_id,String criterio){
        Usuario usuario = usuarioRepository.obtenerUsuario(user_id);
        if(usuario==null){
            throw new UserNotFoundException();
        }
        String nombre = usuario.getUser_name();
        List<Usuario> followers = usuario.getFollowers();
        followers = ordenarPorCriterio(followers,criterio);
        List<UsuarioDto> followersDTO = followers.stream().map(u -> socialMeliMapper.usuarioAUsuarioDTO(u)).collect(Collectors.toList());
        return new SeguidoresUsuarioDTO(user_id,nombre,followersDTO);
    }
*/
    public SeguidosUsuarioDTO mostrarSeguidosDelUsuario(int user_id, String criterio){
        Usuario usuario = usuarioRepository.obtenerUsuario(user_id);
        if (usuario==null){
            throw new UserNotFoundException();
        }
        List<Usuario> followed = usuario.getFollowed();
        followed = ordenarPorCriterio(followed,criterio);
        List<UsuarioDto> followedDTO = followed.stream().map(u -> this.socialMeliMapper.usuarioAUsuarioDTO(u)).collect(Collectors.toList());
        return new SeguidosUsuarioDTO(user_id,usuario.getUser_name(),followedDTO);
    }
/*
    public SeguidosUsuarioDTO mostrarSeguidos(int user_id,String criterio){
        Usuario usuario = usuarioRepository.obtenerUsuario(user_id);
        if (usuario==null){
            throw new UserNotFoundException();
        }
        List<Usuario> followed = usuario.getFollowed();
        followed = ordenarPorCriterio(followed,criterio);
        List<UsuarioDto> followedDTO = followed.stream().map(u -> this.socialMeliMapper.usuarioAUsuarioDTO(u)).collect(Collectors.toList());
        return new SeguidosUsuarioDTO(user_id,usuario.getUser_name(),followedDTO);
    }
*/
    public void agregarPublicacion(PublicacionDTO publicacionDTO){
        Usuario usuario = usuarioRepository.obtenerUsuario(publicacionDTO.getUser_id());
        if (usuario == null){
            throw new UserNotFoundException();
        }
        PublicacionDTO publicacion = usuario.getPublicaciones().stream().filter(p->p.getId_post() == publicacionDTO.getId_post()).findFirst().orElse(null);
        if (publicacion != null){
            throw new RepeatedPostException();
        }
        usuario.agregarPublicacion(publicacionDTO);
    }

    public ArrayList<PublicacionDTO> mostrarPublicaciones(int user_id){
        Usuario usuario = usuarioRepository.obtenerUsuario(user_id);
        if (usuario==null){
            throw new UserNotFoundException();
        }
        return usuario.getPublicaciones();
    }

    public List<Usuario> ordenarPorCriterio(List<Usuario>lista,String criterio){
        switch (criterio){
            case "name_asc":
                lista = lista.stream().sorted(Comparator.comparing(Usuario::getUser_name)).collect(Collectors.toList());
                break;
            case "name_desc":
                lista = lista.stream().sorted(Comparator.comparing(Usuario::getUser_name)).collect(Collectors.toList());
                Collections.reverse(lista);
                break;
        }
        return lista;
    }

    public List<PublicacionDTO> ordenarPorCriterioDeFecha(List<PublicacionDTO>lista,String criterio){
        switch (criterio){
            case "date_asc":
                lista = lista.stream().sorted(Comparator.comparing(PublicacionDTO::getDate)).collect(Collectors.toList());
                break;
            case "date_desc":
                lista = lista.stream().sorted(Comparator.comparing(PublicacionDTO::getDate)).collect(Collectors.toList());
                Collections.reverse(lista);
                break;
        }
        return lista;
    }

    public List<PublicacionDTO> consultarPublicacionesDeUnUsuarioEn2Semanas(int user_id,String criterio) {
        Usuario usuario = usuarioRepository.obtenerUsuario(user_id);
        if (usuario==null){
            throw new UserNotFoundException();
        }
        List<PublicacionDTO> publicaciones = usuario.getPublicaciones().stream().filter(p->DAYS.between(p.getDate(),LocalDate.now())<=14).collect(Collectors.toList());
        publicaciones = ordenarPorCriterioDeFecha(publicaciones,criterio);
        return publicaciones;
    }

    public void dejarDeSeguirA(int user_id,int user_id_to_unfollow) {
        Usuario usuarioQueDejaDeSeguir = usuarioRepository.obtenerUsuario(user_id);
        Usuario usuarioDejadoDeSeguir = usuarioRepository.obtenerUsuario(user_id_to_unfollow);
        if (usuarioQueDejaDeSeguir==null||usuarioDejadoDeSeguir==null){
            throw new UserNotFoundException();
        }
        usuarioQueDejaDeSeguir.dejarDeSeguirA(usuarioDejadoDeSeguir);
    }
}
