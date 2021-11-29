package com.Sprint1.SocialMeli.model;

import com.Sprint1.SocialMeli.dto.FollowerDTO;
import com.Sprint1.SocialMeli.dto.PostDTO;
import lombok.*;

import java.util.ArrayList;

@Data
@NoArgsConstructor @AllArgsConstructor

public class User {
    private int user_id;
    private String user_name;


    private ArrayList<FollowerDTO> followers = new ArrayList();

    private ArrayList<FollowerDTO> followed = new ArrayList();

    private ArrayList<PostDTO> post = new ArrayList();

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
                ", followed=" + followed +
                ", post=" + post +
                '}';
    }
}
