package com.example.socialmeli.utils;

import com.example.socialmeli.dto.UserDTO;

public class AlphaAscSorter implements Sorter<UserDTO>{


    /*AlphaSorter(boolen asc) {}*/
    @Override
    public int sort(UserDTO first, UserDTO second) {
        return first.getUserName().compareTo(second.getUserName());
    }
}
