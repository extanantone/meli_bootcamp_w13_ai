package com.example.socialmeli.demo.comparator;

import com.example.socialmeli.demo.model.Publicacion;

import java.util.Comparator;

public class AscendingPostDateSorter implements Comparator<Publicacion> {

    @Override
    public int compare(Publicacion o1, Publicacion o2) {
        return o2.getDate().compareTo(o1.getDate());
    }
}
