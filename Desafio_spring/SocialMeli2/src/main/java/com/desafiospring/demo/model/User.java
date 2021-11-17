package com.desafiospring.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

//etiquetas que que debo poner si o si en el model

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String name;
    private List<User> followers;
    private List<User> follower; //us7

    public User(Integer id, String name ) {
        this.id = id;
        this.name = name;
        this.followers = new ArrayList<>();
        this.follower = new ArrayList<>();
    }

    //hacemos un metodo que nos permita agregar quien nos sigue(lo modelamos)
    public void AddFollowers(User userfollowers){
        followers.add(userfollowers);

    }





}
