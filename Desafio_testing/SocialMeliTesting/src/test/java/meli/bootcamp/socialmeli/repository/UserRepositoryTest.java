package meli.bootcamp.socialmeli.repository;

import meli.bootcamp.socialmeli.exceptions.UserNotExistException;
import meli.bootcamp.socialmeli.exceptions.UserNotFollowsException;
import meli.bootcamp.socialmeli.mapper.PostMapper;
import meli.bootcamp.socialmeli.model.Post;
import meli.bootcamp.socialmeli.model.User;
import meli.bootcamp.socialmeli.utils.TestUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class UserRepositoryTest {
    IUserRepository userRepository;

    //Preguntar por la mockeadera en este repo.

    @BeforeEach @AfterEach
    public void setUp(){
        TestUtils.emptyObjectFile("user");
        this.userRepository= new UserRepository();
    }

    @Test
    public void createNewUser(){
        //Arrange
        User user= TestUtils.createNewUserWithName("Juan");

        //Act
        userRepository.addUser(user);

        //Assert
        Assertions.assertEquals(userRepository.getUserNameById(user.getUserId()), user.getUserName());
    }

    @Test
    public void deleteExistingUser(){
        //Arrange
        User user= TestUtils.createNewUserWithName("Juan");
        userRepository.addUser(user);

        //Act
        userRepository.deleteUser(user.getUserId());

        //Assert
        Assertions.assertThrows(
                UserNotExistException.class,
                () -> userRepository.getUserNameById(user.getUserId()),
                "El usuario no ha sido eliminado");
    }

    @Test
    public void findUSerPreviouslyInserted(){
        //Arrange
        IUserRepository iUserRepository= Mockito.mock(UserRepository.class);;
        User user= TestUtils.createNewUserWithName("Juan");
        Mockito.when(iUserRepository.findUserById(user.getUserId())).thenReturn(user);

        //Act
        iUserRepository.addUser(user);

        //Assert
        Mockito.verify(iUserRepository, Mockito.atLeastOnce()).addUser(user);
        Assertions.assertEquals(iUserRepository.findUserById(user.getUserId()).getUserName(), user.getUserName());
    }
}
