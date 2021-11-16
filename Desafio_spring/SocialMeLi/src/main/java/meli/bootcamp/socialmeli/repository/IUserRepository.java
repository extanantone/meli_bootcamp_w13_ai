package meli.bootcamp.socialmeli.repository;

import meli.bootcamp.socialmeli.model.User;

import java.util.List;

public interface IUserRepository {
    //Metodos para generar CRUD al repo
    User findUserById(int userID);
    List<User> findAll();
    User updateUserById(int userID);
    void deleteUser(int userID);
    String getUserNameById(int userID);
}
