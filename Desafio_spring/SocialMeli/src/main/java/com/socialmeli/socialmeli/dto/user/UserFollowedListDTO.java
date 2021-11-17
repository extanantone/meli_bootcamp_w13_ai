package com.socialmeli.socialmeli.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class UserFollowedListDTO {
    int user_id;
    String user_name;
    List<UserDTO> followed;

    public UserFollowedListDTO(int user_id, String user_name) {
        this.user_id = user_id;
        this.user_name = user_name;
        followed = new ArrayList<UserDTO>();
    }

    public void addFollowers(UserDTO userDTO){
        followed.add(userDTO);
    }


}
