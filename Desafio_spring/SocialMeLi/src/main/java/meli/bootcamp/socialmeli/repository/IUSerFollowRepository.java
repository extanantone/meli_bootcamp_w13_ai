package meli.bootcamp.socialmeli.repository;

import meli.bootcamp.socialmeli.model.UserFollow;

import java.util.List;

/**
 * Interface para manipular los registros de seguimiento entre cuentas.
 * @author andrmorales
 */
public interface IUSerFollowRepository {
    /**
     * @param userID1 Usuario seguidor.
     * @param userID2 Usuario a seguir.
     *                Crea un nuevo registro de seguimiento en el sistema.
     */
    UserFollow newUserFollow(int userID1, int userID2);

    /**
     * @param userID1 Usuario seguidor.
     * @param userID2 Usuario a seguir.
     *                Consulta si un usuario sigue a otro.
     */
    UserFollow checkUserFollow(int userID1, int userID2);

    /**
     * @param userID1 usuario a consultar.
     *                Consulta los seguidores de un usuario dentro del sistema.
     */
    List<UserFollow> listUserFollowersByID(int userID1);

    /**
     * @param userID1 usuario a consultar.
     *                Consultar los usuario a quien sigue la cuenta.
     */
    List<UserFollow> listFollowedUserByID(int userID1);

    /**
     * @param userID1 Usuario seguidor.
     * @param userID2 Usuario a dejar de seguir.
     *                Eliminar un registro de seguimiento en el sistema.
     */
    void unfollowUser(int userID1, int userID2);

    /**
     *                Devuelve todos los promo post dentro del sistema.
     */
    List<UserFollow> getAllList();
}
