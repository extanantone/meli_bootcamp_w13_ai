package com.bootcamp.SocialMeli.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer user_id;
    private String user_name;
    private List<Integer> follower;
    private List<Integer> followed;
    private List<Integer> publication;

    public User(Integer user_id, String user_name) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.follower = new ArrayList<>();
        this.followed = new ArrayList<>();
        this.publication = new ArrayList<>();
    }

    public void follow(Integer newFollowed) {
        this.followed.add(newFollowed);
    }

    public boolean unfollow(Integer followed) {
        return this.followed.removeIf(i -> i == followed);
    }

    public void addFolower(Integer newFollower) {
        this.follower.add(newFollower);
    }

    public Integer followersCount(){
        return this.follower.size();
    }

    public boolean unfollowFollower(Integer follower) {
        eturn this.follower.removeIf(i -> i == follower);
    }

    public void publicar(Integer newPublication) {
        this.publication.add(newPublication);
    }

    public List<Integer> getPublications() {
        return this.publication;
    }
}
