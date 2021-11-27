package com.socialmeli.socialmeli.unit.repository;

import com.socialmeli.socialmeli.repository.UserRepository;
import com.socialmeli.socialmeli.service.UserAndPostService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UnitTestUserRepository {

    @InjectMocks
    UserRepository userRepository;

    //T-0007 Verificar que la cantidad de seguidores de un determinado usuario sea correcta. (US-0002)
    @Test
    public void testCorrectCountFollowers(){
        //Act
        userRepository.addFollow(1,2);
        //As
        Assertions.assertEquals(1,userRepository.getUser(2).countFollowers());
    }
}
