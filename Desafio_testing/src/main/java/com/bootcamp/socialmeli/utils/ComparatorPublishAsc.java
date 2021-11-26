package com.bootcamp.socialmeli.utils;

import com.bootcamp.socialmeli.DTO.DTOPublishPost;

import java.util.Comparator;

public class ComparatorPublishAsc implements Comparator<DTOPublishPost> {

    @Override
    public int compare(DTOPublishPost o1, DTOPublishPost o2) {
        return o1.getDate().compareTo(o2.getDate());
    }
}
