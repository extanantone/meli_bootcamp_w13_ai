package com.example.socialmeli.unit.service;

import com.example.socialmeli.dto.PostDTO;
import com.example.socialmeli.dto.UserDTO;
import com.example.socialmeli.dto.response.CountFollowersResponseDTO;
import com.example.socialmeli.dto.response.FollowedResponseDTO;
import com.example.socialmeli.dto.response.FollowersResponseDTO;
import com.example.socialmeli.dto.response.PostsResponseDTO;
import com.example.socialmeli.exceptions.UserAlreadyInUseException;
import com.example.socialmeli.exceptions.UserNotFoundException;
import com.example.socialmeli.exceptions.UserSelfUseException;
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

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ExtendWith(MockitoExtension.class)
public class SocialMeliServiceTest {

    @Mock
    private UsuarioRepository usuarioRepository;
    @Mock
    private PostRepository postRepository;

    @InjectMocks
    private SocialMeliService socialMeliService;

    ModelMapper mapper = new ModelMapper();


    @Test
    public void testGetUserById() throws UserNotFoundException {
        //Arrange
        Integer user_id = 11;
        User expected = new User();
        expected.setUserId(user_id);
        expected.setUserName("Santiago");

        //Act
        Mockito.when(usuarioRepository.findById(user_id)).thenReturn(Optional.of(expected));
        User current = socialMeliService.getUserById(user_id);

        //Assert
        Mockito.verify(usuarioRepository, Mockito.atLeastOnce()).findById(user_id);
        Assertions.assertEquals(expected, current);
    }

    @Test
    public void testNotFoundUserById()  {
        //Arrange
        Integer notFoundUserId = 99999999;
        //Assert & Act
        Assertions.assertThrows(UserNotFoundException.class, () -> {
            socialMeliService.getUserById(notFoundUserId);
        });
    }

    @Test
    public void getFollowedLidtFromNotFoundUser() {
        //Arrange
        Integer notFoundUserId = 99999999;
        String order = "name_asc";
        //Assert & Act
        Assertions.assertThrows(UserNotFoundException.class, () -> {
            socialMeliService.getFollowed(notFoundUserId,order);
        });
    }

    @Test
    public void testUserAlreadyFollow() {
        //Arrange
        Integer userId = 1;
        Integer userId2 = 2;
        User usuario = new User();
        usuario.setUserId(userId);
        usuario.setUserName("Santiago");
        User usuario2 = new User();
        usuario2.setUserId(userId2);
        usuario2.setUserName("Gabriel");
        usuario.getFollowersId().add(userId2);
        //Assert
        Mockito.when(usuarioRepository.findById(userId)).thenReturn(Optional.of(usuario));
        Mockito.when(usuarioRepository.findById(userId2)).thenReturn(Optional.of(usuario2));
        //Act
        Assertions.assertThrows(UserAlreadyInUseException.class, () -> {
            socialMeliService.follow(userId2,userId);
        });
    }

    @Test
    public void testUserUnfollowNotFollow()  {
        //Arrange
        Integer userId = 1;
        Integer userId2 = 2;
        User usuario = new User();
        usuario.setUserId(userId);
        usuario.setUserName("Santiago");
        User usuario2 = new User();
        usuario2.setUserId(userId2);
        usuario2.setUserName("Gabriel");
        //Assert
        Mockito.when(usuarioRepository.findById(userId)).thenReturn(Optional.of(usuario));
        //Act
        Assertions.assertThrows(UserAlreadyInUseException.class, () -> {
            socialMeliService.unfollow(userId2,userId);
        });
    }

    @Test
    public void testUserSameId() throws UserNotFoundException {
        //Arrange
        Integer notFoundUserId = 1;
        Integer userId = 1;
        //Assert & Act
        Assertions.assertThrows(UserSelfUseException.class, () -> {
            socialMeliService.follow(userId,notFoundUserId);
        });
    }

