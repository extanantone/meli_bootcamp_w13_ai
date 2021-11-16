package com.meli.SocialMeli.service;

import com.meli.SocialMeli.dto.*;
import com.meli.SocialMeli.exception.BadRequestException;
import com.meli.SocialMeli.helper.Helper;
import com.meli.SocialMeli.model.Post;
import com.meli.SocialMeli.model.User;
import com.meli.SocialMeli.reposity.IRepositoryUser;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class SocialMeliService implements ISocialMeliService{

    IRepositoryUser userRepository;

    public SocialMeliService(IRepositoryUser userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public MensajeDTO addFollow(int userId, int userIdFollow) {
        if(userRepository.findUser(userId)==null)
            throw new BadRequestException("Usuario "+userId+" no encontrado");
        if(userRepository.findUser(userIdFollow)==null)
            throw new BadRequestException("Usuario "+userIdFollow+" no encontrado");
        if(userRepository.containFollower(userIdFollow, userId))
            throw new BadRequestException("Usuario "+userId+" ya se encuentra siguiendo al usuario "+userIdFollow);
        userRepository.addFollower(userId, userIdFollow);
        return new MensajeDTO("Usuario "+userId+" ahora está siguiendo al usuario "+userIdFollow, 1);
    }

    @Override
    public CountFollowersDTO countFollowers(int userId) {
        User usr = userRepository.findUser(userId);
        if(usr==null)
            throw new BadRequestException("Usuario "+userId+" no encontrado");
        return new CountFollowersDTO(userId, usr.getUserName(), usr.getFollowed().size());
    }

    @Override
    public FollowersDTO listFollowers(int userId, String order) {
        User usr = userRepository.findUser(userId);
        if(usr==null)
            throw new BadRequestException("Usuario "+userId+" no encontrado");
        if(usr.getFollowed()==null || usr.getFollowed().size()==0)
            throw new BadRequestException("Usuario "+userId+" no posee seguidores");
        List<User>followed = usr.getFollowed();
        if(order!=null){
            switch (order){
                case "name_asc":    followed = followed.stream().sorted(Comparator.comparing(User::getUserName)).collect(Collectors.toList());
                    break;
                case "name_desc":   followed = followed.stream().sorted(Comparator.comparing(User::getUserName).reversed()).collect(Collectors.toList());
                    break;
                default:            throw new BadRequestException("order: "+order+" es inválido, solo acepta name_asc o name_desc");
            }
            usr.setFollowers(followed);
        }
        return Helper.listFollowersToFollowers(usr);


    }

    @Override
    public FollowedDTO listFollowed(int userId, String order) {
        User usr = userRepository.findUser(userId);
        if(usr==null)
            throw new BadRequestException("Usuario "+userId+" no encontrado");
        if(usr.getFollowers()==null || usr.getFollowers().size()==0)
            throw new BadRequestException("Usuario "+userId+" no posee seguidos");
        List<User>followers = usr.getFollowers();
        if(order!=null){
            switch (order){
                case "name_asc":    followers = followers.stream().sorted(Comparator.comparing(User::getUserName)).collect(Collectors.toUnmodifiableList());
                                    break;
                case "name_desc":   followers = followers.stream().sorted(Comparator.comparing(User::getUserName).reversed()).collect(Collectors.toUnmodifiableList());
                                    break;
                default:            throw new BadRequestException("order: "+order+" es inválido, solo acepta name_asc o name_desc");
            }
            usr.setFollowers(followers);
        }

        return Helper.listFollowedToFollowed(usr);
    }

    @Override
    public MensajeDTO addPost(PostDTOResponse postDto) {

        if(postDto.getUserId()<=0)
            throw new BadRequestException("Usuario "+postDto.getUserId()+" invalido");
        if(postDto==null)
            throw new BadRequestException("Post inválido");
        //control producto
        if(userRepository.containPost(postDto.getIdPost())){
            throw new BadRequestException("id_post existente.");
        }
        if(userRepository.containProduct(postDto.getUserId(), postDto.getDetail().getProductId())){
            throw new BadRequestException("product_id existente.");
        }
        if(postDto.getPrice()<0)
            throw new BadRequestException("price debe ser mayor que cero.");
        if(postDto.getCategory()<0)
            throw new BadRequestException("category debe ser mayor que cero.");
        Post post = Helper.postDTOToPost(postDto);
        userRepository.addPost(post);
        return new MensajeDTO("Post almacenado.",1);
    }

    @Override
    public ListPostsDTO listPostFollowed(int userId, String order) {
        User usr = userRepository.findUser(userId);
        if(usr==null)
            throw new BadRequestException("Usuario "+userId+" no encontrado");
        List<Post> lista= new LinkedList<>();
        for(User follower: usr.getFollowers()){
            lista.addAll(userRepository.listPostUsr(follower.getUserId()));
        }
        lista= lista.stream().filter(p->p.getDate().plusDays(14).compareTo(LocalDate.now())>=0).collect(Collectors.toList());
        if(order!=null){
            switch (order){
                case "date_asc":    lista=lista.stream().sorted(Comparator.comparing(Post::getDate)).collect(Collectors.toList());
                                    break;
                case "date_desc":   lista=lista.stream().sorted(Comparator.comparing(Post::getDate).reversed()).collect(Collectors.toList());
                                    break;
                default:            throw new BadRequestException("order: "+order+" es inválido, solo acepta date_asc o date_desc.");
            }
        }
        return Helper.listPostToListPostDTO(lista, usr.getUserId());
    }

    @Override
    public MensajeDTO unfollow(int userId, int userIdFollow) {
        if(userRepository.findUser(userId)==null)
            throw new BadRequestException("Usuario "+userId+" no encontrado");
        if(userRepository.findUser(userIdFollow)==null)
            throw new BadRequestException("Usuario "+userIdFollow+" no encontrado");
        if(!userRepository.containFollower(userIdFollow, userId))
            throw new BadRequestException("Usuario "+userId+" no se encuentra siguiendo al usuario "+userIdFollow);
        userRepository.unfollow(userId, userIdFollow);
        return new MensajeDTO("Usuario "+userId+" dejó de seguir al usuario "+userIdFollow, 1);
    }
}
