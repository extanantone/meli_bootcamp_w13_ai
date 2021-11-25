package com.socialmeli.repository;

import com.socialmeli.model.Post;
import com.socialmeli.model.User;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UserRepositoryTest {

    public IUserRepository userRepository = new UserRepository();

    // T008

    @Test
    public void shouldBeFilterPostOfLastTwoWeeks(){
        Post p1 = new Post(1, LocalDate.now().minusDays(3),1,"zapato","zapato","","black","",10,1,false,0);
        Post p2 = new Post(2, LocalDate.now().minusWeeks(6),1,"zapato","zapato","","black","",10,1,false,0);
        Post p3 = new Post(3, LocalDate.now().minusDays(5),1,"zapato","zapato","","black","",10,1,false,0);
        Post p4 = new Post(4, LocalDate.now().minusWeeks(8),1,"zapato","zapato","","black","",10,1,false,0);
        User buyer = new User(9,"pablo","pablo@mail.com",new ArrayList<>(),false,new ArrayList<>());
        User seller = new User(10,"pablo","pablo@mail.com",new ArrayList<>(),true,new ArrayList<>());
        seller.addFollower(buyer);
        seller.addPost(p1);
        seller.addPost(p2);
        seller.addPost(p3);
        seller.addPost(p4);
        userRepository.save(buyer);
        userRepository.save(seller);
        assertEquals(seller.getPosts().size(),4);
        List<Post> posts= userRepository.getPostLastTwoWeeksOfFollowed(9);
        assertEquals(posts.size(),2);
        for (Post p:posts){
            assertTrue(!p.getDate().isBefore(LocalDate.now().minusWeeks(2)));
        }

    }


    // More
    @Test
    public void shouldBeAddUser(){
        User buyer = new User(12,"pablo","pablo@mail.com",new ArrayList<>(),false,new ArrayList<>());
        int size = userRepository.findAll().size();
        userRepository.save(buyer);
        assertEquals(userRepository.findAll().size(),size+1);
    }

    @Test
    public void shouldBeFindExistUserByEmail(){
        assertNotNull(userRepository.findUserByEmail("david@mail.com"));
    }

    @Test
    public void  shouldntBeFindUnexistUser(){
        assertNull(userRepository.findUserByEmail("nnoadd@test.com"));
    }

    @Test
    public void shouldBeFindAllSellers(){
        for(User user: userRepository.findAllSellers()){
            assertTrue(user.isSeller());
        }
    }

    @Test
    public void  shouldBeFindFollowedUser(){
        User follwer = userRepository.findUserByEmail("juan@mail.com");
        User followed = userRepository.findUserByEmail("diego@mail.com");
        followed.addFollower(follwer);
        assertTrue(followed.isFollower(follwer));
        List<User> followeds = userRepository.followedUser(follwer);
        assertEquals(followeds.size(),1);
        assertEquals(followeds.get(0),followed);
    }

}
