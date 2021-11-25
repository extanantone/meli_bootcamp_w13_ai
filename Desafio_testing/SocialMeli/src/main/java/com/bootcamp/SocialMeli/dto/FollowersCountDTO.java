package com.bootcamp.SocialMeli.dto;

import com.bootcamp.SocialMeli.entity.Post;
import com.bootcamp.SocialMeli.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FollowersCountDTO {
    private int user_id;
    private String user_name;
    private int followers_count;
}
