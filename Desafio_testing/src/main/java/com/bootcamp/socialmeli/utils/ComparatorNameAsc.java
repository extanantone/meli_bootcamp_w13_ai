package com.bootcamp.socialmeli.utils;

import com.bootcamp.socialmeli.DTO.DTOUser;

import java.util.Comparator;

public class ComparatorNameAsc implements Comparator<DTOUser> {

    @Override
    public int compare(DTOUser o1, DTOUser o2) {
        return o1.getUserName().compareTo(o2.getUserName());
    }
}
