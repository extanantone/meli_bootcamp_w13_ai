package meli.bootcamp.socialmeli.service;

import meli.bootcamp.socialmeli.dto.*;
import meli.bootcamp.socialmeli.model.Post;
import meli.bootcamp.socialmeli.model.PromoPost;
import meli.bootcamp.socialmeli.model.UserFollow;

import java.util.List;

public interface ISocialMeliService {
    /**
     * @param userID Usuario seguidor.
     * @param userIDToFollow usuario a seguir.
     */
    void followUser(int userID, int userIDToFollow);

    /**
     * @param userID Usuario a consultar
     * @return FollowersCountDTO
     */
    FollowersCountDTO getFollowersCount(int userID);

    /**
     * @param userID Usuario seguidor.
     * @param userIDToUnfollow Usuario a dejar de seguir.
     */
    void unfollowUser(int userID, int userIDToUnfollow);

    /**
     *
     * @param user_id Usuario a consultar
     * @param order En caso de estar ordenado, recive el tipo de orden (ascendente
     *              o descendente por fecha).
     * @return ProductsUserIDListDTO
     */
    ProductsUserIDListDTO listSortedPostByUserID(int user_id, String order);

    /**
     * @param newPost Post a agregar.
     */
    void addPost(ProductsPostDTO newPost);

    /**
     * @param userID Usuario a consultar.
     * @param searchFollowers Devuelve un true si esta buscando los seguidores de un usuario, y
     *                        un false en caso tal de buscar las cuentas a las cuales sigue.
     * @param order En caso de estar ordenado, ordenar ascendente o descendentemente por nombre de
     *              usuario.
     * @param sortedResponse Devuelve un true si debe ordenar las respuestas.
     * @return FollowersListDTO
     */
    FollowersListDTO getOrderedFollowersList(int userID, boolean searchFollowers, String order, boolean sortedResponse);

    /**
     * @param productsPromoPostDTO Recibe el Promo Post a agregar.
     */
    void newPromoPost(ProductsPromoPostDTO productsPromoPostDTO);

    /**
     * @param userID ID de usuario a consultar.
     * @return PromoPostCountDTO
     */
    PromoPostCountDTO countPromoPost(int userID);

    /**
     * @param userID ID de usuario a consultar.
     * @return PromoPostDTO
     */
    PromoPostDTO listPromoPostByUSer(int userID);

    /**
     *
     * @return Las listas de los usuarios.
     */
    List<UserFollow> lista();
    List<Post> listaPost();
    List<PromoPost> listaPromoPost();
}
