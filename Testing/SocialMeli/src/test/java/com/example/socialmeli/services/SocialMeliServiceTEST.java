package com.example.socialmeli.services;

import static com.example.socialmeli.TestUtilsGet.*;
import com.example.socialmeli.dto.UserDTO;
import com.example.socialmeli.dto.response.CountFollowersResponseDTO;
import com.example.socialmeli.exceptions.UserNotFoundException;
import com.example.socialmeli.model.User;
import com.example.socialmeli.repositories.PostRepository;
import com.example.socialmeli.repositories.UsuarioRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SocialMeliServiceTEST {
    @Mock
    private UsuarioRepository mockUserRepository;

    @Mock
    private PostRepository mockPostRespository;

    @InjectMocks
    private SocialMeliService mockSocialMeliService;

   @AfterEach
   public void setUp(){
       reset(mockUserRepository);
       reset(mockPostRespository);
   }
   //T-0001
   @Test   //Arrange(organizador/lo que espero)
    void checkUserExistence() throws UserNotFoundException {
        User theo = getTheo();
        when(mockUserRepository.findById(1)).thenReturn(Optional.of(theo));

        User response = mockSocialMeliService.getUserById(1);

        assertEquals(response, theo);
        verify(mockUserRepository, atLeastOnce()).findById(1);

   }

   @Test
    public void checkUserNotExistence() {
       when(mockUserRepository.findById(any())).thenReturn(Optional.empty());

       assertThrows(UserNotFoundException.class, ()-> mockSocialMeliService.getUserById(456));

       verify(mockUserRepository, atLeastOnce()).findById(456);
   }

   //T-0007
   @Test
    public void checkFollowers() throws UserNotFoundException{

       User theo = getTheo();
       theo.setFollowersId(List.of(4,5,2,6,1));

       when(mockUserRepository.findById(1)).thenReturn(Optional.of(theo));

        CountFollowersResponseDTO followersCountDTO  = mockSocialMeliService.countFollowers(1);

        assertEquals(5, followersCountDTO.getFollowersCount());
        verify(mockUserRepository, atLeastOnce()).findById(1);

    }



}
