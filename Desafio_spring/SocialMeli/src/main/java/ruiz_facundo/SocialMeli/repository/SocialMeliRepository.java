package ruiz_facundo.SocialMeli.repository;

import org.springframework.stereotype.Repository;
import ruiz_facundo.SocialMeli.model.Post;
import ruiz_facundo.SocialMeli.model.PromoPost;
import ruiz_facundo.SocialMeli.model.User;

import java.time.Duration;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.DAYS;

@Repository
public class SocialMeliRepository implements SocialMeliRepositoryI {
    private HashMap<Long, User> users;
    private HashMap<Long, Post> posts;

    public SocialMeliRepository() {
        // Load from JSON
        this.users = new HashMap<>();
        this.posts = new HashMap<>();
        this.users.put(1L, new User(1L, "carlotem"));
        this.users.put(2L, new User(2L, "simigaga"));
        this.users.put(3L, new User(3L, "julio_88"));
        this.users.put(4L, new User(4L, "mateo_galpesin_1997"));
    }

    @Override
    public void addFollow(Long idNewFollower, Long idNewFollowed) {
        User newFollower = this.users.get(idNewFollower);
        newFollower.follow(idNewFollowed);
        User newFollowed = this.users.get(idNewFollowed);
        newFollowed.addFollower(idNewFollower);
    }

    @Override
    public void removeFollow(Long idOldFollower, Long idOldFollowed) {
        User oldFollower = this.users.get(idOldFollower);
        oldFollower.unfollow(idOldFollowed);
        User oldFollowed = this.users.get(idOldFollowed);
        oldFollowed.removeFollower(idOldFollower);
    }

    @Override
    public User getUser(Long idUser) {
        return this.users.get(idUser);
    }

    @Override
    public List<User> getFollowers(Long idUser) {
        return this.users.get(idUser).getFollowers().stream().map(
                i -> this.users.get(i)).collect(Collectors.toList());
    }

    @Override
    public List<User> getFollowed(Long idUser) {
        return this.users.get(idUser).getFollowed().stream().map(
                i -> this.users.get(i)).collect(Collectors.toList());
    }

    @Override
    public void addPostToUser(Long idUser, Post newPost) {
        this.users.get(idUser).publish(newPost.getId());
        this.posts.put(newPost.getId(), newPost);
    }

    @Override
    public List<Post> getRecentPosts(Long idUser) {
        LocalDate today = LocalDate.now();
        return this.users.get(idUser).getPosts().stream().map(
                i -> this.posts.get(i)).filter(
                        p -> DAYS.between(p.getPublishDate(), today) < 14).
                collect(Collectors.toList());
    }

    @Override
    public boolean isValidUser(Long idUser) {
        return !Objects.isNull(this.users.get(idUser));
    }

    @Override
    public boolean isValidPost(Long idPost) {
        return !Objects.isNull(this.posts.get(idPost));
    }

    @Override
    public List<Post> getPromoPosts(Long idUser) {
        return this.users.get(idUser).getPosts().stream().map(
                i -> this.posts.get(i)).filter(p->p.hasPromo()).
                collect(Collectors.toList());
    }
}
