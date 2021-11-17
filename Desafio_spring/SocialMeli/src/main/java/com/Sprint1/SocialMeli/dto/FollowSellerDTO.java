package com.Sprint1.SocialMeli.dto;

import com.Sprint1.SocialMeli.model.User;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class FollowSellerDTO {
    private int user_id;
    private String user_name;
    private FollowerDTO followers;


    public FollowSellerDTO(User user) {
        this.user_id = user.getUser_id();
        this.user_name = user.getUser_name();

    }
}
