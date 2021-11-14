package com.lgoyenechea.socialmeli.repository;

import com.lgoyenechea.socialmeli.model.Post;
import com.lgoyenechea.socialmeli.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IRepository<Long, Post> {

    private final List<Post> posts;
    private Long idPostCounter = 1L;
    private Long idProductCounter = 1L;

    public ProductRepository() {
        posts = new ArrayList<>();
    }

    @Override
    public Post save(Post post) {
        setPostId(post);
        setProductId(post.getDetail());
        posts.add(post);
        return post;
    }

    @Override
    public Post getById(Long aLong) {
        return null;
    }

    private void setPostId(Post post) {
        post.setId(idPostCounter);
        idPostCounter++;
    }

    private void setProductId(Product product) {
        product.setId(idProductCounter);
        idProductCounter++;
    }
}