    @Test
    public void testUnFollowUserSameId() throws UserNotFoundException {
        //Arrange
        Integer notFoundUserId = 1;
        Integer userId = 1;
        //Assert & Act
        Assertions.assertThrows(UserSelfUseException.class, () -> {
            socialMeliService.unfollow(userId,notFoundUserId);
        });
    }


    @Test
    public void testFollow() throws UserNotFoundException, UserSelfUseException, UserAlreadyInUseException {
        //Arrange
        Integer user_id = 1;
        Integer user_id2 = 2;
        User usuario = new User();
        usuario.setUserId(user_id);
        usuario.setUserName("Santiago");
        User usuario2 = new User();
        usuario2.setUserId(user_id2);
        usuario2.setUserName("Gabriel");

        //Act
        Mockito.when(usuarioRepository.findById(user_id)).thenReturn(Optional.of(usuario));
        Mockito.when(usuarioRepository.findById(user_id2)).thenReturn(Optional.of(usuario2));

        socialMeliService.follow(user_id, user_id2);

        //Assert
        Mockito.verify(usuarioRepository, Mockito.atLeastOnce()).findById(user_id);
        Mockito.verify(usuarioRepository, Mockito.atLeastOnce()).findById(user_id2);

    }
    @Test
    public void testUnFollow() throws UserNotFoundException, UserSelfUseException, UserAlreadyInUseException {
        //Arrange
        Integer user_id = 1;
        Integer user_id2 = 2;

        User usuario = new User();
        usuario.setUserId(user_id);
        usuario.setUserName("Santiago");

        User usuario2 = new User();
        usuario2.setUserId(user_id2);
        usuario2.setUserName("Gabriel");

        usuario.getFollowersId().add(user_id2);

        //Act
        Mockito.when(usuarioRepository.findById(user_id)).thenReturn(Optional.of(usuario));

        socialMeliService.unfollow(user_id2, user_id);

        //Assert
        Mockito.verify(usuarioRepository, Mockito.times(2)).findById(user_id);
    }

    @Test
    public void testGetFollowersWithOrder() throws UserNotFoundException {
        //Arrange
        Integer userId = 1;
        Integer userId2 = 2;
        Integer userId3 = 3;
        String order = "name_asc";
        String orderInv = "name_desc";

        User usuario = new User();
        usuario.setUserId(userId);
        usuario.setUserName("Santiago");

        User usuario2 = new User();
        usuario2.setUserId(userId2);
        usuario2.setUserName("Gabriel");

        User usuario3 = new User();
        usuario3.setUserId(userId3);
        usuario3.setUserName("Javier");

        usuario.getFollowersId().add(userId2);
        usuario.getFollowersId().add(userId3);

        FollowersResponseDTO followers = new FollowersResponseDTO();
        FollowersResponseDTO followersInv = new FollowersResponseDTO();
        List<User> followersList = new ArrayList<>();

        followersList.add(usuario2);
        followersList.add(usuario3);

        followersList.sort(Comparator.comparing(User::getUserName));
        followers.setFollowers(followersList.stream().map( u -> mapper.map(u, UserDTO.class)).collect(Collectors.toList()));
        followers.setUserId(userId);
        followers.setUserName(usuario.getUserName());

        followersList.sort(Comparator.comparing(User::getUserName).reversed());
        followersInv.setFollowers(followersList.stream().map( u -> mapper.map(u, UserDTO.class)).collect(Collectors.toList()));
        followersInv.setUserId(userId);
        followersInv.setUserName(usuario.getUserName());

        //Act
        Mockito.when(usuarioRepository.findById(userId)).thenReturn(Optional.of(usuario));
        Mockito.when(usuarioRepository.findById(userId2)).thenReturn(Optional.of(usuario2));
        Mockito.when(usuarioRepository.findById(userId3)).thenReturn(Optional.of(usuario3));

        FollowersResponseDTO list = socialMeliService.getFollowers(userId, order);
        FollowersResponseDTO listInv = socialMeliService.getFollowers(userId, orderInv);

        //Assert
        Assertions.assertEquals(list,followers);

        Assertions.assertEquals(listInv,followersInv);
    }

