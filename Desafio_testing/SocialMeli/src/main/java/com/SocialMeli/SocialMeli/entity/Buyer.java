package com.SocialMeli.SocialMeli.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;

@Getter @Setter
public class Buyer extends User{
    public Buyer(){}

    public Buyer(int id, String userName, HashMap<Integer, User> followed) {
        this.id = id;
        this.userName = userName;
        this.followed = followed;
    }
}
