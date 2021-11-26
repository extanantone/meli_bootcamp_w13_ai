package meli.bootcamp.socialmeli.service;

import meli.bootcamp.socialmeli.dto.*;
import meli.bootcamp.socialmeli.exceptions.OrderTypeNotValidException;
import meli.bootcamp.socialmeli.exceptions.UserNotExistException;
import meli.bootcamp.socialmeli.mapper.PostMapper;
import meli.bootcamp.socialmeli.mapper.ProductMapper;
import meli.bootcamp.socialmeli.mapper.UserMapper;
import meli.bootcamp.socialmeli.model.Post;
import meli.bootcamp.socialmeli.model.User;
import meli.bootcamp.socialmeli.model.UserFollow;
import meli.bootcamp.socialmeli.repository.IPostRepository;
import meli.bootcamp.socialmeli.repository.IUSerFollowRepository;
import meli.bootcamp.socialmeli.repository.IUserRepository;
import meli.bootcamp.socialmeli.utils.TestUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@ExtendWith(MockitoExtension.class)
public class SocialMeliServiceTest {
    @Mock
    IUserRepository userRepository;

    @Mock
    IUSerFollowRepository userFollowRepository;

    @Mock
    IPostRepository postRepository;

    @InjectMocks
    SocialMeliService socialMeliService;

    PostMapper postMapper= Mappers.getMapper(PostMapper.class);
    ProductMapper productMapper= Mappers.getMapper(ProductMapper.class);
    UserMapper userMapper= Mappers.getMapper(UserMapper.class);

    @BeforeEach @AfterEach
    public void setUp(){
        ReflectionTestUtils.setField(
                postMapper,
                "productMapper",
                productMapper
        );

        this.socialMeliService= new SocialMeliService(
                userMapper,
                userRepository,
                userFollowRepository,
                postRepository,
                postMapper
        );
    }

    @Test
    public void followUserThatNotExist(){
        //Arrange
        User user1= TestUtils.createNewUserWithName("Pablo");
        User user2= TestUtils.createNewUserWithName("Juan");

        Mockito.when(
                userRepository.findUserById(user1.getUserId())
        ).thenReturn(user1);

        Mockito.when(
                userRepository.findUserById(user2.getUserId())
        ).thenThrow(UserNotExistException.class);

        //Act y Assert
        Assertions.assertThrows(
                UserNotExistException.class,
                () -> socialMeliService.followUser(user1.getUserId(), user2.getUserId()),
                "El usuario no existe pero se logro hacer la conexión");
    }

    @Test
    public void followUserThatExist(){
        //Arrange
        User user1= TestUtils.createNewUserWithName("Pablo");
        User user2= TestUtils.createNewUserWithName("Juan");
        UserFollow userFollow= new UserFollow(user1.getUserId(), user2.getUserId());

        Mockito.when(
                userRepository.findUserById(user1.getUserId())
        ).thenReturn(user1);

        Mockito.when(
                userRepository.findUserById(user2.getUserId())
        ).thenReturn(user2);

        Mockito.when(userFollowRepository.newUserFollow(
                user1.getUserId(), user2.getUserId()
        )).thenReturn(userFollow);


        //Act y Assert
        Assertions.assertDoesNotThrow(
                () -> socialMeliService.followUser(user1.getUserId(), user2.getUserId())
        );
        Mockito.verify(userRepository, Mockito.atLeastOnce()).findUserById(user1.getUserId());
        Mockito.verify(userRepository, Mockito.atLeastOnce()).findUserById(user2.getUserId());
    }

    @Test
    public void unFollowUserThatNotExist(){
        //Arrange
        User user1= TestUtils.createNewUserWithName("Pablo");
        User user2= TestUtils.createNewUserWithName("Juan");

        Mockito.when(
                userRepository.findUserById(user1.getUserId())
        ).thenReturn(user1);

        Mockito.when(
                userRepository.findUserById(user2.getUserId())
        ).thenThrow(UserNotExistException.class);

        //Act y Assert
        Assertions.assertThrows(
                UserNotExistException.class,
                () -> socialMeliService.followUser(user1.getUserId(), user2.getUserId()),
                "El usuario no existe pero se logro hacer la conexión");
    }

