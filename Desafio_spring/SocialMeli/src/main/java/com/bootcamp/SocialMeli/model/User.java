package com.bootcamp.SocialMeli.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Struct;

@Getter @Setter
public class User {
    private int id;
    private String userName;
    private String Tipo;

    public User(int id, String userName) {
        this.id = id;
        this.userName = userName;
        this.Tipo = "Usuario";
    }
}
