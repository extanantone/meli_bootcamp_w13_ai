package com.Sprint1.SocialMeli.dto;

import com.Sprint1.SocialMeli.model.User;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class FollowersListDTO {
    private int user_id;
    private String user_name;
    private List<FollowerDTO> followers;

    public FollowersListDTO(int user_id, String user_name, List<FollowerDTO> followers) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.followers = followers;
    }

    @Override
    public String toString() {
        return "{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", followers=" + followers +
                '}';
    }
}