    @Test
    public void unFollowUserThatExist(){
        //Arrange
        User user1= TestUtils.createNewUserWithName("Pablo");
        User user2= TestUtils.createNewUserWithName("Juan");

        Mockito.when(
                userRepository.findUserById(user1.getUserId())
        ).thenReturn(user1);

        Mockito.when(
                userRepository.findUserById(user2.getUserId())
        ).thenReturn(user2);

        Mockito.when(
                userFollowRepository.checkUserFollow(user1.getUserId(), user2.getUserId())
        ).thenReturn(true);

        //Act y Assert
        Assertions.assertTrue(
                () -> socialMeliService.unfollowUser(user1.getUserId(), user2.getUserId())
        );

        Mockito.verify(userRepository, Mockito.atLeastOnce()).findUserById(user1.getUserId());
        Mockito.verify(userRepository, Mockito.atLeastOnce()).findUserById(user2.getUserId());
    }

    @Test
    public void checkThatNameAscInsensitiveCaseAlphabeticOrderTypeNotExist(){
        //Arrange
        User user= TestUtils.createNewUserWithName("Oscar");

        //Act & Assert
        Assertions.assertThrows(
                OrderTypeNotValidException.class,
                () -> socialMeliService.getOrderedFollowersList(
                        user.getUserId(),
                        false,
                        "nameAsc",
                        true
                ),
                "El tipo de orden no es valido pero entrego un resultado"
        );
    }

    @Test
    public void checkThatNameDescSensitiveCaseAlphabeticOrderTypeExist(){
        //Arrange
        User user= TestUtils.createNewUserWithName("ElSinNombre");
        FollowedListDTO followedListDTO= TestUtils.getNFollowedUserListToDTO(user, 3);
        List<UserFollow> listUserFollow= TestUtils.setUserFollowerRelationsByFollowedListDTO(followedListDTO);

        Mockito.when(userFollowRepository.getAllList()).thenReturn(listUserFollow);
        Mockito.when(userRepository.findUserById(user.getUserId())).thenReturn(user);

        System.out.println("Lista de seguidores desordenada para : " + user.getUserName() + " con id: " + user.getUserId());
        for (UserFollow userID: listUserFollow
        ) {
            String userName= TestUtils.getUserNameFromList(followedListDTO, userID);
            System.out.println(userID.getUserFollower() + " -> userName usuario que sigue: " + userName);
            Mockito.when(userRepository.getUserNameById(userID.getFollowedUser())).thenReturn(userName);
        }

        Mockito.when(userRepository.getUserNameById(user.getUserId())).thenReturn(user.getUserName());

        //Act
        FollowedListDTO tempFollowedList= (FollowedListDTO) socialMeliService.getOrderedFollowersList(
                user.getUserId(),
                false,
                "name_desc",
                true);

        //Assert
        Assertions.assertEquals(tempFollowedList.getUserName(), user.getUserName());
        System.out.println("\nLista de seguidores ordenada para : " + tempFollowedList.getUserName() +
                " con id: " + tempFollowedList.getUserId());
        for (UserDTO userID: tempFollowedList.getFollowed()
        ) {
            System.out.println(tempFollowedList.getUserId() + " -> userName usuario que sigue: " + userID.getUserName());
            Mockito.verify(userRepository, Mockito.atLeastOnce()).getUserNameById(userID.getUserID());
        }
    }

    @Test
    public void checkThatDateOrderTypeNotExist(){
        //Arrange
        User user= TestUtils.createNewUserWithName("Oscar");

        //Act & Assert
        Assertions.assertThrows(
                OrderTypeNotValidException.class,
                () -> socialMeliService.listSortedPostByUserID(
                        user.getUserId(),
                        "NaMEAsc"
                ),
                "El tipo de orden no es valido pero entrego un resultado"
        );
    }

