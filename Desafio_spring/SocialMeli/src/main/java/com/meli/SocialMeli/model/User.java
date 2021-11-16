package com.meli.SocialMeli.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class User {
    private int userId;
    private String userName;
    private List<User>followers = new LinkedList<>();
    private List<User>followed = new LinkedList<>();

    public User(int id, String userName) {
        this.userId = id;
        this.userName = userName;
    }
}
