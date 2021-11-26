package com.bootcamp.socialmeliSprint1.serviceTest;

import com.bootcamp.socialmeliSprint1.dto.response.user.BasicUserInfoDTO;
import com.bootcamp.socialmeliSprint1.dto.response.user.SellerFollowersInfoDTO;
import com.bootcamp.socialmeliSprint1.dto.response.user.SellerFollowersListDTO;
import com.bootcamp.socialmeliSprint1.entitiy.Purchaser;
import com.bootcamp.socialmeliSprint1.entitiy.Seller;
import com.bootcamp.socialmeliSprint1.exception.sortException.BadSorterParamRequest;
import com.bootcamp.socialmeliSprint1.exception.userException.NotFoundFollower;
import com.bootcamp.socialmeliSprint1.exception.userException.NotFoundUserException;
import com.bootcamp.socialmeliSprint1.exception.userException.PurchaserAlreadyFollowSeller;
import com.bootcamp.socialmeliSprint1.repository.ISocialMeliRepository;
import com.bootcamp.socialmeliSprint1.service.UserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    ISocialMeliRepository mockRepository;

    @InjectMocks
    UserServiceImpl userService;

    /**************************************************************************
     *
     * T-0001: Verificar que el usuario a seguir exista. (US-0001)
     *
     **************************************************************************/

    /**
     * This test is successfull if the followed exist.
     */
    @Test
    void ShouldCanToFindFollowedForFollow() {

//        Arrange

        //This id belongs to a valid purchaser user at repository
        Integer purchaserId = 1;

        //This id belongs to a valid Seller user at repository
        Integer sellerId = 3;

        Purchaser purchaser = new Purchaser();
        purchaser.setUserID(purchaserId);

        Seller seller = new Seller();
        seller.setUserID(sellerId);

//        Act & Assert
        Mockito.when(mockRepository.getSeller(3)).thenReturn(Optional.of(seller));
        Mockito.when(mockRepository.getPurchaser(purchaserId)).thenReturn(Optional.of(purchaser));

        try {
            userService.addFollowed(purchaserId,sellerId);
            assertTrue(true);
        }catch (NotFoundUserException e){
            //if user followed don't exist, then throws exception and this test fail.
            fail();
        }
    }

    /**
     *
     * T-0001: Verificar que el usuario a seguir NO exista. (US-0001) No se Cumple
     *
     * This test is successful if the user followed don't exist and then this throws an exception.
     */

    @Test
    void ShouldNOtToCanToFindFollowedForFollow() {

//        Arrange

        //This id belongs to a valid purchaser user at repository
        Integer purchaserId = 1;

/*      This id belongs to Invalid Seller user at repository
        This user exists, but it's a Purchaser user.
        A Purchaser user can't follow to a Purchaser user.*/
        Integer sellerId = 2;

        Purchaser purchaser = new Purchaser();
        purchaser.setUserID(purchaserId);

//        Act
        Mockito.when(mockRepository.getSeller(sellerId)).thenReturn(Optional.empty());

//        Assert
        try {
            userService.addFollowed(purchaserId,sellerId);
            fail();
        }catch (NotFoundUserException e){
            //if user followed don't exist, then throws exception and this test is successful.
            assertTrue(true);
        }
    }

    /**
     *
     * Debe lanzar la Excepcion PurchaserAlreadyFollowUser, si los usuarios ya se siguen.
     *
     * This test is successful if users are already following and the method throws
     * an PurchaserAlreadyFollowUser.
     */
    @Test
    void ShouldNOtToCanToFollowBecauseAlreadyIsFollower() {

//        Arrange

        //This id belongs to a valid purchaser user at repository
        Integer purchaserId = 1;

        //This id belongs to a valid Seller user at repository
        Integer sellerId = 3;

        Purchaser purchaser = new Purchaser();
        purchaser.setUserID(purchaserId);

        Seller seller = new Seller();
        seller.setUserID(sellerId);


        /**
         * Purchaser is follower of Seller
         */
        purchaser.addFollowed(sellerId);


//        Act & Assert
        Mockito.when(mockRepository.getSeller(3)).thenReturn(Optional.of(seller));
        Mockito.when(mockRepository.getPurchaser(purchaserId)).thenReturn(Optional.of(purchaser));

        try {
            userService.addFollowed(purchaserId,sellerId);
            fail();
        }catch (PurchaserAlreadyFollowSeller e){
            //if user followed don't exist, then throws exception and this test is successful.
            assertTrue(true);
        }
    }


    /***************************************************************************
     *
     * T-0002: Verificar que el usuario a dejar de seguir exista. (US-0007)
     *
     **************************************************************************/

    /**
     * This test is successfull if the followed exist.
     */
    @Test
    void ShouldCanToFindUserForUnFollow() {

//        Arrange

        //This id belongs to a valid purchaser user at repository
        Integer purchaserId = 1;

        //This id belongs to a valid Seller user at repository
        Integer sellerId = 3;

        Purchaser purchaser = new Purchaser();
        purchaser.setUserID(purchaserId);
        /**
         * Add empty list of followed
         */
        purchaser.setFollowed(new ArrayList<>());
        //add followed
        purchaser.addFollowed(sellerId);

        Seller seller = new Seller();
        seller.setUserID(sellerId);
        /**
         * Add empty list of followers
         */
        seller.setFollowers(new ArrayList<>());


//        Act
        Mockito.when(mockRepository.getSeller(sellerId)).thenReturn(Optional.of(seller));
        Mockito.when(mockRepository.getPurchaser(purchaserId)).thenReturn(Optional.of(purchaser));


//        Assert
        try {
            userService.unFollow(purchaserId,sellerId);
            assertTrue(true);
        }catch (NotFoundUserException e){
            //if user followed don't exist, then throws exception and this test is successful.
            fail();
        }
    }


    /**
     *
     * T-0002: Verificar que el usuario a dejar de seguir exista. (US-0007) No Se Cumple
     *
     * This test is successfull if the method throws the NotFoundUserException
     */
    @Test
    void ShouldNotCanToFindUserForUnFollow() {

//        Arrange

        //This id belongs to a valid purchaser user at repository
        Integer purchaserId = 1;

        //This id belongs to a Invalid Seller user at repository
        Integer sellerId = 6;

        Purchaser purchaser = new Purchaser();
        purchaser.setUserID(purchaserId);

        Seller seller = new Seller();
        seller.setUserID(sellerId);


//        Act
        Mockito.when(mockRepository.getSeller(sellerId)).thenReturn(Optional.empty());

//        Assert
        try {
            userService.unFollow(purchaserId,sellerId);
            fail();
        }catch (NotFoundUserException e){
            //if user followed don't exist, then throws exception and this test is successful.
            assertTrue(true);
        }
    }

    /**
     *
     * T-0002: Verificar que el usuario a dejar de seguir, Se este siguiendo ya. (US-0002) No Se Cumple
     *
     * This test is successfull if the method throws NotFoundFollower Exception
     *
     * If the purchaser user never had followed to the seller user, this test throws an Exception.
     */
    @Test
    void ShouldNotCanToUnFollowSellerBecauseTheyHadNotBeenFollowers() {

//        Arrange

        //This id belongs to a valid purchaser user at repository
        Integer purchaserId = 1;

        //This id belongs to a Invalid Seller user at repository
        Integer sellerId = 3;

        Purchaser purchaser = new Purchaser();
        purchaser.setUserID(purchaserId);
        /**
         * Add empty list of followed
         */
        purchaser.setFollowed(new ArrayList<>());


        Seller seller = new Seller();

        seller.setUserID(sellerId);
        /**
         * Add empty list of followers
         */
        seller.setFollowers(new ArrayList<>());


//        Act & Assert
        Mockito.when(mockRepository.getSeller(sellerId)).thenReturn(Optional.of(seller));
        Mockito.when(mockRepository.getPurchaser(purchaserId)).thenReturn(Optional.of(purchaser));

        try {
            userService.unFollow(purchaserId,sellerId);
            fail();
        }catch (NotFoundFollower e){
            //if user followed don't exist, then throws exception and this test is successful.
            assertTrue(true);
        }
    }


    /***************************************************************************
     *
     * T-0003: Verificar que el tipo de ordenamiento alfabético exista (US-0008)
     *
     **************************************************************************/

        /**
         * First, need test the getSellerFollowersList method getPurchaserFollowedList
         * ,there are used for get the lists without specific order. Then, the
         * getSellerFollowersListSort method or the getPurchaserFollowedListSort,
         * get there lists and apply a specific sorter.
         */

    /**
     * By Seller's followed list
     *
     * This test is successful if the seller user exists and
     * the method return a list of Seller's Followers.
      */
    @Test
     void ShouldGetFullListFollowersOfSellerBySellerId() {

//        Arrange

        Integer sellerId = 3;

        List<Purchaser> followers = new ArrayList<>();

        Purchaser purchaser1 = new Purchaser(1,"Purchaser1");

        Purchaser purchaser2 = new Purchaser(2,"Purchaser2");

        Seller seller = new Seller(3, "Seller1");

        followers.add(purchaser1);
        followers.add(purchaser2);
//        Act

        Mockito.when(mockRepository.getSeller(sellerId))
                .thenReturn(Optional.of(seller));
        Mockito.when(mockRepository.getSellerFollowers(sellerId))
                .thenReturn(followers);

//        Assert

        try {
            userService.getSellerFollowersList(sellerId);
            assertTrue(true);
        }catch (NotFoundUserException e){
            fail();
        }

    }

    /**
     * This test is successful if the method throws an exception
     * because the sellerId no exists in the repository.
     */
    @Test
    void ShouldNotGetFullListFollowersOfSellerBySellerIdBecauseSellerDontExist() {

//        Arrange

        Integer sellerId = 5;

        Seller seller = new Seller(3, "Seller1");

//        Act
        Mockito.when(mockRepository.getSeller(sellerId))
                .thenReturn(Optional.empty());

//        Assert

        try {
            userService.getSellerFollowersList(sellerId);
            fail();
        }catch (NotFoundUserException e){
            assertTrue(true);
        }

    }

