package meli.bootcamp.socialmeli.repository;

import meli.bootcamp.socialmeli.model.Post;
import meli.bootcamp.socialmeli.model.PromoPost;
import meli.bootcamp.socialmeli.utils.TestUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PromoPostRepositoryTest {
    IPromoPostRepository promoPostRepository;

    @BeforeEach @AfterEach
    public void setUp(){
        TestUtils.emptyObjectFile("promopost");
        this.promoPostRepository= new PromoPostRepository();
    }

    @Test
    public void createNewPromoPostWithOneProduct(){
        //Arrange
        PromoPost promoPost= TestUtils.getPromoPostWithRandomPostIDForAnyUser();

        //Act
        promoPostRepository.addPromoPost(promoPost);

        //Assert
        Assertions.assertTrue(promoPostRepository.existPromoPost(promoPost.getPostId()));
        Assertions.assertEquals(promoPostRepository.findPromoPostById(promoPost.getPostId()).get(),promoPost);
    }

    @Test
    public void deleteExistingPost(){
        //Arrange
        PromoPost promoPost= TestUtils.getPromoPostWithRandomPostIDForAnyUser();
        promoPostRepository.addPromoPost(promoPost);

        //Act
        promoPostRepository.deletePromoPost(promoPost.getPostId());

        //Assert
        Assertions.assertFalse(promoPostRepository.existPromoPost(promoPost.getPostId()));
        Assertions.assertFalse(promoPostRepository.findPromoPostById(promoPost.getPostId()).isPresent());
    }

    @Test
    public void findIfPostExistsAndIsEqualsThanWereInserted(){
        //Arrange
        PromoPost promoPost= TestUtils.getPromoPostWithRandomPostIDForAnyUser();
        promoPostRepository.addPromoPost(promoPost);

        //Act
        promoPostRepository.findPromoPostById(promoPost.getPostId());

        //Assert
        Assertions.assertTrue(promoPostRepository.existPromoPost(promoPost.getPostId()));
        Assertions.assertEquals(promoPostRepository.findPromoPostById(promoPost.getPostId()).get(), promoPost);
    }

    @Test
    public void updatePostWithOneProduct(){
        //Arrange
        PromoPost promoPost= TestUtils.getPromoPostWithRandomPostIDForAnyUser();

        //Act
        promoPostRepository.addPromoPost(promoPost);

        //Assert
        Assertions.assertTrue(promoPostRepository.existPromoPost(promoPost.getPostId()));
        Assertions.assertEquals(
                promoPostRepository.findPromoPostById(promoPost.getPostId()),
                promoPost);
    }
}
