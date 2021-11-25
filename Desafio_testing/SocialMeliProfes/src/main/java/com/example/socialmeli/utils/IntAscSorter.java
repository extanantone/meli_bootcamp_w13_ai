package com.example.socialmeli.utils;

import com.example.socialmeli.dto.UserDTO;

public class IntAscSorter implements Sorter<UserDTO>{

    @Override
    public int sort(UserDTO first, UserDTO second) {
        return first.getUserId() - second.getUserId();
    }
}