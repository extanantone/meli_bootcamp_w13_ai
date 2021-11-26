package meli.bootcamp.socialmeli.repository;

import meli.bootcamp.socialmeli.model.PromoPost;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PromoPostRepository implements IPromoPostRepository{
    private final List<PromoPost> mListPromoPosts= new ArrayList<>();


    @Override
    public void addPromoPost(PromoPost newPost) {
        this.mListPromoPosts.add(newPost);
    }

    @Override
    public Optional<PromoPost> findPromoPostById(int postID) {
        return mListPromoPosts.stream()
                .filter(post -> post.getPostId() == postID)
                .findFirst();
    }

    @Override
    public boolean existPromoPost(int postID) {
        return mListPromoPosts.stream()
                .anyMatch(post -> post.getPostId() == postID);
    }

    @Override
    public PromoPost updatePromoPostById(PromoPost updatePost) {
        return null;
    }

    @Override
    public void deletePromoPost(int postID) {
        mListPromoPosts.remove(mListPromoPosts
                .stream()
                .filter(promoPost -> promoPost.getPostId()==postID)
                .findFirst().get()
        );
    }

    @Override
    public List<PromoPost> getAllList() {
        return this.mListPromoPosts;
    }
}
