package com.SocialMeli.SocialMeli.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PostUserDTO extends PostDTO{
    private Integer user_id;

    @Override
    public String toString() {
        return "PostUserDTO{" +
                "user_id=" + user_id +
                '}';
    }
}
