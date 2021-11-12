package ruiz_facundo.SocialMeli.model;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class User {
    private Long id;
    private String name;
    private List<Long> followers;
    private List<Long> followed;
    private List<Long> posts;

    public User () {}

    public User (Long inId, String inName) {
        this.id = inId;
        this.name = inName;
        this.followers = new ArrayList<>();
        this.followed = new ArrayList<>();
        this.posts = new ArrayList<>();
    }

    public Long getId () {
        return this.id;
    }

    public String getName () {
        return this.name;
    }

    public Integer getFollowersCount () {
        return this.followers.size();
    }

    public List<Long> getFollowers () {
        return this.followers;
    }

    public List<Long> getFollowed () {
        return this.followed;
    }

    public void follow (Long idNewFollowed) {
        this.followed.add(idNewFollowed);
    }

    public boolean unfollow (Long idOldFollowed) {
        return this.followed.removeIf(i -> i == idOldFollowed);
    }

    public void addFollower (Long idNewFollower) {
        this.followers.add(idNewFollower);
    }

    public boolean removeFollower (Long idOldFollower) {
        return this.followers.removeIf(i -> i == idOldFollower);
    }

    public void publish (Long idNewPost) {
        this.posts.add(idNewPost);
    }

    public List<Long> getPosts() {
        return this.posts;
    }
}
