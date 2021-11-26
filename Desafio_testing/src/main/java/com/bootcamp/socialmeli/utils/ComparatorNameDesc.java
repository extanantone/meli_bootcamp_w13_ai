package com.bootcamp.socialmeli.utils;

import com.bootcamp.socialmeli.DTO.DTOUser;

import java.util.Comparator;

public class ComparatorNameDesc implements Comparator<DTOUser> {

    @Override
    public int compare(DTOUser o1, DTOUser o2) {
        return o2.getUserName().compareTo(o1.getUserName());
    }
}
