package com.example.SocialMeli.repository;

import com.example.SocialMeli.entities.Detail;
import com.example.SocialMeli.entities.Post;
import com.example.SocialMeli.entities.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


class UserRepositoryTest {

    UserRepository userRepository;

    @BeforeEach
    void setUp() {
        this.userRepository = new UserRepositoryImpl();
    }

    @Test
    void testGetById() {
        User u = userRepository.getById(1);
        assertAll(
                () -> assertEquals(1L, u.getUser_id()),
                () -> assertEquals("ftagliero", u.getUser_name())

        );
    }

    @Test
    void testGetFollowers() {
        userRepository.saveFollow(4, 3);
        User currentUser = this.userRepository.getById(4);
        assertAll(
                () -> assertEquals(1, userRepository.getFollowers(3).size()),
                () -> assertEquals(currentUser, userRepository.getFollowers(3).get(0))
        );
    }

    @Test
    void testGetFolloweds() {
        userRepository.saveFollow(4,3);
        User expected = this.userRepository.getById(3);
        assertAll(
                () -> assertEquals(1, userRepository.getFolloweds(4).size()),
                () -> assertEquals(expected, userRepository.getFolloweds(4).get(0))
        );
    }

    @Test
    void testUnfollow() {
        userRepository.saveFollow(4,3);
        userRepository.unfollow(4,3);
        assertAll(
                () -> assertEquals(0, userRepository.getFollowers(3).size()),
                () -> assertEquals(0, userRepository.getFolloweds(4).size())
        );
    }

    @Test
    void savePost() {
        Post post = new Post(1L, 1, LocalDate.of(2021,11,27), new Detail(), 1,12.99);

        userRepository.savePost(1,1);
        User current = userRepository.getById(1);
        assertAll(
                () -> assertEquals(1, current.getProducts().size()),
                () -> assertEquals(1, current.getProducts().get(0))
        );
    }

}