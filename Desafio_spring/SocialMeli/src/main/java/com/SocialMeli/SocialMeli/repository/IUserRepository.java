package com.SocialMeli.SocialMeli.repository;

import com.SocialMeli.SocialMeli.entity.User;

import java.util.Map;

public interface IUserRepository {
    public User getUser(int id);
    public boolean addFollower(int userId, int sellerId);
    public Map<Integer, User> getFollowers(int sellerId);
    public Map<Integer, User> getFollowed(int buyerId);
    public boolean  unFollowSeller(int userId, int sellerId);
}
