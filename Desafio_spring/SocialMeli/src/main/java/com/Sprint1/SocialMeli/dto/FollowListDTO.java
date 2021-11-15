package com.Sprint1.SocialMeli.dto;

import com.Sprint1.SocialMeli.model.User;

import java.util.ArrayList;

public class FollowListDTO {
    private int user_id;
    private String user_name;
    private ArrayList<User> followers = new ArrayList();

    public FollowListDTO(int user_id, String user_name, ArrayList<User> followers) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.followers = followers;
    }

    @Override
    public String toString() {
        return "FollowListDTO{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", followers=" + followers +
                '}';
    }
}
