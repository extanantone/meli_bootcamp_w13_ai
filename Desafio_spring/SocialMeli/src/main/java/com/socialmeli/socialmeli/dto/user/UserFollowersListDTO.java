package com.socialmeli.socialmeli.dto.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.socialmeli.socialmeli.dto.post.PostDTO;
import com.socialmeli.socialmeli.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class UserFollowersListDTO {
    int user_id;
    String user_name;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    List<UserDTO> followers;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    List<UserDTO> followed;

    public UserFollowersListDTO(int user_id, String user_name,boolean userFollowers) {
        this.user_id = user_id;
        this.user_name = user_name;
        if (userFollowers) {
            followers = new ArrayList<UserDTO>();
            followed = null;
        } else{
            followed = new ArrayList<UserDTO>();
            followers=null;
        }


    }

    public void addFollowers(UserDTO userDTO,boolean useFollowers){
        if (useFollowers){
            followers.add(userDTO);
            followed = null;
        } else {
            followed.add(userDTO);
            followers = null;
        }

    }


}
