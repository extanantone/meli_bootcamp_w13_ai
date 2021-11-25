package com.SocialMeli.SocialMeli.repository;

import com.SocialMeli.SocialMeli.entity.Post;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class PostRepository implements IPostRepository{
    protected int id = 0;
    protected Map<Integer, Post> posts = new HashMap<>();

    @Override
    public Post getById(int id) {
        return this.posts.get(id);
    }

    @Override
    public boolean create(Post post) {
        this.posts.put(post.getId(), post);
        return true;
    }

    @Override
    public List<Post> getByUserId(int userId, LocalDate date) {
        List<Post> posts = this.posts.values().stream().filter(post -> post.getSellerId() == userId && post.getDate().isAfter(date)).collect(Collectors.toList());
        return posts.stream().sorted(Comparator.comparing(Post::getDate).reversed()).collect(Collectors.toList());
    }

    @Override
    public List<Post> getPromosByUser(int userId) {
        List<Post> posts = this.posts.values().stream().filter(post -> post.getSellerId() == userId && post.isHas_promo()).collect(Collectors.toList());
        return posts.stream().sorted(Comparator.comparing(Post::getDate).reversed()).collect(Collectors.toList());
    }
}
