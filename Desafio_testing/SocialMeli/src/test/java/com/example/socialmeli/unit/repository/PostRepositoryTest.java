package com.example.socialmeli.unit.repository;

import com.example.socialmeli.TestUtilsGet;
import com.example.socialmeli.model.Post;
import com.example.socialmeli.repositories.IRepository;
import com.example.socialmeli.repositories.PostRepository;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Optional;

import static com.example.socialmeli.TestUtilsGet.*;

public class PostRepositoryTest {
    IRepository repoPosts = new PostRepository();

    @Test
    void findById(){
        Post zapatillasPost = getZapatillas();
        repoPosts.push(zapatillasPost);
        Post post = (Post) repoPosts.findById(1).get();

        assertAll(
                () -> assertEquals(1,post.getUserId()),
                () -> assertEquals(1,post.getIdPost()),
                () -> assertEquals(1,post.getDetail().getProductId()),
                () -> assertEquals("zapatillas",post.getDetail().getProductName())
        )
        ;


    }

}
