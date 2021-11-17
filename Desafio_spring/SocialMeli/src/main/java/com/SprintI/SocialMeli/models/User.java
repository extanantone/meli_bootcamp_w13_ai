package com.SprintI.SocialMeli.models;

import com.SprintI.SocialMeli.exceptions.NoAdmitedUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private List<User> followers;
    private List<Post> post;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
        this.followers = new ArrayList<>();
        this.post = new ArrayList<>();
    }

    public void follow(User user){
        if (isFollower(user))
            throw new NoAdmitedUser("Now you follow this user");
        else
            this.followers.add(user);
    }

    public boolean isFollower(User user){
        return  followers.contains(user);
    }

    public void unfollow(User user){
        if (isFollower(user))
            this.followers.remove(user);
        else
            throw new NoAdmitedUser(String.format("This user don't followed with %s",user.getName()));
    }
    public void addPost(Post post) {
        this.post.add(post);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", followers=" + followers +
                ", post=" + post+
                '}';
    }
}
