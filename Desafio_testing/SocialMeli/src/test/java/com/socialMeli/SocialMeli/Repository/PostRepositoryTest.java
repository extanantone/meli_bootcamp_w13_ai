package com.socialMeli.SocialMeli.Repository;

import com.socialMeli.SocialMeli.model.Post;
import com.socialMeli.SocialMeli.model.ProductDetails;
import com.socialMeli.SocialMeli.model.User;
import com.socialMeli.SocialMeli.postDTO.PostFollowedDTO;
import com.socialMeli.SocialMeli.repository.PostRepositoryImp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.*;

@ExtendWith(MockitoExtension.class)
public class PostRepositoryTest {

    PostRepositoryImp postRepository=new PostRepositoryImp();

    static HashMap<Integer, User> list_users;
    static Map<Integer,Post> postList;

    @BeforeAll
    static void initialize(){
        User user1= new User(1,"usuario1");
        User user2= new User(2,"usuario2");

        //el usuario 1 sigue al 2
        user1.setFollowing(Arrays.asList(2));

        list_users = new HashMap<>();
        list_users.put(1,user1);
        list_users.put(2,user2);


        //estan en desorden
        LocalDate date1 = LocalDate.of(2021,11,18);
        LocalDate date2 = LocalDate.of(2021,11,21);
        LocalDate date3 = LocalDate.of(2021,11,20);

        //de mas de 15 dias
        LocalDate date4 = LocalDate.of(2021,11,9);


        ProductDetails productDetails = new ProductDetails(1,"producto1","Prueba","marca","verde","ninguna");
        Post post1 = new Post(2,1,date1,productDetails,1,10.0);
        Post post2 = new Post(2,2,date2,productDetails,1,10.0);
        Post post3 = new Post(2,3,date3,productDetails,1,10.0);
        Post post4 = new Post(2,4,date3,productDetails,1,10.0);

        postList=new HashMap<>();

        postList.put(1,post1);
        postList.put(2,post2);
        postList.put(3,post3);
        postList.put(3,post4);

    }

    //T-0005 y T-0006

    //retorna la postList ordenada de manera ASC
    @Test
    void listPostsFollowedUsers(){
        //arrange
        Integer user_id=1;

        //act
        postRepository.setPostList(postList);
        PostFollowedDTO result = postRepository.productListFollowed(list_users.get(user_id));

        //assert
        Assertions.assertEquals(2,result.getPosts().get(0).getId_post());
        Assertions.assertEquals(1,result.getPosts().get(2).getId_post());
    }

    //T-0008
    @Test
    void listPostFollowedUsersLast2Weeks(){
        //arrange
        Integer user_id=1;

        //act
        postRepository.setPostList(postList);
        PostFollowedDTO result = postRepository.productListFollowed(list_users.get(user_id));

        //assert

        //no trae el post 4
        Assertions.assertEquals(3,result.getPosts().size());
    }
}
