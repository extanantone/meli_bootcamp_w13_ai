package com.example.socialmeli.unit;

import com.example.socialmeli.model.Post;
import com.example.socialmeli.repositories.PostRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

public class PostRepositoryTest {
    private PostRepository repo = new PostRepository();
    private SocialMeliUnitUtils meliUtils = new SocialMeliUnitUtils();

    @Test
    public void newPushedPostShouldBeFound () {
        Integer newPostId = 1;
        Post newPost = this.meliUtils.genDefaultRecentPost(1, newPostId, "Gamer Microphone");

        this.repo.push(newPost);
        Optional<Post> foundPost = this.repo.findById(newPostId);

        Assertions.assertAll(
                () -> Assertions.assertFalse(foundPost.isEmpty()),
                () -> Assertions.assertTrue(this.meliUtils.arePostsEqual(newPost, foundPost.get()))
        );
    }

    @Test
    public void invalidIdShouldNotFindPost () {
        Integer invalidId = 1;

        Optional<Post> foundPost = this.repo.findById(invalidId);

        Assertions.assertTrue(foundPost.isEmpty());
    }

    @Test
    public void findAllShouldGetAllPosts () {
        Post firstPost = this.meliUtils.genDefaultRecentPost(1,1, "Gamer Mouse");
        Post secondPost = this.meliUtils.genDefaultRecentPost(1, 3, "Gamer Keyboard");

        this.repo.push(firstPost);
        this.repo.push(secondPost);
        List<Post> foundPosts = this.repo.findAll();

        Assertions.assertAll(
                () -> Assertions.assertEquals(2, foundPosts.size()),
                () -> Assertions.assertTrue(foundPosts.stream().
                        anyMatch(p -> this.meliUtils.arePostsEqual(firstPost, p))),
                () -> Assertions.assertTrue(foundPosts.stream().
                        anyMatch(p -> this.meliUtils.arePostsEqual(secondPost, p)))
        );
    }

    @Test
    public void validUserIdShouldFindTheirPosts () {
        Integer userId = 1;
        Integer notUserId = 2;
        Post userPost = this.meliUtils.genDefaultRecentPost(userId, 2, "Gamer Speakers");
        Post notUserPost = this.meliUtils.genDefaultRecentPost(notUserId, 3, "Gamer Webcam");

        this.repo.push(userPost);
        this.repo.push(notUserPost);
        List<Object> foundPosts = this.repo.findByUserId(userId);

        Assertions.assertAll(
                () -> Assertions.assertEquals(1, foundPosts.size()),
                () -> Assertions.assertTrue(foundPosts.stream().
                        anyMatch(p -> this.meliUtils.arePostsEqual(userPost, (Post) p))),
                () -> Assertions.assertTrue(foundPosts.stream().
                        noneMatch(p -> this.meliUtils.arePostsEqual(notUserPost, (Post) p)))
        );
    }

    @Test
    public void invalidUserIdShouldNotGetPosts () {
        Post firstPost = this.meliUtils.genDefaultRecentPost(1, 2, "Gamer Mouse pad");
        Post secondPost = this.meliUtils.genDefaultRecentPost(2, 3, "Gamer Back Light");
        Integer invalidUserId = 3;

        this.repo.push(firstPost);
        this.repo.push(secondPost);
        List<Object> foundPosts = this.repo.findByUserId(invalidUserId);

        Assertions.assertTrue(foundPosts.isEmpty());
    }

    @Test
    public void validUserIdShouldFindTheirPromos () {
        Integer userId = 1;
        Integer notUserId = 2;
        Post userPost = this.meliUtils.genDefaultRecentPost(userId, 2, "Gamer Blender");
        Post userPromo = this.meliUtils.genDefaultRecentPromo(userId, 1, "Gamer Toaster", 25.0);
        Post notUserPost = this.meliUtils.genDefaultRecentPost(notUserId, 3, "Gamer Fork");
        Post notUserPromo = this.meliUtils.genDefaultRecentPost(notUserId, 4, "Gamer Knife");

        this.repo.push(userPost);
        this.repo.push(userPromo);
        this.repo.push(notUserPost);
        this.repo.push(notUserPromo);
        List<Object> foundPosts = this.repo.findByUserIdAndHasPromo(userId, true);

        Assertions.assertAll(
                () -> Assertions.assertEquals(1, foundPosts.size()),
                () -> Assertions.assertTrue(foundPosts.stream().
                        anyMatch(p -> this.meliUtils.arePostsEqual(userPromo, (Post) p))),
                () -> Assertions.assertTrue(foundPosts.stream().
                        noneMatch(p -> this.meliUtils.arePostsEqual(userPost, (Post) p))),
                () -> Assertions.assertTrue(foundPosts.stream().
                        noneMatch(p -> this.meliUtils.arePostsEqual(notUserPost, (Post) p))),
                () -> Assertions.assertTrue(foundPosts.stream().
                        noneMatch(p -> this.meliUtils.arePostsEqual(notUserPromo, (Post) p)))
        );
    }

    @Test
    public void invalidUserIdShouldNotGetPromosNorPosts () {
        Post newPost = this.meliUtils.genDefaultRecentPost(1, 2, "Gamer Notebook");
        Post newPromo = this.meliUtils.genDefaultRecentPromo(2, 3, "Gamer Pen", 33.0);
        Integer invalidUserId = 3;

        this.repo.push(newPost);
        this.repo.push(newPromo);
        List<Object> foundPosts = this.repo.findByUserId(invalidUserId);

        Assertions.assertTrue(foundPosts.isEmpty());
    }

}
