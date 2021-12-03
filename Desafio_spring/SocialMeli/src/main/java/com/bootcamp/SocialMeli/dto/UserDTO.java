package com.bootcamp.SocialMeli.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class UserDTO {
    private int userId;
    private String userName;
    private int followers_count;
    private List<UserDTO> followers;
    private List<UserDTO> followed;
    private List<ProductDTO> products;


    public UserDTO(String userName) {
        this.userName = userName;
    }

    public UserDTO(int userId, String userName) {
        this.userId = userId;
        this.userName = userName;
        this.followers = new ArrayList<>();
        this.followed = new ArrayList<>();
        this.products = new ArrayList<>();
    }

    public String toString(int userId, String userName, int followers_count) {
        return String.format("{ 'userId:' %int, 'userName': %s, followersCount: %int }",userId,userName,followers_count);
    }

}
