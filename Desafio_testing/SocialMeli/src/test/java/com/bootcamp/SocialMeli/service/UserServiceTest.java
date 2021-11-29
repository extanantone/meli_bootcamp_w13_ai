package com.bootcamp.SocialMeli.service;

import com.bootcamp.SocialMeli.dto.*;
import com.bootcamp.SocialMeli.exceptions.NoValidOrderException;
import com.bootcamp.SocialMeli.exceptions.UserNotFoundException;
import com.bootcamp.SocialMeli.model.Detail;
import com.bootcamp.SocialMeli.model.Post;
import com.bootcamp.SocialMeli.model.User;
import com.bootcamp.SocialMeli.repository.UserRepository;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.TestPropertySource;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository mockRepository;

    @InjectMocks
    private UserService service;

    //T-0001 - EXISTE
    @Test
    public void followsUserAndExists(){
        //Arrange
        User user1 = new User(1, "Juan");
        User user2 = new User(2, "Sebastian");

        //Mock
        Mockito.when(mockRepository.getUser(1)).thenReturn(java.util.Optional.of(user1));
        Mockito.when(mockRepository.getUser(2)).thenReturn(java.util.Optional.of(user2));

        //Act
        service.followUser(2, 1);

        //Assert
        Assertions.assertEquals(user1.getFollowers().get(2), user2);
        Assertions.assertEquals(user2.getFollowed().get(1), user1);
    }

    //T-0001 - NO EXISTE
    @Test
    public void followUserAndNotExists(){
        //Arrange
        User user2 = new User(2, "Sebastoam");

        //Mock
        Mockito.when(mockRepository.getUser(2)).thenReturn(java.util.Optional.of(user2));
        Mockito.when(mockRepository.getUser(7)).thenThrow(UserNotFoundException.class);

        //Assert & Act
        Assertions.assertThrows(UserNotFoundException.class,() -> service.followUser(2,7));
    }

    //T-0002 - EXISTE
    @Test
    public void unfollowUserAndExists(){
        //Arrange
        User user1 = new User(1, "Juan");
        User user2 = new User(2, "Sebastian");
        user1.addFollower(user2);
        user2.addFollowed((user1));
        Assertions.assertEquals(user1.getFollowers().size(), 1);
        Assertions.assertEquals(user2.getFollowed().size(), 1);

        //Mock
        Mockito.when(mockRepository.getUser(1)).thenReturn(java.util.Optional.of(user1));
        Mockito.when(mockRepository.getUser(2)).thenReturn(java.util.Optional.of(user2));

        //Act
        service.unfollowUser(2,1);

        //Assert
        Assertions.assertFalse(user1.getFollowers().containsKey(user2.getUserId()));
        Assertions.assertFalse(user2.getFollowed().containsKey(user1.getUserId()));
    }

    //T-0002 - NO EXISTE
    @Test
    public void unfollowUserAndNotExists(){
        //Arrange
        User user2 = new User(2, "Sebastian");

        //Mock
        Mockito.when(mockRepository.getUser(2)).thenReturn(java.util.Optional.of(user2));
        Mockito.when(mockRepository.getUser(7)).thenThrow(UserNotFoundException.class);


        //Assert
        Assertions.assertThrows(UserNotFoundException.class,() -> service.unfollowUser(2,7));
    }

    //T-0003 - SE CUMPLE
    @Test
    public void verifyAlphabeticOrderExists(){
        //Arrange
        User user1 = new User(1, "Juan");

        //Mock
        Mockito.when(mockRepository.getUser(user1.getUserId())).thenReturn(java.util.Optional.of(user1));

        //Assert
        Assertions.assertDoesNotThrow(() -> service.getFollowers(1, "name_desc"));
        Assertions.assertDoesNotThrow(() -> service.getFollowers(1, "name_asc"));
        Assertions.assertDoesNotThrow(() -> service.getFollowed(1, "name_desc"));
        Assertions.assertDoesNotThrow(() -> service.getFollowed(1, "name_asc"));

    }

    //T-0003 - NO SE CUMPLE
    @Test
    public void verifyAlphabeticOrderDoesNotExist(){
        //Arrange
        User user1 = new User(1, "Juan");

        //Mock
        Mockito.when(mockRepository.getUser(user1.getUserId())).thenReturn(java.util.Optional.of(user1));

        //Assert
        Assertions.assertThrows(NoValidOrderException.class, ()-> service.getFollowers(1, "name_asc**" ));
        Assertions.assertThrows(NoValidOrderException.class, ()-> service.getFollowers(1, "name_desc**" ));
        Assertions.assertThrows(NoValidOrderException.class, ()-> service.getFollowed(1, "name_asc**" ));
        Assertions.assertThrows(NoValidOrderException.class, ()-> service.getFollowed(1, "name_desc**" ));
    }

    //T-0004
    @Test
    public void ordersByNameCorrectly(){
        //Arrange
        User user1 = new User(1, "Juan");
        User user2 = new User(2, "Sebastian");
        User user3 = new User(3, "Lucas");
        User user4 = new User(4, "Franco");

        user1.addFollower(user2);
        user1.addFollower(user3);
        user1.addFollower(user4);
        user3.addFollower(user2);

        user2.addFollowed(user1);
        user2.addFollowed(user3);

        List<UserDTO> followerListAsc = new ArrayList<>();
        followerListAsc.add(new UserDTO(user4.getUserId(), user4.getUserName()));
        followerListAsc.add(new UserDTO(user3.getUserId(), user3.getUserName()));
        followerListAsc.add(new UserDTO(user2.getUserId(), user2.getUserName()));
        FollowersDTO followersAscDTO = new FollowersDTO(user1.getUserId(), user1.getUserName(), followerListAsc);

        List<UserDTO> followerListDesc = new ArrayList<>();
        followerListDesc.add(new UserDTO(user2.getUserId(), user2.getUserName()));
        followerListDesc.add(new UserDTO(user3.getUserId(), user3.getUserName()));
        followerListDesc.add(new UserDTO(user4.getUserId(), user4.getUserName()));
        FollowersDTO followersDescDTO = new FollowersDTO(user1.getUserId(), user1.getUserName(), followerListDesc);


        List<UserDTO> followedListAsc = new ArrayList<>();
        followedListAsc.add(new UserDTO(user1.getUserId(), user1.getUserName()));
        followedListAsc.add(new UserDTO(user3.getUserId(), user3.getUserName()));
        FollowedDTO followedAscDTO = new FollowedDTO(user2.getUserId(), user2.getUserName(), followedListAsc);


        List<UserDTO> followedListDesc = new ArrayList<>();
        followedListDesc.add(new UserDTO(user3.getUserId(), user3.getUserName()));
        followedListDesc.add(new UserDTO(user1.getUserId(), user1.getUserName()));
        FollowedDTO followedDescDTO = new FollowedDTO(user2.getUserId(), user2.getUserName(), followedListDesc);

        //Mock
        Mockito.when(mockRepository.getUser(1)).thenReturn(java.util.Optional.of(user1));
        Mockito.when(mockRepository.getUser(2)).thenReturn(java.util.Optional.of(user2));

        //Act
        FollowersDTO actualFollowersAscDTO = service.getFollowers(user1.getUserId(), "name_asc");
        FollowersDTO actualFollowersDescDTO = service.getFollowers(user1.getUserId(), "name_desc");
        FollowedDTO actualFollowedAscDTO = service.getFollowed(user2.getUserId(), "name_asc");
        FollowedDTO actualFollowedDescDTO = service.getFollowed(user2.getUserId(), "name_desc");

        //Assert
        Assertions.assertEquals(actualFollowersAscDTO, followersAscDTO);
        Assertions.assertEquals(actualFollowersDescDTO, followersDescDTO);
        Assertions.assertEquals(actualFollowedAscDTO, followedAscDTO);
        Assertions.assertEquals(actualFollowedDescDTO, followedDescDTO);

    }

    //T-0005 - SE CUMPLE
    @Test
    public void verifyOrderByDateAndExists(){
        //Arrange
        User user1 = new User(1, "Juan");

        //Mock
        Mockito.when(mockRepository.getUser(user1.getUserId())).thenReturn(java.util.Optional.of(user1));

        //Assert
        Assertions.assertDoesNotThrow(() -> service.getPostsList(1, "date_asc"));
        Assertions.assertDoesNotThrow(() -> service.getPostsList(1, "date_desc"));

    }

    //T-0005 - NO SE CUMPLE
    @Test
    public void verifyOrderByDateAndNotExists(){
        //Arrange
        User user1 = new User(1, "Juan");

        //Mock
        Mockito.when(mockRepository.getUser(user1.getUserId())).thenReturn(java.util.Optional.of(user1));

        //Assert
        Assertions.assertThrows(NoValidOrderException.class, ()-> service.getPostsList(1, "date_desc**"));
        Assertions.assertThrows(NoValidOrderException.class, ()-> service.getPostsList(1, "date_asc**" ));
    }

    //T-0006
    @Test
    public void verifyDateOrderIsCorrect(){
        //Arrange
        User user1 = new User(1, "Juan");
        User user2 = new User(2, "Sebastian");

        user1.addFollower(user2);
        user2.addFollowed(user1);

        DetailDTO detailDTO = new DetailDTO(1, "Zapatilla", "Ropa", "Nike", "Negro", "Ropa deportiva");
        PostDTO postDTO1 = new PostDTO(1,1,"27-11-2021", detailDTO, 1, 200.0);
        PostDTO postDTO2 = new PostDTO(1,2,"22-11-2021", detailDTO, 1, 300.0);
        PostDTO postDTO3 = new PostDTO(1,3,"18-11-2021", detailDTO, 1, 400.0);
        PostDTO postDTO4 = new PostDTO(1,4,"05-11-2021", detailDTO, 1, 500.0);

        //Lista de DTO
        List<PostDTO> postListAsc = new ArrayList<>();
        postListAsc.add(postDTO3);
        postListAsc.add(postDTO2);
        postListAsc.add(postDTO1);

        List<PostDTO> postListDesc = new ArrayList<>();
        postListDesc.add(postDTO1);
        postListDesc.add(postDTO2);
        postListDesc.add(postDTO3);
        Map<Integer, Post> posts = new HashMap<>();
        Post post1 = new Post(postDTO1.getUserId(), postDTO1.getIdPost(), LocalDate.parse(postDTO1.getDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                new Detail(postDTO1.getDetail().getProductId(), postDTO1.getDetail().getProductName(), postDTO1.getDetail().getType(), postDTO1.getDetail().getBrand(), postDTO1.getDetail().getColor(), postDTO1.getDetail().getNotes() ),
                postDTO1.getCategory(), postDTO1.getPrice());
        Post post2 = new Post(postDTO2.getUserId(), postDTO2.getIdPost(), LocalDate.parse(postDTO2.getDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                new Detail(postDTO2.getDetail().getProductId(), postDTO2.getDetail().getProductName(), postDTO2.getDetail().getType(), postDTO2.getDetail().getBrand(), postDTO2.getDetail().getColor(), postDTO2.getDetail().getNotes() ),
                postDTO2.getCategory(), postDTO2.getPrice());
        Post post3 = new Post(postDTO3.getUserId(), postDTO3.getIdPost(), LocalDate.parse(postDTO3.getDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                new Detail(postDTO3.getDetail().getProductId(), postDTO3.getDetail().getProductName(), postDTO3.getDetail().getType(), postDTO3.getDetail().getBrand(), postDTO3.getDetail().getColor(), postDTO3.getDetail().getNotes() ),
                postDTO3.getCategory(), postDTO3.getPrice());
        Post post4 = new Post(postDTO4.getUserId(), postDTO4.getIdPost(), LocalDate.parse(postDTO4.getDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                new Detail(postDTO4.getDetail().getProductId(), postDTO4.getDetail().getProductName(), postDTO4.getDetail().getType(), postDTO4.getDetail().getBrand(), postDTO4.getDetail().getColor(), postDTO4.getDetail().getNotes() ),
                postDTO4.getCategory(), postDTO4.getPrice());

        posts.put(postDTO1.getIdPost(), post1);
        posts.put(postDTO2.getIdPost(), post2);
        posts.put(postDTO3.getIdPost(), post3);
        posts.put(postDTO4.getIdPost(), post4);

        PostsListDTO expectedPostsListDTOAsc = new PostsListDTO(2, postListAsc);
        PostsListDTO expectedPostsListDTODesc = new PostsListDTO(2, postListDesc);

        //Mock
        Mockito.when(mockRepository.getUser(user2.getUserId())).thenReturn(java.util.Optional.of(user2));
        Mockito.when(mockRepository.getPosts()).thenReturn(posts);

        //Act
        PostsListDTO actualPostsListDTOAsc = service.getPostsList(user2.getUserId(), "date_asc");
        PostsListDTO actualPostsListDTODesc = service.getPostsList(user2.getUserId(), "date_desc");

        //Assert
        Assertions.assertEquals(actualPostsListDTOAsc, expectedPostsListDTOAsc);
        Assertions.assertEquals(actualPostsListDTODesc, expectedPostsListDTODesc);
    }

    //T-0007
    @Test
    public void countFollowersTest(){
        //Arrange
        User usuario1 = new User(1, "Juan");
        User usuario2 = new User(2, "Sebastian");
        User usuario3 = new User(3, "Lucas");
        usuario1.addFollower(usuario2);
        usuario1.addFollower(usuario3);

        //Mock
        Mockito.when(mockRepository.getUser(1)).thenReturn(java.util.Optional.of(usuario1));

        //Act
        FollowerCountDTO followersDTO = service.countFollowers(usuario1.getUserId());

        //Assert
        Assertions.assertEquals(followersDTO.getFollowersCount(), usuario1.getFollowers().size());
    }

    //T-0008
    @Test
    public void verifyPostsAreTwoWeeksLongMax(){
        //Arrange
        User user1 = new User(1, "Juan");
        User user2 = new User(2, "Sebastian");

        user1.addFollower(user2);
        user2.addFollowed(user1);

        DetailDTO detailDTO = new DetailDTO(1, "Zapatilla", "Ropa", "Nike", "Negro", "Ropa deportiva");
        PostDTO postDTO1 = new PostDTO(1,1,"27-11-2021", detailDTO, 1, 200.0);
        PostDTO postDTO2 = new PostDTO(1,2,"22-11-2021", detailDTO, 1, 300.0);
        PostDTO postDTO3 = new PostDTO(1,3,"18-10-2021", detailDTO, 1, 400.0);
        PostDTO postDTO4 = new PostDTO(1,4,"05-11-2021", detailDTO, 1, 500.0);

        //Lista de DTO
        List<PostDTO> postList = new ArrayList<>();
        postList.add(postDTO2);
        postList.add(postDTO1);

        Map<Integer, Post> posts = new HashMap<>();
        Post post1 = new Post(postDTO1.getUserId(), postDTO1.getIdPost(), LocalDate.parse(postDTO1.getDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                new Detail(postDTO1.getDetail().getProductId(), postDTO1.getDetail().getProductName(), postDTO1.getDetail().getType(), postDTO1.getDetail().getBrand(), postDTO1.getDetail().getColor(), postDTO1.getDetail().getNotes() ),
                postDTO1.getCategory(), postDTO1.getPrice());
        Post post2 = new Post(postDTO2.getUserId(), postDTO2.getIdPost(), LocalDate.parse(postDTO2.getDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                new Detail(postDTO2.getDetail().getProductId(), postDTO2.getDetail().getProductName(), postDTO2.getDetail().getType(), postDTO2.getDetail().getBrand(), postDTO2.getDetail().getColor(), postDTO2.getDetail().getNotes() ),
                postDTO2.getCategory(), postDTO2.getPrice());
        Post post3 = new Post(postDTO3.getUserId(), postDTO3.getIdPost(), LocalDate.parse(postDTO3.getDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                new Detail(postDTO3.getDetail().getProductId(), postDTO3.getDetail().getProductName(), postDTO3.getDetail().getType(), postDTO3.getDetail().getBrand(), postDTO3.getDetail().getColor(), postDTO3.getDetail().getNotes() ),
                postDTO3.getCategory(), postDTO3.getPrice());
        Post post4 = new Post(postDTO4.getUserId(), postDTO4.getIdPost(), LocalDate.parse(postDTO4.getDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                new Detail(postDTO4.getDetail().getProductId(), postDTO4.getDetail().getProductName(), postDTO4.getDetail().getType(), postDTO4.getDetail().getBrand(), postDTO4.getDetail().getColor(), postDTO4.getDetail().getNotes() ),
                postDTO4.getCategory(), postDTO4.getPrice());

        posts.put(postDTO1.getIdPost(), post1);
        posts.put(postDTO2.getIdPost(), post2);
        posts.put(postDTO3.getIdPost(), post3);
        posts.put(postDTO4.getIdPost(), post4);

        PostsListDTO expectedPostsListDTOAsc = new PostsListDTO(user2.getUserId(), postList);

        //Mock
        Mockito.when(mockRepository.getUser(user2.getUserId())).thenReturn(java.util.Optional.of(user2));
        Mockito.when(mockRepository.getPosts()).thenReturn(posts);

        //Act
        PostsListDTO actualPostsListDTOAsc = service.getPostsList(user2.getUserId(), "");

        //Assert
        Assertions.assertEquals(actualPostsListDTOAsc.getPosts().size(), expectedPostsListDTOAsc.getPosts().size());
    }
}
