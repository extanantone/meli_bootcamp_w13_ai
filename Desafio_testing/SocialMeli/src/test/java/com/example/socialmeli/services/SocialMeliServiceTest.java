package com.example.socialmeli.services;

import com.example.socialmeli.exceptions.UserNotFoundException;
import com.example.socialmeli.model.User;
import com.example.socialmeli.repositories.PostRepository;
import com.example.socialmeli.repositories.UsuarioRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


@ExtendWith(MockitoExtension.class)
public class SocialMeliServiceTest {
    @Mock
    UsuarioRepository usuarioRepository;

    @Mock
    PostRepository postRepository;

    @InjectMocks
    SocialMeliService socialMeliService;

    @AfterEach
    public void resetMock() {
        Mockito.reset(usuarioRepository);
        Mockito.reset(postRepository);
    }

    @Test
    public void followerUserExist() throws UserNotFoundException {
        User follower = new User();
        follower.getUserId();
        follower.setUserName("Bl3nker");
        User followed = new User();
        followed.getUserId();
        followed.setUserName("Minujin");
        Mockito.when(usuarioRepository.findById(1)).thenReturn(Optional.of(follower));
        Mockito.when(usuarioRepository.findById(2)).thenReturn(Optional.of(followed));


        assertDoesNotThrow(() -> socialMeliService.follow(1, 2));

        Mockito.verify(usuarioRepository, Mockito.times(1)).findById(1);
        Mockito.verify(usuarioRepository, Mockito.times(1)).findById(2);

        assertEquals(followed.getFollowersId().size(),1);

    }

    @Test
    public void followerUserNotExist(){
        User follower = new User();
        follower.getUserId();
        follower.setUserName("Bl3nker");
        User followed = null;
        Mockito.when(usuarioRepository.findById(1)).thenReturn(Optional.of(follower));
        Mockito.when(usuarioRepository.findById(2)).thenReturn(Optional.empty());


        assertThrows(UserNotFoundException.class,() -> socialMeliService.follow(1, 2));

        Mockito.verify(usuarioRepository, Mockito.times(1)).findById(1);
        Mockito.verify(usuarioRepository, Mockito.times(1)).findById(2);
    }

    @Test
    public void unfollowUserExist() {
        User follower = new User();
        follower.getUserId();
        follower.setUserName("Bl3nker");
        User followed = new User();
        followed.getUserId();
        followed.setUserName("Minujin");
        Mockito.when(usuarioRepository.findById(1)).thenReturn(Optional.of(follower));
        Mockito.when(usuarioRepository.findById(2)).thenReturn(Optional.of(followed));
        assertDoesNotThrow(() -> socialMeliService.follow(1, 2));
        assertDoesNotThrow(() -> socialMeliService.unfollow(1,2));
        assertEquals(followed.getFollowersId().size(),0);

    }

    @Test
    public void OrderByNameAscFollowers(){
        User follower = new User();
        follower.getUserId();
        follower.setUserName("Bl3nker");
        User follower2 = new User();
        follower2.getUserId();
        follower2.setUserName("Minujin");
        User follower3 = new User();
        follower3.getUserId();
        follower3.setUserName("Benja");
        User followed = new User();
        followed.getUserId();
        followed.setUserName("Tef");
    }
}
