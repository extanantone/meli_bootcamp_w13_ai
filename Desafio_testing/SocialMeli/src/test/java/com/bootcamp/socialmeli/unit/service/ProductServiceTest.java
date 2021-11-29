package com.bootcamp.socialmeli.unit.service;

import com.bootcamp.socialmeli.dto.PostDTO;
import com.bootcamp.socialmeli.dto.ProductDTO;
import com.bootcamp.socialmeli.dto.ResponsePostDTO;
import com.bootcamp.socialmeli.exception.NotFoundOrderParamException;
import com.bootcamp.socialmeli.exception.NotPossibleOperationException;
import com.bootcamp.socialmeli.model.Post;
import com.bootcamp.socialmeli.model.Product;
import com.bootcamp.socialmeli.model.User;
import com.bootcamp.socialmeli.repository.IProductRepository;
import com.bootcamp.socialmeli.repository.IUserRepository;
import com.bootcamp.socialmeli.service.ProductService;
import com.google.common.collect.Comparators;
import com.google.common.collect.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    IProductRepository iProductRepository;
    @Mock
    IUserRepository iUserRepository;

    @InjectMocks
    ProductService productService;

    static User userTest;
    static User userFollowedTest;
    static User userFollowedTest2;
    static Post postTest;
    static Post postTest2;
    static Product productTest;
    static Product productTest2;
    static PostDTO postDTO;
    static PostDTO postDTO2;
    static ProductDTO productDTO;
    static ProductDTO productDTO2;
    static List<User> userFollowedList;
    static List<Post> postList;


    @BeforeAll
    public static void initializingVariablesForTesting(){
        userTest = new User(1, "Nico");
        userFollowedTest = new User(3, "Pedro");
        userFollowedTest2 = new User(4,"Carlos");
        userTest.addFollowed(userFollowedTest.getId());
        userTest.addFollowed(userFollowedTest2.getId());
        userFollowedList = Arrays.asList(userFollowedTest, userFollowedTest2);

        productTest = new Product(
                1,
                "Silla Gamer",
                "Gamer",
                "Racer",
                "Red Black",
                "Special Edition"
        );
        productTest2 = new Product(
                4,
                "Teclado Gamer",
                "Gamer",
                "Logitech",
                "Plate",
                "Hardcore Edition"
        );

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        postTest = new Post(
                18,
                LocalDate.parse("01-11-2021", formatter),
                10000,
                123,
                3,
                productTest
        );

        postTest2 = new Post(
                20,
                LocalDate.parse("05-11-2021", formatter),
                500,
                456,
                4,
                productTest2
        );

        postList = Arrays.asList(postTest, postTest2);

        productDTO = new ProductDTO(
                productTest.getProductId(),
                productTest.getProductName(),
                productTest.getType(),
                productTest.getBrand(),
                productTest.getColor(),
                productTest.getNotes()
        );
        productDTO2 = new ProductDTO(
                productTest2.getProductId(),
                productTest2.getProductName(),
                productTest2.getType(),
                productTest2.getBrand(),
                productTest2.getColor(),
                productTest2.getNotes()
        );

        postDTO = new PostDTO(
                postTest.getIdPost(),
                postTest.getDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                postTest.getPrice(),
                postTest.getCategory(),
                productDTO
        );
        postDTO2 = new PostDTO(
                postTest2.getIdPost(),
                postTest2.getDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                postTest2.getPrice(),
                postTest2.getCategory(),
                productDTO2
        );
    }


    @Test
    void shouldGetProductsFollowed() throws NotPossibleOperationException {
        //Arrange
        ResponsePostDTO current;
        ResponsePostDTO expected = new ResponsePostDTO(
                userTest.getId(),
                Arrays.asList(postDTO, postDTO2)
        );

        Mockito.when(iUserRepository.getUser(userTest.getId()))
                .thenReturn(userTest);
        Mockito.when(iUserRepository.getUsersFollowed(userTest))
                .thenReturn(userFollowedList);
        Mockito.when(iProductRepository.getPost(userFollowedTest.getId()))
                .thenReturn(Arrays.asList(postTest));
        Mockito.when(iProductRepository.getPost(userFollowedTest2.getId()))
                .thenReturn(Arrays.asList(postTest2));
        //Act
        current = productService.getProductsFollowed(userTest.getId(), null);

        //Assert
        Assertions.assertEquals(expected, current);
    }

    @Test
    void shouldGetProductsFollowedInAscOrder() throws NotPossibleOperationException {
        //Arrange
        String order = "date_asc";
        ResponsePostDTO current;
        ResponsePostDTO expected = new ResponsePostDTO(
                userTest.getId(),
                Arrays.asList(postDTO, postDTO2)
        );

        Mockito.when(iUserRepository.getUser(userTest.getId()))
                .thenReturn(userTest);
        Mockito.when(iUserRepository.getUsersFollowed(userTest))
                .thenReturn(userFollowedList);
        Mockito.when(iProductRepository.getPost(userFollowedTest.getId()))
                .thenReturn(Arrays.asList(postTest));
        Mockito.when(iProductRepository.getPost(userFollowedTest2.getId()))
                .thenReturn(Arrays.asList(postTest2));
        //Act
        current = productService.getProductsFollowed(userTest.getId(), order);

        //Assert

        Assertions.assertEquals(expected, current);

        Comparator<PostDTO> comparator = Comparator.comparing(postDTO -> postDTO.getDate());
        Assertions.assertTrue(Comparators.isInOrder(current.getPosts(), comparator));

    }

    @Test
    void shouldGetProductsFollowedInDescOrder() throws NotPossibleOperationException {
        //Arrange
        String order = "date_desc";
        ResponsePostDTO current;
        ResponsePostDTO expected = new ResponsePostDTO(
                userTest.getId(),
                Arrays.asList(postDTO2, postDTO)
        );

        Mockito.when(iUserRepository.getUser(userTest.getId()))
                .thenReturn(userTest);
        Mockito.when(iUserRepository.getUsersFollowed(userTest))
                .thenReturn(userFollowedList);
        Mockito.when(iProductRepository.getPost(userFollowedTest.getId()))
                .thenReturn(Arrays.asList(postTest));
        Mockito.when(iProductRepository.getPost(userFollowedTest2.getId()))
                .thenReturn(Arrays.asList(postTest2));
        //Act
        current = productService.getProductsFollowed(userTest.getId(), order);

        //Assert

        Assertions.assertEquals(expected, current);

        Comparator<PostDTO> comparator = Comparator.comparing(postDTO -> postDTO.getDate());
        Assertions.assertTrue(Comparators.isInOrder(Lists.reverse(current.getPosts()), comparator));

    }

    @Test
    void shouldThrowExceptionWhenOrderParamNotExist() throws NotPossibleOperationException {
        //Arrange
        String order = "invalid order param";
        ResponsePostDTO current;
        ResponsePostDTO expected = new ResponsePostDTO(
                userTest.getId(),
                Arrays.asList(postDTO, postDTO2)
        );

        Mockito.when(iUserRepository.getUser(userTest.getId()))
                .thenReturn(userTest);
        Mockito.when(iUserRepository.getUsersFollowed(userTest))
                .thenReturn(userFollowedList);
        Mockito.when(iProductRepository.getPost(userFollowedTest.getId()))
                .thenReturn(Arrays.asList(postTest));
        Mockito.when(iProductRepository.getPost(userFollowedTest2.getId()))
                .thenReturn(Arrays.asList(postTest2));

        //Act & Assert
        Assertions.assertThrows(NotFoundOrderParamException.class,
                () -> productService.getProductsFollowed(userTest.getId(), order));

    }

}
