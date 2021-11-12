package com.bootcamp.socialmeli.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.LowerCamelCaseStrategy.class)
public class User {

    private int userId;
    private String userName;
    private HashMap<Integer,User> listFolows = new HashMap<Integer,User>();

    public User(int userId, String nombre) {
        this.userId = userId;
        this.userName = nombre;
    }

    public boolean addListFollows(Integer userIdToFollow, User userToFollow){
        if(!listFolows.containsKey(userIdToFollow)){
            listFolows.put(userIdToFollow,userToFollow);
            return true;
        }
        return false;
    }

}
