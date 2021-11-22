package com.example.socialMeli.model;

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
public class Comprador extends Usuario{
    private List<Vendedor> siguiendo;

    public Comprador(String name, int user_id) {
        super(name, user_id);
        this.siguiendo = new ArrayList<Vendedor>();
    }
}
