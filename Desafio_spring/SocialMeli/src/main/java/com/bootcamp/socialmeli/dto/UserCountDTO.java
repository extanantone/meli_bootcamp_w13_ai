package com.bootcamp.socialmeli.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserCountDTO extends UserDTO{
    private Integer followers_count;

    public UserCountDTO(long user_id, String user_name, Integer followers_count) {
        super(user_id, user_name);
        this.followers_count = followers_count;
    }

}
