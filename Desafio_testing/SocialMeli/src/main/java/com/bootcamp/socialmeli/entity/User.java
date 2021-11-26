package com.bootcamp.socialmeli.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long userId;
    private String userName;
    private List<User> followers;
    private List<User> followed;

    public boolean addFollower(User follower){
        return this.followers.add(follower);
    }

    public boolean addFollowed(User followed){
        return this.followed.add(followed);
    }

    public boolean removeFollower(User follower){
        if(!this.followers.contains(follower)) return true;
        return this.followers.remove(follower);
    }

    public boolean removeFollowed(User followed){
        if(!this.followers.contains(followed)) return true;
        return this.followed.remove(followed);
    }
}
