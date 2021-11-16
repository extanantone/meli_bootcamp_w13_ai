package meli.bootcamp.socialmeli.controller;

import meli.bootcamp.socialmeli.dto.FollowersCountDTO;
import meli.bootcamp.socialmeli.dto.FollowersListDTO;
import meli.bootcamp.socialmeli.dto.ProductsPostDTO;
import meli.bootcamp.socialmeli.dto.ProductsUserIDListDTO;
import meli.bootcamp.socialmeli.model.Post;
import meli.bootcamp.socialmeli.model.UserFollow;
import meli.bootcamp.socialmeli.service.SocialMeliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SocialController implements ISocialController{
    @Autowired
    public SocialMeliService socialMeliService;

    @Override
    public ResponseEntity<String> followUser(int user_id, int user_id_to_follow) {
        socialMeliService.followUser(user_id, user_id_to_follow);
        return new ResponseEntity<>("El ususario "+user_id +" sigue a "+user_id_to_follow, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<FollowersCountDTO> countFollowersUser(int user_id) {
        return new ResponseEntity<>(socialMeliService.getFollowersCount(user_id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<FollowersListDTO> listFollowersUser(int user_id) {
        return new ResponseEntity<>(socialMeliService.getFollowersList(user_id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<FollowersListDTO> listFollowedUser(int user_id) {
        return new ResponseEntity<>(socialMeliService.getFollowedList(user_id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> addPost(ProductsPostDTO newPost) {
        socialMeliService.addPost(newPost);
        return new ResponseEntity<>("Post agregado", HttpStatus.OK);
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
    public ResponseEntity<ProductsUserIDListDTO> listSortedPostByUserID(int user_id) {
        return new ResponseEntity<>(socialMeliService.listSortedPostByUserID(user_id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> unfollowUser(int user_id, int user_id_to_unfollow) {
        socialMeliService.unfollowUser(user_id, user_id_to_unfollow);
        return new ResponseEntity<>("El usuario "+ user_id+ "ya no sigue a "+ user_id_to_unfollow, HttpStatus.OK);
    }
}
