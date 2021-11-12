package com.socialmeli.model;

import com.socialmeli.exception.InvalidSellerException;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
        else if(followers.contains(follower))
            throw new InvalidSellerException("Now follow this user");
        followers.add(follower);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
