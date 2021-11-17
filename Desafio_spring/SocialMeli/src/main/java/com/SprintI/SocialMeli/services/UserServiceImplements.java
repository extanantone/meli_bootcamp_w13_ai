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
        if(userIdToFollow != userId) {
            User userToFollow = userRepository.findById(userIdToFollow);
            userToFollow.follow(userNow);
        }
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
        System.out.println(order);
        if(order.equals("name_desc")){
            List<User> sorted = user.getFollowers().stream().sorted(Comparator.comparing(User::getName).reversed()).collect(Collectors.toList());
            user.setFollowers(sorted);
            return new UserFollowersDTO(user);
        }
        List<User> sorted = user.getFollowers().stream().sorted(Comparator.comparing(User::getName)).collect(Collectors.toList());
        user.setFollowers(sorted);
        return new UserFollowersDTO(user);
    }

    @Override
    public UserFollowedDTO followed(int id, String order) {
        User user = userRepository.findById(id);
//        List<UserDTO> users = userRepository.getUsers().stream().filter(u -> u.isFollower(user)).map(UserDTO::new).collect(Collectors.toList());

        if(order.equals("name_desc")){
            List<User> sorted = user.getFollowers().stream().sorted(Comparator.comparing(User::getName).reversed()).collect(Collectors.toList());
            user.setFollowers(sorted);
            return new UserFollowedDTO(user.getId(), user.getName(), sorted.stream().map(UserDTO::new).collect(Collectors.toList()));
        }
        List<User> sorted = user.getFollowers().stream().sorted(Comparator.comparing(User::getName)).collect(Collectors.toList());
        user.setFollowers(sorted);
        return new UserFollowedDTO(user);
    }

    @Override
    public void addNewPost(PostWithoutDiscountDTO postWithoutDiscountDTO) {
        User user = userRepository.findById(postWithoutDiscountDTO.getUserId());
        Post post = new Post(postWithoutDiscountDTO.getIdPost(), postWithoutDiscountDTO.getUserId(),
                LocalDate.parse(postWithoutDiscountDTO.getDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                postWithoutDiscountDTO.getDetail(), postWithoutDiscountDTO.getCategory(), postWithoutDiscountDTO.getPrice());
        user.addPost(post);
    }

    @Override
    public UserPostDTO listPostTwoWeeksEarly(int id, String order) {
        User user = userRepository.findById(id);

        LocalDate now = LocalDate.now();
        LocalDate last14 = now.minusDays(14);

        Comparator<Post> postOrder = Comparator.comparing(Post::getDate);

        if(order.equals("date_desc")){
            postOrder = postOrder.reversed();
        }

        List<PostWithoutDiscountDTO> users = userRepository.getUsers()
                .stream().filter(u -> u.isFollower(user)).flatMap(us -> us.getPost().stream())
                .filter(d -> d.getDate().isAfter(last14) && d.getDate().isBefore(now)).sorted(postOrder)
                .map(PostWithoutDiscountDTO::new).collect(Collectors.toList());

        return new UserPostDTO(user.getId(), users);
    }


}
