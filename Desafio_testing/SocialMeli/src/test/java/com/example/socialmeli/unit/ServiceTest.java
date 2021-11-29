package com.example.socialmeli.unit;

import com.example.socialmeli.exceptions.UserNotFoundException;
import com.example.socialmeli.model.User;
import com.example.socialmeli.repositories.PostRepository;
import com.example.socialmeli.repositories.UsuarioRepository;
import com.example.socialmeli.services.SocialMeliService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ServiceTest {

    @Mock
    private UsuarioRepository userRepo;
    @Mock
    private PostRepository postRepo;
    @InjectMocks
    private SocialMeliService service;

    private ModelMapper mapper = new ModelMapper();

    @BeforeEach
    public void inic(){
        Mockito.reset(userRepo);
        Mockito.reset(postRepo);
    }

    @Test
    public void findUserToFollow(){

        // Arrange
        Integer idOk =3;
        Integer idNotOk= 5;
        List<Integer> followersId = new ArrayList<>();
        User expected = new User(3,"Manuel Vendedor",followersId);
        Optional<User> expect = Optional.of(expected);

        // Act

        Mockito.when(userRepo.findById(idOk)).
                thenReturn(expect);
        Mockito.when(userRepo.findById(idNotOk)).thenReturn(Optional.empty());


        // Assert

        Assertions.assertThrows(UserNotFoundException.class,
                () -> this.service.follow(idOk, idNotOk));


}





}
