package com.desafio_spring.principal.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario implements Comparable<String>{
    private int userId;
    private String userName;

    @Override
    public int compareTo(String o) {
        return this.userName.compareTo(o);
    }
}
