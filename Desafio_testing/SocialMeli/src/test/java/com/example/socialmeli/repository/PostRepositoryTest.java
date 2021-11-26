package com.example.socialmeli.repository;

import com.example.socialmeli.exception.PostIdNotFoundException;
import com.example.socialmeli.model.Post;
import com.example.socialmeli.model.PostDetail;
import com.example.socialmeli.model.PromoPost;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class PostRepositoryTest {
    static IPostRepository postRepository = new PostRepository();

    @BeforeAll
    static void settingUpDummyPosts() {
        System.out.println("Setting up dummy posts, both promo and not promo...\n");
        Post post = new Post(
                7,
                1,
                LocalDate.of(2021, 10, 29),
                new PostDetail(
                        7,
                        "pizza",
                        "rica",
                        "buena",
                        "color barata",
                        "nah, ta rica"),
                1,
                9.99D
        );
        PromoPost promoPost = new PromoPost(
                8,
                1,
                LocalDate.of(2021, 10, 29),
                new PostDetail(
                        8,
                        "pizza",
                        "rica",
                        "buena",
                        "color barata",
                        "nah, ta rica"),
                1,
                9.99D,
                true,
                0.0009D
        );
        postRepository.addPromoPost(8, promoPost);
        postRepository.addPost(7, post);
    }

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
        System.out.println("Should fail to add the post successfully, hence returning false...");
        assertFalse(postRepository.addPost(2, post));
        System.out.println("Should not be added due to promo post with same ID in promo post list...\n");
        assertFalse(postRepository.addPost(8, post));
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
        assertTrue(postRepository.addPost(3, post));
        System.out.println("Should find the correct post...\n");
        Post foundPost = postRepository.find(3);
        assertEquals((int) foundPost.getIdPost(), 3);
        assertEquals((int) foundPost.getUserId(), 1);
        assertEquals((int) foundPost.getDetails().getProductId(), 3);
    }

    @Test
    void shouldGetAllPosts() {
        System.out.println("Creating one post to ensure that atleast one exists at the time of execution of this test...");
        System.out.println("user ID 1, post ID 4, product ID 4...");
        Post post = new Post(
                4,
                1,
                LocalDate.of(2021, 10, 29),
                new PostDetail(
                        4,
                        "pizza",
                        "rica",
                        "buena",
                        "color barata",
                        "nah, ta rica"),
                1,
                9.99D
        );
        assertTrue(postRepository.addPost(4, post));
        System.out.println("Should retrieve all posts, created so far...\n");
        assertTrue(postRepository.getPosts().size() > 0);
    }

    @Test
    void shouldAddPromoPost() {
        System.out.println("Creating promo post for user with ID 1, post ID 5, product ID 5...");
        PromoPost promoPost = new PromoPost(
                5,
                1,
                LocalDate.of(2021, 10, 29),
                new PostDetail(
                        5,
                        "pizza",
                        "rica",
                        "buena",
                        "color barata",
                        "nah, ta rica"),
                1,
                9.99D,
                true,
                0.0009D
                );
        System.out.println("Should add the post successfully, hence returning true...\n");
        assertTrue(postRepository.addPromoPost(5, promoPost));
    }

    @Test
    void shouldNotAddPromoPost() {
        System.out.println("Creating promo post for user with ID 1, post ID 6, product ID 6...");
        PromoPost promoPost = new PromoPost(
                6,
                1,
                LocalDate.of(2021, 10, 29),
                new PostDetail(
                        6,
                        "pizza",
                        "rica",
                        "buena",
                        "color barata",
                        "nah, ta rica"),
                1,
                9.99D,
                true,
                0.0009D
        );
        postRepository.addPromoPost(6, promoPost);
        System.out.println("Should not add the post successfully, hence returning false...");
        assertFalse(postRepository.addPromoPost(6, promoPost));
        System.out.println("Should not be added due to post with same ID in post list...\n");
        assertFalse(postRepository.addPromoPost(7, promoPost));
    }

    @Test
    void shouldGetAllPromoPosts() {
        System.out.println("Should get all the promo posts, at least 1...\n");
        assertTrue(postRepository.getPromoPosts().size() > 0);
    }

}
