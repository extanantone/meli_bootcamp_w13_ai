package meli.bootcamp.socialmeli.repository;

import meli.bootcamp.socialmeli.model.Post;
import meli.bootcamp.socialmeli.model.UserFollow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PostRepository implements IPostRepository{
    private final List<Post> mListPosts= new ArrayList<>();

    @Override
    public void addPost(Post newPost) {
        mListPosts.add(newPost);
    }

    @Override
    public Post findPostById(int postID) {
        return  mListPosts.stream()
                .filter(post -> post.getPostId() == postID)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Post updatePostById(Post updatePost) {
        return null;
    }

    @Override
    public void deletePost(int postID) {

    }
    @Override
    public List<Post> getAllList() {
        return mListPosts;
    }
}
