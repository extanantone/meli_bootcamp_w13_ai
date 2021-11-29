package com.bootcamp.SocialMeli.util;

import com.bootcamp.SocialMeli.dto.ResponseDTO;
import com.bootcamp.SocialMeli.model.*;

import java.time.LocalDate;

public class TestUtilsGenerator {
    public static ResponseDTO getResponseDTO(String code, String message) {
        return new ResponseDTO(code, message);
    }

    public static void follow(User userFollower, User userFollowed) {
        userFollower.getFollowed().add(userFollowed);
        userFollowed.getFollowers().add(userFollower);
    }

    public static void addFollowers(User user) {
        user.getFollowers().add(new User(3, "Lucas"));
        user.getFollowers().add(new User(4, "Brenda"));
        user.getFollowers().add(new User(5, "Sofía"));
        user.getFollowers().add(new User(6, "Camilo"));
        user.getFollowers().add(new User(7, "Jorge"));
        user.getFollowers().add(new User(8, "Matilda"));
    }

    public static void addFollowed(User user) {
        user.getFollowed().add(new User(3, "Lucas"));
        user.getFollowed().add(new User(4, "Brenda"));
        user.getFollowed().add(new User(5, "Sofía"));
        user.getFollowed().add(new User(6, "Camilo"));
        user.getFollowed().add(new User(7, "Jorge"));
        user.getFollowed().add(new User(8, "Matilda"));
    }

    public static void addFollowedWithPosts(User user) {
        addFollowed(user);

        Product product = new Product(
                1,
                "Silla Gamer",
                "Gamer",
                "Racer",
                "Red",
                "Special Edition",
                100,
                1500.50);

        user.getFollowed().get(0).getPosts().add(
                new Post(3, 1, LocalDate.of(2021, 11, 1), product));
        user.getFollowed().get(0).getPosts().add(
                new Post(3, 2, LocalDate.of(2021, 11, 18), product));
        user.getFollowed().get(1).getPosts().add(
                new Post(4, 1, LocalDate.of(2021, 11, 13), product));
        user.getFollowed().get(1).getPosts().add(
                new Post(4, 2, LocalDate.of(2021, 11, 25), product));
        user.getFollowed().get(2).getPosts().add(
                new Post(5, 1, LocalDate.of(2021, 11, 15), product));
        user.getFollowed().get(2).getPosts().add(
                new Post(5, 2, LocalDate.of(2021, 11, 11), product));
        user.getFollowed().get(3).getPosts().add(
                new Post(6, 1, LocalDate.of(2021, 11, 16), product));
        user.getFollowed().get(3).getPosts().add(
                new Post(6, 2, LocalDate.of(2021, 11, 19), product));
        user.getFollowed().get(4).getPosts().add(
                new Post(7, 1, LocalDate.of(2021, 11, 23), product));
        user.getFollowed().get(4).getPosts().add(
                new Post(7, 2, LocalDate.of(2021, 11, 20), product));
        user.getFollowed().get(5).getPosts().add(
                new Post(8, 1, LocalDate.of(2021, 11, 9), product));
        user.getFollowed().get(5).getPosts().add(
                new Post(8, 2, LocalDate.of(2021, 11, 20), product));
    }
}