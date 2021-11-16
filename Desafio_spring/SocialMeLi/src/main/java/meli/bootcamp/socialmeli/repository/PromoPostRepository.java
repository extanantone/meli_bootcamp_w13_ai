package meli.bootcamp.socialmeli.repository;

import meli.bootcamp.socialmeli.model.Post;
import meli.bootcamp.socialmeli.model.PromoPost;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PromoPostRepository implements IPromoPostRepository{
    private final List<PromoPost> mListPromoPosts= new ArrayList<>();


    @Override
    public void addPromoPost(PromoPost newPost) {
        this.mListPromoPosts.add(newPost);
    }

    @Override
    public Post findPromoPostById(int postID) {
        return mListPromoPosts.stream()
                .filter(post -> post.getPostId() == postID)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Post updatePromoPostById(int postID) {
        return null;
    }

    @Override
    public void deletePromoPost(int postID) {

    }

    @Override
    public List<PromoPost> getAllList() {
        return this.mListPromoPosts;
    }
}
