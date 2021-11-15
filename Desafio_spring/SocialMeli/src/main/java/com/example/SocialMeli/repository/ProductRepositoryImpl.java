package com.example.SocialMeli.repository;

import com.example.SocialMeli.entities.Post;
import com.example.SocialMeli.entities.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    List<Post> posts = new ArrayList<>();


    @Override
    public Boolean saveProduct(Post post) {
        return this.posts.add(post);
    }
}
