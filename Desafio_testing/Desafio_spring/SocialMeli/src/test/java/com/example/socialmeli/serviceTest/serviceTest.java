package com.example.socialmeli.serviceTest;
import com.example.socialmeli.dto.PostDTO;
import com.example.socialmeli.dto.UserDTO;
import com.example.socialmeli.dto.response.FollowersResponseDTO;
import com.example.socialmeli.dto.response.PostsResponseDTO;
import com.example.socialmeli.exceptions.*;
import com.example.socialmeli.model.Post;
import com.example.socialmeli.model.Product;
import com.example.socialmeli.model.User;
import com.example.socialmeli.repositories.PostRepository;
import com.example.socialmeli.repositories.UsuarioRepository;
import com.example.socialmeli.services.SocialMeliService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.util.comparator.Comparators;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@ExtendWith(MockitoExtension.class)
public class serviceTest {
    @Mock
    ModelMapper mapper;
    @Mock
    UsuarioRepository repository;
    @Mock
    PostRepository postRepository;
    @InjectMocks
    SocialMeliService service;



    @Test @DisplayName("Verifica que exista el user y no el userToFollow, cuando no lo encuentra, lanza una excepcion")
    void followUserThatIsNotFound() throws UserNotFoundException, UserSelfUseException, UserAlreadyInUseException {
        Integer userId = 9999;
        Integer userToFollowId = 99999;
        Mockito.when(repository.findById(userId)).thenReturn(Optional.of(new User()));
        Mockito.when(repository.findById(userToFollowId)).thenReturn(Optional.empty());
        Assertions.assertThrows(UserNotFoundException.class,()->service.follow(userId,userToFollowId));
    }
    @Test @DisplayName("Verifica que se lance la excepcion de que se trata de seguir a si mismo")
    void followMyselfTest(){
        Integer userId = 1;
        Integer userToFollowId = 1;
        Assertions.assertThrows(UserSelfUseException.class,()->service.follow(userId,userToFollowId));
    }
    @Test @DisplayName("Verifica que no sigas al mismo usuario dos veces")
    void followOneTwice() throws UserNotFoundException, UserSelfUseException, UserAlreadyInUseException {
        //Arrange
        Integer userId = 1;
        Integer userToFollowId = 2;
        User userToFollow = new User();
        userToFollow.getFollowersId().add(1);
        //Mock
        Mockito.when(repository.findById(userId)).thenReturn(Optional.of(new User()));
        Mockito.when(repository.findById(userToFollowId)).thenReturn(Optional.of(userToFollow));
        //Act and assert
        Assertions.assertThrows(UserAlreadyInUseException.class,()->service.follow(userId,userToFollowId));
    }

    @Test @DisplayName("Verifica que exista el user y no el userToUnfollow, cuando no lo encuentra, lanza una excepcion")
    void unfollowUserThatIsNotFound() throws UserNotFoundException, UserSelfUseException, UserAlreadyInUseException {
        Integer userId = 999;
        Integer userToUnfollowId = 99999;
        Mockito.when(repository.findById(userToUnfollowId)).thenReturn(Optional.empty());
        Assertions.assertThrows(UserNotFoundException.class,()->service.unfollow(userId,userToUnfollowId));
    }

    @Test @DisplayName("Verifica que exista el user y no el userToUnfollow, cuando no lo encuentra, lanza una excepcion")
    void unfollowMyselfTest() throws UserNotFoundException, UserSelfUseException, UserAlreadyInUseException {
        Integer userId = 1;
        Integer userToUnfollowId = 1;
        Assertions.assertThrows(UserSelfUseException.class,()->service.follow(userId,userToUnfollowId));
    }

