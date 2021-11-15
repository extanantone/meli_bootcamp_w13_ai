package com.example.socialmeli.demo.comparator;

import com.example.socialmeli.demo.model.Usuarios;


import java.util.Comparator;
import java.util.Locale;

public class DescendingUserName implements Comparator<Usuarios> {

    @Override
    public int compare(Usuarios o1, Usuarios o2) {
        return o2.getUsername().toLowerCase().compareToIgnoreCase(o1.getUsername().toLowerCase());
    }


}
