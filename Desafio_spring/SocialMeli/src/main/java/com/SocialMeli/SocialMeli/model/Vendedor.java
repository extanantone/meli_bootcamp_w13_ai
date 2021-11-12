package com.SocialMeli.SocialMeli.model;

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
public class Vendedor extends Usuario {
    private List<Comprador> followers;

    public Vendedor(int user_id, String user_name) {
        super(user_id, user_name);
        this.followers = new ArrayList<Comprador>();
    }
}
