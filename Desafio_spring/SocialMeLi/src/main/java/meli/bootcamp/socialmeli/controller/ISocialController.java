package meli.bootcamp.socialmeli.controller;

import meli.bootcamp.socialmeli.dto.FollowersCountDTO;
import meli.bootcamp.socialmeli.dto.FollowersListDTO;
import meli.bootcamp.socialmeli.dto.ProductsPostDTO;
import meli.bootcamp.socialmeli.dto.ProductsUserIDListDTO;
import meli.bootcamp.socialmeli.model.Post;
import meli.bootcamp.socialmeli.model.UserFollow;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ISocialController {
    @GetMapping("/users/{user_id}/follow/{user_id_to_follow}")
    ResponseEntity<String> followUser(@PathVariable int user_id, @PathVariable int user_id_to_follow);

    @GetMapping("/users/{user_id}/followers/count")
    ResponseEntity<FollowersCountDTO> countFollowersUser(@PathVariable int user_id);

    @GetMapping("/users/{user_id}/followers/list")
    ResponseEntity<FollowersListDTO> listFollowersUser(@PathVariable int user_id);

    @GetMapping("/users/{user_id}/followed/list")
    ResponseEntity<FollowersListDTO> listFollowedUser(@PathVariable int user_id);

    @PostMapping("products/post")
    ResponseEntity<String> addPost(@RequestBody ProductsPostDTO newPost);

    @GetMapping("products/followed/{user_id}/list")
    ResponseEntity<ProductsUserIDListDTO> listSortedPostByUserID(@PathVariable int user_id);

    @PostMapping("/users/{user_id}/unfollow/{user_id_to_unfollow}")
    ResponseEntity<String> unfollowUser(@PathVariable int user_id, @PathVariable int user_id_to_unfollow);

    @GetMapping("/listaSeguidores")
    List<UserFollow> lista();

    @GetMapping("/listaPost")
    List<Post> listaPost();

}
