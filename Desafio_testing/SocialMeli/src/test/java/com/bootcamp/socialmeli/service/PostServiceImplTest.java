package com.bootcamp.socialmeli.service;

import com.bootcamp.socialmeli.dto.CreatePostDTO;
import com.bootcamp.socialmeli.dto.ListedPostDTO;
import com.bootcamp.socialmeli.dto.Ordenable;
import com.bootcamp.socialmeli.dto.ProductDTO;
import com.bootcamp.socialmeli.entity.Post;
import com.bootcamp.socialmeli.entity.Product;
import com.bootcamp.socialmeli.entity.User;
import com.bootcamp.socialmeli.exception.MissingBodyAttributeException;
import com.bootcamp.socialmeli.mapper.PostMapper;
import com.bootcamp.socialmeli.mapper.UserMapper;
import com.bootcamp.socialmeli.repository.PostRepositoryImpl;
import com.bootcamp.socialmeli.repository.UserRepositoryImpl;
import com.bootcamp.socialmeli.util.OrderUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class PostServiceImplTest {

    @Mock
    private UserRepositoryImpl userRepository;

    @Mock
    private OrderUtils orderUtils;

    @Spy
    private PostMapper postMapper;

    @Mock
    private PostRepositoryImpl postRepository;

    @InjectMocks
    private PostServiceImpl postService;

    @Test
    void correctlyFilteredPosts(){
        User user1 = new User(1L, "Juan", new ArrayList<>(), new ArrayList<>());
        User user2 = new User(2L, "Camilo", new ArrayList<>(), new ArrayList<>());
        User user3 = new User(3L, "Lozano", new ArrayList<>(), new ArrayList<>());
        User user4 = new User(4L, "Mejia", new ArrayList<>(), new ArrayList<>(List.of(user1,user2,user3)));
        Post post1 = new Post(1L, LocalDate.of(2021,11,25),new Product(),null,null,null,null);
        Post post2 = new Post(2L, LocalDate.of(2021,2,28),new Product(),null,null,null,null);
        Post post3 = new Post(3L, LocalDate.of(2021,8,30),new Product(),null,null,null,null);
        Post post4 = new Post(4L, LocalDate.of(2021,11,1),new Product(),null,null,null,null);
        Post post5 = new Post(5L, LocalDate.of(2021,2,15),new Product(),null,null,null,null);
        Post post6 = new Post(6L, LocalDate.of(2021,11,15),new Product(),null,null,null,null);
        List<Post> list1 = List.of(post1,post2,post3);
        List<Post> list2 = List.of(post4,post5,post6);
        List<Post> list3 = List.of();
        ListedPostDTO listedPost1 = new ListedPostDTO(1L, LocalDate.of(2021,11,25),new ProductDTO(),null,null,null,null);
        ListedPostDTO listedPost2 = new ListedPostDTO(2L, LocalDate.of(2021,2,28),new ProductDTO(),null,null,null,null);
        ListedPostDTO listedPost3 = new ListedPostDTO(3L, LocalDate.of(2021,8,30),new ProductDTO(),null,null,null,null);
        ListedPostDTO listedPost4 = new ListedPostDTO(4L, LocalDate.of(2021,11,1),new ProductDTO(),null,null,null,null);
        ListedPostDTO listedPost5 = new ListedPostDTO(5L, LocalDate.of(2021,2,15),new ProductDTO(),null,null,null,null);
        ListedPostDTO listedPost6 = new ListedPostDTO(6L, LocalDate.of(2021,11,15),new ProductDTO(),null,null,null,null);
        List<ListedPostDTO> listOfListedPost1 = List.of(listedPost1,listedPost2,listedPost3);
        List<ListedPostDTO> listOfListedPost2 = List.of(listedPost4,listedPost5,listedPost6);
        List<ListedPostDTO> expectedList = List.of(listedPost1, listedPost6);
        Mockito.when(userRepository.getUser(Mockito.anyLong())).thenReturn(user4);
        Mockito.when(postRepository.getUserPosts(1L)).thenReturn(list1);
        Mockito.when(postRepository.getUserPosts(2L)).thenReturn(list2);
        Mockito.when(postRepository.getUserPosts(3L)).thenReturn(List.of());
        //Mockito.when(postMapper.postListToDTO(list1)).thenReturn(listOfListedPost1);
        //Mockito.when(postMapper.postListToDTO(list2)).thenReturn(listOfListedPost2);
        //Mockito.when(postMapper.postListToDTO(list3)).thenReturn(List.of());
        Mockito.when(orderUtils.order(Mockito.any(Ordenable.class), Mockito.anyString())).then(AdditionalAnswers.returnsFirstArg());
        Ordenable actual = postService.listFollowedPosts(4L, "date_asc");
        Set<ListedPostDTO> expected = Set.copyOf(expectedList);
        Assertions.assertTrue(expected.containsAll(actual.getPosts()));
    }

    @Test
    void createPostSuccessTest(){
        ProductDTO product1 = new ProductDTO(1L,"Silla", "Gamer", "Gamer boi", "victoria", "Es gamer");
        CreatePostDTO post1 = new CreatePostDTO(1L, LocalDate.of(2021,11,25),product1,1,1000000.,false,0.);
        User user = new User(1L, "Juan", new ArrayList<>(), new ArrayList<>());
        Mockito.when(userRepository.getUser(Mockito.anyLong())).thenReturn(user);
        Mockito.when(postRepository.savePost(Mockito.any(Post.class), Mockito.anyLong())).thenReturn(1L);
        Long newId = postService.createPost(post1);
        Assertions.assertNotNull(newId);
    }

    @Test
    void createPostMissingBodyAttributeTest(){
        ProductDTO product1 = new ProductDTO(1L,"Silla", "Gamer", "Gamer boi", "victoria", "Es gamer");
        CreatePostDTO post1 = new CreatePostDTO(1L, LocalDate.of(2021,11,25),null,1,1000000.,false,0.);
        User user = new User(1L, "Juan", new ArrayList<>(), new ArrayList<>());
        Mockito.when(userRepository.getUser(Mockito.anyLong())).thenReturn(user);
        Assertions.assertThrows(MissingBodyAttributeException.class, () -> postService.createPost(post1));
    }

}
