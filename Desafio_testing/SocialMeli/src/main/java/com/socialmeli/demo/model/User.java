package com.socialmeli.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Integer userId;
    private String userName;
    private String name;
    private String lastName;
    private List<User> followed;
    private List<User> followers;
    private List<Post> posts;

    public User(Integer userId, String userName, String name, String lastName) {
        this.userId = userId;
        this.userName = userName;
        this.name = name;
        this.lastName = lastName;
        this.followed = new LinkedList<User>();
        this.followers = new LinkedList<User>();
        this.posts = new LinkedList<Post>();
    }

    public User(String userName, String name, String lastName) {
        this.userName = userName;
        this.name = name;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", followed=" + followed +
                ", followers=" + followers +
                ", posts=" + posts +
                '}';
    }
}
