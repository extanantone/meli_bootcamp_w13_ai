package com.socialMeli.SocialMeli.userDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserFollowersCountDTO {
    private Integer user_id;
    private String user_name;
    private Integer followers_count;

    public UserFollowersCountDTO(Integer user_id, String user_name, Integer followers_count) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.followers_count = followers_count;
    }

    @Override
    public String toString() {
        return "UserFollowersCountDTO{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", followers_count=" + followers_count +
                '}';
    }
}
