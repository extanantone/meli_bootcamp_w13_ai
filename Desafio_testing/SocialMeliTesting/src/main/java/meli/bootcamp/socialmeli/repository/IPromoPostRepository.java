package meli.bootcamp.socialmeli.repository;

import meli.bootcamp.socialmeli.model.Post;
import meli.bootcamp.socialmeli.model.PromoPost;

import java.util.List;

/**
 * Interface para manipular los datos de los promo post dentro del sistema.
 * @author andrmorales
 */
public interface IPromoPostRepository {
    /**
     * @param newPost Post a almacenar.
     *                Recibe un nuevo promo post para guardar en el sistema.
     */
    void addPromoPost(PromoPost newPost);

    /**
     * @param postID ID post a consultar.
     *                Consulta un promo post dentro del sistema.
     */
    PromoPost findPromoPostById(int postID);

    /**
     * @param updatePost Post a actualizar.
     *                Recibe un promo post para actualizarlo en el sistema.
     */
    PromoPost updatePromoPostById(PromoPost updatePost);

    /**
     * @param postID ID post a eliminar.
     *                Recibe un id de promo post para eliminarlo del sistema.
     */
    void deletePromoPost(int postID);

    /**
     *                Devuelve todos los promo post dentro del sistema.
     */
    List<PromoPost> getAllList();

}
