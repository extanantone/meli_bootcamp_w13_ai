package com.example.socialmeli.demo.comparator;

import com.example.socialmeli.demo.model.Post;

import java.util.Comparator;

public class AscendingPostDateSorter implements Comparator<Post> {

    @Override
    public int compare(Post o1, Post o2) {
        return o1.getDate().compareTo(o2.getDate());
    }
}
