package com.bootcamp.socialmeli.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO implements Comparable<UserDTO>{
    @JsonProperty("user_id")
    private Long userID;
    @JsonProperty("user_name")
    private String userName;

    @Override
    public int compareTo(UserDTO o) {
        return this.userName.compareTo(o.getUserName());
    }
}
