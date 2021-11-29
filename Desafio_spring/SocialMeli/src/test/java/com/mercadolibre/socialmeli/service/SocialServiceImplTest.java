package com.mercadolibre.socialmeli.service;

import com.mercadolibre.socialmeli.dto.FollowersCountDTO;
import com.mercadolibre.socialmeli.dto.FollowersDTO;
import com.mercadolibre.socialmeli.dto.PublicationsFollowDTO;
import com.mercadolibre.socialmeli.dto.UserDTO;
import com.mercadolibre.socialmeli.exception.NotFoundException;
import com.mercadolibre.socialmeli.model.*;
import com.mercadolibre.socialmeli.repository.SocialRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class SocialServiceImplTest {

    @Mock
    SocialRepositoryImpl socialRepository;

    @InjectMocks
    SocialServiceImpl socialService;

    private static String EXPECT_EXCEPTONMESSAGE = "No se encontró el usuario";
    private static String ORDER_ASC = "order_asc";
    private static String ORDER_DESC = "order_desc";
    private static ModelMapper modelMapper;
    private static Followers followers;

    @BeforeAll
    public static void setUp(){
        modelMapper = new ModelMapper();
        followers = new Followers();
        List<User> followersList = new ArrayList<>();
        followersList.add(new User(2,"Pepe"));
        followersList.add(new User(1,"Maga"));
        followersList.add(new User(3,"Funalito"));

        followers.setId(4);
        followers.setName("Otro");
        followers.setUsers(followersList);
    }
    @Test
    void userByIdNotFound() {
        //Arrange
        UserDTO user = new UserDTO(1,"Maga");
        //Act
        Mockito.when(socialRepository.findUserById(user.getId())).thenReturn(null);
        Exception exception = assertThrows(NotFoundException.class,
                () -> socialService.getUserById(user.getId()));

        String currentMessage = exception.getMessage();

        Mockito.verify(socialRepository,Mockito.atLeastOnce()).findUserById(user.getId());
        Assertions.assertEquals(EXPECT_EXCEPTONMESSAGE,currentMessage);
    }

    @Test
    public void findUserById(){
        //Arrange
        User user = new User(1,"Maggy");
        UserDTO expect = modelMapper.map(user, UserDTO.class);
        //Act
        Mockito.when(socialRepository.findUserById(1)).thenReturn(user);
        UserDTO currentUser = socialService.getUserById(1);
        //Assert
        Assertions.assertEquals(expect,currentUser);
    }

    @Test
    void unfollowUserByIdWithNotFound() {
        //Arrange
        User user = new User(1,"Maga");
        User userUnfollow = new User(6,"Pepe");

        //Act
        Mockito.when(socialRepository.findUserById(user.getId())).thenReturn(user);
        Mockito.when(socialRepository.findUserById(userUnfollow.getId())).thenReturn(null);
        Exception exception = Assertions.assertThrows(NotFoundException.class,
                ()->socialService.unfollowUser(user.getId(),userUnfollow.getId()));
        //Assert
        Mockito.verify(socialRepository,Mockito.times(2))
                .findUserById(Mockito.anyInt());

        String currentMessage = exception.getMessage();
        Assertions.assertEquals(EXPECT_EXCEPTONMESSAGE,currentMessage);
    }

    @Test
    void unfollowUserById() {
        //Arrange
        User user = new User(1,"Maga");
        User userUnfollow = new User(6,"Pepe");

        //Act
        Mockito.when(socialRepository.findUserById(user.getId())).thenReturn(user);
        Mockito.when(socialRepository.findUserById(userUnfollow.getId())).thenReturn(userUnfollow);
        Mockito.when(socialRepository.unFollowUser(user.getId(),userUnfollow.getId())).thenReturn(true);
        boolean response = socialService.unfollowUser(user.getId(),userUnfollow.getId());
        //Assert
        Mockito.verify(socialRepository,Mockito.times(2))
                .findUserById(Mockito.anyInt());
         Mockito.verify(socialRepository,Mockito.times(1))
                 .unFollowUser(user.getId(),userUnfollow.getId());

        Assertions.assertTrue(response);
    }

    //Verificar que el tipo de ordenamiento alfabético exista (US-0008)
    @Test
    void orderAphabeticFollowers(){
        //Lo que espero
        List<User> expectedList = new ArrayList<>();
        expectedList.add(new User(3,"Fulanito"));
        expectedList.add(new User(1,"Maga"));
        expectedList.add(new User(2,"Pepe"));

        Followers expected= new Followers();
        expected.setId(4);
        expected.setName("Otro");
        expected.setUsers(expectedList);

        //Act
        Mockito.when(socialRepository.findUserById(4))
                .thenReturn(new User(expected.getId(),expected.getName()));
        Mockito.when(socialRepository.orderingUsersFollowers(followers.getId(), ORDER_ASC))
                .thenReturn(expected);
        FollowersDTO expectedDTO = modelMapper.map(expected,FollowersDTO.class);
        FollowersDTO currentDTO = socialService.orderingUsersFollowers(followers.getId(), ORDER_ASC);

        //Assert
        Mockito.verify(socialRepository,Mockito.times(1))
                .findUserById(4);
        Mockito.verify(socialRepository,Mockito.atLeastOnce())
                .orderingUsersFollowers(followers.getId(), ORDER_ASC);

        Assertions.assertEquals(expectedDTO,currentDTO);
    }

    @Test
    void orderAphabeticFollowersDesc(){
        //Arrange
        List<User> expectedList = new ArrayList<>();
        expectedList.add(new User(2,"Pepe"));
        expectedList.add(new User(1,"Maga"));
        expectedList.add(new User(3,"Fulanito"));

        Followers expected= new Followers();
        expected.setId(4);
        expected.setName("Otro");
        expected.setUsers(expectedList);

        //Act
        Mockito.when(socialRepository.findUserById(4))
                .thenReturn(new User(expected.getId(),expected.getName()));
        Mockito.when(socialRepository.orderingUsersFollowers(followers.getId(), ORDER_DESC))
                .thenReturn(expected);

        FollowersDTO expectedDTO = modelMapper.map(expected,FollowersDTO.class);
        FollowersDTO currentDTO = socialService.orderingUsersFollowers(followers.getId(), ORDER_DESC);

        //Assert
        Mockito.verify(socialRepository,Mockito.times(1))
                .findUserById(4);
        Mockito.verify(socialRepository,Mockito.atLeastOnce())
                .orderingUsersFollowers(followers.getId(), ORDER_DESC);

        Assertions.assertEquals(expectedDTO,currentDTO);
    }

    @Test
    void orderDateDesc(){
        //Arrange
        List<User> expectedList = new ArrayList<>();
        expectedList.add(new User(2,"Pepe"));
        expectedList.add(new User(1,"Maga"));
        expectedList.add(new User(3,"Fulanito"));

        Followers expected= new Followers();
        expected.setId(4);
        expected.setName("Otro");
        expected.setUsers(expectedList);

        //Act
        Mockito.when(socialRepository.findUserById(4))
                .thenReturn(new User(expected.getId(),expected.getName()));
        Mockito.when(socialRepository.orderingUsersFollowers(followers.getId(), ORDER_DESC))
                .thenReturn(expected);

        FollowersDTO expectedDTO = modelMapper.map(expected,FollowersDTO.class);
        FollowersDTO currentDTO = socialService.orderingUsersFollowers(followers.getId(), ORDER_DESC);

        //Assert
        Mockito.verify(socialRepository,Mockito.times(1))
                .findUserById(4);
        Mockito.verify(socialRepository,Mockito.atLeastOnce())
                .orderingUsersFollowers(followers.getId(), ORDER_DESC);

        Assertions.assertEquals(expectedDTO,currentDTO);
    }


    @Test
    void orderAphabeticFollowersNull(){
        //Arrange
        List<User> expectedList = new ArrayList<>();
        expectedList.add(new User(2,"Pepe"));
        expectedList.add(new User(1,"Maga"));
        expectedList.add(new User(3,"Fulanito"));

        Followers expected= new Followers();
        expected.setId(4);
        expected.setName("Otro");
        expected.setUsers(expectedList);

        //Act
        Mockito.when(socialRepository.findUserById(4))
                .thenReturn(new User(expected.getId(),expected.getName()));
        Mockito.when(socialRepository.orderingUsersFollowers(followers.getId(), null))
                .thenReturn(expected);
        FollowersDTO expectedDTO = modelMapper.map(expected,FollowersDTO.class);
        FollowersDTO currentDTO = socialService.orderingUsersFollowers(followers.getId(), null);

        //Assert
        Mockito.verify(socialRepository,Mockito.times(1))
                .findUserById(4);
        Mockito.verify(socialRepository,Mockito.atLeastOnce())
                .orderingUsersFollowers(followers.getId(), null);

        Assertions.assertEquals(expectedDTO,currentDTO);
    }

    @Test
    void countUserFollowers(){
        //Arrange
        User user = new User(1, "Maga");
        FollowersCountDTO expected = new FollowersCountDTO(1,"Maga",1);
        //Act
        Mockito.when(socialRepository.findUserById(1)).thenReturn(user);
        Mockito.when(socialRepository.countFollowers(1)).thenReturn(1L);

        FollowersCountDTO current = socialService.followersCount(1);
        //Assert
        Mockito.verify(socialRepository,Mockito.atLeastOnce()).findUserById(1);
        Mockito.verify(socialRepository,Mockito.times(1)).countFollowers(1);
        Assertions.assertEquals(expected,current);
    }

    @Test
    void latestPublications() {
        //Arrange
        //Creo productos publicados
        Product p1 = new Product(1,"papa","verdura","nose","marron","Papitas ricas");
        Product p3 = new Product(3,"Tomate","verdura","nose","Rojo","Tomates cherry");

        //Expect publications
        PublicationsFollowed pFollowedExpected = new PublicationsFollowed();
        List<Publication>publicationsExpected = new ArrayList<>();
        //El user Id es 0 porque no lo muestra en el response, entonces se carga valor default
        publicationsExpected.add(new Publication(0,2, LocalDate.of(2021,11,17), p3,1,80.00));
        publicationsExpected.add(new Publication(0,1, LocalDate.of(2021,11,25), p1,1,100.00));
        pFollowedExpected.setUserId(4);
        pFollowedExpected.setPosts(publicationsExpected);
        PublicationsFollowDTO pFollowDTOExpected = modelMapper.map(pFollowedExpected,PublicationsFollowDTO.class);
        User user = new User(4,"Otro");

        Mockito.when(socialRepository.findUserById(4)).thenReturn(user);
        Mockito.when( socialRepository.latestPublications(4)).thenReturn(pFollowedExpected);

        //Act
        PublicationsFollowDTO publicationsCurrent = socialService.latestPublications(4);

        //Asserts
        Mockito.verify(socialRepository,Mockito.atLeastOnce()).findUserById(4);
        Mockito.verify(socialRepository,Mockito.atLeastOnce()).latestPublications(4);
        Assertions.assertEquals(pFollowDTOExpected,publicationsCurrent);
    }


}