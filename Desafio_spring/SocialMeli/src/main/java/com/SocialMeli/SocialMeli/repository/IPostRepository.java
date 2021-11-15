package com.SocialMeli.SocialMeli.repository;

import com.SocialMeli.SocialMeli.entity.Post;

import java.time.LocalDate;
import java.util.List;

public interface IPostRepository {
    public Post getById(int id);
    public boolean create(Post post);
    public List<Post> getByUserId(int userId, LocalDate date);
    public List<Post> getPromosByUser(int userId);
}
