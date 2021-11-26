package com.example.socialmeli.demo.unittest.repository;

import com.example.socialmeli.demo.exception.VendorNotFoundException;
import com.example.socialmeli.demo.model.Post;
import com.example.socialmeli.demo.repository.IPostRepository;
import com.example.socialmeli.demo.repository.PostRepository;
import org.hamcrest.number.OrderingComparison;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PostRepositoryTest {

IPostRepository postRepository;

    @BeforeEach
    private void initialize(){
        this.postRepository= new PostRepository();
    }



    //T 0005
    @Test
    void testToOrderByPostDateReturningAnOkResponse(){

        int userId = 3;
        String order = "date_asc";
        ResponseEntity expectedResponse = new ResponseEntity(HttpStatus.OK);


        //Act and Assert
        postRepository.getPostsFromFollowedUsersSinceTwoWeeks(userId,order);


    }

    @Test
        //Este test va a fallar, ya que en mi sistema, que el order sea null no provoca que arroje una excepcion
    void testToThrowARunTimeExceptionByPassingANullOrderForPosts(){

        int userId = 3;
        String order = null;
        RuntimeException expectedResponse = new RuntimeException();


        //Act and Assert
        Assertions.assertThrows(RuntimeException.class, new Executable() {

            @Override
            public void execute() throws Throwable {
                postRepository.getPostsFromFollowedUsersSinceTwoWeeks(userId,order);
            }
        });
    }

    //T 0006
    @Test
    void testThatPostsFromFollowedUsersAreInAscendingOrderByDate(){

        //Arrange
        List<Post> responsePosts = new ArrayList<>();
        LocalDate today = LocalDate.now();
        LocalDate dateFromOneWeek = LocalDate.now().minusWeeks(1);
        LocalDate dateFromTwoWeeks = LocalDate.now().minusWeeks(2);

        Post p1 = new Post();
        Post p2 = new Post();
        Post p3 = new Post();
        p1.setUserId(3);
        p2.setUserId(3);
        p3.setUserId(3);
        p2.setDate(dateFromOneWeek);
        p1.setDate(today);
        p3.setDate(dateFromTwoWeeks);

        postRepository.createPost(p1);
        postRepository.createPost(p2);
        postRepository.createPost(p3);

        //Act
        responsePosts = postRepository.getPostsFromFollowedUsersSinceTwoWeeks(3,"date_asc");

        //Check if list is ordered in an ascending order by date:

        boolean sorted = true;
        for (int i = 1; i < responsePosts.size(); i++) {
            if (responsePosts.get(i-1).getDate().compareTo(responsePosts.get(i).getDate()) > 0)
                sorted = false;
        }

        //Assert
        Assertions.assertTrue(sorted);


    }

    @Test
    void testThatPostsFromFollowedUsersAreInDescendingOrderedByDate(){

        //Arrange
        List<Post> responsePosts = new ArrayList<>();
        LocalDate today = LocalDate.now();
        LocalDate dateFromOneWeek = LocalDate.now().minusWeeks(1);
        LocalDate dateFromTwoWeeks = LocalDate.now().minusWeeks(2);

        Post p1 = new Post();
        Post p2 = new Post();
        Post p3 = new Post();
        p1.setUserId(3);
        p2.setUserId(3);
        p3.setUserId(3);
        p1.setDate(today);
        p3.setDate(dateFromTwoWeeks);
        p2.setDate(dateFromOneWeek);

        postRepository.createPost(p1);
        postRepository.createPost(p2);
        postRepository.createPost(p3);

        //Act
        responsePosts = postRepository.getPostsFromFollowedUsersSinceTwoWeeks(3,"date_desc");

        //Check if list is ordered in a descending order by date:

        boolean sorted = true;
        for (int i = 1; i < responsePosts.size(); i++) {
            if (responsePosts.get(i-1).getDate().compareTo(responsePosts.get(i).getDate()) < 0)
                sorted = false;
        }


        //Assert
        Assertions.assertTrue(sorted);


    }


    //T 0008
    @Test
    void testThatPostsFromUserFollowedVendorsAreNewerThantTwoWeeksAgo(){

        //Arrange}
        int expectedCorrectPosts = 2;
        List<Post> responsePosts = new ArrayList<>();
        LocalDate today = LocalDate.now();
        LocalDate dateFromTwoWeeks = LocalDate.now().minusWeeks(3);

        Post p1 = new Post();
        Post p2 = new Post();
        Post p3 = new Post();
        p1.setUserId(3);
        p2.setUserId(3);
        p3.setUserId(3);
        p1.setDate(today);
        p2.setDate(dateFromTwoWeeks);
        p3.setDate(today);

        postRepository.createPost(p1);
        postRepository.createPost(p2);
        postRepository.createPost(p3);

        //Act
        responsePosts = postRepository.getPostsFromFollowedUsersSinceTwoWeeks(3,null);

        //Assert
        Assertions.assertEquals(expectedCorrectPosts,responsePosts.size());


    }


}
