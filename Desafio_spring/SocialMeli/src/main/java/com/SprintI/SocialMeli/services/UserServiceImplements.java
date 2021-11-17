package com.SprintI.SocialMeli.services;

import com.SprintI.SocialMeli.dtos.*;
import com.SprintI.SocialMeli.models.Post;
import com.SprintI.SocialMeli.models.User;
import com.SprintI.SocialMeli.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImplements implements UserService{
    @Autowired
    UserRepository userRepository;


    @Override
    public void followUser(int userId, int userIdToFollow) {
        User userNow = userRepository.findById(userId);
        User userToFollow = userRepository.findById(userIdToFollow);
        userToFollow.follow(userNow);

    }

    @Override
    public void unfollowUser(int userId, int userIdToUnfollow) {
        User userNow = userRepository.findById(userId);
        User userToUnfollow = userRepository.findById(userIdToUnfollow);
        userToUnfollow.unfollow(userNow);
    }

    @Override
    public List<UserDTO> getUsers() {
        return userRepository.getUsers().stream().map(UserDTO::new).collect(Collectors.toList());
    }

    @Override
    public UserCountDTO quantityOfFollowers(int id) {
        User user = userRepository.findById(id);
        return new UserCountDTO(user.getId(), user.getName(), user.getFollowers().size());
    }

    @Override
    public UserFollowersDTO followers(int id, String order) {
        User user = userRepository.findById(id);
        if(order == "name_asc") {
            List<User> sorted = user.getFollowers().stream().sorted(Comparator.comparing(User::getName)).collect(Collectors.toList());
            user.setFollowers(sorted);
            return new UserFollowersDTO(user);
        }
        else if(order == "name_desc"){
            List<User> sorted = user.getFollowers().stream().sorted(Comparator.comparing(User::getName).reversed()).collect(Collectors.toList());
            user.setFollowers(sorted);
            return new UserFollowersDTO(user);
        } else {
            return new UserFollowersDTO(user);

        }

    }

    @Override
    public UserFollowedDTO followed(int id, String order) {
        User user = userRepository.findById(id);
        List<UserDTO> users = new ArrayList<>();
        userRepository.getUsers().forEach(u -> {
            if (u.isFollower(user)) {
                users.add(new UserDTO(u));
            }
        });
        return new UserFollowedDTO(user.getId(), user.getName(), users);
    }

    @Override
    public void addNewPost(PostWithoutDiscountDTO postWithoutDiscountDTO) {
        User user = userRepository.findById(postWithoutDiscountDTO.getUserId());
        Post post = new Post(postWithoutDiscountDTO.getIdPost(), postWithoutDiscountDTO.getUserId(),
                LocalDate.parse(postWithoutDiscountDTO.getDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                postWithoutDiscountDTO.getDetail(), postWithoutDiscountDTO.getCategory(), postWithoutDiscountDTO.getPrice());
        user.addPost(post);
    }

    /*@Override
    public UserPostDTO listPostTwoWeeksEarly(int id) {
        User user = userRepository.findById(id);
        List<PostWithoutDiscountDTO> posts = userRepository.getPostFollowed(id).stream().map(PostWithoutDiscountDTO::new).collect(Collectors.toList());
        return new UserPostDTO(user.getId(), posts);
    }*/


}
