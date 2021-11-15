package com.Sprint1.SocialMeli.model;

import com.Sprint1.SocialMeli.dto.FollowerDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor

public class User {
    private int user_id;
    private String user_name;


    private ArrayList<User> followers = new ArrayList();

    private ArrayList<User> followed = new ArrayList();

    private ArrayList<User> post = new ArrayList();

    public User(int user_id, String user_name) {
        this.user_id = user_id;
        this.user_name = user_name;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", followers=" + followers +

                ", post=" + post +
                '}';
    }
}