    @Test @DisplayName("Verifica que no intentes de dejar de seguir al mismo usuario dos veces")
    void unfollowUserTwice() throws UserNotFoundException, UserSelfUseException, UserAlreadyInUseException {
        //Arrange
        Integer userId = 1;
        Integer userToUnfollowId = 2;
        User userToUnfollow = new User();
        //Mock
        Mockito.when(repository.findById(userToUnfollowId)).thenReturn(Optional.of(userToUnfollow));
        //Act and assert
        Assertions.assertThrows(UserAlreadyInUseException.class,()->service.unfollow(userId,userToUnfollowId));
    }
    @Test @DisplayName("Verificamos que el ordenamiento alfabetico funcione correctamente")
    void alphabeticOrderAscTest() throws UserNotFoundException, UserSelfUseException, UserAlreadyInUseException {
        //arrange
        User user1 = new User();
        user1.setUserId(1);
        user1.setUserName("Antonio");
        User user2 = new User();
        user2.setUserId(2);
        user2.setUserName("Camila");
        User user3 = new User();
        user3.setUserId(3);
        user3.setUserName("Pablo");
        Mockito.when(repository.findById(1)).thenReturn(Optional.of(user1));
        Mockito.when(repository.findById(2)).thenReturn(Optional.of(user2));
        Mockito.when(repository.findById(3)).thenReturn(Optional.of(user3));
        List<Integer> seguidores = new ArrayList<>(){{add(2);add(3);}};
        user1.setFollowersId(seguidores);
        List<User> userExpect = new ArrayList<>();
        userExpect.add(user2);
        userExpect.add(user3);
        //act
        FollowersResponseDTO userActual = service.getFollowers(user1.getUserId(), "name_asc");
        List<String> nombresActual = userActual.getFollowers().stream().map(UserDTO::getUserName).collect(Collectors.toList());
        List<String> nombresExpect = userExpect.stream().map(User::getUserName).collect(Collectors.toList());
        //assert
        Assertions.assertEquals(nombresExpect,nombresActual);
    }
    @Test @DisplayName("Verificamos que el ordenamiento alfabetico funcione correctamente")
    void alphabeticOrderDescTest() throws UserNotFoundException, UserSelfUseException, UserAlreadyInUseException {
        //arrange
        User user1 = new User();
        user1.setUserId(1);
        user1.setUserName("Antonio");
        User user2 = new User();
        user2.setUserId(2);
        user2.setUserName("Camila");
        User user3 = new User();
        user3.setUserId(3);
        user3.setUserName("Pablo");
        Mockito.when(repository.findById(1)).thenReturn(Optional.of(user1));
        Mockito.when(repository.findById(2)).thenReturn(Optional.of(user2));
        Mockito.when(repository.findById(3)).thenReturn(Optional.of(user3));
        List<Integer> seguidores = new ArrayList<>(){{add(2);add(3);}};
        user1.setFollowersId(seguidores);
        List<User> userExpect = new ArrayList<>();
        userExpect.add(user3);
        userExpect.add(user2);
        //act
        FollowersResponseDTO userActual = service.getFollowers(user1.getUserId(), "name_desc");
        List<String> nombresActual = userActual.getFollowers().stream().map(UserDTO::getUserName).collect(Collectors.toList());
        List<String> nombresExpect = userExpect.stream().map(User::getUserName).collect(Collectors.toList());
        //assert
        Assertions.assertEquals(nombresExpect,nombresActual);
    }

