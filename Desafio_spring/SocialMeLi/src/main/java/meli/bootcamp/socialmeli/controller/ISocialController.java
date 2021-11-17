package meli.bootcamp.socialmeli.controller;

import meli.bootcamp.socialmeli.dto.*;
import meli.bootcamp.socialmeli.model.Post;
import meli.bootcamp.socialmeli.model.PromoPost;
import meli.bootcamp.socialmeli.model.UserFollow;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface ISocialController {
    @GetMapping("/users/{user_id}/follow/{user_id_to_follow}")
    ResponseEntity<GenericResponseDTO> followUser(@PathVariable int user_id, @PathVariable int user_id_to_follow);

    @GetMapping("/users/{user_id}/followers/count")
    ResponseEntity<FollowersCountDTO> countFollowersUser(@PathVariable int user_id);

    @PostMapping("products/post")
    ResponseEntity<GenericResponseDTO> addPost(@RequestBody ProductsPostDTO newPost);

    @GetMapping("products/followed/{user_id}/list")
    ResponseEntity<ProductsUserIDListDTO> listSortedPostByUserID(@PathVariable int user_id);

    @GetMapping(value = "products/followed/{user_id}/list", params = "order")
    ResponseEntity<ProductsUserIDListDTO> listSortedPostByUserID(@PathVariable int user_id, @RequestParam String order);

    @PostMapping("/users/{user_id}/unfollow/{user_id_to_unfollow}")
    ResponseEntity<GenericResponseDTO> unfollowUser(@PathVariable int user_id, @PathVariable int user_id_to_unfollow);

    @GetMapping(value = "/users/{user_id}/{method}/list", params = {"order"})
    ResponseEntity<FollowersListDTO> getOrderedList(@PathVariable int user_id, @RequestParam String order, @PathVariable String method);

    @GetMapping(value = "/users/{user_id}/{method}/list")
    ResponseEntity<FollowersListDTO> getOrderedList(@PathVariable int user_id, @PathVariable String method);

    @PostMapping(value = "/products/promo-post")
    ResponseEntity<GenericResponseDTO> publicPromoPost(@RequestBody ProductsPromoPostDTO productsPromoPostDTO);

    @GetMapping(value = "/products/{user_id}/promo-post/count")
    ResponseEntity<PromoPostCountDTO> countPromoPostBySeller(@PathVariable int user_id);

    @GetMapping(value = "/products/{user_id}/list")
    ResponseEntity<PromoPostDTO> listPromoPostByUser(@PathVariable int user_id);

    //Obtener todas las listas almacenadas durante la ejecución del sistema
    @GetMapping("/listaSeguidores")
    List<UserFollow> lista();

    @GetMapping("/listaPost")
    List<Post> listaPost();

    @GetMapping("/listaPromoPost")
    List<PromoPost> listaPromoPost();

}
