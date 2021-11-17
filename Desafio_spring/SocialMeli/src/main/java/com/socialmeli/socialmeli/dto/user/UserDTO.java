package com.socialmeli.socialmeli.dto.user;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserDTO  implements Comparable<UserDTO> {
    int user_id;
    String user_name;

    @Override
    public int compareTo(UserDTO e) {
        return this.getUser_name().compareTo(e.getUser_name());
    }
}
