package com.bootcamp.socialmeli.repository;

import com.bootcamp.socialmeli.DTO.DTOPostProduct;
import com.bootcamp.socialmeli.model.Post;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepository implements IPostRepository{

    public static List<Post> postList = new ArrayList<Post>();

    @Override
    public boolean addPost(Post post) {
        int count = postList.size();
        postList.add(post);

        if(postList.size() <= count)
            return false;

        return true;
    }
}
