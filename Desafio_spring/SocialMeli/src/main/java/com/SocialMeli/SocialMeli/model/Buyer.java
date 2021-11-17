package com.SocialMeli.SocialMeli.model;

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
public class Buyer extends User {
    private List <Seller> followed = new ArrayList<Seller>();

    public Buyer(String user_name, int user_id) {
        super(user_name, user_id);
    }
}
