package com.example.socialmeli.unit.service;


import com.example.socialmeli.dto.PostDTO;
import com.example.socialmeli.dto.response.PostsResponseDTO;
import com.example.socialmeli.exceptions.UserNotFoundException;
import com.example.socialmeli.model.Post;
import com.example.socialmeli.model.Product;
import com.example.socialmeli.model.User;
import com.example.socialmeli.repositories.PostRepository;
import com.example.socialmeli.repositories.UsuarioRepository;
import com.example.socialmeli.services.SocialMeliService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ExtendWith(MockitoExtension.class)
public class T008 {

    User pedro = new User(1, "pedro", List.of());

    Integer userId = pedro.getUserId();

    User juan = new User(3, "juan", List.of(userId));
    User victoria = new User(2, "victoria", List.of(userId));

    LocalDate localDate = LocalDate.now();


    Post postNuevo2Juan = new Post(
            3,
            1,
            Date.from(localDate.minusDays(3).atStartOfDay(ZoneId.systemDefault()).toInstant()),
            new Product(
                    1,
                    "Chancletas Gamer de Juan",
                    "Ulra Cool product",
                    "Razer",
                    "Red",
                    "Compralas oporto..."
            ),
            1,
            1000,
            false,
            0.0);

    Post postViejo1Juan = new Post(
            3,
            2,
            Date.from(localDate.minusDays(16).atStartOfDay(ZoneId.systemDefault()).toInstant()),
            new Product(
                    1,
                    "Chancletas No Gamer Viejas de Juan",
                    "Ulra Cool product",
                    "Razer",
                    "Red",
                    "Compralas oporto..."
            ),
            1,
            1000,
            false,
            0.0);

    Post postNuevo3Victoria = new Post(
            2,
            3,
            Date.from(localDate.minusDays(10).atStartOfDay(ZoneId.systemDefault()).toInstant()),
            new Product(
                    1,
                    "Chancletas No Gamer Nuevas de Victoria",
                    "Ulra Cool product",
                    "Razer",
                    "Red",
                    "Compralas oporto..."
            ),
            1,
            1000,
            false,
            0.0);

    Post postViejo2Victoria = new Post(
            2,
            4,
            Date.from(localDate.minusDays(20).atStartOfDay(ZoneId.systemDefault()).toInstant()),
            new Product(
                    1,
                    "Chancletas No Gamer Viejas de Victoria",
                    "Ulra Cool product",
                    "Razer",
                    "Red",
                    "Compralas oporto..."
            ),
            1,
            1000,
            false,
            0.0);

    Post postNuevo1Victoria = new Post(
            2,
            5,
            Date.from(localDate.minusDays(1).atStartOfDay(ZoneId.systemDefault()).toInstant()),
            new Product(
                    1,
                    "Chancletas No Gamer Nuevas de Victoria",
                    "Ulra Cool product",
                    "Razer",
                    "Red",
                    "Compralas oporto..."
            ),
            1,
            1000,
            false,
            0.0);

    @Mock
    UsuarioRepository userRepository;


    PostRepository postRepository =
            Mockito.mock(PostRepository.class);

    @InjectMocks
    SocialMeliService service;

    ModelMapper mapper = new ModelMapper();

    @Test
    void t0008() throws Exception {

        //Arrange

        List<User> listFollowed = List.of(juan, victoria);

        List<Post> listPostVictoria = List.of(
                postNuevo3Victoria, postViejo2Victoria, postNuevo1Victoria);

        List<Post> listPostJuan = List.of(
                postNuevo2Juan, postViejo1Juan );

        List<Post> listPostExpected = List.of(
                postNuevo1Victoria, postNuevo2Juan, postNuevo3Victoria);

        List<PostDTO> listPostDTOExpected = listPostExpected.stream().
                map( post -> mapper.map( post, PostDTO.class ) ).
                collect(Collectors.toList());

        PostsResponseDTO expectedDTO = new PostsResponseDTO(
                userId, listPostDTOExpected);

        Mockito.when(userRepository.findById( pedro.getUserId() )).
                thenReturn(Optional.of( pedro ));

        Mockito.when(userRepository.findFollowed(userId)).
                thenReturn( listFollowed );

        Mockito.when(postRepository.findByUserId( victoria.getUserId() )).
                thenReturn( listPostVictoria );

        Mockito.when(postRepository.findByUserId( juan.getUserId() ) ).
                thenReturn( listPostJuan );

        //Act
        PostsResponseDTO response = service.
                getFollowedPostList(userId, "date_desc");

        //Assert
        Mockito.verify(
                userRepository,
                Mockito.times(1) ).findFollowed(userId);

        /*Mockito.verify(
                postRepository,
                Mockito.times(1) ).findByUserId(  victoria.getUserId() );

        Mockito.verify(
                postRepository,
                Mockito.times(1) ).findByUserId(  juan.getUserId() );*/

        Mockito.verify(
                postRepository,
                Mockito.times(2) ).findByUserId(  Mockito.anyInt() );

        Assertions.assertEquals(expectedDTO, response);

    }

}