    @Test @DisplayName("Verificamos que el ordenamiento por fecha funcione correctamente")
    void verifyOrderByDate() throws UserNotFoundException, UserSelfUseException, UserAlreadyInUseException {
        //arrange
        User user1 = new User();
        user1.setUserId(1);
        user1.setUserName("Antonio");
        User user2 = new User();
        user2.setUserId(2);
        user2.setUserName("Camila");
        User user3 = new User();
        user3.setUserId(3);
        user3.setUserName("Pablo");
        Mockito.when(repository.findById(1)).thenReturn(Optional.of(user1));
        Mockito.when(repository.findById(2)).thenReturn(Optional.of(user2));
        Mockito.when(repository.findById(3)).thenReturn(Optional.of(user3));
        List<Integer> seguidores = new ArrayList<>(){{add(2);add(3);}};
        user1.setFollowersId(seguidores);
        List<User> userExpect = new ArrayList<>();
        userExpect.add(user2);
        userExpect.add(user3);
        //act
        FollowersResponseDTO userActual = service.getFollowers(user1.getUserId(), "name_asc");
        List<String> nombresActual = userActual.getFollowers().stream().map(UserDTO::getUserName).collect(Collectors.toList());
        List<String> nombresExpect = userExpect.stream().map(User::getUserName).collect(Collectors.toList());
        //assert
        Assertions.assertEquals(nombresExpect,nombresActual);
    }
    @Test @DisplayName("Verificamos que ordene correctamente por fecha ascendentemente")
    void orderByDateAscTest() throws UserNotFoundException, PostAlreadyExistException, InvalidPromoException {
        /*
            Hable con Anibal sobre algunos problemas en la implementacion y un supuesto problema entre las versiones del proyecto subido
            en el branch de profes, por ejemplo, en la linea 186 del archivo socialMeliService, se pasaba por parametro un null, por lo cual
            Anibal me dijo que lo cambie por "order", no pudimos concluir si habia mas diferencias en la version final del codigo del branch
            y/o otros posibles conflictos.
            No pude finalizar este test ni su version descendente debido a que la lista de posts me venia vacia y no logramos encontrar la razon.
         */
        User user1 = new User();
        user1.setUserId(1);
        user1.setUserName("Antonio");
        User user2 = new User();
        user2.setUserId(2);
        user2.setUserName("Camila");
        User user3 = new User();
        user3.setUserId(3);
        user3.setUserName("Pablo");
        List<Integer> seguidores = new ArrayList<>(){{add(2);add(3);}};
        user1.setFollowersId(seguidores);


        List<User> seguidoresU = new ArrayList<>();
        seguidoresU.add(user2);
        seguidoresU.add(user3);
        PostDTO post1 = new PostDTO();
        post1.setUserId(2);
        post1.setDate(new Date(2021,11,12));
        PostDTO post2 = new PostDTO();
        post2.setUserId(2);
        post2.setDate(new Date(2021,11,14));
        PostDTO post3 = new PostDTO();
        post3.setUserId(3);
        post3.setDate(new Date(2021,11,9));
        PostDTO oldPost1 = new PostDTO();
        oldPost1.setUserId(3);
        oldPost1.setDate(new Date(2021,2,3));
        PostDTO oldPost2 = new PostDTO();
        oldPost2.setDate(new Date(2021,1,2));
        oldPost2.setUserId(2);
        List<PostDTO> expected = new ArrayList<>();
        expected.add(post3);
        expected.add(post1);
        expected.add(post2);
        List<Object> actual = new ArrayList<>();
        actual.add(post1);
        actual.add(post2);
        actual.add(post3);
        actual.add(oldPost1);
        actual.add(oldPost2);
        user1.setFollowersId(seguidores);
        Mockito.when(repository.findById(1)).thenReturn(Optional.of(user1));
        Mockito.when(postRepository.findByUserId(2)).thenReturn(actual);
        Mockito.when(postRepository.findByUserId(3)).thenReturn(actual);
        Mockito.when(postRepository.findByUserId(1)).thenReturn(actual);
        Mockito.when(repository.findFollowers(1)).thenReturn(seguidoresU);

        PostsResponseDTO posts = service.getFollowedPostList(1, "date_asc");
        List<PostDTO> listaDePosts = posts.getPosts();
        Assertions.assertEquals(expected,listaDePosts);
    }


    @Test @DisplayName("Verificamos que el numero de seguidores sea correcto")
    void countFollowersTest() throws UserNotFoundException {
        User user1 = new User();
        user1.setUserId(1);
        User user2 = new User();
        user2.setUserId(2);
        User user3 = new User();
        user3.setUserId(3);

        List<Integer> seguidores = new ArrayList<>(){{add(2);add(3);}};
        user1.setFollowersId(seguidores);

        Mockito.when(repository.findById(1)).thenReturn(Optional.of(user1));

        Assertions.assertEquals(2,service.countFollowers(1).getFollowersCount());
    }

}
