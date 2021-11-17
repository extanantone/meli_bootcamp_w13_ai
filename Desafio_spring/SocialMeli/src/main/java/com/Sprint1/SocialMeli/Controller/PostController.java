package com.Sprint1.SocialMeli.Controller;

import com.Sprint1.SocialMeli.DTO.PostFullDTO;
import com.Sprint1.SocialMeli.DTO.PostListDTO;
import com.Sprint1.SocialMeli.DTO.PostShortDTO;
import com.Sprint1.SocialMeli.DTO.PromoPostCountDTO;
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

    @PostMapping("/post")
    public ResponseEntity<String> altaPublicacion (@RequestBody PostShortDTO publicacion){

        //TODO: Agregar validaciones

        if(postService.crearPublicacion(publicacion)){
            return new ResponseEntity<String>(
                    "Todo OK",
                    HttpStatus.OK);
        }else{
            return new ResponseEntity<String>(
                    "Bad Request",
                    HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/followed/{user_id}/list")
    public ResponseEntity<PostListDTO> obtenerListPosts (@PathVariable("user_id") Integer userId, @RequestParam(value = "order", required = false) String order){

        //TODO: Agregar validaciones

        return new ResponseEntity<PostListDTO>(
                postService.obtenerListadoPostsDeVendedor(userId, order),
                HttpStatus.OK);
    }

    @PostMapping("/promopost")
    public ResponseEntity<String> altaPublicacionPromocion (@RequestBody PostFullDTO publicacionFull){

        //TODO: Agregar validaciones (Validar si vino el compo hasPromo y Discount)

        if(postService.crearPostPromocion(publicacionFull)){
            return new ResponseEntity<String>(
                    "Todo OK",
                    HttpStatus.OK);
        }else{
            return new ResponseEntity<String>(
                    "Bad Request",
                    HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{user_id}/promo-post/count")
    public ResponseEntity<PromoPostCountDTO> obtenerCantPromoPost (@PathVariable("user_id") Integer userId){

        //TODO: Agregar validaciones

        return new ResponseEntity<PromoPostCountDTO>(
                postService.obtenerCantPromoPost(userId),
                HttpStatus.OK);
    }




    //TODO: BORRAR
    @GetMapping("/pruebaPost")
    public ResponseEntity<HashMap> obtenerPrueba ()
    {

        return new ResponseEntity<HashMap>(
                postService.pruebaPost(),
                HttpStatus.OK);
    }
}
