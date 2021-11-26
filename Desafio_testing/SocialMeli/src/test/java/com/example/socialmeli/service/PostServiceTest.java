package com.example.socialmeli.service;

import com.example.socialmeli.dto.*;
import com.example.socialmeli.model.Post;
import com.example.socialmeli.model.PostDetail;
import com.example.socialmeli.model.PromoPost;
import com.example.socialmeli.model.User;
import com.example.socialmeli.repository.IPostRepository;
import com.example.socialmeli.repository.IUserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PostServiceTest {

    @Mock
    private IPostRepository mockPostRepository;

    @Mock
    private IUserRepository mockUserRepository;

    @InjectMocks
    PostService postService;

    @Test
    void shouldAddPost() {
        Integer userId = 1;
        Integer postId = 1;
        PostDTO postDTO = new PostDTO(
                1,
                1,
                "16-11-2021",
                new ProductDetailDTO(1,
                        "pizza",
                        "rica",
                        "buena",
                        "riquis",
                        "nanainanas"),
                1,
                0.009D
        );
        User user = new User(1, "dos");

        when(mockPostRepository.addPost(eq(userId), Mockito.any(Post.class))).thenReturn(true);
        when(mockUserRepository.find(userId)).thenReturn(user);

        postService.addPost(userId, postId, postDTO);

        verify(mockUserRepository, atLeastOnce()).find(userId);
    }

    @Test
    void shouldAddPromoPost() {
        Integer userId = 1;
        Integer postId = 1;
        PromoPostDTO postDTO = new PromoPostDTO(
                1,
                1,
                "16-11-2021",
                new ProductDetailDTO(1,
                        "pizza",
                        "rica",
                        "buena",
                        "riquis",
                        "nanainanas"),
                1,
                0.009D,
                true,
                0.000001D
        );
        User user = new User(1, "dos");

        when(mockPostRepository.addPromoPost(eq(userId), Mockito.any(PromoPost.class))).thenReturn(true);
        when(mockUserRepository.find(userId)).thenReturn(user);

        postService.addPromoPost(userId, postId, postDTO);

        verify(mockUserRepository, atLeastOnce()).find(userId);
    }

    @Test
    void shouldReturnDefaultOrder() {
        User user = new User(1, "dos");
        user.addPost(1);
        user.addPost(2);
        Post post = new Post(
                1,
                1,
                LocalDate.of(2021, 11, 29),
                new PostDetail(
                        1,
                        "nice",
                        "ninice",
                        "hikini-to",
                        "si",
                        "no"
                ),
                1,
                0.99D
        );
        Post post2 = new Post(
                2,
                1,
                LocalDate.of(2021, 11, 28),
                new PostDetail(
                        2,
                        "nice",
                        "ninice",
                        "hikini-to",
                        "si",
                        "no"
                ),
                1,
                0.99D
        );
        when(mockUserRepository.find(1)).thenReturn(user);
        when(mockPostRepository.find(1)).thenReturn(post);
        when(mockPostRepository.find(2)).thenReturn(post2);

        UserPostDTO userPostDTO = postService.getPosts(1, "");

        assertEquals(1, userPostDTO.getPosts().get(0).getIdPost());
        assertEquals(2, userPostDTO.getPosts().get(1).getIdPost());
    }

    @Test
    void shouldReturnAscOrder() {
        User user = new User(1, "dos");
        user.addPost(1);
        user.addPost(2);
        Post post = new Post(
                1,
                1,
                LocalDate.of(2021, 11, 29),
                new PostDetail(
                        1,
                        "nice",
                        "ninice",
                        "hikini-to",
                        "si",
                        "no"
                ),
                1,
                0.99D
        );
        Post post2 = new Post(
                2,
                1,
                LocalDate.of(2021, 11, 28),
                new PostDetail(
                        2,
                        "nice",
                        "ninice",
                        "hikini-to",
                        "si",
                        "no"
                ),
                1,
                0.99D
        );
        when(mockUserRepository.find(1)).thenReturn(user);
        when(mockPostRepository.find(1)).thenReturn(post);
        when(mockPostRepository.find(2)).thenReturn(post2);

        UserPostDTO userPostDTO = postService.getPosts(1, "date_asc");

        assertEquals(2, userPostDTO.getPosts().get(0).getIdPost());
        assertEquals(1, userPostDTO.getPosts().get(1).getIdPost());
    }

    @Test
    void shouldGetAmountOfDiscountedPosts() {
        User user = new User(1, "dos");
        user.addPromoPost(1);
        user.addPromoPost(2);

        when(mockUserRepository.find(1)).thenReturn(user);

        PromoCountDTO promoCountDTO = postService.getPromoCount(1);

        assertEquals(2, promoCountDTO.getPromoProductsCount());
    }

    @Test
    void shouldOnlyReturnRecentPosts() {
        User user = new User(1, "dos");
        user.addPost(1);
        user.addPost(2);
        Post post = new Post(
                1,
                1,
                LocalDate.now(),
                new PostDetail(
                        1,
                        "nice",
                        "ninice",
                        "hikini-to",
                        "si",
                        "no"
                ),
                1,
                0.99D
        );
        Post post2 = new Post(
                2,
                1,
                LocalDate.of(2021, 10, 28),
                new PostDetail(
                        2,
                        "nice",
                        "ninice",
                        "hikini-to",
                        "si",
                        "no"
                ),
                1,
                0.99D
        );
        when(mockUserRepository.find(1)).thenReturn(user);
        when(mockPostRepository.find(1)).thenReturn(post);
        when(mockPostRepository.find(2)).thenReturn(post2);

        UserPostDTO userPostDTO = postService.getPosts(1, "");

        assertEquals(1, userPostDTO.getPosts().size());
    }
}
