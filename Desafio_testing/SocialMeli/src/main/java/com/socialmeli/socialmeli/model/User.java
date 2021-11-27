package com.socialmeli.socialmeli.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class User {
    List<Integer> followed;
    List<Integer> followers;
    List<Integer> publication;

    int user_id;
    String user_name;

    public User(int user_id, String user_name) {
        followed = new ArrayList<Integer>();
        followers = new ArrayList<Integer>();
        publication = new ArrayList<Integer>();
        this.user_id = user_id;
        this.user_name = user_name;
    }

    public boolean isInFollowed(int user_id){
        return followed.contains(user_id);
    }

    public void addFollowed(int user_id_to_follow){
         followed.add(user_id_to_follow);
    }
    public void addFollower(int user_id){
        followers.add(user_id);
    }

    public int countFollowers(){
        return followers.size();
    }

    public void addPublication(int id_post){
        publication.add(id_post);
    }

    public void unFollowInFollowed(int user_id_to_unfollow){
        followed.remove(followed.indexOf(user_id_to_unfollow));
    }
    public void unFollowInFollower(int user_id_unfollower){
        followers.remove(followers.indexOf(user_id_unfollower));
    }
}
