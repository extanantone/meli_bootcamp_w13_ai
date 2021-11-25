package com.example.socialmeli.utils;

import com.example.socialmeli.dto.UserDTO;

public class AlphaDescSorter implements Sorter<UserDTO>{

    @Override
    public int sort(UserDTO first, UserDTO second) {
        return second.getUserName().compareTo(first.getUserName());
    }
}
