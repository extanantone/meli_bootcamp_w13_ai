package meli.bootcamp.socialmeli.controller;

import meli.bootcamp.socialmeli.dto.*;
import meli.bootcamp.socialmeli.model.Post;
import meli.bootcamp.socialmeli.model.PromoPost;
import meli.bootcamp.socialmeli.model.UserFollow;
import meli.bootcamp.socialmeli.service.SocialMeliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class SocialController implements ISocialController{
    @Autowired
    public SocialMeliService socialMeliService;

    @Override
    public ResponseEntity<GenericResponseDTO> followUser(int user_id, int user_id_to_follow) {
        socialMeliService.followUser(user_id, user_id_to_follow);
        GenericResponseDTO genericResponseDTO= new GenericResponseDTO();
        genericResponseDTO.getResponse().put("code","200");
        genericResponseDTO.getResponse().put("response","Usuario " + user_id+ " siguiendo a " + user_id_to_follow);
        return new ResponseEntity<>(genericResponseDTO, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<FollowersCountDTO> countFollowersUser(int user_id) {
        return new ResponseEntity<>(socialMeliService.getFollowersCount(user_id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<GenericResponseDTO> addPost(ProductsPostDTO newPost) {
        socialMeliService.addPost(newPost);
        GenericResponseDTO genericResponseDTO= new GenericResponseDTO();
        genericResponseDTO.getResponse().put("code","200");
        genericResponseDTO.getResponse().put("response","Post " + newPost.getId_post() + " agregado exitosamente");
        return new ResponseEntity<>(genericResponseDTO, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<FollowersListDTO> getOrderedList(int user_id, String order, String method) {
        if ((method.equals("followers")) || (method.equals("followed"))) {
            boolean searchFollowers;
            searchFollowers = method.equals("followers");
            if (order.equals("noOrder"))
                return new ResponseEntity<>(socialMeliService.getOrderedFollowersList(user_id, searchFollowers, null, false), HttpStatus.OK);
            else
                return new ResponseEntity<>(socialMeliService.getOrderedFollowersList(user_id, searchFollowers, order, true), HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<ProductsUserIDListDTO> listSortedPostByUserID(int user_id, String order) {
        return new ResponseEntity<>(socialMeliService.listSortedPostByUserID(user_id, order), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<GenericResponseDTO> unfollowUser(int user_id, int user_id_to_unfollow) {
        socialMeliService.unfollowUser(user_id, user_id_to_unfollow);
        GenericResponseDTO genericResponseDTO= new GenericResponseDTO();
        genericResponseDTO.getResponse().put("code","200");
        genericResponseDTO.getResponse().put("response","Usuario " + user_id+ " ya no sigue a " + user_id_to_unfollow);
        return new ResponseEntity<>(genericResponseDTO, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<GenericResponseDTO> publicPromoPost(ProductsPromoPostDTO productsPromoPostDTO) {
        socialMeliService.newPromoPost(productsPromoPostDTO);
        GenericResponseDTO genericResponseDTO= new GenericResponseDTO();
        genericResponseDTO.getResponse().put("code","200");
        genericResponseDTO.getResponse().put("response","PromoPost agregado exitosamente");
        return new ResponseEntity<>(genericResponseDTO, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PromoPostCountDTO> countPromoPostBySeller(int user_id) {
        return new ResponseEntity<>(socialMeliService.countPromoPost(user_id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PromoPostDTO> listPromoPostByUser(int user_id) {
        return new ResponseEntity<>(socialMeliService.listPromoPostByUSer(user_id), HttpStatus.OK);
    }

    @Override
    public List<UserFollow> lista() {
        return socialMeliService.lista();
    }

    @Override
    public List<Post> listaPost() {
        return socialMeliService.listaPost();
    }

    @Override
    public List<PromoPost> listaPromoPost() {
        return socialMeliService.listaPromoPost();
    }

}
