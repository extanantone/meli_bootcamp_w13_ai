package meli.bootcamp.socialmeli.service;

import meli.bootcamp.socialmeli.dto.FollowedListDTO;
import meli.bootcamp.socialmeli.dto.UserDTO;
import meli.bootcamp.socialmeli.exceptions.OrderTypeNotValidException;
import meli.bootcamp.socialmeli.exceptions.UserNotExistException;
import meli.bootcamp.socialmeli.mapper.UserMapper;
import meli.bootcamp.socialmeli.model.User;
import meli.bootcamp.socialmeli.model.UserFollow;
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

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class SocialMeliServiceTest {
    @Mock
    IUserRepository userRepository;

    @Mock
    IUSerFollowRepository userFollowRepository;

    @InjectMocks
    SocialMeliService socialMeliService;

    UserMapper userMapper= Mappers.getMapper(UserMapper.class);

    @BeforeEach @AfterEach
    public void setUp(){
        this.socialMeliService= new SocialMeliService(userMapper, userRepository, userFollowRepository);
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
        System.out.println("Lista de seguidores ordenada para : " + tempFollowedList.getUserName() +
                " con id: " + tempFollowedList.getUserId());
        for (UserDTO userID: tempFollowedList.getFollowed()
        ) {
            System.out.println(tempFollowedList.getUserId() + " -> userName usuario que sigue: " + userID.getUserName());
            Mockito.verify(userRepository, Mockito.atLeastOnce()).getUserNameById(userID.getUserID());
        }
    }

    @Test
    public void checkThatDateOrderTypeExist(){
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
}
