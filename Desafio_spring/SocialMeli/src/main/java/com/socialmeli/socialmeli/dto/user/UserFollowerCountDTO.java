package com.socialmeli.socialmeli.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserFollowerCountDTO {
    int user_id;
    String user_name;
    int followers_count;
}
