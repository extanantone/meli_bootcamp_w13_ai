package repository;

import com.SocialMeli.SocialMeli.dto.SellersDTO;
import com.SocialMeli.SocialMeli.dto.UserDTO;
import com.SocialMeli.SocialMeli.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
        UserDTO sellersDTO = repo.createSellers(userDTO);
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





}
