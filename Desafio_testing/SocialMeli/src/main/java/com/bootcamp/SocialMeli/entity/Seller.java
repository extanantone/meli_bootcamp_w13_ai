package com.bootcamp.SocialMeli.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Seller extends User{

    private List<Buyer> followers;
    private List<Post> post;

    private int followersCount;

    public Seller(int userId, String userName) {
        super(userId, userName);
        this.followers = new ArrayList<>();
        this.post = new ArrayList<>();
    }


}
