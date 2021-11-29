package com.lgoyenechea.socialmeli.service;

import com.lgoyenechea.socialmeli.dto.*;
import com.lgoyenechea.socialmeli.exception.UserNotFoundException;
import com.lgoyenechea.socialmeli.model.Post;
import com.lgoyenechea.socialmeli.model.Product;
import com.lgoyenechea.socialmeli.repository.ProductRepository;
import com.lgoyenechea.socialmeli.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    ProductRepository mockProductRepository;

    @Mock
    UserRepository mockUserRepository;

    @Mock
    UserService mockUserService;

    @InjectMocks
    ProductService productService;

    List<Post> posts;

    Post post1;
    Post post2;
    Post post3;

    @BeforeEach
    void setUp() {
        initPosts();
    }

    @Test
    void givenCorrectUserId_whenFollowedPostsList_postBetweenTwoWeeksAgo() {
        UserFollowedListDTO followedListDto = new UserFollowedListDTO();
        UserDTO userDto = new UserDTO();
        userDto.setUserId(2L);
        followedListDto.getFollowed().add(userDto);

        when(mockUserService.followedList(1L, "name_asc")).thenReturn(followedListDto);
        when(mockProductRepository.getByUserId(2L)).thenReturn(posts);

        UserFollowedPostsListDTO userFollowedPostsListDto =
                productService.followedPostsList(1L, "date_asc");

        assertEquals(userFollowedPostsListDto.getPosts().size(), 1);
    }

    @Test
    void givenCorrectPostWithPromo_whenSaveWithPromo_thenSaved() {
        PostCreationPromoDTO dto = new PostCreationPromoDTO();
        dto.setUserId(1L);
        dto.setDetail(new ProductCreationDTO());
        dto.setDate("26-11-2021");
        post1.setId(1L);

        when(mockProductRepository.getById(1L)).thenReturn(post1);
        when(mockUserRepository.existsById(1L)).thenReturn(true);
        when(mockProductRepository.save(any())).thenReturn(post1);

        PostPromoDTO postPromoDto = productService.saveWithPromo(dto);

        assertEquals(postPromoDto.getIdPost(), mockProductRepository.getById(1L).getId());
    }

    @Test
    void givenIncorrectUserId_whenSaveWithPromo_throwsUserNotFoundException() {
        PostCreationPromoDTO dto = new PostCreationPromoDTO();
        dto.setUserId(1L);
        when(mockUserRepository.existsById(1L)).thenReturn(false);
        assertThrows(UserNotFoundException.class, () -> productService.saveWithPromo(dto));
        verify(mockUserRepository, times(1)).existsById(1L);
    }

    private void initPosts() {
        post1 = new Post();
        post1.setDate(LocalDate.now());
        post1.setDetail(new Product());

        post2 = new Post();
        post2.setDate(LocalDate.of(2021, 11, 13));
        post2.setDetail(new Product());

        post3 = new Post();
        post3.setDate(LocalDate.of(2021, 10, 12));
        post3.setDetail(new Product());

        posts = List.of(post1, post2, post3);
    }
}