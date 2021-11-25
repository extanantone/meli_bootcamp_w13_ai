package meli.bootcamp.socialmeli.controller;

import meli.bootcamp.socialmeli.dto.*;
import meli.bootcamp.socialmeli.model.Post;
import meli.bootcamp.socialmeli.model.PromoPost;
import meli.bootcamp.socialmeli.model.UserFollow;
import org.hibernate.validator.constraints.Range;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

public interface ISocialController {
    /**
     * @param user_id usuario seguidor.
     * @param user_id_to_follow usuario a seguir.
     * @return ResponseEntity
     *              Endpoint para registrar un nuevo seguidor (US 001).
     * */
    @GetMapping("/users/{user_id}/follow/{user_id_to_follow}")
    ResponseEntity<GenericResponseDTO> followUser(
            @PathVariable
                @Positive(
                        message = "El id debe ser mayor a cero.")
            @Range(min = 1, message = "La id no puede estar vacía.") int user_id,
            @PathVariable @Min(1) int user_id_to_follow);

    /**
     * @param user_id usuario a consultar.
     * @return ResponseEntity
     *              Endpoint para contar los seguidores del usuario (US 002).
     * */
    @GetMapping("/users/{user_id}/followers/count")
    ResponseEntity<FollowersCountDTO> countFollowersUser(
            @PathVariable
                @Positive(
                        message = "El id debe ser mayor a cero.")
                @Range(min = 1, message = "La id no puede estar vacía.") int user_id);

    /**
     * @param user_id usuario a consultar.
     * @param order si desea ordenar los ascendente o descendentemente.
     * @param method si desea consultar la lista de sus seguidores o a quienes sigue.
     * @return ResponseEntity
    *               Este endpoint enlaza el US 003, US 004 y el US 008, ya que recibe los mismos datos
     *              y varia el parámetro del order entre uno y otro. Por lo que {method} va a ser
     *              followers o followed (en caso tal de que no sea asi, devuelve un 400).
     *               Y si se le envía el parámetro de order, ordenara la lista; en caso contrario,
     *              entregara la lista con los productos de las ultimas dos semanas.
    * */
    @GetMapping(value = "/users/{user_id}/{method}/list")
    ResponseEntity<Object> getOrderedList(
            @PathVariable
                @Positive(
                        message = "El id debe ser mayor a cero.")
                @Range(min = 1, message = "La id no puede estar vacía.") int user_id,
            @RequestParam(defaultValue = "noOrder")
                @Pattern(
                        regexp = "name_asc|name_desc",
                        flags = Pattern.Flag.CASE_INSENSITIVE,
                        message = "El tipo de orden debe ser name_asc o name_desc") String order,
            @PathVariable
                @Pattern(
                        regexp = "followers|followed",
                        flags = Pattern.Flag.CASE_INSENSITIVE,
                        message = "El tipo de orden debe ser name_asc o name_desc") String method);

    /**
     * @param newPost recibe el DTO de un nuevo producto a registrar
     * @return ResponseEntity
     *                      Endpoint para registrar un nuevo producto (US 005)
     * */
    @PostMapping("products/post")
    ResponseEntity<GenericResponseDTO> addPost(@RequestBody @Valid ProductsPostDTO newPost);

    /**
     * @param user_id usuario a consultar.
     * @param order si desea ordenar ascendente o descendentemente las fechas de los post publicados.
     * @return ResponseEntity
     * Este endpoint enlaza el US 006 y el US 009, ya que recibe los mismos datos y varia el
     *              parámetro del order entre uno y otro. Por lo que {method} va a ser followers o followed
     *              (en caso tal de que no sea asi, devuelve un 400).
     *              Y si se le envía el parámetro de order, ordenara la lista; en caso contrario,
     *              entregara la lista con los productos de las ultimas dos semanas.
     * */
    @GetMapping("products/followed/{user_id}/list")
    ResponseEntity<ProductsUserIDListDTO> listSortedPostByUserID(
            @PathVariable
                @Positive(
                        message = "El id debe ser mayor a cero.")
                @Range(min = 1, message = "La id no puede estar vacía.") int user_id,
            @RequestParam(defaultValue = "noOrder") @Pattern(
                    regexp = "date_asc|date_desc",
                    flags = Pattern.Flag.CASE_INSENSITIVE,
                    message = "El tipo de orden debe ser name_asc o name_desc") String order);

    /**
     * @param user_id usuario a consultar.
     * @return ResponseEntity
     *                Endpoint para eliminar el registro del seguidor del sistema. (US 007)
     * */
    @PostMapping("/users/{user_id}/unfollow/{user_id_to_unfollow}")
    ResponseEntity<GenericResponseDTO> unfollowUser(
            @PathVariable
                @Positive(
                        message = "El id debe ser mayor a cero.")
                @Range(min = 1, message = "La id no puede estar vacía.") int user_id,
            @PathVariable
                @Positive(
                        message = "El id debe ser mayor a cero.")
                @Range(min = 1, message = "La id no puede estar vacía.") int user_id_to_unfollow);

    /**
     * @param productsPromoPostDTO publicar un producto en promoción.
     * @return ResponseEntity
     *                Endpoint para registrar un nuevo producto en promoción. (US 010)
     * */
    @PostMapping(value = "/products/promo-post")
    ResponseEntity<GenericResponseDTO> publicPromoPost(@RequestBody ProductsPromoPostDTO productsPromoPostDTO);

    /**
     * @param user_id usuario a consultar.
     * @return ResponseEntity
     *                Endpoint para contar los productos en promoción para los vendedores. (US 011)
     * */
    @GetMapping(value = "/products/{user_id}/promo-post/count")
    ResponseEntity<PromoPostCountDTO> countPromoPostBySeller(
            @PathVariable
                @Positive(
                        message = "El id debe ser mayor a cero.")
                @Range(min = 1, message = "La id no puede estar vacía.") int user_id);

    /**
     * @param user_id usuario a consultar.
     * @return ResponseEntity
     *                Endpoint para listar los productos en promoción de un usuario. (US 012)
     * */
    @GetMapping(value = "/products/{user_id}/list")
    ResponseEntity<PromoPostDTO> listPromoPostByUser(
            @PathVariable
                @Positive(
                        message = "El id debe ser mayor a cero.")
                @Range(min = 1, message = "La id no puede estar vacía.") int user_id);

    /**
     *                Endpoints para listar los datos existentes en el sistema.
     * */
    @GetMapping("/listaSeguidores")
    List<UserFollow> lista();

    @GetMapping("/listaPost")
    List<Post> listaPost();

    @GetMapping("/listaPromoPost")
    List<PromoPost> listaPromoPost();

}
