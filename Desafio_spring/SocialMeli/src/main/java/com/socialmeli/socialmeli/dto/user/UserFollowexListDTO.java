package com.socialmeli.socialmeli.dto.user;

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
public class UserFollowexListDTO{
    int user_id;
    String user_name;
    List<UserDTO> followers;

    public UserFollowexListDTO(int user_id, String user_name) {
        this.user_id = user_id;
        this.user_name = user_name;
        followers = new ArrayList<UserDTO>();
    }

    public void addFollowers(UserDTO userDTO){
        followers.add(userDTO);
    }


}
