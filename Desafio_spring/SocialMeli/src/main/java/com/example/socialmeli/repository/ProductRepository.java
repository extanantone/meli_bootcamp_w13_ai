package com.example.socialmeli.repository;

import com.example.socialmeli.exception.BadRequestException;
import com.example.socialmeli.model.Post;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductRepository implements IProductRepository{
    List<Post> posts = new ArrayList<>();


    @Override
    public void createPost(Post post) {
        posts.add(post);
    }

    @Override
    public Boolean findById(Integer postId) {

        return posts.stream()
                .filter(x-> x.getIdPost().equals(postId))
                .findFirst().isEmpty();

    }

    @Override
    public List<Post> listPosts(Integer userId) {
        LocalDate twoWeaksBefore = LocalDate.now().minusDays(15);
        return posts.stream()
                .filter(x -> x.getUserId().equals(userId))
                .filter(x -> x.getDate().isAfter(twoWeaksBefore))
                .collect(Collectors.toList());
    }

    @Override
    public List<Post> promoPost(Integer userId) {

        return posts.stream()
                .filter(x -> x.getUserId().equals(userId))
                .filter(x -> x.getHasPromo())
                .collect(Collectors.toList());
    }


}
