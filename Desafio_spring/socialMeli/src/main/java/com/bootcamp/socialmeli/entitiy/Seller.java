package com.bootcamp.socialmeli.entitiy;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Seller extends User {

    private List<Post> posts;
    private List<Integer> followers;

    public Seller(int userID, String user_name) {
        super(userID, user_name);
        this.posts = new ArrayList<>();
        this.followers = new ArrayList<>();
    }

    public void addFollower(Integer sellerId)
    {
        followers.add(sellerId);
    }
    public void deleteFollower(Integer sellerId)
    {
        followers.remove(sellerId);
    }

//    añadir post y eliminar post
}
