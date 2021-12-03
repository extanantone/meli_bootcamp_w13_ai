package com.bootcamp.SocialMeli.service;



import com.bootcamp.SocialMeli.dto.PostDTO;
import com.bootcamp.SocialMeli.model.Post;
import com.bootcamp.SocialMeli.dto.PostDoneDTO;

import java.text.ParseException;
import java.util.List;

public interface ProductService {
    List<Post> getPostList();
    List<Post> getPostListById(int userId);
    PostDoneDTO getPostListFrom2WeeksAgo(int userId, String order);

    void post(PostDTO newPost) throws ParseException;
}
