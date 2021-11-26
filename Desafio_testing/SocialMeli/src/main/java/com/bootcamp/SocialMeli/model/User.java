package com.bootcamp.SocialMeli.model;

import lombok.Data;

//@Getter @Setter
@Data
public class User {
    private int userId;
    private String userName;
    private String tipo;

    public User(int userId, String userName) {
        this.userId = userId;
        this.userName = userName;
        this.tipo = "Usuario";
    }
}
