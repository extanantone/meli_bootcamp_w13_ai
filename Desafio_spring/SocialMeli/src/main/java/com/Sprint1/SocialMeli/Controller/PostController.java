package com.Sprint1.SocialMeli.Controller;

import com.Sprint1.SocialMeli.DTO.*;
import com.Sprint1.SocialMeli.Service.IPostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/products")
public class PostController {

    IPostService postService;

    public PostController(IPostService postService) {
        this.postService = postService;
    }

    //US_0005
    @PostMapping("/post")
    public ResponseEntity<ResponseDTO> altaPublicacion (@RequestBody PostShortDTO publicacion){
        if(postService.crearPublicacion(publicacion)){
            return new ResponseEntity<ResponseDTO>(
                    new ResponseDTO("Todo OK"),
                    HttpStatus.OK);
        }else{
            return new ResponseEntity<ResponseDTO>(
                    new ResponseDTO("Bad Request"),
                    HttpStatus.BAD_REQUEST);
        }
    }

    //US_0006 y US_0009
    @GetMapping("/followed/{user_id}/list")
    public ResponseEntity<PostListDTO> obtenerListPosts (@PathVariable("user_id") Integer userId, @RequestParam(value = "order", required = false) String order){
        return new ResponseEntity<PostListDTO>(
                postService.obtenerListadoPostsDeVendedor(userId, order),
                HttpStatus.OK);
    }

    //US_0010
    @PostMapping("/promopost")
    public ResponseEntity<ResponseDTO> altaPublicacionPromocion (@RequestBody PostFullDTO publicacionFull){
        if(postService.crearPostPromocion(publicacionFull)){
            return new ResponseEntity<ResponseDTO>(
                    new ResponseDTO("OK"),
                    HttpStatus.OK);
        }else{
            return new ResponseEntity<ResponseDTO>(
                    new ResponseDTO("Bad Request"),
                    HttpStatus.BAD_REQUEST);
        }
    }

    //US_0011
    @GetMapping("/{user_id}/promo-post/count")
    public ResponseEntity<PromoPostCountDTO> obtenerCantPromoPost (@PathVariable("user_id") Integer userId){
        return new ResponseEntity<PromoPostCountDTO>(
                postService.obtenerCantPromoPost(userId),
                HttpStatus.OK);
    }

    //US_0012
    @GetMapping("/{user_id}/list")
    public ResponseEntity<PromoPostListDTO> obtenerListPromoPost (@PathVariable("user_id") Integer userId, @RequestParam(value = "order", required = false) String order){
        return new ResponseEntity<PromoPostListDTO>(
                postService.obtenerListPromoPost(userId, order),
                HttpStatus.OK);
    }
}
