package com.bootcamp.SocialMeli.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class Buyer extends User{

    public Buyer(int id, String name) {

        super(id, name, new HashMap<Integer, Seller>());
    }
}
