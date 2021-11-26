package com.example.socialmeli.service;

import com.example.socialmeli.dto.*;
import com.example.socialmeli.model.Post;
import com.example.socialmeli.model.PostDetail;
import com.example.socialmeli.model.PromoPost;
import com.example.socialmeli.model.User;
import com.example.socialmeli.repository.IPostRepository;
import com.example.socialmeli.repository.IUserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
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

    public void addPost(Integer userId, Integer postId, @Valid PostDTO post) {
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
        if (postRepository.addPost(postId, postModel)) { userRepository.find(userId).addPost(postId); }
    }

    public void addPromoPost(Integer userId, Integer postId, @Valid PromoPostDTO post) {
        PostDetail postDetail = new PostDetail(
                post.getDetail().getProductId(),
                post.getDetail().getProductName(),
                post.getDetail().getType(),
                post.getDetail().getBrand(),
                post.getDetail().getColor(),
                post.getDetail().getNotes()
        );
        PromoPost promoPostModel = new PromoPost(
                post.getIdPost(),
                post.getUserId(),
                post.getDate(),
                postDetail,
                post.getCategory(),
                post.getPrice(),
                post.isHasPromo(),
                post.getDiscount()
        );
        if (postRepository.addPromoPost(postId, promoPostModel)) { userRepository.find(userId).addPromoPost(postId); }
    }

    public UserPostDTO getPosts(Integer userId, String order) {
        int daysToSearch = 14;
        User user = userRepository.find(userId);
        @Valid
        UserPostDTO userPosts = new UserPostDTO(userId);
        Post post;
        @Valid
        PostListDTO postListDTO;
        @Valid
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
        if (userPosts.getPosts().size() > 1) {
            if (order != null && order.equals("date_asc")) {
                userPosts.getPosts().sort(Comparator.comparing(PostListDTO::getDate));
            } else {
                userPosts.getPosts().sort(Comparator.comparing(PostListDTO::getDate).reversed());
            }
        }
        return userPosts;
    }

    @Override
    public PromoCountDTO getPromoCount(Integer userId) {
        User user = userRepository.find(userId);
        @Valid
        PromoCountDTO promoCountDTO = new PromoCountDTO(user.getId(), user.getName(), user.getPromoPosts().size());
        return promoCountDTO;
    }
}
