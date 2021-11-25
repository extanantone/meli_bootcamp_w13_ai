package com.example.socialmeli.utils;

import com.example.socialmeli.dto.UserDTO;

public class IntDescSorter implements Sorter<UserDTO>{

    @Override
    public int sort(UserDTO first, UserDTO second) {
        return second.getUserId() - first.getUserId();
    }
}
