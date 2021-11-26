package meli.bootcamp.socialmeli.repository;

import meli.bootcamp.socialmeli.model.User;

import java.util.List;

/**
 * Interface para manipular los datos de usuarios dentro del sistema.
 * @author andrmorales
 */
public interface IUserRepository {
    /**
     * @param user
     * @implNote Se agrega un usuario al sistema
     * @return
     */
    User addUser(User user);

    /**
     * @param userId UsuarioID a consultar
     * @implNote Metodo que busca si un usuario existe en el sistema
     */
    boolean userExist(int userId);

    /**
     * @param userID usuario a consultar.
     *               Consulta si un usuario existe en el sistema.
     */
    User findUserById(int userID);

    /**
     * @param user Usuario a actualizar.
     *                Recibe un usuario para actualizarlo en el sistema.
     */
    User updateUserById(User user);

    /**
     * @param userID ID de usuario a eliminar.
     *               Elimina un usuario dentro del sistema.
     */
    void deleteUser(int userID);

    /**
     * @param userID ID de usuario a consultar.
     *                Devuelve el nombre de usuario.
     */
    String getUserNameById(int userID);

    /**
     * Devuelve todos los usuario dentro del sistema.
     */
    List<User> findAll();

}
