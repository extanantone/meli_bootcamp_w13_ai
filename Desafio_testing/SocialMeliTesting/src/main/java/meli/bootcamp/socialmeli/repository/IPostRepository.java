package meli.bootcamp.socialmeli.repository;

import meli.bootcamp.socialmeli.model.Post;

import java.util.List;
import java.util.Optional;

/**
 * Interface para manipular los datos de los post dentro del sistema.
 * @author andrmorales
 */
public interface IPostRepository {
    /**
     * @param newPost Post a almacenar.
     *                Recibe un nuevo post para guardar en el sistema.
     */
    void addPost(Post newPost);

    /**
     * @param postID ID post a consultar.
     *                Consulta un post dentro del sistema.
     * @return
     */
    Optional<Post> findPostById(int postID);

    /**
     * @param updatePost Post a actualizar.
     *                Recibe un post para actualizarlo en el sistema.
     */
    Post updatePostById(Post updatePost);

    /**
     * @param postID
     * @return Boolean
     * @implNote Busca si un post existe dentro del sistema.
     */

    boolean existPost(int postID);

    /**
     * @param postID ID post a eliminar.
     *                Recibe un id post para eliminarlo del sistema.
     */
    void deletePost(int postID);

    /**
     *                Devuelve todos los post dentro del sistema.
     */
    List<Post> getAllList();

}
