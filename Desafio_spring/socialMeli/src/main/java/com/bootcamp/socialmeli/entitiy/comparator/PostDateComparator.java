package com.bootcamp.socialmeli.entitiy.comparator;

import com.bootcamp.socialmeli.entitiy.Post;

import java.util.Comparator;

public class PostDateComparator implements Comparator<Post> {

    @Override
    public int compare(Post o1, Post o2) {

        int compared;

        if(o1.getDate().equals(o2.getDate())){
            return 0;
        }else{
            if(o1.getDate().isBefore(o2.getDate())){
                return 1;
            }else{
                return -1;
            }

        }
    }

}
