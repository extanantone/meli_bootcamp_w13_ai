package meli.bootcamp.socialmeli.repository;

import meli.bootcamp.socialmeli.mapper.PostMapper;
import meli.bootcamp.socialmeli.model.Post;
import meli.bootcamp.socialmeli.utils.TestUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PostRepositoryTest {
    IPostRepository postRepository;

    PostMapper postMapper;

    @BeforeEach @AfterEach
    public void setUp(){
        TestUtils.emptyObjectFile("post");
        this.postRepository= new PostRepository();
    }

    @Test
    public void createNewPostWithOneProduct(){
        //Arrange
        Post post= TestUtils.getPostWithRandomPostIDForAnyUser();

        //Act
        postRepository.addPost(post);

        //Assert
        Assertions.assertTrue(postRepository.existPost(post.getPostId()));
        Assertions.assertEquals(postRepository.findPostById(post.getPostId()).get(),post);
    }

    @Test
    public void deleteExistingPost(){
        //Arrange
        Post post= TestUtils.getPostWithRandomPostIDForAnyUser();
        postRepository.addPost(post);

        //Act
        postRepository.deletePost(post.getPostId());

        //Assert
        Assertions.assertFalse(postRepository.existPost(post.getPostId()));
        Assertions.assertFalse(postRepository.findPostById(post.getPostId()).isPresent());
    }

    @Test
    public void findIfPostExistsAndIsEqualsThanWereInserted(){
        //Arrange
        Post post= TestUtils.getPostWithRandomPostIDForAnyUser();
        postRepository.addPost(post);

        //Act
        postRepository.findPostById(post.getPostId());

        //Assert
        Assertions.assertTrue(postRepository.existPost(post.getPostId()));
        Assertions.assertEquals(postRepository.findPostById(post.getPostId()).get(), post);
    }

    @Test
    public void updatePostWithOneProduct(){
        //Arrange
        Post post= TestUtils.getPostWithRandomPostIDForAnyUser();

        //Act
        postRepository.addPost(post);

        //Assert
        Assertions.assertTrue(postRepository.existPost(post.getPostId()));
        Assertions.assertEquals(
                postRepository.findPostById(post.getPostId()).get(),
                post);
    }
}
