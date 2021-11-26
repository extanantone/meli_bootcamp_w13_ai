package com.bootcamp.SocialMeli.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//@Getter @Setter
@Data
public class User {
    private int id;
    private String userName;
    private String tipo;

    public User(int id, String userName) {
        this.id = id;
        this.userName = userName;
        this.tipo = "Usuario";
    }
}
