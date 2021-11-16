package com.socialmeli.socialmeli.repository;

import com.socialmeli.socialmeli.model.Post;
import com.socialmeli.socialmeli.model.Product;
import com.socialmeli.socialmeli.model.User;
import org.apache.tomcat.jni.Local;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository implements UserRepositoryI{
    private Map<Integer, User> userList = new HashMap<Integer, User>(){{
        User u1 = new User(1,"user1");

        u1.addPublication(1);
        put(1,u1);
        u1 = new User(2,"vendendor2");

        u1.addPublication(2);
        put(2,u1);
        u1 = new User(3,"vendendor3");
        u1.addPublication(3);
        u1.addPublication(4);
        u1.addPublication(5);
        put(3,u1);
    }};



    @Override
    public String addFollow(int user_id, int user_id_to_follow) {
        //Users exists
        if(userList.containsKey(user_id)){
            if(userList.containsKey(user_id_to_follow)){
                if(!userList.get(user_id).isInFollowed(user_id_to_follow)){
                    userList.get(user_id).addFollowed(user_id_to_follow);
                    userList.get(user_id_to_follow).addFollower(user_id);
                    return "true";
                } else {
                    return "existingRelationship";
                }
            } else {
                return "notExistentUserToFollow";
            }
        } else {
            return "notExistentUser";
        }
    }

    @Override
    public User getUser(int user_id) {
        return userList.get(user_id);
    }

    @Override
    public boolean userExists(int user_id) {
        return userList.containsKey(user_id);
    }

    @Override
    public void addPost(int user_id,int post_id) {
        userList.get(user_id).addPublication(post_id);
    }

    @Override
    public String getUserName(int user_id){
        return userList.get(user_id).getUser_name();
    }

    @Override
    public String unfollow(int user_id, int user_id_to_unfollow) {
        //Users exists
        if(userList.containsKey(user_id)){
            if(userList.containsKey(user_id_to_unfollow)){
                if(userList.get(user_id).isInFollowed(user_id_to_unfollow)){
                    userList.get(user_id).unFollowInFollowed(user_id_to_unfollow);
                    userList.get(user_id_to_unfollow).unFollowInFollower(user_id);
                    return "true";
                } else {
                    return "notExistingRelationship";
                }
            } else {
                return "notExistentUserToFollow";
            }
        } else {
            return "notExistentUser";
        }
    }

}
