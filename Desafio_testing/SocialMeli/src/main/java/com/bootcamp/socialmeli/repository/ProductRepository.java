package com.bootcamp.socialmeli.repository;

import com.bootcamp.socialmeli.model.Post;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository{

    private List<Post> postList;

    public ProductRepository(){
        postList = new ArrayList<>();
    }

    @Override
    public void postProduct(Post post) {
        postList.add(post);
    }

    @Override
    public List<Post> getPost(int userId) {
        List<Post> postListFiltered = new ArrayList<>();
        //date corresponde al rango de fecha que quiero obtener los post
        LocalDate date = LocalDate.now().minusWeeks(2);

        for (Post p : postList){
            boolean isInPeriod = p.getDate().isEqual(date) || p.getDate().isAfter(date);
            if(p.getUserId() == userId && isInPeriod)   postListFiltered.add(p);
        }
        return postListFiltered;
    }

}