    @Test
    public void testGetFollowedsWithOrder() throws UserNotFoundException {
        //Arrange
        Integer userId = 1;
        Integer userId2 = 2;
        Integer userId3 = 3;
        String order = "name_asc";
        String orderInv = "name_desc";

        User usuario = new User();
        usuario.setUserId(userId);
        usuario.setUserName("Santiago");

        User usuario2 = new User();
        usuario2.setUserId(userId2);
        usuario2.setUserName("Gabriel");

        User usuario3 = new User();
        usuario3.setUserId(userId3);
        usuario3.setUserName("Javier");

        usuario.getFollowersId().add(userId3);
        usuario2.getFollowersId().add(userId3);

        FollowedResponseDTO followed = new FollowedResponseDTO();
        FollowedResponseDTO followedInv = new FollowedResponseDTO();
        List<User> followedList = new ArrayList<>();

        followedList.add(usuario2);
        followedList.add(usuario);

        followedList.sort(Comparator.comparing(User::getUserName));
        followed.setFollowed(followedList.stream().map( u -> mapper.map(u, UserDTO.class)).collect(Collectors.toList()));
        followed.setUserId(userId3);
        followed.setUserName(usuario.getUserName());

        followedList.sort(Comparator.comparing(User::getUserName).reversed());
        followedInv.setFollowed(followedList.stream().map( u -> mapper.map(u, UserDTO.class)).collect(Collectors.toList()));
        followedInv.setUserId(userId3);
        followedInv.setUserName(usuario.getUserName());

        //Act
        Mockito.when(usuarioRepository.findById(userId3)).thenReturn(Optional.of(usuario));
        Mockito.when(usuarioRepository.findFollowed(userId3)).thenReturn(followedList);

        FollowedResponseDTO list = socialMeliService.getFollowed(userId3, order);
        FollowedResponseDTO listInv = socialMeliService.getFollowed(userId3, orderInv);

        //Assert
        Assertions.assertEquals(followed,list);

        Assertions.assertEquals(followedInv,listInv);
    }

