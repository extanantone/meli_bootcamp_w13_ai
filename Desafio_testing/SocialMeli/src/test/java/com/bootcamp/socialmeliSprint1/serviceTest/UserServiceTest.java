package com.bootcamp.socialmeliSprint1.serviceTest;

import com.bootcamp.socialmeliSprint1.entitiy.Purchaser;
import com.bootcamp.socialmeliSprint1.entitiy.Seller;
import com.bootcamp.socialmeliSprint1.exception.userException.NotFoundFollower;
import com.bootcamp.socialmeliSprint1.exception.userException.NotFoundUserException;
import com.bootcamp.socialmeliSprint1.exception.userException.PurchaserAlreadyFollowSeller;
import com.bootcamp.socialmeliSprint1.repository.ISocialMeliRepository;
import com.bootcamp.socialmeliSprint1.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    ISocialMeliRepository mockRepository;

    @InjectMocks
    UserServiceImpl userService;

    /**
     *
     * T-0001: Verificar que el usuario a seguir exista. (US-0001) Se Cumple
     *
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


    /**
     *
     * T-0002: Verificar que el usuario a dejar de seguir exista. (US-0007) Se Cumple
     *
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


}
