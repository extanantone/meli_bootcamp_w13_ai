package com.bootcamp.SocialMeli.service;

import com.bootcamp.SocialMeli.dto.*;
import com.bootcamp.SocialMeli.exception.DuplicateIdException;
import com.bootcamp.SocialMeli.exception.NotFoundExceptionUsers;
import com.bootcamp.SocialMeli.mapper.PostMater;
import com.bootcamp.SocialMeli.model.Post;
import com.bootcamp.SocialMeli.model.User;
import com.bootcamp.SocialMeli.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

        if(iUserRepository.getUser(post.getUserId()) ==null){throw new NotFoundExceptionUsers(post.getUserId()); }
        if(iUserRepository.getPost(post.getIdPost())!=null){
            throw new DuplicateIdException(postDTO.getIdPost(),Post.class.getSimpleName());
        }
        iUserRepository.setPost(post);
        iUserRepository.cambiarTipo(post.getUserId());

        return postDTO;
    }

    @Override
    public PublicacionesDTO getPublicaciones(int id) {

        List<Integer> usersSeguidos = new ArrayList<>();

        iUserRepository.getSegidor().stream().filter(seguidor -> seguidor.getIdSeguidor()==id).forEach(
                user ->{
                    usersSeguidos.add( iUserRepository.getUser(user.getIdSeguido()).getUserId());
                }
        );
        List<PostsDTO> posts = new ArrayList<>();
        usersSeguidos.forEach(
                                users ->{   if(iUserRepository.getPosts(users).size()>0){
                                            iUserRepository.getPosts(users).forEach(
                                                 user -> posts.add(PostMater.PostToPostsDTO( iUserRepository.getPost(user.getIdPost()))));
                                        }});

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

    @Override
    public PromopostDTO setPromopost(PromopostDTO promopostDTO) {

        if(iUserRepository.getUser(promopostDTO.getUserId()) ==null){throw new NotFoundExceptionUsers(promopostDTO.getUserId()); }
        if(iUserRepository.getPost(promopostDTO.getIdPost())!=null){
            throw new DuplicateIdException(promopostDTO.getIdPost(),Post.class.getSimpleName());
        }
        iUserRepository.setpromopost(PostMater.PromoPostDToToPromoPost(promopostDTO));

        return promopostDTO;
    }

    @Override
    public PromoPostCoutDTO getCountPromo(int id) {
        if(iUserRepository.getUser(id) ==null){throw new NotFoundExceptionUsers(id); }

        User user = iUserRepository.getUser(id);
        int count = (int) iUserRepository.getlistPromopost(id).stream().count();

        return new PromoPostCoutDTO(user.getUserId(), user.getUserName(), count);
    }

    @Override
    public PublicacionesPromoDTO getpublicacionesPromo(int id) {
        if(iUserRepository.getUser(id) ==null){throw new NotFoundExceptionUsers(id); }

        User user = iUserRepository.getUser(id);
        List<PromopostDTO> promopostDTOS = iUserRepository.getlistPromopost(id)
                .stream().map(promoPost -> PostMater.PromoposTopromoPostDTO(promoPost)).collect(Collectors.toList());

        return new PublicacionesPromoDTO(user.getUserId(),user.getUserName(),promopostDTOS);
    }
}
