package meli.bootcamp.socialmeli.repository;

import meli.bootcamp.socialmeli.model.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PostRepository implements IPostRepository{
    private final List<Post> mListPosts= new ArrayList<>();

    @Override
    public void addPost(Post newPost) {
        mListPosts.add(newPost);
    }

    @Override
    public Optional<Post> findPostById(int postID) {
        return  mListPosts.stream()
                .filter(post -> post.getPostId() == postID)
                .findFirst();
    }

    @Override
    public Post updatePostById(Post updatePost) {
        return null;
    }

    @Override
    public boolean existPost(int postID) {
        return mListPosts.stream()
                .anyMatch(post -> post.getPostId() == postID);
    }

    @Override
    public void deletePost(int postID) {
        mListPosts.remove(mListPosts
                .stream()
                .filter(post -> post.getPostId()==postID)
                .findFirst().get()
        );
    }
    @Override
    public List<Post> getAllList() {
        return mListPosts;
    }
}
