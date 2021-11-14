package com.bootcamp.socialmeli.entitiy;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Seller extends User {

    private HashMap<Integer,Post> posts;
    private List<Integer> followers;

    public Seller(int userID, String user_name) {
        super(userID, user_name);
        this.posts = new HashMap<>();
        this.followers = new ArrayList<>();
    }

    public void addFollower(Integer sellerId)
    {
        followers.add(sellerId);
    }
    public void deleteFollower(Integer sellerId)
    {
        followers.remove(sellerId);
    }

    public void setPost(Post post){
        posts.put(post.getPostId(),post);
    }

    public Post getPost(Integer postId){
        return posts.get(postId);
    }

}
