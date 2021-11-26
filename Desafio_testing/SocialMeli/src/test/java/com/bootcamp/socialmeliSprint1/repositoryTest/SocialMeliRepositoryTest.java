package com.bootcamp.socialmeliSprint1.repositoryTest;

import com.bootcamp.socialmeliSprint1.entitiy.Post;
import com.bootcamp.socialmeliSprint1.entitiy.Purchaser;
import com.bootcamp.socialmeliSprint1.entitiy.Seller;
import com.bootcamp.socialmeliSprint1.repository.SocialMeliRepositoryImpl;
import com.bootcamp.socialmeliSprint1.utils.PostFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

public class SocialMeliRepositoryTest {

    /**
     * Repository is initialized with four users,
     * id(1,2) by purchaser and id(3,4) by seller.
     */
    SocialMeliRepositoryImpl repository = new SocialMeliRepositoryImpl();

    PostFactory factory = new PostFactory();

    /**
     * This test is successful if the Purchaser user exists
     * The purchaser exist and his role is correct, then the test have to can find the user.
     */
    @Test
    void PurchaserExistsInHisRoleThenThisShouldFindTheUser() {

//        Arrange

        //This id belongs to a purchaser user at repository
        Integer id = 1;

//        Act
        Optional<Purchaser> expect = repository.getPurchaser(id);

//        Assert
        Assertions.assertEquals(id,expect.get().getUserID());

    }


    /**
     * This test is successful if the Purchaser user don't exist.
     * The purchaser doesn't exist, then the test have to can send an empty Optional.
     */
    @Test
    void PurchaserNotExistsInHisRoleThenThisThrowAnException() {

//        Arrange

        //This id belongs to a purchaser user at repository
        Integer id = 3;

//        Act
        Optional<Purchaser> expect = repository.getPurchaser(id);

//        Assert
        Assertions.assertEquals(Optional.empty() ,expect);

    }



    /**
     * This test is successful if the Seller exists
     * The Seller exist and his role is correct, then the test have to can find the user.
     */
    @Test
    void SellerExistsInHisRoleThenThisShouldFindTheUser() {

//        Arrange

        //This id belongs to a Seller user at repository
        Integer id = 3;

//        Act
        Optional<Seller> expect = repository.getSeller(id);

//        Assert
        Assertions.assertEquals(id,expect.get().getUserID());

    }


    /**
     * This test is successful if the Seller user don't exist.
     * The purchaser doesn't exist, then the test have to can send an empty Optional.
     */
    @Test
    void SellerNotExistsInHisRoleThenThisThrowAnException() {

//        Arrange

        //This id belongs to a purchaser user at repository
        Integer id = 1;

//        Act
        Optional<Seller> expect = repository.getSeller(id);

//        Assert
        Assertions.assertEquals(Optional.empty() , expect);

    }


    /**
     * Test Create new Post Successful if the method don't throw an exception
     */
    @Test
    void ShouldToCreateNewPost() {

//        Arrange

        Integer sellerId = 5;

        List<Post> allPosts = factory.getListOfTwoValidPostsAndTwoPostsOfTreeWeeksAgo();

//        Act & Assert

        try {
            repository.createNewPost(3,allPosts.get(0));
            Assertions.assertTrue(true);
        }catch (Exception e){
            Assertions.fail();
        }

    }



    /**
     * Test Create new Post Successful if the method throws an exception
     * because the post is null
     */
    @Test
    void ShouldNotToCreateNewPostWithNullPost() {

//        Arrange
        Integer sellerId = 5;

//        Act & Assert

        try {
            repository.createNewPost(3,null);
            Assertions.fail();
        }catch (Exception e){
            Assertions.assertTrue(true);
        }

    }

    /**
     * Test Create new Post Successful if the method throws an exception
     * because the id is null
     */
    @Test
    void ShouldNotToCreateNewPostWithNullSellerId() {

//        Act & Assert
        try {
            repository.createNewPost(null,new Post());
            Assertions.fail();
        }catch (Exception e){
            Assertions.assertTrue(true);
        }
    }

