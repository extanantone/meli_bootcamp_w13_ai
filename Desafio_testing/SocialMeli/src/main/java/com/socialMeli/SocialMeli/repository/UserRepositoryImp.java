package com.socialMeli.SocialMeli.repository;

import com.socialMeli.SocialMeli.exception.userExceptions.AlreadyFollowedUserException;
import com.socialMeli.SocialMeli.exception.userExceptions.NotFollowingUserException;
import com.socialMeli.SocialMeli.userDto.*;
import com.socialMeli.SocialMeli.model.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class UserRepositoryImp implements UserRepository{
    private HashMap<Integer, User> list_users = new HashMap<>();

    @Override
    public HashMap<Integer, User> getList_users() {
        return list_users;
    }

    @Override
    public void loadUsers() {
        User user1= new User(1,"usuario1");
        User user2= new User(2,"usuario2");
        User user3= new User(3,"vendedor1");
        User user4= new User(4,"vendedor2");
        list_users.put(1,user1);
        list_users.put(2,user2);
        list_users.put(3,user3);
        list_users.put(4,user4);
    }

    @Override
    public UserFollowDTO follow(Integer user_id, Integer user_to_follow_id) {
        User user = list_users.get(user_id);
        User user_to_follow = list_users.get(user_to_follow_id);
        if(user.getFollowing().contains(user_to_follow_id)){
            throw new AlreadyFollowedUserException();
        }
        user.getFollowing().add(user_to_follow_id);
        user_to_follow.getFollowers().add(user_id);
        UserFollowDTO userDTO = new UserFollowDTO(user);
        return userDTO;
    }

    @Override
    public UserFollowersCountDTO countFollowers(Integer user_id) {
        User user = list_users.get(user_id);
        UserFollowersCountDTO userFollowersCountDTO = new UserFollowersCountDTO(user.getId(),user.getUsername(),user.getFollowers().size());
        return userFollowersCountDTO;
    }

    @Override
    public FollowersListDTO listFollowers(Integer user_id) {
        User user= list_users.get(user_id);
        FollowersListDTO listDTO = new FollowersListDTO(user.getId(),user.getUsername());
        for (Integer follower_id: user.getFollowers()) {
            User follower= list_users.get(follower_id);
            UserInfoDTO followerDTO=new UserInfoDTO(follower.getId(), follower.getUsername());
            listDTO.addFollowerDTO(followerDTO);
        }
        return listDTO;
    }

    @Override
    public FollowedListDTO listFollowed(Integer user_id) {
        User user= list_users.get(user_id);
        FollowedListDTO listDTO = new FollowedListDTO(user.getId(),user.getUsername());
        for (Integer followed_id: user.getFollowing()) {
            User followed= list_users.get(followed_id);
            UserInfoDTO followedDTO=new UserInfoDTO(followed.getId(), followed.getUsername());
            listDTO.addFollowedDTO(followedDTO);
        }
        return listDTO;
    }

    @Override
    public UserFollowDTO unfollow(Integer user_id, Integer user_id_to_unfollow) {
        if(!list_users.get(user_id).getFollowing().contains(user_id_to_unfollow)){
            throw new NotFollowingUserException();
        }
        list_users.get(user_id).getFollowing().remove(user_id_to_unfollow);
        list_users.get(user_id_to_unfollow).getFollowers().remove(user_id);
        UserFollowDTO userDTO = new UserFollowDTO(list_users.get(user_id));
        return userDTO;
    }
}
