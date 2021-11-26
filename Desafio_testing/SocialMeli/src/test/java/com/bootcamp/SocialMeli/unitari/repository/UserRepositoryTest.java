package com.bootcamp.SocialMeli.unitari.repository;

import com.bootcamp.SocialMeli.model.User;
import com.bootcamp.SocialMeli.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryTest {

    UserRepository repository = new UserRepository();
    @Test
    void whengetUserThenUserOK(){
        //Arrange
        User expect = new User(1,"Juan");
        //Act
        User current = repository.getUser(1);
        //Asset
        Assertions.assertEquals(expect,current);
    }

    @Test
    void whengetUserThenUserNull(){

        //Act
        User current = repository.getUser(6);
        //Asset
        Assertions.assertNull(current);
    }
}
