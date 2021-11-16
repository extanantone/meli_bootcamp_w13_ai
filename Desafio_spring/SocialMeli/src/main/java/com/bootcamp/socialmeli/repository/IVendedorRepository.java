package com.bootcamp.socialmeli.repository;

import com.bootcamp.socialmeli.model.Post;
import com.bootcamp.socialmeli.model.User;

import javax.swing.text.html.Option;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface IVendedorRepository {
    public List<User> openUserJson();
    public User getUser(Long idUser);
    public List<User> getFollowers(Long idUser);
    public List<User> getFolloweds(Long idUser);
    public void addFollow(Long idFollower, Long idFollowed);
    //post
    public void addPostToUser(Long idUser, Post post);
    public List<Post> getRecentPosts(Long idUser);


}
