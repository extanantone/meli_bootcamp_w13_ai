package com.bootcamp.socialmeli.entitiy.comparator;

import com.bootcamp.socialmeli.entitiy.Post;

import java.util.Comparator;

public class PostComparator implements Comparator<Post> {

    private SorterOrder order;

    public PostComparator(SorterOrder order) {
        this.order = order;
    }

    @Override
    public int compare(Post o1, Post o2) {

        int compared;

        if(o1.getDate().equals(o2.getDate())){
            compared = 0;
        }else{
            if(o1.getDate().isBefore(o2.getDate())){
                compared = 1;
            }else{
                compared = -1;
            }

        }
        return (order == SorterOrder.ASC)
                ? compared
                : compared * (-1);
    }

}