    @Test
    public void checkDateAscDateOrderTypeExistAndGetSortedList(){
        //Arrange
        User user= TestUtils.createNewUserWithName("Arnulfo");
        FollowedListDTO followedListDTO= TestUtils.getNFollowedUserListToDTO(user, 3);
        List<UserFollow> listUserFollow= TestUtils.setUserFollowerRelationsByFollowedListDTO(followedListDTO);

        List<Post> tempListPost= TestUtils.setTwoProductsForAllFollowedUser(followedListDTO);

        Mockito.when(userFollowRepository.getAllList()).thenReturn(listUserFollow);
        Mockito.when(postRepository.getAllList()).thenReturn(tempListPost);
        Mockito.when(userRepository.findUserById(user.getUserId())).thenReturn(user);
        Mockito.when(userRepository.findUserById(user.getUserId())).thenReturn(user);

        System.out.println("Lista de productos del seguidor desordenada para " + followedListDTO.getUserName() +
                " con id: " + followedListDTO.getUserId());
        //Post tempPost= (userID) ->
        for (UserFollow userFollow : listUserFollow) {
            System.out.println("Usuario " + userFollow.getFollowedUser());
                    List<Post> tempPost= tempListPost.stream()
                    .filter(post -> post.getUserId() == userFollow.getFollowedUser())
                    .collect(Collectors.toList());
            System.out.println("Producto: ID -> " + tempPost.get(0).getPostId() +
                    " con nombre de producto -> " + tempPost.get(0).getDetail().getProductName() +
                    " y con fecha de publicación -> " + tempPost.get(0).getDate().toString());
            System.out.println("Producto: ID -> " + tempPost.get(1).getPostId() +
                    " con nombre de producto -> " + tempPost.get(1).getDetail().getProductName() +
                    " y con fecha de publicación -> " + tempPost.get(1).getDate().toString());
        }

        //Act
        ProductsUserIDListDTO productsUserIDListDTO= socialMeliService.listSortedPostByUserID(
                        user.getUserId(),
                        "date_asc"
                );

        //Assert
        Assertions.assertEquals(
                productsUserIDListDTO.getPost().size(),
                tempListPost.stream()
                    .filter(post ->  LocalDate.now().minusWeeks(2).compareTo(post.getDate()) < 0)
                    .count()
        );
        System.out.println("Fecha de hoy hace dos semanas: ");
        System.out.println(LocalDate.now().minusWeeks(2));
        System.out.println("\nUsuario seguidor: " + productsUserIDListDTO.getUserId());
        System.out.println("Publicaciones de las ultimas dos semanas de las cuentas seguidas: ");
        productsUserIDListDTO.getPost().forEach(System.out::println);
    }

    @Test
    public void checkIfFollowersCountIsAssert(){
        //Arrange
        User user= TestUtils.createNewUserWithName("Arnulfo");
        FollowersListDTO followersListDTO= TestUtils.getNFollowersUserListToDTO(user, 9);
        List<UserFollow> listUserFollow= TestUtils.setUserFollowerRelationsByFollowersListDTO(followersListDTO);

        Mockito.when(userFollowRepository.listUserFollowersByID(user.getUserId())).thenReturn(listUserFollow);
        Mockito.when(userRepository.findUserById(user.getUserId())).thenReturn(user);
        Mockito.when(userRepository.findUserById(user.getUserId())).thenReturn(user);

        //Act
        FollowersCountDTO followersCountDTO= socialMeliService.getFollowersCount(user.getUserId());

        //Assert
        Assertions.assertEquals(followersCountDTO.getFollowersCount(), listUserFollow.size());
    }

    @Test
    public void unFollowUserThatExistButNotFollowsUser(){
        //Arrange
        User followerUser= TestUtils.createNewUserWithName("Pablo");
        User userToFollow= TestUtils.createNewUserWithName("Juan");
        UserFollow userFollow= new UserFollow(followerUser.getUserId(), userToFollow.getUserId());

        Mockito.when(
                userRepository.findUserById(followerUser.getUserId())
        ).thenReturn(followerUser);

        Mockito.when(
                userRepository.findUserById(userToFollow.getUserId())
        ).thenReturn(userToFollow);

        Mockito.when(
                userFollowRepository.newUserFollow(followerUser.getUserId(), userToFollow.getUserId())
        ).thenReturn(userFollow);

        //
        UserFollow think= socialMeliService.followUser(followerUser.getUserId(), userToFollow.getUserId());

        //Act y Assert
        Assertions.assertEquals(think, userFollow);

        Mockito.verify(userRepository, Mockito.atLeastOnce()).findUserById(followerUser.getUserId());
        Mockito.verify(userRepository, Mockito.atLeastOnce()).findUserById(userToFollow.getUserId());
    }

}
