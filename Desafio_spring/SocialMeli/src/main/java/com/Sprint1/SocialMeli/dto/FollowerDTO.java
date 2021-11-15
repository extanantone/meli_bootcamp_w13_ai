package com.Sprint1.SocialMeli.dto;

import com.Sprint1.SocialMeli.model.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor

public class FollowerDTO extends User {
    private int user_id;
    private String user_name;

    public FollowerDTO(User user) {
        this.user_id = user.getUser_id();
        this.user_name = user.getUser_name();

    }

    @Override
    public String toString() {
        return "{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                '}';
    }
}
