package com.SocialMeli.SocialMeli.unit.service;

import com.SocialMeli.SocialMeli.dto.MessageDTOResponse;
import com.SocialMeli.SocialMeli.dto.PostDTORequest;
import com.SocialMeli.SocialMeli.dto.PostsByUserDTOResponse;
import com.SocialMeli.SocialMeli.dto.ProductDTO;
import com.SocialMeli.SocialMeli.entity.Buyer;
import com.SocialMeli.SocialMeli.entity.Post;
import com.SocialMeli.SocialMeli.entity.Product;
import com.SocialMeli.SocialMeli.entity.Seller;
import com.SocialMeli.SocialMeli.exception.AlreadyExistsException;
import com.SocialMeli.SocialMeli.exception.BadRequestException;
import com.SocialMeli.SocialMeli.exception.NotFoundException;
import com.SocialMeli.SocialMeli.repository.IPostRepository;
import com.SocialMeli.SocialMeli.repository.IUserRepository;
import com.SocialMeli.SocialMeli.repository.PostRepository;
import com.SocialMeli.SocialMeli.repository.UserRepository;
import com.SocialMeli.SocialMeli.service.PostService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PostServiceTest {
    @Mock
    static IPostRepository postRepository;

    @Mock
    static IUserRepository userRepository;

    @InjectMocks
    PostService postService;

    private static Post postCreate = new Post();

    private static Post postCreate2 = new Post();

    private static Buyer buyer1 = new Buyer(1, "Buyer1", new HashMap<>());
    private static Buyer buyer2 = new Buyer(2, "Buyer2", new HashMap<>());
    private static Seller seller1 = new Seller(3, "Seller1", new HashMap<>(), new HashMap<>());
    private static Seller seller2 = new Seller(4, "Seller2", new HashMap<>(), new HashMap<>());

    @BeforeEach
    void setUp(){
        buyer1.getFollowed().put(3, seller1);

        postCreate.setId(1);
        postCreate.setDate(LocalDate.now());
        postCreate.setSellerId(3);
        postCreate.setPrice(1000);
        postCreate.setCategory(1);
        Product product = new Product();
        product.setId(1);
        product.setName("Producto 1");
        product.setBrand("Brand 1");
        product.setColor("Negro");
        product.setType("Tipo");
        product.setNotes("");
        postCreate.setDetail(product);

        postRepository.create(postCreate);

        LocalDate yesterday = LocalDate.now().minus(Period.ofDays(1));

        postCreate2.setId(2);
        postCreate2.setDate(yesterday);
        postCreate2.setSellerId(3);
        postCreate2.setPrice(1000);
        postCreate2.setCategory(1);
        Product product2 = new Product();
        product2.setId(2);
        product2.setName("Producto 2");
        product2.setBrand("Brand 2");
        product2.setColor("Negro");
        product2.setType("Tipo");
        product2.setNotes("");
        postCreate2.setDetail(product2);
    }

    @Test
    void getPostByIdSuccess(){
        //Arrange
        int id = 1;
        when(postRepository.getById(id)).thenReturn(postCreate);

        //Act
        PostDTORequest postDTORequest = postService.getById(id);

        //Assert
        Assertions.assertEquals(postDTORequest.getId_post(), postCreate.getId());
    }

    @Test
    void getPostByIdNotFoundException(){
        //Arrange
        int id = 2;

        //Act & Assert
        Assertions.assertThrows(
                NotFoundException.class, ()->postService.getById(id)
        );
    }

    @Test
    void createSuccess(){
        //Arrange
        PostDTORequest postDTORequest = new PostDTORequest();
        postDTORequest.setId_post(2);
        postDTORequest.setUser_id(3);
        postDTORequest.setDate(LocalDate.now());
        postDTORequest.setCategory(1);
        postDTORequest.setPrice(1000.0);
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProduct_id(2);
        productDTO.setProduct_name("Producto 2");
        productDTO.setColor("Blanco");
        productDTO.setBrand("Marca 2");
        productDTO.setType("Tipo");
        productDTO.setNotes("");
        postDTORequest.setDetail(productDTO);

        //when(postRepository.create(postToCreate)).thenReturn(true);
        when(userRepository.getUser(3)).thenReturn(new Seller());

        //Act
        MessageDTOResponse messageDTOResponse = postService.create(postDTORequest);

        //Assert
        Assertions.assertNotNull(messageDTOResponse);
    }

    @Test
    void createPostThenSellerNotFoundException(){
        //Arrange
        PostDTORequest postDTORequest = new PostDTORequest();
        postDTORequest.setId_post(2);
        postDTORequest.setUser_id(3);
        postDTORequest.setDate(LocalDate.now());
        postDTORequest.setCategory(1);
        postDTORequest.setPrice(1000.0);

        ProductDTO productDTO = new ProductDTO();
        productDTO.setProduct_id(2);
        productDTO.setProduct_name("Producto 2");
        productDTO.setColor("Blanco");
        productDTO.setBrand("Marca 2");
        productDTO.setType("Tipo");
        productDTO.setNotes("");
        postDTORequest.setDetail(productDTO);

        //when(postRepository.create(postToCreate)).thenReturn(true);
        when(userRepository.getUser(3)).thenReturn(null);

        //Act & Assert
        Assertions.assertThrows(
                NotFoundException.class, ()->postService.create(postDTORequest)
        );
    }

    @Test
    void createPostThenPostAlreadyExists(){
        //Arrange
        PostDTORequest postDTORequest = new PostDTORequest();
        postDTORequest.setId_post(1);
        postDTORequest.setUser_id(3);
        postDTORequest.setDate(LocalDate.now());
        postDTORequest.setCategory(1);
        postDTORequest.setPrice(1000.0);

        ProductDTO productDTO = new ProductDTO();
        productDTO.setProduct_id(2);
        productDTO.setProduct_name("Producto 2");
        productDTO.setColor("Blanco");
        productDTO.setBrand("Marca 2");
        productDTO.setType("Tipo");
        productDTO.setNotes("");
        postDTORequest.setDetail(productDTO);

        when(userRepository.getUser(3)).thenReturn(new Seller());
        when(postRepository.getById(1)).thenReturn(new Post());

        //Act & Assert
        Assertions.assertThrows(
                AlreadyExistsException.class, ()->postService.create(postDTORequest)
        );
    }

    @Test
    void getByUserAndOrderAscSuccess(){
        //Arrange
        int userId = 1;
        int sellerId = 3;
        String order = "date_asc";

        LocalDate date = LocalDate.now().minus(Period.ofDays(14));

        when(userRepository.getUser(userId)).thenReturn(buyer1);
        when(postRepository.getByUserId(sellerId, date)).thenReturn(Arrays.asList(postCreate2, postCreate));

        //Act
        PostsByUserDTOResponse postsByUserDTOResponse = postService.getByUser(userId, order);

        //Assert
        Assertions.assertTrue(
                postsByUserDTOResponse.getPosts().get(0).getDate().isBefore(postsByUserDTOResponse.getPosts().get(1).getDate())
        );
    }

    @Test
    void getByUserAndOrderDescSuccess(){
        //Arrange
        int userId = 1;
        int sellerId = 3;
        String order = "date_desc";

        LocalDate date = LocalDate.now().minus(Period.ofDays(14));

        when(userRepository.getUser(userId)).thenReturn(buyer1);
        when(postRepository.getByUserId(sellerId, date)).thenReturn(Arrays.asList(postCreate2, postCreate));

        //Act
        PostsByUserDTOResponse postsByUserDTOResponse = postService.getByUser(userId, order);

        //Assert
        Assertions.assertTrue(
                postsByUserDTOResponse.getPosts().get(0).getDate().isAfter(postsByUserDTOResponse.getPosts().get(1).getDate())
        );
    }

    @Test
    void getByUserAndOrderFormatException(){
        //Arrange
        int userId = 1;
        int sellerId = 3;
        String order = "NULL";

        LocalDate date = LocalDate.now().minus(Period.ofDays(14));

        when(userRepository.getUser(userId)).thenReturn(buyer1);
        when(postRepository.getByUserId(sellerId, date)).thenReturn(Arrays.asList(postCreate2, postCreate));

        //Act & Assert
        Assertions.assertThrows(
                BadRequestException.class, ()->postService.getByUser(userId, order)
        );
    }
}
