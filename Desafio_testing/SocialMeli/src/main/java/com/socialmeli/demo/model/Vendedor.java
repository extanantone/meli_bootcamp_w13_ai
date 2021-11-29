package com.socialmeli.demo.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
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
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Vendedor extends Usuario{
    private List<Publicacion> publicaciones;
    private List<Comprador> seguidores;

    public Vendedor(String name, Integer user_id) {
        super(name, user_id);
        this.publicaciones = new ArrayList<Publicacion>();
        this.seguidores = new ArrayList<Comprador>();
    }

}
