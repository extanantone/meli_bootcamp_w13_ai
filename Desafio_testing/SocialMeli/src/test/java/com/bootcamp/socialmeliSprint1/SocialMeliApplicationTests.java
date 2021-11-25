package com.bootcamp.socialmeliSprint1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;

import com.bootcamp.socialmeliSprint1.entitiy.Purchaser;
import com.bootcamp.socialmeliSprint1.entitiy.Seller;
import com.bootcamp.socialmeliSprint1.exception.userException.NotFoundUserException;
import com.bootcamp.socialmeliSprint1.exception.userException.PurchaserAlreadyFollowSeller;
import com.bootcamp.socialmeliSprint1.repository.ISocialMeliRepository;
import com.bootcamp.socialmeliSprint1.service.IUserService;

import com.bootcamp.socialmeliSprint1.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class SocialMeliApplicationTests {

    @Autowired
    IUserService uservice;

    //    Los mocks se inyectan dependiendo de la clase que se quiera probar
    @Mock
    ISocialMeliRepository urepository;

    //    El mock que se inyectará
    @InjectMocks
    UserServiceImpl mockService;

    @Test
    void shouldAutoFollow2(){


        Purchaser purchaser = new Purchaser();

        purchaser.addFollowed(11);

        when(urepository.getSeller(11)).thenReturn(Optional.of(new Seller()));

        when(urepository.getPurchaser(10)).thenReturn(Optional.of(purchaser));

        try {
            // si pasa el follow falló la prueba
            mockService.addFollowed(10,11);
            fail();
        }catch (PurchaserAlreadyFollowSeller e){
            // si cae en la excepcion el test pasa.
            assertTrue(true);
        }

    }


    @Test
    void shouldFailAutoFollow2(){

        when(urepository.getSeller(10)).thenReturn(Optional.of(new Seller()));

        when(urepository.getPurchaser(10)).thenReturn(Optional.empty());

        urepository.follow(10,11);


    }

    /*Sin mock*/


    @Test
    void shouldFailAutoFollow(){
       
        try {
            uservice.addFollowed(1, 2);
            fail();
        } catch (NotFoundUserException e) {
            assertNotNull(e);
        }
        
    }

    @Test
    void shouldFollow(){
       
        try {
            
            uservice.addFollowed(1, 3);

        } catch (NotFoundUserException e) {
            
            assertNotNull(e);
            fail();
        }
        
    }


    @Test
    void contextLoads() {
    }

}
