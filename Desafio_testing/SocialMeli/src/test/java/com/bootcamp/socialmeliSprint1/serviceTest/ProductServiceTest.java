package com.bootcamp.socialmeliSprint1.serviceTest;

import com.bootcamp.socialmeliSprint1.dto.response.post.PostOutDTO;
import com.bootcamp.socialmeliSprint1.dto.response.post.SellersPostsDTO;
import com.bootcamp.socialmeliSprint1.entitiy.Post;
import com.bootcamp.socialmeliSprint1.entitiy.Purchaser;
import com.bootcamp.socialmeliSprint1.exception.sortException.BadSorterParamRequest;
import com.bootcamp.socialmeliSprint1.exception.userException.NotFoundUserException;
import com.bootcamp.socialmeliSprint1.repository.ISocialMeliRepository;

import com.bootcamp.socialmeliSprint1.service.ProductServiceImpl;
import com.bootcamp.socialmeliSprint1.utils.PostFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    ISocialMeliRepository mockRepository;

    @InjectMocks
    ProductServiceImpl productService;

    PostFactory postFactory = new PostFactory();

    /***************************************************************************
     *
     * T-0005: Verificar que el tipo de ordenamiento por fecha exista (US-0009)
     *
     **************************************************************************/

/**
* To test the sorting by date, I first need to test the method
* that returns the list without order.
*/

    /**
     * This test is successful if the getSellersPost method not fail.
     */
    @Test
    void ShouldGetToListOFSellersPostsWithoutOrder() {

//        Arrange
        Integer idPurchaser = 1;

        Purchaser purchaser = new Purchaser(1,"Juan");

        List<Post> postList = postFactory.getListOfTwoValidPosts();

//        Act
        Mockito.when(mockRepository.getPurchaser(idPurchaser))
                .thenReturn(Optional.of(purchaser));

        Mockito.when(mockRepository.getSellersPosts(idPurchaser))
                .thenReturn(postList);
//        Assert

        try {
            productService.getSellersPosts(idPurchaser);
            Assertions.assertTrue(true);
        }catch (Exception e){
            Assertions.fail();
        }

    }


    /**
     * This test is successful if the result is an NotFoundUserException
     * because the purchaser don't exist
     */
    @Test
    void ShouldNoyGetToListOFSellersPostsWithoutOrderBecausePurchaserDontExist() {
//        Arrange
        Integer idPurchaser = 100;

//        Act & Assert
        try {
            productService.getSellersPosts(idPurchaser);
        }catch (NotFoundUserException e){
            Assertions.assertTrue(true);
        }

    }

    /**
     * Now, This is the test by correct sortParam
     * This is successful if the method getSellersPostsSort
     * don't return an exception with "date_asc" param.
     */
    @Test
    void ShouldToSortPostListByParamDateAsc() {
        //        Arrange
        Integer idPurchaser = 1;

        Purchaser purchaser = new Purchaser(1,"Juan");

        List<Post> postList = postFactory.getListOfTwoValidPosts();

        List<PostOutDTO> expectedList = postFactory.getCastListPostToPostOutDTO(postList);

//        Act
        Mockito.when(mockRepository.getPurchaser(idPurchaser))
                .thenReturn(Optional.of(purchaser));

        Mockito.when(mockRepository.getSellersPosts(idPurchaser))
                .thenReturn(postList);

//        Assert

        try {
            productService.getSellersPostsSort(idPurchaser, "date_asc");
            Assertions.assertTrue(true);
        }catch (BadSorterParamRequest e){
            Assertions.fail();
        }
    }

    /**
     * Now, This is the test by correct sortParam
     * This is successful if the method getSellersPostsSort
     * don't return an exception with "date_desc" param.
     */
    @Test
    void ShouldToSortPostListByParamDateDesc() {
        //        Arrange
        Integer idPurchaser = 1;

        Purchaser purchaser = new Purchaser(1,"Juan");

        List<Post> postList = postFactory.getListOfTwoValidPosts();

        List<PostOutDTO> expectedList = postFactory.getCastListPostToPostOutDTO(postList);

//        Act
        Mockito.when(mockRepository.getPurchaser(idPurchaser))
                .thenReturn(Optional.of(purchaser));

        Mockito.when(mockRepository.getSellersPosts(idPurchaser))
                .thenReturn(postList);

//        Assert

        try {
            productService.getSellersPostsSort(idPurchaser, "date_desc");
            Assertions.assertTrue(true);
        }catch (BadSorterParamRequest e){
            Assertions.fail();
        }
    }

    /**
     * Now, This is the test by *Incorrect* sortParam
     * This is successful if the method getSellersPostsSort
     * returns an exception with "daate_asc" param.
     */
    @Test
    void ShouldToSortPostListByIncorrectParamDate() {
        //        Arrange
        Integer idPurchaser = 1;

        Purchaser purchaser = new Purchaser(1,"Juan");

        List<Post> postList = postFactory.getListOfTwoValidPosts();

        List<PostOutDTO> expectedList = postFactory.getCastListPostToPostOutDTO(postList);

//        Act
        Mockito.when(mockRepository.getPurchaser(idPurchaser))
                .thenReturn(Optional.of(purchaser));

        Mockito.when(mockRepository.getSellersPosts(idPurchaser))
                .thenReturn(postList);

//        Assert

        try {
            productService.getSellersPostsSort(idPurchaser, "daate_asc");
            Assertions.fail();
        }catch (BadSorterParamRequest e){
            Assertions.assertTrue(true);
        }
    }

    /**
     * Now, This is the test by *Incorrect* sortParam
     * This is successful if the method getSellersPostsSort
     * returns an exception with "date_ascx" param.
     */
    @Test
    void ShouldToSortPostListByIncorrectParamSortAsc() {
        //        Arrange
        Integer idPurchaser = 1;

        Purchaser purchaser = new Purchaser(1,"Juan");

        List<Post> postList = postFactory.getListOfTwoValidPosts();

//        Act
        Mockito.when(mockRepository.getPurchaser(idPurchaser))
                .thenReturn(Optional.of(purchaser));

        Mockito.when(mockRepository.getSellersPosts(idPurchaser))
                .thenReturn(postList);

//        Assert

        try {
            productService.getSellersPostsSort(idPurchaser, "date_ascx");
            Assertions.fail();
        }catch (BadSorterParamRequest e){
            Assertions.assertTrue(true);
        }
    }

    /**
     * Now, This is the test by *Incorrect* sortParam
     * This is successful if the method getSellersPostsSort
     * returns an exception with "date_desxx" param.
     */
    @Test
    void ShouldToSortPostListByIncorrectParamSortDesc() {
        //        Arrange
        Integer idPurchaser = 1;

        Purchaser purchaser = new Purchaser(1,"Juan");

        List<Post> postList = postFactory.getListOfTwoValidPosts();

        List<PostOutDTO> expectedList = postFactory.getCastListPostToPostOutDTO(postList);

//        Act
        Mockito.when(mockRepository.getPurchaser(idPurchaser))
                .thenReturn(Optional.of(purchaser));

        Mockito.when(mockRepository.getSellersPosts(idPurchaser))
                .thenReturn(postList);

//        Assert

        try {
            productService.getSellersPostsSort(idPurchaser, "date_descx");
            Assertions.fail();
        }catch (BadSorterParamRequest e){
            Assertions.assertTrue(true);
        }
    }

    /**
     * Now, This is the test by *Full Incorrect* sortParam
     * This is successful if the method getSellersPostsSort
     * returns an exception with "FullIncorrect" param.
     */
    @Test
    void ShouldToSortPostListByIncorrectFullParam() {
        //        Arrange
        Integer idPurchaser = 1;

        Purchaser purchaser = new Purchaser(1,"Juan");

        List<Post> postList = postFactory.getListOfTwoValidPosts();

        List<PostOutDTO> expectedList = postFactory.getCastListPostToPostOutDTO(postList);

//        Act
        Mockito.when(mockRepository.getPurchaser(idPurchaser))
                .thenReturn(Optional.of(purchaser));

        Mockito.when(mockRepository.getSellersPosts(idPurchaser))
                .thenReturn(postList);

//        Assert

        try {
            productService.getSellersPostsSort(idPurchaser, "FailParam");
            Assertions.fail();
        }catch (BadSorterParamRequest e){
            Assertions.assertTrue(true);
        }
    }

    /***************************************************************************
     *
     * T-0006: Verificar el correcto ordenamiento ascendente y descendente por fecha. (US-0009)
     *
     **************************************************************************/

    /**
     * Now, This is the test by correct sortParam
     * This is successful if the method getSellersPostsSort
     * and sorting of correct form, then never return an
     * exception with "date_desc" param.
     */
    @Test
    void ShouldToSortPostListByParamDateDescAndThisIsCorrect() {
        //        Arrange
        Integer idPurchaser = 1;

        Purchaser purchaser = new Purchaser(1,"Juan");

        List<Post> postList = postFactory.getListOfTwoValidPosts();

        List<PostOutDTO> expectedList = postFactory.getCastListPostToPostOutDTO(postList);

//        Act
        Mockito.when(mockRepository.getPurchaser(idPurchaser))
                .thenReturn(Optional.of(purchaser));

        Mockito.when(mockRepository.getSellersPosts(idPurchaser))
                .thenReturn(postList);

//        Assert

        SellersPostsDTO currentListTest = productService.getSellersPostsSort(idPurchaser, "date_desc");

        Assertions.assertAll(
                ()-> Assertions.assertEquals(expectedList.get(0).getPostId(),
                        currentListTest.getPosts().get(0).getPostId()),

                () -> Assertions.assertEquals(expectedList.get(1).getPostId(),
                        currentListTest.getPosts().get(1).getPostId())
                );
    }

    /**
     * Now, This is the test by correct sortParam
     * This is successful if the method getSellersPostsSort
     * and sorting of correct form, then never return an
     * exception with "date_asc" param.
     */
    @Test
    void ShouldToSortPostListByParamDateAscAndThisIsCorrect() {
        //        Arrange
        Integer idPurchaser = 1;

        Purchaser purchaser = new Purchaser(1,"Juan");

        List<Post> postList = postFactory.getListOfTwoValidPostsReverse();

        List<PostOutDTO> expectedList = postFactory.getCastListPostToPostOutDTO(postList);

//        Act
        Mockito.when(mockRepository.getPurchaser(idPurchaser))
                .thenReturn(Optional.of(purchaser));

        Mockito.when(mockRepository.getSellersPosts(idPurchaser))
                .thenReturn(postList);

//        Assert

        SellersPostsDTO currentListTest = productService.getSellersPostsSort(idPurchaser, "date_asc");

        Assertions.assertAll(
                ()-> Assertions.assertEquals(expectedList.get(0).getPostId(),
                        currentListTest.getPosts().get(0).getPostId()),

                () -> Assertions.assertEquals(expectedList.get(1).getPostId(),
                        currentListTest.getPosts().get(1).getPostId())
        );
    }

}
