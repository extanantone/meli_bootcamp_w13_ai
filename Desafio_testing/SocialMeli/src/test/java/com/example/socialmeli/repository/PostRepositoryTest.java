package com.example.socialmeli.repository;

import com.example.socialmeli.exception.PostIdNotFoundException;
import com.example.socialmeli.model.Post;
import com.example.socialmeli.model.PostDetail;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class PostRepositoryTest {
    IPostRepository postRepository = new PostRepository();

    @Test
    void shouldAddPost() {
        System.out.println("Creating post for user with ID 1, post ID 1, product ID 1");
        Post post = new Post(
                1,
                1,
                LocalDate.of(2021, 10, 29),
                new PostDetail(
                        1,
                        "pizza",
                        "rica",
                        "buena",
                        "color barata",
                        "nah, ta rica"),
                1,
                9.99D
                );
        System.out.println("Should add the post successfully, hence returning true...\n");
        assertTrue(postRepository.addPost(1, post));
    }


    @Test
    void shouldNotAddPost() {
        System.out.println("Creating post for user with ID 1, post ID 2, product ID 2");
        Post post = new Post(
                2,
                1,
                LocalDate.of(2021, 10, 29),
                new PostDetail(
                        2,
                        "pizza",
                        "rica",
                        "buena",
                        "color barata",
                        "nah, ta rica"),
                1,
                9.99D
        );
        assertTrue(postRepository.addPost(2, post));
        System.out.println("Should fail to add the post successfully, hence returning false...\n");
        assertFalse(postRepository.addPost(2, post));
    }

    @Test
    void shouldThrowPostIdNotFoundException() {
        System.out.println("Should throw PostIdNotFoundException...\n");
        assertThrows(PostIdNotFoundException.class, () -> postRepository.find(99));
    }

    @Test
    void shouldFindPostById() {
        System.out.println("Creating post for user with ID 1, post ID 3, product ID 3");
        Post post = new Post(
                3,
                1,
                LocalDate.of(2021, 10, 29),
                new PostDetail(
                        3,
                        "pizza",
                        "rica",
                        "buena",
                        "color barata",
                        "nah, ta rica"),
                1,
                9.99D
        );
        assertTrue(postRepository.addPost(2, post));
        System.out.println("Should fail to add the post successfully, hence returning false...\n");
        assertFalse(postRepository.addPost(2, post));
    }

}
