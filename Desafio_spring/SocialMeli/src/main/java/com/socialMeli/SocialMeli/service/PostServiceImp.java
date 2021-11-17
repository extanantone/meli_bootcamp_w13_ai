package com.socialMeli.SocialMeli.service;

import com.socialMeli.SocialMeli.model.Post;
import com.socialMeli.SocialMeli.model.User;
import com.socialMeli.SocialMeli.postDTO.PostDTO;
import com.socialMeli.SocialMeli.postDTO.PostFollowedDTO;
import com.socialMeli.SocialMeli.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class PostServiceImp implements PostService{

    @Autowired
    PostRepository postRepository;

    @Override
    public Post create(Post post) {
        return postRepository.create(post);
    }

    @Override
    public PostFollowedDTO productListFollowed(User user) {

        return postRepository.productListFollowed(user);
    }

    @Override
    public PostFollowedDTO productListFollowed(User user, String date_desc) {
        PostFollowedDTO productiList = postRepository.productListFollowed(user);
        Collections.reverse(productiList.getPosts());
        return productiList;
    }
}
