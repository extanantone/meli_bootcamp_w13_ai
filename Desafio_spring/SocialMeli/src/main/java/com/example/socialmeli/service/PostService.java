package com.example.socialmeli.service;

import com.example.socialmeli.dto.PostDTO;
import com.example.socialmeli.dto.PostListDTO;
import com.example.socialmeli.dto.ProductDetailDTO;
import com.example.socialmeli.dto.UserPostDTO;
import com.example.socialmeli.model.Post;
import com.example.socialmeli.model.PostDetail;
import com.example.socialmeli.model.User;
import com.example.socialmeli.repository.IPostRepository;
import com.example.socialmeli.repository.IUserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;

import static java.time.temporal.ChronoUnit.DAYS;

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
    }

    public UserPostDTO getPosts(Integer userId) {
        int daysToSearch = 14;
        User user = userRepository.find(userId);
        UserPostDTO userPosts = new UserPostDTO(userId);
        Post post;
        PostListDTO postListDTO;
        ProductDetailDTO productDetailDTO;
        for(int postId : user.getPosts()){
            post = postRepository.find(postId);
            if (DAYS.between(post.getDate(), LocalDate.now()) < daysToSearch) {
                productDetailDTO = new ProductDetailDTO(
                        post.getDetails().getProductId(),
                        post.getDetails().getProductName(),
                        post.getDetails().getType(),
                        post.getDetails().getBrand(),
                        post.getDetails().getColor(),
                        post.getDetails().getNotes()
                );
                postListDTO = new PostListDTO(
                        post.getIdPost(),
                        post.getDate(),
                        productDetailDTO,
                        post.getCategory(),
                        post.getPrice()
                );
                userPosts.getPosts().add(postListDTO);
            }
        }
        if (userPosts.getPosts().size() > 2) {
            userPosts.getPosts().sort(Comparator.comparing(PostListDTO::getDate).reversed());
        }
        return userPosts;
    }
}
