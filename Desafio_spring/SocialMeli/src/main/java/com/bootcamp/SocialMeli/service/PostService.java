package com.bootcamp.SocialMeli.service;

import com.bootcamp.SocialMeli.dto.FollowedPostsDTO;
import com.bootcamp.SocialMeli.dto.FollowersListDTO;
import com.bootcamp.SocialMeli.dto.PostDTO;
import com.bootcamp.SocialMeli.model.Post;
import com.bootcamp.SocialMeli.model.User;
import com.bootcamp.SocialMeli.repository.IPostRepository;
import com.bootcamp.SocialMeli.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
public class PostService implements IPostService{
    @Autowired IPostRepository postRepository;
    @Autowired IUserRepository userRepository;

    @Override
    public void addPost(Post post) {
        postRepository.add(post);
        int userId = post.getUserId();

        User user = userRepository.find(userId).orElseThrow();
        //tirar excepción si el usuario no existe
        //tirar excepción si el usuario no puede vender
        user.addPost(post);
    }

    @Override
    public FollowedPostsDTO getFollowedPosts(int userId, Optional<String> order) {
        User user = this.userRepository.find(userId).orElseThrow();
        //tirar not found exception
        List<User> listOfFollowed = new ArrayList<>(user.getFollowed().values());
        FollowedPostsDTO followedPosts = new FollowedPostsDTO(userId);

        LocalDate today = LocalDate.now();

        List<PostDTO> listOfPosts = new ArrayList<>();

        for (User followed : listOfFollowed) {
            for (Post post : followed.getPosts().values()) {
                LocalDate postDate = post.getDate();
                long dateDifference = DAYS.between(postDate, today);
                if (dateDifference > 14) {
                    continue;
                }
                listOfPosts.add(new PostDTO(post));
            }
        }
        if (order.isEmpty()) {
            followedPosts.setPosts(listOfPosts);
            return followedPosts;
        }
        if (order.get().equals("date_asc")) {
            listOfPosts.sort(Comparator.comparing(PostDTO::getDate));
        }
        else if (order.get().equals("date_desc")) {
            listOfPosts.sort(Comparator.comparing(PostDTO::getDate).reversed());
        }
        //tirar excepción si el orden es otro?

        followedPosts.setPosts(listOfPosts);
        return followedPosts;
    }
}
