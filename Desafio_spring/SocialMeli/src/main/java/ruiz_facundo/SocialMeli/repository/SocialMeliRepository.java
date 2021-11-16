package ruiz_facundo.SocialMeli.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;
import ruiz_facundo.SocialMeli.model.Post;
import ruiz_facundo.SocialMeli.model.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.DAYS;

@Repository
public class SocialMeliRepository implements SocialMeliRepositoryI {
    private final HashMap<Long, User> users;
    private final HashMap<Long, Post> posts;

    public SocialMeliRepository() {
        this.users = (HashMap<Long, User>) this.loadUsersFromJSON();
        this.posts = (HashMap<Long, Post>) this.loadPostsFromJSON();
    }

    private Map<Long, User> loadUsersFromJSON() {
        File file = null;
        try { file = ResourceUtils.getFile("classpath:users.json");
        } catch (FileNotFoundException e) { e.printStackTrace(); }
        ObjectMapper objectMapper = new ObjectMapper();
        List<User> userList = null;
        try { userList = objectMapper.readValue(file, new TypeReference<List<User>>() {});
        } catch (IOException e) { e.printStackTrace(); }
        return userList.stream().collect(Collectors.toMap(User::getId, Function.identity()));
    }

    private Map<Long, Post> loadPostsFromJSON() {
        File file = null;
        try { file = ResourceUtils.getFile("classpath:posts.json");
        } catch (FileNotFoundException e) { e.printStackTrace(); }
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        List<Post> postList = null;
        try { postList = objectMapper.readValue(file, new TypeReference<List<Post>>() {});
        } catch (IOException e) { e.printStackTrace(); }
        return postList.stream().collect(Collectors.toMap(Post::getId, Function.identity()));
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
        return this.users.get(idUser).getFollowers().stream().map(this.users::get).
                collect(Collectors.toList());
    }

    @Override
    public List<User> getFollowed(Long idUser) {
        return this.users.get(idUser).getFollowed().stream().map(this.users::get).
                collect(Collectors.toList());
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
                this.posts::get).filter(p -> DAYS.between(p.getPublishDate(), today) < 14).
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
        return this.users.get(idUser).getPosts().stream().map(this.posts::get).
                filter(Post::isHasPromo).collect(Collectors.toList());
    }
}
