package com.bootcamp.SocialMeli.service;

import com.bootcamp.SocialMeli.dto.PostDTO;
import com.bootcamp.SocialMeli.dto.PostsDTO;
import com.bootcamp.SocialMeli.dto.PublicacionesDTO;
import com.bootcamp.SocialMeli.dto.UserDTO;
import com.bootcamp.SocialMeli.exception.DuplicateIdException;
import com.bootcamp.SocialMeli.exception.NotFoundExceptionUsers;
import com.bootcamp.SocialMeli.mapper.PostMater;
import com.bootcamp.SocialMeli.mapper.UserMapper;
import com.bootcamp.SocialMeli.model.Post;
import com.bootcamp.SocialMeli.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;
import java.time.temporal.ChronoUnit;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService implements IPostService {
    @Autowired
    IUserRepository iUserRepository;

    @Override
    public PostDTO setPost(PostDTO postDTO) {
        Post post = PostMater.PostDToToPost(postDTO);

        if(iUserRepository.getUser(post.getIdUser()) ==null){throw new NotFoundExceptionUsers(post.getIdUser()); }
        if(iUserRepository.getPost(post.getIdPost())!=null){
            throw new DuplicateIdException(postDTO.getId_post(),Post.class.getSimpleName());
        }
        iUserRepository.setPost(post);
        iUserRepository.cambiarTipo(post.getIdUser());

        return postDTO;
    }

    @Override
    public PublicacionesDTO getPublicaciones(int id) {

        List<Integer> usersSeguidos = new ArrayList<>();

        iUserRepository.getSegidor().stream().filter(seguidor -> seguidor.getIdSeguidor()==id).forEach(
                user ->{
                    usersSeguidos.add( iUserRepository.getUser(user.getIdSeguido()).getId());
                }
        );
        List<PostsDTO> posts = new ArrayList<>();
        usersSeguidos.forEach(
                                users ->{   if(iUserRepository.getPosts(users).size()>0){
                                            iUserRepository.getPosts(users).forEach(
                                                 user -> posts.add(PostMater.PostToPostsDTO( iUserRepository.getPost(user.getIdPost()))));
                                        }});

        List<PostsDTO> ordenada = posts.stream().sorted(Comparator.comparing(PostsDTO::getDate)).collect(Collectors.toList());
        List<PostsDTO> ordenadadesc = posts.stream().sorted(Comparator.comparing(PostsDTO::getDate).reversed()).collect(Collectors.toList());

        return new PublicacionesDTO(id,ordenadadesc.stream().filter(postsDTO ->  (int)ChronoUnit.DAYS.between(postsDTO.getDate(),LocalDate.now())<=14 ).collect(Collectors.toList()));

    }

    @Override
    public PublicacionesDTO getPublicaciones(int id, String order) {
        List<Post> posts;
        if(order.equals("date_asc")){

            posts = iUserRepository.getPosts(id).stream().sorted(Comparator.comparing(Post::getDate)).collect(Collectors.toList());

        }else{
            posts = iUserRepository.getPosts(id).stream().sorted(Comparator.comparing(Post::getDate).reversed()).collect(Collectors.toList());
        }
        List<PostsDTO> postsDTOS = posts.stream().map(post -> PostMater.PostToPostsDTO(post)).collect(Collectors.toList());

        return new PublicacionesDTO(id,postsDTOS);

    }
}
