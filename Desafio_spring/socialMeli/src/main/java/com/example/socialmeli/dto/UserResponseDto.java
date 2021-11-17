package com.example.socialmeli.dto;

import com.example.socialmeli.model.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UserResponseDto extends UserDto{
    Integer followers_count;
    Integer promo_post_count;
    //TODO mapper user to userdto
    List<User> followers;
    List<User> followed;

    public UserResponseDto(Integer user_id,String user_name,Integer followers_count, Integer promo_post_count, List<User> followers, List<User> followed) {
        this.followers_count = followers_count;
        this.promo_post_count = promo_post_count;
        this.followers = followers;
        this.followed = followed;
        super.user_id = user_id;
        super.user_name = user_name;
    }
}
