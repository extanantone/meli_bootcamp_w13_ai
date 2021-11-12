package com.SocialMeli.SocialMeli.repository;

import com.SocialMeli.SocialMeli.dto.UserDTO;
import org.apache.catalina.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository implements IUserRepository{

    private final List<UserDTO> database = new ArrayList<>();

    @Override
    public UserDTO save(UserDTO user) {
        if(user.getUser_id() == null){
            user.setUser_id(database.size()+1);
        }

        database.add(user);
        return user;
    }

    @Override
    public UserDTO findUserByUserId(Integer user_id) {
        UserDTO userDTO = database.get(user_id);
        return userDTO;
    }


    @Override
    public UserDTO follow(Integer user_id, Integer user_id_to_follow) {
        UserDTO current_user = findUserByUserId(user_id);
        UserDTO follow_user = findUserByUserId(user_id_to_follow);

        if( current_user != null && follow_user != null ){
            //Al usuario actual
            List<UserDTO> followedList = current_user.getFollowed();
            followedList.add(follow_user);
            current_user.setFollowed(followedList);
        }

        return current_user;
    }
}
