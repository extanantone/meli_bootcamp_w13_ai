package com.example.socialmeli.demo.comparator;

import com.example.socialmeli.demo.model.Post;

import java.util.Comparator;

public class DescendingPostDateSorter implements Comparator<Post> {

    @Override
    public int compare(Post o1, Post o2) {
       return o2.getDate().compareTo(o1.getDate());
    }
}
