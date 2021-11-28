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
public class Buyer extends User{

    private List<Seller> followed;

    public Buyer(int userId, String userName) {
        super(userId, userName);
        this.followed = new ArrayList<>();
    }



}
