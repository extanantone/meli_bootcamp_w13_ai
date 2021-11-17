package com.bootcamp.SocialMeli.service;

import com.bootcamp.SocialMeli.dto.FollowedPostsDTO;
import com.bootcamp.SocialMeli.dto.PostDTO;
import com.bootcamp.SocialMeli.dto.PromoPostsCountDTO;
import com.bootcamp.SocialMeli.dto.PromoPostsDTO;
import com.bootcamp.SocialMeli.exception.UserNotFoundException;
import com.bootcamp.SocialMeli.mapper.IPostMapper;
import com.bootcamp.SocialMeli.mapper.PostMapper;
import com.bootcamp.SocialMeli.model.Post;
import com.bootcamp.SocialMeli.model.User;
import com.bootcamp.SocialMeli.repository.IPostRepository;
import com.bootcamp.SocialMeli.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
public class PostService implements IPostService{
    @Autowired IPostMapper postMapper;
    @Autowired IPostRepository postRepository;
    @Autowired IUserRepository userRepository;

    @Override
    public void addPost(Post post) {
        postRepository.add(post);
        int userId = post.getUserId();

        User user = userRepository.find(userId).orElseThrow(() ->
                new UserNotFoundException(userId));
        user.addPost(post);
    }

    @Override
    public FollowedPostsDTO getFollowedPosts(int userId, Optional<String> order) {
        User user = this.userRepository.find(userId).orElseThrow(() ->
                new UserNotFoundException(userId));

        List<User> listOfFollowed = new ArrayList<>(user.getFollowed().values());

        LocalDate today = LocalDate.now();

        List<PostDTO> listOfPosts = new ArrayList<>();

        for (User followed : listOfFollowed) {
            for (Post post : followed.getPosts().values()) {
                LocalDate postDate = post.getDate();
                long dateDifference = DAYS.between(postDate, today);
                if (dateDifference > 14) {
                    continue;
                }
                PostDTO postDTO = postMapper.postToPostDTO(post);
                listOfPosts.add(postDTO);
            }
        }
        if (order.isPresent()) {
            if (order.get().equals("date_asc")) {
                listOfPosts.sort(Comparator.comparing(PostDTO::getDate));
            }
            else if (order.get().equals("date_desc")) {
                listOfPosts.sort(Comparator.comparing(PostDTO::getDate).reversed());
            }
            //tirar excepción si el orden es otro?
        }

        FollowedPostsDTO followedPosts = new FollowedPostsDTO(userId, listOfPosts);
        return followedPosts;
    }

    @Override
    public PromoPostsCountDTO getPromoPostsCount(int userId, Optional<String> order) {
        User user = this.userRepository.find(userId).orElseThrow(() ->
                new UserNotFoundException(userId));

        List<Post> listOfPromoPosts = user.getPosts().values()
                .stream()
                .filter(post -> post.isHasPromo())
                .collect(Collectors.toList());

        PromoPostsCountDTO promoPostsCountDTO = new PromoPostsCountDTO(userId, user.getName(), listOfPromoPosts.size());
        return promoPostsCountDTO;
    }

    @Override
    public PromoPostsDTO getPromoPosts(int userId, Optional<String> order) {
        User user = this.userRepository.find(userId).orElseThrow(() ->
                new UserNotFoundException(userId));

        List<PostDTO> listOfPromoPosts = user.getPosts().values()
                .stream()
                .filter(post -> post.isHasPromo())
                .map(post -> postMapper.postToPostDTO(post))
                .collect(Collectors.toList());


        if (order.isPresent()) {
            if (order.get().equals("name_asc")) {
                listOfPromoPosts
                        .sort(Comparator.comparing(post -> post.getDetail().getProductName()));
            }
            else if (order.get().equals("name_desc")) {
                listOfPromoPosts
                        .sort(Comparator.comparing(post -> post.getDetail().getProductName()));
                Collections.reverse(listOfPromoPosts);
            }
            //tirar excepción si el orden es otro?
        }

        PromoPostsDTO promoPostsDTO = new PromoPostsDTO(userId, user.getName(), listOfPromoPosts);
        return promoPostsDTO;
    }
}
