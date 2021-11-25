package com.example.socialmeli.utils;

import com.example.socialmeli.dto.PostDTO;

public class DateAscSorter implements Sorter<PostDTO> {

    @Override
    public int sort(PostDTO first, PostDTO second) {
        return first.getDate().compareTo(second.getDate());
    }
}
