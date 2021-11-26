package com.bootcamp.socialmeli.repository;

import com.bootcamp.socialmeli.DTO.DTOUser;
import com.bootcamp.socialmeli.model.User;
import com.bootcamp.socialmeli.utils.ComparatorNameAsc;
import com.bootcamp.socialmeli.utils.ComparatorNameDesc;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserRepository implements IUserRepository{

    public static List<User> listUsers = new ArrayList<>();

    public UserRepository() {
        inicializarUsers();
    }

    public static void inicializarUsers(){

        listUsers.add(new User(1,"anibal"));
        listUsers.add(new User(2,"marco"));
        listUsers.add(new User(3,"gabriela"));
        listUsers.add(new User(4,"andres"));

    }

    @Override
    public User findById(int idUser) {

        if(!listUsers.isEmpty()){
            try{
                return listUsers.get(idUser - 1);
            }catch (Exception e) {
                throw new RuntimeException("Usuario " + idUser + " no encontrado");
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

    @Override
    public List<DTOUser> orderFollowersAndFolloweds(List<DTOUser> dtoUserList, String order) {
        if(order.equals("name_desc"))
            return dtoUserList.stream().sorted(new ComparatorNameDesc()).collect(Collectors.toList());
        return dtoUserList.stream().sorted(new ComparatorNameAsc()).collect(Collectors.toList());
    }

}
