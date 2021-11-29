package com.example.SocialMeli.service;

import com.example.SocialMeli.dto.*;
import com.example.SocialMeli.exceptions.UserNotFoundException;
import com.example.SocialMeli.model.Product;
import com.example.SocialMeli.model.Publication;
import com.example.SocialMeli.model.User;
import com.example.SocialMeli.repository.SocialRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.annotation.Description;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class SocialServiceTest {

    User user1;
    User user2;
    User user3;
    User user4;

    Product product1;
    Product product2;
    Product product3;
    Product product4;
    Product productPromo1;
    Product productPromo2;
    Publication publication1;
    Publication publication2;
    Publication publication3;
    Publication publication4;
    Publication publicationPromo1;
    Publication publicationPromo2;

    @Mock
    SocialRepository socialRepository;

    @InjectMocks
    SocialService socialService;

    @BeforeEach
    void setUp(){
        user1 = new User(1,"Diego", new ArrayList<>(),new ArrayList<>(), new ArrayList<>());
        user2 = new User(2,"Pepe", new ArrayList<>(),new ArrayList<>(), new ArrayList<>());
        user3 = new User(3,"Luisa", new ArrayList<>(),new ArrayList<>(), new ArrayList<>());
        user4 = new User(4,"Jose", new ArrayList<>(),new ArrayList<>(), new ArrayList<>());

        product1 = new Product(1, "Tenis", "Sport","Racer","Blue","Special");
        product2 = new Product(1, "Celular", "Sport","Racer","Blue","Special");
        product3 = new Product(1, "Monitor", "Sport","Racer","Blue","Special");
        product4 = new Product(1, "Teclado", "Sport","Racer","Blue","Special");
        productPromo1 = new Product(1, "Mouse", "Sport","Racer","Blue","Special");
        productPromo2 = new Product(1, "Portatil", "Sport","Racer","Blue","Special");
        publication1 = new Publication(1,1, LocalDate.parse(LocalDate.now().minusWeeks(1).toString()),product1,10,25,false,0);
        publication2 = new Publication(1,2, LocalDate.parse(LocalDate.now().minusWeeks(1).minusDays(1).toString()),product2,10,25,false,0);
        publication3 = new Publication(1,3, LocalDate.parse(LocalDate.now().minusWeeks(3).toString()),product3,10,25,false,0);
        publication4 = new Publication(1,4, LocalDate.parse(LocalDate.now().minusWeeks(3).minusDays(1).toString()),product4,10,25,false,0);
        publicationPromo1 = new Publication(1,1, LocalDate.parse(LocalDate.now().minusWeeks(1).toString()),productPromo1,10,25,true,0.25);
        publicationPromo2 = new Publication(1,2, LocalDate.parse(LocalDate.now().minusWeeks(1).minusDays(1).toString()),productPromo2,10,25,true,0.5);

    }

    @Test
    @Description(value = "T-0001 Seguir a usuario y generar excepcion de que no exista")
    void getUsersIdThenThrowUserNotFoundExceptionWhenFollow() {
    //  arrange
        int userId1 = 1;
        int userId2 = 2;

        Mockito.when(socialRepository.findUser(userId1))
                .thenReturn(Optional.of(user1));
        Mockito.when(socialRepository.findUser(userId2))
                .thenReturn(Optional.empty());
    //act & assert
        Assertions.assertThrows(UserNotFoundException.class, () -> socialService.followUser(userId1,userId2));
    }

    @Test
    @Description(value = "T-0001 Seguir a usuario y continuar flujo correctamente")
    void getUsersIdThenReturnNothingWhenFollow() {
        //  arrange
        int userId1 = 1;
        int userId2 = 2;

        Mockito.when(socialRepository.findUser(userId1))
                .thenReturn(Optional.of(user1));
        Mockito.when(socialRepository.findUser(userId2))
                .thenReturn(Optional.of(user2));
        //act & assert
        Assertions.assertDoesNotThrow(() -> socialService.followUser(userId1,userId2));
    }

    @Test
    @Description(value = "T-0002 Dejar de seguir a usuario y generar excepcion de que no exista")
    void getUsersIdThenThrowUserNotFoundExceptionWhenUnfollow() {
        //  arrange
        int userId1 = 1;
        int userId2 = 2;

        //act
        Mockito.when(socialRepository.findUser(userId1))
                .thenReturn(Optional.of(user1));
        Mockito.when(socialRepository.findUser(userId2))
                .thenReturn(Optional.empty());
        //act & assert
        Assertions.assertThrows(UserNotFoundException.class, () -> socialService.unfollowUser(userId1,userId2));
    }

    @Test
    @Description(value = "T-0002 Dejar de seguir a usuario y continuar flujo correctamente")
    void getUsersIdThenReturnNothingWhenUnfollow() {
        //  arrange
        int userId1 = 1;
        int userId2 = 2;
        user1.addFollowed(user2);
        user2.addFollower(user1);
        //act
        Mockito.when(socialRepository.findUser(userId1))
                .thenReturn(Optional.of(user1));

        Mockito.when(socialRepository.findUser(userId2))
                .thenReturn(Optional.of(user2));
        //act & assert
        Mockito.doNothing().when(socialRepository).unfollowUser(user1, user2);
        //socialRepository.unfollowUser(user1,user2);
        Assertions.assertDoesNotThrow(() -> socialService.unfollowUser(userId1,userId2));
    }


    @Test
    @Description(value = "T-0004 Correcto funcionamiento de obtener followers ordenados ascendentemente")
    void getUserIdThenReturnFollowersOrderAsc(){
        //arrange
        user1.addFollower(user2);
        user1.addFollower(user3);
        user1.addFollower(user4);

        List<User> userExpect = new ArrayList<>();
        userExpect.add(user4);
        userExpect.add(user3);
        userExpect.add(user2);

        //act
        Mockito.when(socialRepository.findUser(user1.getUserId()))
                .thenReturn(Optional.of(user1));
        UserFollowDto userActual = socialService.listFollowers(user1.getUserId(), "name_asc");

        List<String> nombresActual = userActual.getFollowers().stream().map(UserDto::getUserName).collect(Collectors.toList());
        List<String> nombresExpect = userExpect.stream().map(User::getUserName).collect(Collectors.toList());
        //assert
        Assertions.assertEquals(nombresExpect,nombresActual);

    }

    @Test
    @Description(value = "T-0004 Correcto funcionamiento de obtener followers ordenados descendentemente")
    void getUserIdThenReturnFollowersOrderDesc(){
        //arrange
        user1.addFollower(user4);
        user1.addFollower(user3);
        user1.addFollower(user2);

        List<User> userExpect = new ArrayList<>();
        userExpect.add(user2);
        userExpect.add(user3);
        userExpect.add(user4);

        //act
        Mockito.when(socialRepository.findUser(user1.getUserId()))
                .thenReturn(Optional.of(user1));
        UserFollowDto userActual = socialService.listFollowers(user1.getUserId(), "name_desc");

        List<String> nombresActual = userActual.getFollowers().stream().map(UserDto::getUserName).collect(Collectors.toList());
        List<String> nombresExpect = userExpect.stream().map(User::getUserName).collect(Collectors.toList());
        //assert
        Assertions.assertEquals(nombresExpect,nombresActual);
    }

    @Test
    @Description(value = "T-0004 Correcto funcionamiento de obtener followed ordenados ascendentemente")
    void getUserIdThenReturnFollowedOrderAsc(){
        //arrange
        user1.addFollowed(user2);
        user1.addFollowed(user3);
        user1.addFollowed(user4);

        List<User> userExpect = new ArrayList<>();
        userExpect.add(user4);
        userExpect.add(user3);
        userExpect.add(user2);

        //act
        Mockito.when(socialRepository.findUser(user1.getUserId()))
                .thenReturn(Optional.of(user1));
        UserFollowDto userActual = socialService.listFollowed(user1.getUserId(), "name_asc");

        List<String> nombresActual = userActual.getFollowed().stream().map(UserDto::getUserName).collect(Collectors.toList());
        List<String> nombresExpect = userExpect.stream().map(User::getUserName).collect(Collectors.toList());
        //assert
        Assertions.assertEquals(nombresExpect,nombresActual);

    }

    @Test
    @Description(value = "T-0004/T-0003 Correcto funcionamiento de obtener followed ordenados descendentemente")
    void getUserIdThenReturnFollowedOrderDesc(){
        //arrange
        user1.addFollowed(user2);
        user1.addFollowed(user3);
        user1.addFollowed(user4);

        List<User> userExpect = new ArrayList<>();
        userExpect.add(user2);
        userExpect.add(user3);
        userExpect.add(user4);

        //act
        Mockito.when(socialRepository.findUser(user1.getUserId()))
                .thenReturn(Optional.of(user1));
        UserFollowDto userActual = socialService.listFollowed(user1.getUserId(), "name_desc");

        List<String> nombresActual = userActual.getFollowed().stream().map(UserDto::getUserName).collect(Collectors.toList());
        List<String> nombresExpect = userExpect.stream().map(User::getUserName).collect(Collectors.toList());
        //assert
        Assertions.assertEquals(nombresExpect,nombresActual);

    }

    @Test
    @Description(value = "T-0006/T-0005 Correcto funcionamiento de ordenamiento por fecha ascendente")
    void getUserIdThenReturnPostsOrderAsc() {
        //arrange
        user1.addPublication(publication1);
        user1.addPublication(publication2);
        user1.addPublication(publication3);
        user1.addPublication(publication4);
        user2.addFollowed(user1);

        ProductDto productDto1 = new ProductDto(1, "Tenis", "Sport","Racer","Blue","Special");
        ProductDto productDto2 = new ProductDto(1, "Celular", "Sport","Racer","Blue","Special");
        PublicationDto publicationDto1 = new PublicationDto(0,1, LocalDate.now().minusWeeks(1).toString(),productDto1,10,25,false,0);
        PublicationDto publicationDto2 = new PublicationDto(0,2,LocalDate.now().minusWeeks(1).minusDays(1).toString(),productDto2,10,25,false,0);

        UserDto userDto = new UserDto();
        userDto.setUserId(user2.getUserId());
        userDto.addPublication(publicationDto2);
        userDto.addPublication(publicationDto1);

        //act
        Mockito.when(socialRepository.findUser(user2.getUserId()))
                .thenReturn(Optional.of(user2));

        UserDto userActual = socialService.getProductsFollowed(user2.getUserId(),"date_asc");
        //assert

        Assertions.assertEquals(userDto, userActual);
    }

    @Test
    @Description(value = "T-0006/T-0008 Correcto funcionamiento de ordenamiento por fecha descendente")
    void getUserIdThenReturnPostsOrderDesc() {
        //arrange
        user1.addPublication(publication1);
        user1.addPublication(publication2);
        user1.addPublication(publication3);
        user1.addPublication(publication4);
        user2.addFollowed(user1);

        ProductDto productDto1 = new ProductDto(1, "Tenis", "Sport","Racer","Blue","Special");
        ProductDto productDto2 = new ProductDto(1, "Celular", "Sport","Racer","Blue","Special");
        PublicationDto publicationDto1 = new PublicationDto(0,1, LocalDate.now().minusWeeks(1).toString(),productDto1,10,25,false,0);
        PublicationDto publicationDto2 = new PublicationDto(0,2,LocalDate.now().minusWeeks(1).minusDays(1).toString(),productDto2,10,25,false,0);

        UserDto userDto = new UserDto();
        userDto.setUserId(user2.getUserId());
        userDto.addPublication(publicationDto1);
        userDto.addPublication(publicationDto2);

        //act
        Mockito.when(socialRepository.findUser(user2.getUserId()))
                .thenReturn(Optional.of(user2));

        UserDto userActual = socialService.getProductsFollowed(user2.getUserId(),"date_desc");
        //assert

        Assertions.assertEquals(userDto, userActual);
    }

    @Test
    @Description(value = "T-0007/T-0008 Verificar que la cantidad de seguidores de un usuario sea la correcta")
    void getUserIdThenReturnNumberOfFollowers() {
        //arrange
        Mockito.when(socialRepository.findUser(user1.getUserId()))
                .thenReturn(Optional.of(user1));

        user1.addFollower(user2);
        user1.addFollower(user3);
        user1.addFollower(user4);

        //act
        UserDataDto userActual = socialService.countFollowers(user1.getUserId());
        //assert
        Assertions.assertEquals(3,userActual.getFollowers_count());
    }

    @Test
    @Description(value = "T-0009 Devuelve las publicaciones en promoción de un vendedor")
    void getUserIdThenReturnPublicationsWithPromo() {
        //arrange

        user1.addPublication(publicationPromo1);
        user1.addPublication(publicationPromo2);
        user1.addPublication(publication1);
        user1.addPublication(publication2);

        ProductDto productPromoDto1 = new ProductDto(1, "Mouse", "Sport","Racer","Blue","Special");
        ProductDto productPromoDto2 = new ProductDto(1, "Portatil", "Sport","Racer","Blue","Special");
        PublicationDto publicationPromoDto1 = new PublicationDto(0,1, LocalDate.parse(LocalDate.now().minusWeeks(1).toString()).toString(),productPromoDto1,10,25,true,0.25);
        PublicationDto publicationPromoDto2 = new PublicationDto(0,2, LocalDate.parse(LocalDate.now().minusWeeks(1).minusDays(1).toString()).toString(),productPromoDto2,10,25,true,0.5);


        Mockito.when(socialRepository.findUser(user1.getUserId()))
                .thenReturn(Optional.of(user1));

        UserDto userExpected = new UserDto();
        userExpected.setUserId(user1.getUserId());
        userExpected.setUserName(user1.getUserName());
        userExpected.addPublication(publicationPromoDto1);
        userExpected.addPublication(publicationPromoDto2);

        //act
        UserDto userActual = socialService.getPublicationsPromo(user1.getUserId(), "name_asc");
        //assert
        Assertions.assertEquals(userExpected,userActual);
    }

}