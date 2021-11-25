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


}
