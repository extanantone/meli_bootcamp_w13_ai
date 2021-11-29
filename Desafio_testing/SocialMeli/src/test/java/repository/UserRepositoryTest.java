package repository;

import com.SocialMeli.SocialMeli.dto.*;
import com.SocialMeli.SocialMeli.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryTest {

    UserRepository repo = new UserRepository();

    @Test
    @DisplayName("T-0000 Crear un usuario vendedor")
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
    @DisplayName("T-0000 Falla al crear un usuario vendedor.  Retorna un null.")
    void userSellerDontCreate(){
        // Arrange
        UserDTO userDTO = new UserDTO();
        userDTO.setUser_id(1);
        userDTO.setUser_name("Camilo");

        // Act
        UserDTO current = repo.createSellers(userDTO);

        // Assert
        Assertions.assertNull(current.getUser_id());
    }


    @Test
    @DisplayName("T-0000 Verificar si existe un vendedor por el ID")
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


    @Test
    @DisplayName("T-0000 Verificar un vendedor que no existe por el ID.  Retorna un null.")
    void userSellerDontExist(){
        // Arrange
        Integer user_id = 100;

        // Act
        SellersDTO current = repo.findSellerByUserId(user_id);

        // Assert
        Assertions.assertNull(current);
    }


    @Test
    @DisplayName("T-0000 Verificar si existe un comprador por el ID")
    void userBuyerExist(){
        // Arrange
        Integer user_id = 1;
        UserDTO userDTO = new UserDTO(null, "Camilo");
        UserDTO buyerDTO = repo.createBuyers(userDTO);

        // Act
        BuyersDTO current = repo.findBuyerByUserId(user_id);

        // Assert
        Assertions.assertEquals(buyerDTO,current);
    }


    @Test
    @DisplayName("T-0000 Verificar un comprador que no existe por el ID. Retorna un null.")
    void userBuyerDontExist(){
        // Arrange
        Integer user_id = 100;

        // Act
        BuyersDTO current = repo.findBuyerByUserId(user_id);

        // Assert
        Assertions.assertNull(current);
    }


    // En dado caso que cualquiera de los dos usuarios no exista
    // o ya se estén siguiendo, se retornará un false.
    @Test
    @DisplayName("T-0001 Seguimiento exitoso de los usuarios")
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
    // o ya se estén siguiendo, se retornará un false.
    @Test
    @DisplayName("T-0001 Seguimiento sin éxito de los usuarios")
    void userFollowedWithoutSuccess(){
        // Arrange
        Integer user_id = 100;
        UserDTO userDTO = new UserDTO(null, "Camilo");
        repo.createSellers(userDTO);
        UserDTO buyerDTO = repo.createBuyers(userDTO);

        // Act
        Boolean followStatus = repo.follow(buyerDTO.getUser_id(), user_id);

        // Assert
        Assertions.assertFalse(followStatus);
    }


    // En dado caso que cualquiera de los dos usuarios no exista
    // o no se hayan seguido, se retornará un false.
    @Test
    @DisplayName("T-0002 Dejar de seguir un usuario exitosamente")
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

    // En dado caso que cualquiera de los dos usuarios no exista
    // o no se hayan seguido, se retornará un false.
    @Test
    @DisplayName("T-0002 Dejar de seguir un usuario  sin éxito.")
    void userUnfollowedWithoutSuccess(){
        // Arrange
        Integer user_id = 10;
        UserDTO userDTO = new UserDTO(null, "Camilo");
        UserDTO sellersDTO = repo.createSellers(userDTO);
        UserDTO buyerDTO = repo.createBuyers(userDTO);
        repo.follow(buyerDTO.getUser_id(), sellersDTO.getUser_id());

        // Act
        Boolean followStatus = repo.unfollow(buyerDTO.getUser_id(), user_id);

        // Assert
        Assertions.assertFalse(followStatus);
    }


    // Siempre va a retornar el usuario sin importar si le envìas o no el order
    // al igual si el usuario escribe mal el order
    @Test
    @DisplayName("T-0003 Verificando el ordenamiento alfabético con valor para el parámetro order")
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
    @DisplayName("T-0003 Verificando el ordenamiento alfabetico sin valor para el parámetro order")
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
    @DisplayName("T-0004 Verificar ordenamiento alfabetico de los followers ascendentemente")
    void checkingSortedAlphaAscSellers(){
        // Arrange
        String order = "name_asc";
        Integer user_id = 1;
        UserDTO userDTO = new UserDTO(null, "Camilo");
        repo.createSellers(userDTO);
        UserDTO follower1 = new UserDTO(null, "Vanesa");
        repo.createBuyers(follower1);
        follower1.setUser_id(1);
        UserDTO follower2 = new UserDTO(null, "Ana");
        repo.createBuyers(follower2);
        follower2.setUser_id(2);
        UserDTO follower3 = new UserDTO(null, "Martín");
        repo.createBuyers(follower3);
        follower3.setUser_id(3);
        
        repo.follow(1,1);
        repo.follow(2,1);
        repo.follow(3,1);

        List<UserDTO> userDTOList = new ArrayList<>();
        userDTOList.add(follower2);
        userDTOList.add(follower3);
        userDTOList.add(follower1);
        
        
        // Act
        SellersDTO sellersDTO = repo.followersListSorted(user_id, order);

        // Assert
        Assertions.assertEquals(userDTOList, sellersDTO.getFollowers());

    }


    @Test
    @DisplayName("T-0004 Verificar ordenamiento alfabetico de los followers descendentemente")
    void checkingSortedAlphaDescSellers(){
        // Arrange
        String order = "name_desc";
        Integer user_id = 1;
        UserDTO userDTO = new UserDTO(null, "Camilo");
        repo.createSellers(userDTO);
        UserDTO follower1 = new UserDTO(null, "Vanesa");
        repo.createBuyers(follower1);
        follower1.setUser_id(1);
        UserDTO follower2 = new UserDTO(null, "Ana");
        repo.createBuyers(follower2);
        follower2.setUser_id(2);
        UserDTO follower3 = new UserDTO(null, "Martín");
        repo.createBuyers(follower3);
        follower3.setUser_id(3);

        repo.follow(1,1);
        repo.follow(2,1);
        repo.follow(3,1);

        List<UserDTO> userDTOList = new ArrayList<>();
        userDTOList.add(follower1);
        userDTOList.add(follower3);
        userDTOList.add(follower2);


        // Act
        SellersDTO sellersDTO = repo.followersListSorted(user_id, order);

        // Assert
        Assertions.assertEquals(userDTOList, sellersDTO.getFollowers());

    }

    @Test
    @DisplayName("T-0004 Verificar ordenamiento alfabetico de los followeds ascendentemente")
    void checkingSortedAlphaAscBuyers(){
        // Arrange
        String order = "name_asc";
        Integer user_id = 1;
        UserDTO userDTO = new UserDTO(null, "Camilo");
        repo.createBuyers(userDTO);
        UserDTO followed1 = new UserDTO(null, "Vanesa");
        repo.createSellers(followed1);
        followed1.setUser_id(1);
        UserDTO followed2 = new UserDTO(null, "Ana");
        repo.createSellers(followed2);
        followed2.setUser_id(2);
        UserDTO followed3 = new UserDTO(null, "Martín");
        repo.createSellers(followed3);
        followed3.setUser_id(3);

        repo.follow(1,1);
        repo.follow(1,2);
        repo.follow(1,3);

        List<UserDTO> userDTOList = new ArrayList<>();
        userDTOList.add(followed2);
        userDTOList.add(followed3);
        userDTOList.add(followed1);


        // Act
        BuyersDTO sellersDTO = repo.followedListSorted(user_id, order);

        // Assert
        Assertions.assertEquals(userDTOList, sellersDTO.getFollowed());

    }


    @Test
    @DisplayName("T-0005 Ordenamiento por fecha con parámetro de order")
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
    @DisplayName("T-0005 Ordenamiento por fecha sin parámetro de order")
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


    @Test
    @DisplayName("T-0006 Verificar ordenamiento por fecha de los posts ascendentemente")
    void checkingSortedDateAscSellers(){
        // Arrange
        String order = "date_asc";
        Integer user_id = 1;
        UserDTO userDTO = new UserDTO(null, "Camilo");
        repo.createSellers(userDTO);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        PostDTO postDTO = new PostDTO(1,LocalDate.parse("20/11/2021",formatter),1,123.89,null);
        PostUserDTO postUserDTO = new PostUserDTO(user_id, postDTO);
        repo.createPost(postUserDTO);

        PostDTO postDTO2 = new PostDTO(2,LocalDate.parse("29/11/2021",formatter),2,234.65,null);
        PostUserDTO postUserDTO2 = new PostUserDTO(user_id, postDTO2);
        repo.createPost(postUserDTO2);

        PostDTO postDTO3 = new PostDTO(3,LocalDate.parse("25/11/2021",formatter),2,234.65,null);
        PostUserDTO postUserDTO3 = new PostUserDTO(user_id, postDTO3);
        repo.createPost(postUserDTO3);

        List<PostDTO> postDTOList = new ArrayList<>();
        postDTOList.add(postDTO);
        postDTOList.add(postDTO3);
        postDTOList.add(postDTO2);


        // Act
        PostListDTO postListDTO = repo.postList(user_id, order);

        // Assert
        Assertions.assertEquals(postDTOList, postListDTO.getPosts());

    }

    @Test
    @DisplayName("T-0006 Verificar ordenamiento por fecha de los post descendentemente")
    void checkingSortedDateDescSellers(){
        // Arrange
        String order = "date_desc";
        Integer user_id = 1;
        UserDTO userDTO = new UserDTO(null, "Camilo");
        repo.createSellers(userDTO);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        PostDTO postDTO = new PostDTO(1,LocalDate.parse("20/11/2021",formatter),1,123.89,null);
        PostUserDTO postUserDTO = new PostUserDTO(user_id, postDTO);
        repo.createPost(postUserDTO);

        PostDTO postDTO2 = new PostDTO(2,LocalDate.parse("29/11/2021",formatter),2,234.65,null);
        PostUserDTO postUserDTO2 = new PostUserDTO(user_id, postDTO2);
        repo.createPost(postUserDTO2);

        PostDTO postDTO3 = new PostDTO(3,LocalDate.parse("25/11/2021",formatter),2,234.65,null);
        PostUserDTO postUserDTO3 = new PostUserDTO(user_id, postDTO3);
        repo.createPost(postUserDTO3);

        List<PostDTO> postDTOList = new ArrayList<>();
        postDTOList.add(postDTO2);
        postDTOList.add(postDTO3);
        postDTOList.add(postDTO);


        // Act
        PostListDTO postListDTO = repo.postList(user_id, order);

        // Assert
        Assertions.assertEquals(postDTOList, postListDTO.getPosts());

    }



    @Test
    @DisplayName("T-0007 Verificando que la cantidad de seguidores sea la correcta")
    void checkingAmountFollowersFromSellers(){
        // Arrange
        Integer user_id = 1;
        UserDTO userDTO = new UserDTO(null, "Camilo");
        repo.createSellers(userDTO);
        repo.createBuyers(new UserDTO(null, "Vanesa"));
        repo.createBuyers(new UserDTO(null, "Ana"));
        repo.createBuyers(new UserDTO(null, "Martín"));

        repo.follow(1,1);
        repo.follow(2,1);
        repo.follow(3,1);


        // Act
        FollowersCountDTO sellersDTO = repo.followersCount(user_id);

        // Assert
        Assertions.assertEquals(3, sellersDTO.getFollowers_count());

    }

    @Test
    @DisplayName("T-0008 Verificando los últimos posts de un vendedor de las últimas 2 semanas")
    void checkingLastDatePostsByUser(){
        // Arrange
        String order = "date_asc";
        Integer user_id = 1;
        UserDTO userDTO = new UserDTO(null, "Camilo");
        repo.createSellers(userDTO);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        PostUserDTO postUserDTO = new PostUserDTO();
        postUserDTO.setUser_id(user_id);
        postUserDTO.setDate(LocalDate.parse("29/11/2021",formatter));
        postUserDTO.setId_post(1);
        postUserDTO.setCategory(1);
        postUserDTO.setPrice(123.89);
        repo.createPost(postUserDTO);

        PostUserDTO postUserDTO2 = new PostUserDTO();
        postUserDTO2.setUser_id(user_id);
        postUserDTO2.setDate(LocalDate.parse("25/11/2021",formatter));
        postUserDTO2.setId_post(1);
        postUserDTO2.setCategory(1);
        postUserDTO2.setPrice(123.89);
        repo.createPost(postUserDTO2);


        // Este post no deberìa de contarse porque tiene una fecha muy vieja
        PostUserDTO postUserDTO3 = new PostUserDTO();
        postUserDTO3.setUser_id(user_id);
        postUserDTO3.setDate(LocalDate.parse("25/10/2021",formatter));
        postUserDTO3.setId_post(1);
        postUserDTO3.setCategory(1);
        postUserDTO3.setPrice(123.89);
        repo.createPost(postUserDTO3);

        // Act
        PostListDTO postListDTO = repo.postList(user_id, order);

        // Assert
        //Assertions.assertNotNull(postListDTO);
        Assertions.assertEquals(2,postListDTO.getPosts().size());

    }


}
