package com.bootcamp.SocialMeli.repository;

import com.bootcamp.SocialMeli.dto.UserDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository{
    private List<UserDTO> usersList = new ArrayList<>();

    public UserRepositoryImpl() {
        UserDTO user1 = new UserDTO(1,"MELI");
        UserDTO user2 = new UserDTO(2,"Accenture");
        UserDTO user3 = new UserDTO(3,"Pepas");
        UserDTO user4 = new UserDTO(4,"Isadora");
        this.usersList.add(user1);
        this.usersList.add(user2);
        this.usersList.add(user3);
        this.usersList.add(user4);
    }

    @Override
    public List<UserDTO> getUsers() {
        return usersList;
    }
    @Override
    public boolean userExists(int id){
        for (int i =0;i<usersList.size();i++){
            if (usersList.get(i).getUserId()==id){
                return true;
            }
        }
        return false;
    }
/*    @Override
    public List<User> orderByNameAsc(int userId, String order){
        getFollowersList(userId).getFollowers().stream().sorted().collect(Collectors.toList());
    }

    @Override
    public List<User> orderByNameDesc(int userId, String order);*/


}
