package com.bootcamp.socialmeli.utils;

import com.bootcamp.socialmeli.DTO.DTOPublishPost;

import java.util.Comparator;

public class ComparatorPublishDesc implements Comparator<DTOPublishPost> {

    @Override
    public int compare(DTOPublishPost o1, DTOPublishPost o2) {
        return o2.getDate().compareTo(o1.getDate());
    }
}
