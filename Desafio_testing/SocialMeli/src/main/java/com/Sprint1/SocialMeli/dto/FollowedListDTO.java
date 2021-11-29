package com.Sprint1.SocialMeli.dto;

import com.Sprint1.SocialMeli.model.User;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class FollowedListDTO {
    private int user_id;
    private String user_name;
    private List<FollowerDTO> followed;

    public FollowedListDTO(int user_id, String user_name, List<FollowerDTO> followed) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.followed = followed;
    }

    @Override
    public String toString() {
        return "{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", followed=" + followed +
                '}';
    }
}
