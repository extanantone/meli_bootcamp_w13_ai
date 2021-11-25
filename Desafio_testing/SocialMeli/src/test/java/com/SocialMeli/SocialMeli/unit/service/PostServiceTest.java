package com.SocialMeli.SocialMeli.unit.service;

import com.SocialMeli.SocialMeli.dto.MessageDTOResponse;
import com.SocialMeli.SocialMeli.dto.PostDTORequest;
import com.SocialMeli.SocialMeli.dto.ProductDTO;
import com.SocialMeli.SocialMeli.entity.Buyer;
import com.SocialMeli.SocialMeli.entity.Post;
import com.SocialMeli.SocialMeli.entity.Product;
import com.SocialMeli.SocialMeli.entity.Seller;
import com.SocialMeli.SocialMeli.exception.AlreadyExistsException;
import com.SocialMeli.SocialMeli.exception.NotFoundException;
import com.SocialMeli.SocialMeli.repository.IPostRepository;
import com.SocialMeli.SocialMeli.repository.IUserRepository;
import com.SocialMeli.SocialMeli.repository.PostRepository;
import com.SocialMeli.SocialMeli.repository.UserRepository;
import com.SocialMeli.SocialMeli.service.PostService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.HashMap;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PostServiceTest {
    @Mock
    static IPostRepository postRepository = new PostRepository();

    @Mock
    static IUserRepository userRepository = new UserRepository();

    @InjectMocks
    PostService postService;

    static Post postCreate = new Post();

    @BeforeAll
    static void setUp(){
        postCreate.setId(1);
        postCreate.setDate(LocalDate.of(2021, 11, 25));
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
    }

    @Test
    void getPostByIdSuccess(){
        //Arrange
        int id = 1;

        //Act
        PostDTORequest postDTORequest = postService.getById(id);

        //Assert
        Assertions.assertNotNull(postDTORequest);
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
        postDTORequest.setDate(LocalDate.of(2021, 11, 25));
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
        postDTORequest.setDate(LocalDate.of(2021, 11, 25));
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
        postDTORequest.setDate(LocalDate.of(2021, 11, 25));
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
}
