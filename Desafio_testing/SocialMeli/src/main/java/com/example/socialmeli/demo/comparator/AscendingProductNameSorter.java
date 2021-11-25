package com.example.socialmeli.demo.comparator;

import com.example.socialmeli.demo.model.Post;
import com.example.socialmeli.demo.model.Product;
import com.example.socialmeli.demo.model.PromoPost;

import java.util.Comparator;

public class AscendingProductNameSorter implements Comparator<Post> {


    @Override
    public int compare(Post o1, Post o2) {
        return o2.getDetail().getProductName().toLowerCase().compareTo(o1.getDetail().getProductName().toLowerCase());
    }
}
