package com.example.socialmeli.demo.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Followers {

    private int userID;
    //En este hash almacenaremos a cada usuario que nuestro userId siga
    private Map<Integer, Usuarios> usuariosSeguidos;


    public Followers(int userID) {
        this.userID = userID;
        usuariosSeguidos = new HashMap<>();
    }
}
