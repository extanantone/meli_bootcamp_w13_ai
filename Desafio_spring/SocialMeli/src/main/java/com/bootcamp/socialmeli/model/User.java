package com.bootcamp.socialmeli.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class User {

    private long userId;
    private String userName;
    private List<Long> followers;
    private List<Long> followed;

    public User(long userId, String userName) {
        this.userId = userId;
        this.userName = userName;
        this.followers = new ArrayList<>();
        this.followed = new ArrayList<>();
    }

    public void addFollowed (Long idNewFollowed) {
        this.followed.add(idNewFollowed);
    }

    public void addFollower (Long idNewFollower) {
        this.followers.add(idNewFollower);
    }

    public Integer getFollowersCount () {
        return this.followers.size();
    }
}