/**
* Now need to test the alphabetic sort options
 * Remember, the sorting is independent of  list to sort.
 * Then, now needs to test the getPurchaserFollowedList method
 * and the sort options.
*/

    /**
     * By Seller's followed list
     *
     * This test is successful if the purchaser user exists and
     * the method return a list of Purchaser's Followed.
     */
    @Test
    void ShouldGetFullListFollowedOfPurchaserByPurchaserId() {

//        Arrange

        Integer purchaserId = 1;

        List<Seller> followed = new ArrayList<>();

        Seller seller1 = new Seller(3,"Seller1");

        Seller seller2 = new Seller(4,"Seller2");

        Purchaser purchaser = new Purchaser(1, "Purchaser");

        followed.add(seller1);
        followed.add(seller2);
//        Act

        Mockito.when(mockRepository.getPurchaser(purchaserId))
                .thenReturn(Optional.of(purchaser));
        Mockito.when(mockRepository.getPurchaserFollowed(purchaserId))
                .thenReturn(followed);

//        Assert

        try {
            userService.getPurchaserFollowedList(purchaserId);
            assertTrue(true);
        }catch (NotFoundUserException e){
            fail();
        }

    }


    /**
     * First the Descendant form (Seller -> Followers List)
     */
    @Test
    void ShouldToSortByNameOfDescendantForm() {

//        Arrange

        Integer sellerId = 3;

        List<Purchaser> followers = new ArrayList<>();

        Purchaser purchaser1 = new Purchaser(1,"Juan");

        Purchaser purchaser2 = new Purchaser(2,"Pedro");

        Seller seller = new Seller(3, "Seller1");

        followers.add(purchaser1);
        followers.add(purchaser2);

        List<Integer> followersSeller = new ArrayList<>();
        followersSeller.add(1);
        followersSeller.add(2);

        seller.setFollowers(followersSeller);

//        Act

        Mockito.when(mockRepository.getSeller(sellerId))
                .thenReturn(Optional.of(seller));
        Mockito.when(mockRepository.getSellerFollowers(sellerId))
                .thenReturn(followers);

//        Assert

        try {
            userService.getSellerFollowersListSort(sellerId, "name_desc");
            assertTrue(true);
        }catch (BadSorterParamRequest e){
            fail();
        }

    }

    /**
     * First the Ascendant form
     */
    @Test
    void ShouldToSortByNameOfAscendantForm() {

//        Arrange

        Integer sellerId = 3;

        List<Purchaser> followers = new ArrayList<>();

        Purchaser purchaser1 = new Purchaser(1,"Juan");

        Purchaser purchaser2 = new Purchaser(2,"Pedro");

        Seller seller = new Seller(3, "Seller1");

        followers.add(purchaser1);
        followers.add(purchaser2);

        List<Integer> followersSeller = new ArrayList<>();
        followersSeller.add(1);
        followersSeller.add(2);

        seller.setFollowers(followersSeller);

//        Act

        Mockito.when(mockRepository.getSeller(sellerId))
                .thenReturn(Optional.of(seller));
        Mockito.when(mockRepository.getSellerFollowers(sellerId))
                .thenReturn(followers);

//        Assert

        try {
            userService.getSellerFollowersListSort(sellerId, "name_asc");
            assertTrue(true);
        }catch (BadSorterParamRequest e){
            fail();
        }

    }


    /**
     * This test is Successful if throws a BadSorterParamRequest
     * because sends a bad param. (name_deesssc)
     */
    @Test
    void ShouldNotToSortFormBecauseIncorrectParagram() {

//        Arrange

        Integer sellerId = 3;

        List<Purchaser> followers = new ArrayList<>();

        Purchaser purchaser1 = new Purchaser(1,"Juan");

        Purchaser purchaser2 = new Purchaser(2,"Pedro");

        Seller seller = new Seller(3, "Seller1");

        followers.add(purchaser1);
        followers.add(purchaser2);

        List<Integer> followersSeller = new ArrayList<>();
        followersSeller.add(1);
        followersSeller.add(2);

        seller.setFollowers(followersSeller);

//        Act

        Mockito.when(mockRepository.getSeller(sellerId))
                .thenReturn(Optional.of(seller));
        Mockito.when(mockRepository.getSellerFollowers(sellerId))
                .thenReturn(followers);

//        Assert

        try {
            userService.getSellerFollowersListSort(sellerId, "name_deesc");
            fail();
        }catch (BadSorterParamRequest e){
            assertTrue(true);
        }

    }


    /**
     * This test is Successful if throws a BadSorterParamRequest
     * because sends a bad param. (naame_desc)
     */
    @Test
    void ShouldNotToSortFormBecauseIncorrectParagramName() {

//        Arrange

        Integer sellerId = 3;

        List<Purchaser> followers = new ArrayList<>();

        Purchaser purchaser1 = new Purchaser(1,"Juan");

        Purchaser purchaser2 = new Purchaser(2,"Pedro");

        Seller seller = new Seller(3, "Seller1");

        followers.add(purchaser1);
        followers.add(purchaser2);

        List<Integer> followersSeller = new ArrayList<>();
        followersSeller.add(1);
        followersSeller.add(2);

        seller.setFollowers(followersSeller);

//        Act

        Mockito.when(mockRepository.getSeller(sellerId))
                .thenReturn(Optional.of(seller));
        Mockito.when(mockRepository.getSellerFollowers(sellerId))
                .thenReturn(followers);

//        Assert

        try {
            userService.getSellerFollowersListSort(sellerId, "naame_desc");
            fail();
        }catch (BadSorterParamRequest e){
            assertTrue(true);
        }

    }

    /**
     * This test is Successful if throws a BadSorterParamRequest
     * because sends a bad param. (ErrorParam)
     */
    @Test
    void ShouldNotToSortFormBecauseIncorrectFullParagram() {

//        Arrange

        Integer sellerId = 3;

        List<Purchaser> followers = new ArrayList<>();

        Purchaser purchaser1 = new Purchaser(1,"Juan");

        Purchaser purchaser2 = new Purchaser(2,"Pedro");

        Seller seller = new Seller(3, "Seller1");

        followers.add(purchaser1);
        followers.add(purchaser2);

        List<Integer> followersSeller = new ArrayList<>();
        followersSeller.add(1);
        followersSeller.add(2);

        seller.setFollowers(followersSeller);

//        Act

        Mockito.when(mockRepository.getSeller(sellerId))
                .thenReturn(Optional.of(seller));
        Mockito.when(mockRepository.getSellerFollowers(sellerId))
                .thenReturn(followers);

//        Assert

        try {
            userService.getSellerFollowersListSort(sellerId, "errorParam");
            fail();
        }catch (BadSorterParamRequest e){
            assertTrue(true);
        }

    }


    /***************************************************************************
     *
     * T-0004: Verificar el correcto ordenamiento ascendente y descendente por nombre. (US-0008)
     *
     **************************************************************************/

    /**
     * First the Descendant form
     *
     * This test is successful if the list is sort of descendant form by name
     */
    @Test
    void ShouldToSortByNameOfAscendantFormAndBeEqualsTestList() {

//        Arrange

        Integer sellerId = 3;

        List<Purchaser> followers = new ArrayList<>();

        Purchaser purchaser1 = new Purchaser(1,"Juan");

        Purchaser purchaser2 = new Purchaser(2,"Pedro");

        Seller seller = new Seller(3, "Seller1");

        followers.add(purchaser1);
        followers.add(purchaser2);

        List<Integer> followersSeller = new ArrayList<>();
        followersSeller.add(1);
        followersSeller.add(2);

        seller.setFollowers(followersSeller);

        List<BasicUserInfoDTO> expected = new ArrayList<>();

        /**
         * Here, in expected list is add the purchasers in desc order.
         */
        expected.add(new BasicUserInfoDTO(purchaser2.getUserID(), purchaser2.getUserName()));
        expected.add(new BasicUserInfoDTO(purchaser1.getUserID(), purchaser1.getUserName()));

        SellerFollowersListDTO expectedSorted= new SellerFollowersListDTO(sellerId,seller.getUserName(),expected);

//        Act

        Mockito.when(mockRepository.getSeller(sellerId))
                .thenReturn(Optional.of(seller));
        Mockito.when(mockRepository.getSellerFollowers(sellerId))
                .thenReturn(followers);


        //list obtain of test method.
        SellerFollowersListDTO currentSorted = userService.getSellerFollowersListSort(sellerId, "name_desc");
//        Assert

        /**
         * validate to correct order
         */
        Assertions.assertAll(
                ()-> Assertions.assertEquals(expectedSorted.getFollowers().get(0).getUserName()
                        ,currentSorted.getFollowers().get(0).getUserName()),
                ()-> Assertions.assertEquals(expectedSorted.getFollowers().get(1).getUserName()
                        ,currentSorted.getFollowers().get(1).getUserName())
        );

    }

    /**
     * Now the Ascendant form
     *
     * This test is successful if the list is sort of descendant form by name
     */
    @Test
    void ShouldToSortByNameOfDescendantFormAndBeEqualsTestList() {

//        Arrange

        Integer sellerId = 3;

        List<Purchaser> followers = new ArrayList<>();

        Purchaser purchaser1 = new Purchaser(1,"Juan");

        Purchaser purchaser2 = new Purchaser(2,"Pedro");

        Seller seller = new Seller(3, "Seller1");

        followers.add(purchaser1);
        followers.add(purchaser2);

        List<Integer> followersSeller = new ArrayList<>();
        followersSeller.add(1);
        followersSeller.add(2);

        seller.setFollowers(followersSeller);

        List<BasicUserInfoDTO> expected = new ArrayList<>();

        /**
         * Here, in expected list is add the purchasers in ASC order.
         */
        expected.add(new BasicUserInfoDTO(purchaser1.getUserID(), purchaser1.getUserName()));
        expected.add(new BasicUserInfoDTO(purchaser2.getUserID(), purchaser2.getUserName()));


        SellerFollowersListDTO expectedSorted= new SellerFollowersListDTO(sellerId,seller.getUserName(),expected);

//        Act

        Mockito.when(mockRepository.getSeller(sellerId))
                .thenReturn(Optional.of(seller));
        Mockito.when(mockRepository.getSellerFollowers(sellerId))
                .thenReturn(followers);


        //list obtain of test method.
        SellerFollowersListDTO currentSorted = userService.getSellerFollowersListSort(sellerId, "name_asc");
//        Assert

        /**
         * validate to correct order
         */
        Assertions.assertAll(
                ()-> Assertions.assertEquals(expectedSorted.getFollowers().get(0).getUserName()
                        ,currentSorted.getFollowers().get(0).getUserName()),
                ()-> Assertions.assertEquals(expectedSorted.getFollowers().get(1).getUserName()
                        ,currentSorted.getFollowers().get(1).getUserName())
        );

    }


    /***************************************************************************
     *
     * T-0007: Verificar que la cantidad de seguidores
     * de un determinado usuario sea correcta. (US-0002)
     *
     **************************************************************************/

    /**
     * This test is successfull if the number os followers
     * after of to call the getSellerFollowersCount method
     * is equals to expected list with 2 followers.
     */
    @Test
    void ShouldGetToListOfFollowersCorrectInfo() {

//        Arrange
        Integer sellerId = 1;

        Integer expectedFollowers = 2;

        List<Integer> followers = new ArrayList<>();
        followers.add(2);
        followers.add(3);

        //seller with two followers
        Seller seller = new Seller(1,"seller");
        seller.setFollowers(followers);

//        Act

        Mockito.when(mockRepository.getSeller(sellerId))
                .thenReturn(Optional.of(seller));

//        Assert

        SellerFollowersInfoDTO current = userService.getSellerFollowersCount(sellerId);

        Assertions.assertEquals(2,current.getFollowersCount());

    }


    /**
     * In this test, the seller user dont exist.
     * the test is successful if the getSellerFollowersCount
     * throws an NotFoundUserException
     */
    @Test
    void ShouldGetToListOfFollowersInCorrectInfo() {

//        Arrange
        Integer sellerId = 1;

//        Act

        Mockito.when(mockRepository.getSeller(sellerId))
                .thenReturn(Optional.empty());

//        Assert

        try {
            userService.getSellerFollowersCount(sellerId);
            Assertions.fail();
        }catch (NotFoundUserException e){
            Assertions.assertTrue(true);
        }

    }

}
