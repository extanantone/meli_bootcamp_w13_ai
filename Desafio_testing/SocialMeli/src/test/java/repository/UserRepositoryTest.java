package repository;

import com.SocialMeli.SocialMeli.dto.PostListDTO;
import com.SocialMeli.SocialMeli.dto.SellersDTO;
import com.SocialMeli.SocialMeli.dto.UserDTO;
import com.SocialMeli.SocialMeli.repository.UserRepository;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.hasProperty;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class UserRepositoryTest {

    UserRepository repo = new UserRepository();

    @Test
    void userSellerCreate(){
        // Arrange
        UserDTO userDTO = new UserDTO();
        userDTO.setUser_id(null);
        userDTO.setUser_name("Camilo");


        // Act
        UserDTO current = repo.createSellers(userDTO);

        // Assert
        Assertions.assertEquals(1, current.getUser_id());
    }


    @Test
    void userSellerExist(){
        // Arrange
        Integer user_id = 1;
        UserDTO userDTO = new UserDTO(null, "Camilo");
        UserDTO sellersDTO = repo.createSellers(userDTO);

        // Act
        SellersDTO current = repo.findSellerByUserId(user_id);

        // Assert
        Assertions.assertEquals(sellersDTO,current);
    }


    // En dado caso que cualquiera de los dos usuarios no exista
    // se retornará un false porque en ningun momento se van seguir
    @Test
    void userFollowedSuccess(){
        // Arrange
        Integer user_id = 1;
        UserDTO userDTO = new UserDTO(null, "Camilo");
        repo.createSellers(userDTO);
        UserDTO buyerDTO = repo.createBuyers(userDTO);

        // Act
        Boolean followStatus = repo.follow(buyerDTO.getUser_id(), user_id);

        // Assert
        Assertions.assertTrue(followStatus);
    }


    // En dado caso que cualquiera de los dos usuarios no exista
    // se retornará un false porque en ningun momento se podrían seguir
    @Test
    void userUnfollowedSuccess(){
        // Arrange
        Integer user_id = 1;
        UserDTO userDTO = new UserDTO(null, "Camilo");
        UserDTO sellersDTO = repo.createSellers(userDTO);
        UserDTO buyerDTO = repo.createBuyers(userDTO);
        repo.follow(buyerDTO.getUser_id(), sellersDTO.getUser_id());

        // Act
        Boolean followStatus = repo.unfollow(buyerDTO.getUser_id(), user_id);

        // Assert
        Assertions.assertTrue(followStatus);
    }


    // Siempre va a retornar el usuario sin importar si le envìas o no el order
    // al igual si el usuario escribe mal el order
    @Test
    @DisplayName("Con valor para el parámetro order")
    void checkingSortedAlphaTypeSellers(){
        // Arrange
        String order = "name_asc";
        Integer user_id = 1;
        UserDTO userDTO = new UserDTO(null, "Camilo");
        repo.createSellers(userDTO);

        // Act
        SellersDTO sellersDTO = repo.followersListSorted(user_id, order);

        // Assert
        Assertions.assertNotNull(sellersDTO);

    }

    @Test
    @DisplayName("Sin valor para el parámetro order")
    void checkingSortedAlphaTypeSellersWithoutOrder(){
        // Arrange
        Integer user_id = 1;
        UserDTO userDTO = new UserDTO(null, "Camilo");
        repo.createSellers(userDTO);

        // Act
        SellersDTO sellersDTO = repo.followersListSorted(user_id, null);

        // Assert
        Assertions.assertNotNull(sellersDTO);

    }


    @Test
    void checkingSortedAlphaAscSellers(){
        // Arrange
        String order = "name_asc";
        Integer user_id = 1;
        UserDTO userDTO = new UserDTO(null, "Camilo");
        repo.createSellers(userDTO);
        UserDTO follower1 = new UserDTO(null, "Vanesa");
        repo.createBuyers(follower1);
        follower1.setUser_id(1);
        UserDTO followerTest = new UserDTO(1, "Vanesa");
        /*UserDTO follower2 = new UserDTO(null, "Ana");
        repo.createBuyers(follower2);
        UserDTO follower3 = new UserDTO(null, "Martín");
        repo.createBuyers(follower3);*/
        
        repo.follow(1,1);
        /*repo.follow(2,1);
        repo.follow(3,1);*/

        List<UserDTO> userDTOList = new ArrayList<>();
        /*userDTOList.add(follower2);
        userDTOList.add(follower3);*/
        userDTOList.add(follower1);
        
        
        // Act
        SellersDTO sellersDTO = repo.followersListSorted(user_id, order);
        List<UserDTO> followersList = sellersDTO.getFollowers();

        // Assert
        //Assertions.assertTrue(CollectionUtils.isEqualCollection(userDTOList, followersList));
        Assertions.assertEquals(userDTOList, sellersDTO.getFollowers());
        //ssertThat(userDTOList, hasItems(followerTest));
        //Assertions.assertTrue(followersList.retainAll(userDTOList));
        //Assertions.assertTrue(userDTOList.containsAll(userDTOList));
        //assertThat(userDTOList, hasItems(followerTest));


    }


    @Test
    @DisplayName("Con parámetro de order")
    void checkingSortedDateTypeSellers(){
        // Arrange
        String order = "name_asc";
        Integer user_id = 1;
        UserDTO userDTO = new UserDTO(null, "Camilo");
        repo.createSellers(userDTO);


        // Act
        PostListDTO postListDTO = repo.postList(user_id, order);

        // Assert
        Assertions.assertNotNull(postListDTO);

    }

    @Test
    @DisplayName("Sin parámetro de order")
    void checkingSortedDateTypeSellersWithoutOrder(){
        // Arrange
        Integer user_id = 1;
        UserDTO userDTO = new UserDTO(null, "Camilo");
        repo.createSellers(userDTO);


        // Act
        PostListDTO postListDTO = repo.postList(user_id, null);

        // Assert
        Assertions.assertNotNull(postListDTO);

    }


}
