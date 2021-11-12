package com.socialmeli.model;

import com.socialmeli.exception.InvalidSellerException;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class User {

    private static int cont = 0;

    private int id;
    private String name;
    private String email;
    private List<User> followers;
    private boolean seller;

    public User(){
        id=++cont;
        followers = new ArrayList<>();
    }

    public User(String name,String email,boolean seller){
        this();
        this.name = name;
        this.email = email;
        this.seller = seller;
    }

    public void addFollower(User follower){
        if(!seller)
            throw new InvalidSellerException("Not allow follow user");
        followers.add(follower);
    }

}
