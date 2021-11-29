package com.bootcamp.SocialMeli.unitari.repository;

import com.bootcamp.SocialMeli.model.User;
import com.bootcamp.SocialMeli.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

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

    @Test
    void whengetExisteSeguidorThenTrue(){

        Assertions.assertFalse(repository.getExisteSeguidor(1,3));
    }

    @Test
    void whencambiarTipoThenCambiaTipoVendedor(){

        User user = new User(3,"Julian");
        user.setTipo("Vendedor");

        repository.cambiarTipo(3);

        Assertions.assertEquals(user,repository.getUser(3) );
    }


}