    @Test
    void PurchaserShouldToCanToFollowSeller() {

//        Arrange

        //configure stage
        /**
         *  The getPurchaser and GetSeller method has been test here already.
         *
         * 1 -> id of valid purchaser in repository
         */
        Purchaser p = repository.getPurchaser(1).get();

        /**
         * 3 -> id of valid seller in repository
         */
        Seller s = repository.getSeller(3).get();

        /**
         * Manual follow
         */
        p.addFollowed(3);
        s.addFollower(1);


        /**
         * Now, If the tracking method is successful,
         * the number of followers will increase at one.
         */
//        Act
        /**
         *  4 -> id of valid seller in repository.
         */
        repository.follow(p.getUserID(),4);
//        Assert

        /**
         * Purchaser follow at seller with id 1 and seller witch id 4
         */
        Integer followersExpected = 2;

        /**
         * Seller with id -> 4 has one follower
         * because in "act" is used follow() method.
         */
        Integer followedOfSeller4Expected = 1;

        Assertions.assertAll(
                ()->Assertions.assertEquals(followersExpected, p.getFollowed().size()),
                ()->Assertions.assertEquals(followedOfSeller4Expected, repository.getSeller(4).get().getFollowers().size())
        );
    }


    /**
     * This test is successful if the number of followed returned
     * by the getSellerFollowers method increases
     */
    @Test
    void ShouldToReturnAListOfFollowersOfASellerWithCorrectNumberOfFollowers() {

//        Arrange

        /**
         * Nobody has followers and nobody is followed here.
         */

        /**
         * 1 -> id of valid purchaser in repository
         *
         * 3 -> id of valid seller in repository
         */
//        Act
        repository.follow(1,3);

        Integer currentFollowers = repository.getSeller(3)
                .get().getFollowers().size();

//        Assert
        Integer numFollowersExpected = 1;

        Assertions.assertEquals(numFollowersExpected, currentFollowers);

    }

    /**
     * This test is successful if the number of followed returned
     * by the getSellerFollowers method increases
     */
    @Test
    void ShouldToReturnAListOfFollowedOfAPurchaserWithCorrectNumberOfFollowed() {

//        Arrange

        /**
         * Nobody has followers and nobody is followed here.
         */

        /**
         * 1 -> id of valid purchaser in repository
         *
         * 3 -> id of valid seller in repository
         */
//        Act
        repository.follow(1,3);

        Integer currentFollowed = repository.getPurchaser(1).get().getFollowed().size();

//        Assert
        Integer numFollowedExpected = 1;

        Assertions.assertEquals(numFollowedExpected, currentFollowed);

    }

    /***************************************************************************
     *
     * T-0008: Verificar que la consulta de publicaciones realizadas en las
     * últimas dos semanas de un determinado vendedor sean efectivamente de
     * las últimas dos semanas. (US-0006)
     *
     **************************************************************************/


    /**
     * If the number of post is only of the posts with date after the last two weeks,
     * the test is successful.
     */
    @Test
    void ShouldToGetOnlyPostWithDateAfterTheLastWeeks() {
//        Arrange

        Integer purchaserId=1;

        Integer sellerId = 3;

        List<Post> allPostByTest = factory.getListOfTwoValidPostsAndTwoPostsOfTreeWeeksAgo();

        Purchaser purchaser = repository.getPurchaser(purchaserId).get();

        Seller seller = repository.getSeller(sellerId).get();

        /**
         * Config stage by test
         */
        /**
         * Two post has date after the last two weeks.(0,1)
         * Two post has date before the last two weeks.(2,3)
         */
        allPostByTest.stream().forEach(post -> {
            seller.setPost(post);
        });

        /**
         * Now, purchaser will follower of seller with new posts
         */
        repository.follow(purchaserId,sellerId);

//        Act
        var currentPosts = repository.getSellersPosts(purchaserId);

//        Assert
        List<Post> expected = factory.getListOfTwoValidPosts();

        Assertions.assertEquals(expected.size(),currentPosts.size());


    }
}
