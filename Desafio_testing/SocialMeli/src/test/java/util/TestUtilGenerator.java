package util;

import com.SocialMeli.SocialMeli.dto.UserDTO;
import com.SocialMeli.SocialMeli.repository.UserRepository;

public class TestUtilGenerator {

    public static UserRepository repo;

    public static UserDTO createUsers(){
        UserDTO userDTO = new UserDTO(null, "Camilo");
        UserDTO sellersDTO = repo.createSellers(userDTO);
        UserDTO buyerDTO = repo.createBuyers(userDTO);

        return buyerDTO;
    }
}
