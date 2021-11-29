package com.example.SocialMeli.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)

public class User {

    private int userId;
    private String userName;
    private List<User> followers;
    private List<User> followed;
    private List<Publication> posts;


    public void addFollower(User user){
        this.followers.add(user);
    }

    public void addFollowed(User user){
        this.followed.add(user);
    }

    public void addPublication(Publication publication){
        this.posts.add(publication);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                //", followers=" + followers +
                ", followed=" + followed +
                ", posts=" + posts +
                '}';
    }
}
