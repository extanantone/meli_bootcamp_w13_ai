package com.bootcamp.socialmeli.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class User {

    private long userId;
    private String userName;
    private List<Long> followers;
    private List<Long> followed;
    private List<Long> post;


    public User(long userId, String userName) {
        this.userId = userId;
        this.userName = userName;
        this.followers = new ArrayList<>();
        this.followed = new ArrayList<>();
        this.post = new ArrayList<>();
    }

    public void addFollowed (Long idNewFollowed) {
        this.followed.add(idNewFollowed);
    }

    public boolean unFollowed (Long idFollowed) {
        return this.followed.removeIf(i -> i == idFollowed);
    }

    public void addFollower (Long idNewFollower) {
        this.followers.add(idNewFollower);
    }

    public boolean removeFollower (Long idFollower) {
        return this.followers.removeIf(i -> i == idFollower);
    }

    public Integer getFollowersCount () {
        return this.followers.size();
    }

    public void addNewPost(long idPost){this.post.add(idPost);}

    public List<Long> getPosts() {
        return this.post;
    }
}
