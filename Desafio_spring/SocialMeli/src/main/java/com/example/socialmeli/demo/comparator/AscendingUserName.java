package com.example.socialmeli.demo.comparator;

import com.example.socialmeli.demo.model.Usuarios;

import java.util.Comparator;

public class AscendingUserName implements Comparator<Usuarios> {

    @Override
    public int compare(Usuarios o1, Usuarios o2) {
        return o1.getUserName().toLowerCase().compareToIgnoreCase(o2.getUserName().toLowerCase());
    }

}
