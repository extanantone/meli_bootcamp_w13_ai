package com.example.socialmeli.utils;

import com.example.socialmeli.dto.PostDTO;

public class DateDescSorter implements Sorter<PostDTO> {

    @Override
    public int sort(PostDTO first, PostDTO second) {
        return second.getDate().compareTo(first.getDate());
    }
}
