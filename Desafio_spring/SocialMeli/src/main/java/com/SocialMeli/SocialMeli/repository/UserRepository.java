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
        UserDTO userDTO = database.get(user_id-1);
        //System.out.println(userDTO.toString());

        return userDTO;
    }


    @Override
    public UserDTO follow(Integer user_id, Integer user_id_to_follow) {
        UserDTO current_user = findUserByUserId(user_id);
        UserDTO follow_user = findUserByUserId(user_id_to_follow);

        if( current_user != null && follow_user != null && user_id != user_id_to_follow ){
            //Al usuario actual se le agrega el usuario a seguir
            //List<UserDTO> followedList = current_user.getFollowed();
            List<Integer> followedList = current_user.getFollowed();
            if( followedList == null ){
                followedList = new ArrayList<>();
            }
            if( !followedList.contains(follow_user.getUser_id())  ){
                followedList.add(follow_user.getUser_id());
                current_user.setFollowed(followedList);
            }


            //Al usuario seguido se le agrega al usuario quién lo sigue
            //List<UserDTO> followersList = follow_user.getFollowers();
            List<Integer> followersList = follow_user.getFollowers();
            if( followersList == null ){
                followersList = new ArrayList<>();
            }
            if( !followersList.contains(current_user.getUser_id()) ){
                followersList.add(current_user.getUser_id());
                follow_user.setFollowers(followersList);
            }


        }

        return current_user;
    }
}
