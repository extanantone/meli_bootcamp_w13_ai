package com.bootcamp.socialmeli.repository;

import com.bootcamp.socialmeli.DTO.DTOCount;
import com.bootcamp.socialmeli.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository implements IUserRepository{

    public static List<User> listUsers = new ArrayList<>();

    public UserRepository() {
        inicializarUsers();
    }

    public static void inicializarUsers(){

        listUsers.add(new User(1,"comprador1"));
        listUsers.add(new User(2,"comprador2"));
        listUsers.add(new User(3,"vendedor3"));
        listUsers.add(new User(4,"vendedor4"));

    }

    @Override
    public User findById(int idUser) {

        if(!listUsers.isEmpty()){
            try{
                return listUsers.get(idUser - 1);
            }catch (Exception e) {
                throw new RuntimeException("Usuario no encontrado");
            }
        }

        throw new RuntimeException("La lista de Usuarios está vacía");
    }

    @Override
    public int getCountFollowersOfuser(int idUser) {

        int countFollowers = 0;

        if(!listUsers.isEmpty()){

            for (User u : listUsers) {
                if(u.getListFolows().containsKey(idUser))
                    countFollowers++;
            }

            return countFollowers;

        }

        throw new RuntimeException("La lista de Usuarios está vacía");

    }

    @Override
    public List<User> getFollowersFromUser(int idUser) {

        List<User> listFollowers = new ArrayList<>();

        if(!listUsers.isEmpty()){

            for (User u : listUsers) {
                if(u.getListFolows().containsKey(idUser))
                    listFollowers.add(u);
            }

            return listFollowers;

        }

        throw new RuntimeException("La lista de Usuarios está vacía");

    }

}
