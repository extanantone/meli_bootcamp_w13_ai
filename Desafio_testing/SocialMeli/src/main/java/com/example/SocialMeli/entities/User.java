package com.example.SocialMeli.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long user_id;
    private String user_name;
    private List<Long> seguidos;
    private List<Long> seguidores;
    private List<Long> products;


    public User(Long user_id, String user_name) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.seguidores = new ArrayList<>();
        this.seguidos = new ArrayList<>();
        this.products = new ArrayList<>();
    }

    public User(long userId, String name, List<Long> products) {
        this.user_id = userId;
        this.user_name = name;
        this.seguidores = new ArrayList<>();
        this.seguidos = new ArrayList<>();
        this.products = products;
    }
}
