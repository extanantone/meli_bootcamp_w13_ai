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
public class Comprador extends Usuario {
    List <Vendedor> followed;

    public Comprador(int user_id, String user_name) {
        super(user_id, user_name);
        this.followed = new ArrayList<Vendedor>();
    }
}
