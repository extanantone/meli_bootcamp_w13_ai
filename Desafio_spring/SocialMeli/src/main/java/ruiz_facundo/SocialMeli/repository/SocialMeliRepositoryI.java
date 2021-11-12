package ruiz_facundo.SocialMeli.repository;

import ruiz_facundo.SocialMeli.model.Post;
import ruiz_facundo.SocialMeli.model.PromoPost;
import ruiz_facundo.SocialMeli.model.User;

import java.util.List;

public interface SocialMeliRepositoryI {
    void addFollow(Long idNewFollower, Long idNewFollowed);
    void removeFollow(Long idOldFollower, Long idOldFollowed);
    User getUser(Long idUser);
    List<User> getFollowers(Long idUser);
    List<User> getFollowed(Long idUser);
    void addPostToUser(Long idUser, Post newPost);
    List<Post> getRecentPosts(Long idUser);
    boolean isValidUser(Long idUser);
    boolean isValidPost(Long idPost);
    List<Post> getPromoPosts(Long idUser);
}
