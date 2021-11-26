package com.example.socialmeli.UnitTest.Repository;

import com.example.socialmeli.dto.UserDto;
import com.example.socialmeli.exception.BadRequestException;
import com.example.socialmeli.model.User;
import com.example.socialmeli.repository.IUserRepository;
import com.example.socialmeli.repository.UserRepository;
import net.bytebuddy.dynamic.DynamicType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class UserRepositoryTest {

    IUserRepository userRepository = new UserRepository();

    @Test
    @DisplayName("Verificar que el usuario exista")
    void test101() {

        Integer userId = 1;
        User userExpect = new User();
        userExpect.setUserId(1);
        userExpect.setUserName("Camilo_vendedor1");

        Optional<User> expect = Optional.of(userExpect);

        Optional<User> current = userRepository.findById(1);

       Assertions.assertAll(
               () -> Assertions.assertEquals(expect.get().getUserId(),current.get().getUserId()),
               () -> Assertions.assertEquals(expect.get().getUserName(),current.get().getUserName())
       );
    }

    @Test
    @DisplayName("Verificar que el usuario no exista")
    void test102() {

        Integer userId = 5;

        Optional<User> current = userRepository.findById(userId);


        Assertions.assertTrue(current.isEmpty());

    }


}