    @Test
    public void testGetFollowedPostWithOrderAndDate() throws UserNotFoundException {
        //Arrange
        String order = "date_asc";
        String orderInv = "date_desc";
        Integer userId = 1;
        Integer userId2 = 2;

        User usuario = new User();
        usuario.setUserId(userId);
        usuario.setUserName("Santiago");

        User usuario2 = new User();
        usuario2.setUserId(userId2);
        usuario2.setUserName("Gabriel");

        usuario.getFollowersId().add(userId2);
        List<User> followersList = new ArrayList<>();
        followersList.add(usuario2);

        Product product = new Product();
        product.setProductId(1);
        product.setProductName("Producto 1");
        product.setType("Type");
        product.setBrand("Brand");
        product.setColor("Color");
        product.setNotes("Notes");

        Post post = new Post();
        post.setIdPost(1);
        post.setUserId(userId);
        post.setDate(Date.valueOf("2021-11-25"));
        post.setCategory(1);
        post.setPrice(100.12);
        post.setDetail(product);
        Post post2 = new Post();
        post2.setIdPost(2);
        post2.setUserId(userId);
        post2.setDate(Date.valueOf("2021-11-16"));
        post2.setCategory(1);
        post2.setPrice(100.12);
        post2.setDetail(product);
        Post post3 = new Post();
        post3.setIdPost(3);
        post3.setUserId(userId);
        post3.setDate(Date.valueOf("2021-11-01"));
        post3.setCategory(1);
        post3.setPrice(100.12);
        post3.setDetail(product);

        List<Post> posts = new ArrayList<>();
        posts.add(post);
        posts.add(post2);
        posts.add(post3);

        List<PostDTO> postsList = posts.stream().map( u -> mapper.map(u, PostDTO.class)).collect(Collectors.toList());
        List<PostDTO> postsListInv = postsList;


        postsList = postsList.stream().
                filter(poste ->
                        poste.getDate().compareTo(
                                Date.from(
                                        LocalDate.now()
                                                .minusDays(14)
                                                .atStartOfDay(
                                                        ZoneId.systemDefault()
                                                ).toInstant())) >0).
                collect(Collectors.toList());

        postsListInv = postsList.stream().
                filter(poste ->
                        poste.getDate().compareTo(
                                Date.from(
                                        LocalDate.now()
                                                .minusDays(14)
                                                .atStartOfDay(
                                                        ZoneId.systemDefault()
                                                ).toInstant())) >0).
                collect(Collectors.toList());


        postsList.sort(Comparator.comparing(PostDTO::getDate));
        postsListInv.sort(Comparator.comparing(PostDTO::getDate).reversed());

        PostsResponseDTO postsDto = new PostsResponseDTO();
        postsDto.setPosts(postsList);
        postsDto.setUserId(userId2);


        PostsResponseDTO postsDtoInv = new PostsResponseDTO();
        postsDtoInv.setPosts(postsListInv);
        postsDtoInv.setUserId(userId2);

        //Act
        Mockito.when(postRepository.findByUserId(userId2)).thenReturn(new ArrayList<>(posts));
        Mockito.when(usuarioRepository.findById(userId2)).thenReturn(Optional.of(usuario2));
        Mockito.when(usuarioRepository.findFollowed(userId2)).thenReturn(followersList);

        PostsResponseDTO list = socialMeliService.getFollowedPostList(userId2, order);
        PostsResponseDTO listInv = socialMeliService.getFollowedPostList(userId2, orderInv);

        //Assert
        Assertions.assertEquals(postsDto,list);
        Assertions.assertEquals(postsDto,list);

        Assertions.assertEquals(postsDtoInv,listInv);
        Assertions.assertEquals(postsDtoInv,listInv);

        for (int i = 0; i < list.getPosts().size(); i++) {
            Assertions.assertTrue(this.itsTwoWeeksOld(list.getPosts().get(i)));
        }
        for (int i = 0; i < listInv.getPosts().size(); i++) {
            Assertions.assertTrue(this.itsTwoWeeksOld(listInv.getPosts().get(i)));
        }
    }

    private boolean itsTwoWeeksOld(PostDTO post){
        return (post.getDate().compareTo(Date.from(
                LocalDate.now()
                        .minusDays(14)
                        .atStartOfDay(
                                ZoneId.systemDefault()
                        ).toInstant())) >0);
    }

    @Test
    public void testCountFollowers() throws UserNotFoundException {
        //Arrange
        Integer userId = 1;
        Integer userId2 = 2;
        Integer userId3 = 3;

        User usuario = new User();
        usuario.setUserId(userId);
        usuario.setUserName("Santiago");

        User usuario2 = new User();
        usuario2.setUserId(userId2);
        usuario2.setUserName("Gabriel");

        User usuario3 = new User();
        usuario3.setUserId(userId3);
        usuario3.setUserName("Javier");

        usuario.getFollowersId().add(userId2);
        usuario.getFollowersId().add(userId3);

        Integer expectedCount = usuario.getFollowersId().size();
        CountFollowersResponseDTO expectedQuantity = new CountFollowersResponseDTO();
        expectedQuantity.setFollowersCount(expectedCount);
        expectedQuantity.setUserId(usuario.getUserId());
        expectedQuantity.setUserName(usuario.getUserName());

        //Act
        Mockito.when(usuarioRepository.findById(userId)).thenReturn(Optional.of(usuario));
        CountFollowersResponseDTO quantity = socialMeliService.countFollowers(userId);
        //Assert
        Assertions.assertEquals(expectedQuantity.getFollowersCount(),quantity.getFollowersCount());

    }


}
