package com.bootcamp.socialmeliSprint1.repositoryTest;

import com.bootcamp.socialmeliSprint1.entitiy.Purchaser;
import com.bootcamp.socialmeliSprint1.entitiy.Seller;
import com.bootcamp.socialmeliSprint1.repository.SocialMeliRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

public class SocialMeliRepositoryTest {

    /**
     * Repository is initialized with four users,
     * id(1,2) by purchaser and id(3,4) by seller.
     */
    SocialMeliRepositoryImpl repository = new SocialMeliRepositoryImpl();


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

//        Asser
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

//        Asser
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

//        Asser
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

//        Asser
        Assertions.assertEquals(Optional.empty() , expect);

    }


}
