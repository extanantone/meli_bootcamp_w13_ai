package com.bootcamp.SocialMeli.model;

import lombok.*;

import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Seller {

    private String name;
    private int id_Seller;
    List<Buyer> followers= new LinkedList<>();
    List<Post> posts= new LinkedList<>();

}
