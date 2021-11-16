package com.example.socialmeli.service;

import com.example.socialmeli.dto.PostDTO;
import com.example.socialmeli.model.Post;
import com.example.socialmeli.model.PostDetail;
import com.example.socialmeli.repository.IPostRepository;
import com.example.socialmeli.repository.IUserRepository;
import org.springframework.stereotype.Service;

@Service
public class PostService implements IPostService{
    private final IPostRepository postRepository;
    private final IUserRepository userRepository;

    public PostService(IPostRepository postRepository, IUserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public void addPost(Integer userId, Integer postId, PostDTO post) {
        PostDetail postDetail = new PostDetail(
                post.getDetail().getProductId(),
                post.getDetail().getProductName(),
                post.getDetail().getType(),
                post.getDetail().getBrand(),
                post.getDetail().getColor(),
                post.getDetail().getNotes()
        );
        Post postModel = new Post(
                post.getIdPost(),
                post.getUserId(),
                post.getDate(),
                postDetail,
                post.getCategory(),
                post.getPrice()
        );
        userRepository.find(userId).addPost(postId);
        postRepository.addPost(postId, postModel);
        System.out.println(postRepository.getPosts().size());
        System.out.println(postRepository.find(postId).getPrice());
    }
}
