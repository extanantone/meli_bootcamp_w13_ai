package com.Sprint1.SocialMeli.Service;

import com.Sprint1.SocialMeli.DTO.PostListDTO;
import com.Sprint1.SocialMeli.DTO.PostShortDTO;
import com.Sprint1.SocialMeli.DTO.UserShortDTO;
import com.Sprint1.SocialMeli.Model.Post;
import com.Sprint1.SocialMeli.Model.User;
import com.Sprint1.SocialMeli.Repository.IPostRepository;
import com.Sprint1.SocialMeli.Repository.IUserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
public class PostServiceImpl implements IPostService{

    IPostRepository postRepository;
    IUserRepository userRepository;

    public PostServiceImpl(IPostRepository postRepository, IUserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    //TODO: BORRAR
    public HashMap<Integer, Post> pruebaPost(){
        return postRepository.pruebaPost();
    }

    @Override
    public Boolean crearPublicacion(PostShortDTO publicacion) {
        Post nuevaPublicacion = new Post(publicacion);

        return postRepository.crearPublicacion(nuevaPublicacion);
    }

    @Override
    public PostListDTO obtenerListadoPostsDeVendedor(int userId) {
        List<Post> listaPosts = new ArrayList<Post>();
        User usuario = userRepository.obtenerUsuario(userId);
        PostListDTO postListResultado = new PostListDTO(userId);

        for (UserShortDTO vendedor : usuario.getFolloweds()) {
            listaPosts.addAll(postRepository.obtenerPostsPorVendedor(vendedor.getUserId()));
        }

        List<PostShortDTO> listaPostShortFiltrada = listaPosts.stream()
                .filter(post -> DAYS.between(post.getDate(), LocalDate.now()) < 15)
                .sorted(Comparator.comparing(Post::getDate))
                .map(post -> new PostShortDTO(post))
                .collect(Collectors.toList());

        postListResultado.setPosts(listaPostShortFiltrada);

        return postListResultado;


    }
}
