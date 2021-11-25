package com.SocialMeli.SocialMeli.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Seller extends User{
    protected Map<Integer, User> followers;

    public Seller(int id, String userName, HashMap<Integer, User> followed, HashMap<Integer, User> followers) {
        this.id = id;
        this.userName = userName;
        this.followed = followed;
        this.followers = followers;
    }
}
