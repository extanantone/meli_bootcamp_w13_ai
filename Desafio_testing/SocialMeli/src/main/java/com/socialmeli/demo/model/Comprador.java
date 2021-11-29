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
public class Comprador extends Usuario{
    private List<Vendedor> siguiendo;

    public Comprador(String name, Integer user_id) {
        super(name, user_id);
        this.siguiendo = new ArrayList<Vendedor>();
    }
}
