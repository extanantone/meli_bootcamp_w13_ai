package com.meli.SocialMeli.reposity;

import com.meli.SocialMeli.model.Post;
import com.meli.SocialMeli.model.Promo;
import com.meli.SocialMeli.model.User;

import java.util.List;

public interface IRepository {

    public User findUser(int idUser);
    public boolean containFollower(int idUserFollow, int idUser);
    public List<User> listFollowers(int idUser);
    public void addFollower(int idUser, int idUserFollower);
    public List<User> listFollowed(int idUser);
    public void addPost(Post post);
    public List<Post> listPostUsr(int userId);
    public boolean containPost(int idPost);
    public boolean containProduct(int userId, int idProduct);
    public void unfollow(int idUser, int idUserFollower);
    public void addPromo(Promo promo);
    public List<Promo> listPromoUsr(int userId);
    public boolean containPromo(int idPostPromo);
    public boolean containProductPromo(int userId, int idProductPromo);
}
