package com.socialMeli.SocialMeli.Service;

import com.socialMeli.SocialMeli.model.Post;
import com.socialMeli.SocialMeli.model.ProductDetails;
import com.socialMeli.SocialMeli.model.User;
import com.socialMeli.SocialMeli.postDTO.PostDTO;
import com.socialMeli.SocialMeli.postDTO.PostFollowedDTO;
import com.socialMeli.SocialMeli.repository.PostRepository;
import com.socialMeli.SocialMeli.repository.UserRepository;
import com.socialMeli.SocialMeli.service.PostServiceImp;
import com.socialMeli.SocialMeli.service.UserServiceImp;
import com.socialMeli.SocialMeli.userDto.UserFollowDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.*;

@ExtendWith(MockitoExtension.class)
public class PostServiceTest {
    @Mock
    PostRepository postRepository;

    @InjectMocks
    PostServiceImp postService;

    static PostFollowedDTO postFollowedDTO;
    static HashMap<Integer, User> list_users;

    @BeforeAll
    static void initialize(){
        User user1= new User(1,"usuario1");
        User user2= new User(2,"usuario2");
        list_users = new HashMap<>();
        list_users.put(1,user1);
        list_users.put(2,user2);

        LocalDate date1 = LocalDate.of(2021,11,25);
        LocalDate date2 = LocalDate.of(2021,11,22);
        LocalDate date3 = LocalDate.of(2021,11,21);

        List<Post> posts=new ArrayList<>();

        ProductDetails productDetails = new ProductDetails(1,"producto1","Prueba","marca","verde","ninguna");
        Post post1 = new Post(2,1,date1,productDetails,1,10.0);
        Post post2 = new Post(2,2,date2,productDetails,1,10.0);
        Post post3 = new Post(2,3,date3,productDetails,1,10.0);

        posts.add(post1);
        posts.add(post2);
        posts.add(post3);

        postFollowedDTO=new PostFollowedDTO(1, posts);
    }



    //T-0005 y T-0006
    //cuando el orden es ascendente no se le pasa parametro de orden a la funcion ya que el orden por defecto es ascendente desde el repositorio, o si el valor de order es
    // incorrecto se devuelve la lista en orden ascendente
    @Test
    void getProductsFollowedListWithOrderASC(){
        //arrange
        Integer user_id=1;

        //act
        Mockito.when(postRepository.productListFollowed(list_users.get(user_id))).thenReturn(postFollowedDTO);
        postService.productListFollowed(list_users,user_id);

        //assert
        Mockito.verify(postRepository,Mockito.atLeastOnce()).productListFollowed(list_users.get(user_id));
    }

    //retorna el reverse de la lista que viene del repositorio
    @Test
    void getProductsFollowedListWithOrderDESC(){
        //arrange
        Integer user_id=1;
        Integer last_post_id_list=3;
        //act
        Mockito.when(postRepository.productListFollowed(list_users.get(user_id))).thenReturn(postFollowedDTO);
        PostFollowedDTO result = postService.productListFollowed(list_users,1,"date_desc");

        //assert - se compara que el ultimo post de la lista que devuelve el repo sea el primero al llamar el service
        Assertions.assertEquals(last_post_id_list,result.getPosts().get(0).getId_post());
        Mockito.verify(postRepository,Mockito.atLeastOnce()).productListFollowed(list_users.get(user_id));
    }


    //T-0008
    //el repo hace el filtro


}
