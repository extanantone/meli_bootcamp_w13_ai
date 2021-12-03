package com.bootcamp.SocialMeli.service;

import com.bootcamp.SocialMeli.dto.*;
import com.bootcamp.SocialMeli.exception.*;
import com.bootcamp.SocialMeli.model.User;
import com.bootcamp.SocialMeli.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository repositoryUsers;


    public UserServiceImpl(UserRepository repositoryUsers) {
        this.repositoryUsers = repositoryUsers;
    }

    @Override
    public List<UserDTO> allUsers(){
        return repositoryUsers.getUsers();
    }

    @Override
    public UserDTO getUserById(int userId) {
        return repositoryUsers.getUsers().stream().
                filter(u -> u.getUserId() == userId).findFirst().orElse(null);
    }

    @Override
    public void followUser(int userId, int userIdToFollow){
        if(!repositoryUsers.userExists(userId)){
            throw new UserIdNotFoundException(userId);
        }
        if (!repositoryUsers.userExists(userIdToFollow)){
            throw new UserIdNotFoundException(userIdToFollow);
        }
        else {
            UserDTO user = getUserById(userId);
            UserDTO userToFollow = getUserById(userIdToFollow);
            if (user.getFollowed().contains(userToFollow)){
                throw new UserAlreadyFollowedException(userToFollow.getUserId());
            }
            ;
            user.getFollowed().add(userToFollow);
            userToFollow.getFollowers().add(user);
        }
    }

    @Override
    public void unfollowUser(int userId, int userIdToFollow){
        if(!repositoryUsers.userExists(userId)){
            throw new UserIdNotFoundException(userId);
        }
        if (!repositoryUsers.userExists(userIdToFollow)){
            throw new UserIdNotFoundException(userIdToFollow);
        }
        else {
            UserDTO user = getUserById(userId);
            UserDTO userToUnfollow = getUserById(userIdToFollow);
            if (!user.getFollowed().contains(userToUnfollow)) {
                throw new NotFollowingUserException(userToUnfollow.getUserId());
            }
            user.getFollowed().remove(userToUnfollow);
            userToUnfollow.getFollowers().remove(user);
        }
    }

    public UserCountFollowersDTO countFollowers (int userId){
        return new UserCountFollowersDTO
                (userId,getUserById(userId).getUserName(),getUserById(userId).getFollowers_count());

    }

    @Override
    public UserFollowersDTO getFollowersList(int userId){



        //------------------
        UserDTO user = getUserById(userId);
        UserFollowersDTO userResponse = new UserFollowersDTO(user.getUserId(),user.getUserName());
        List<UserDTO> followers = user.getFollowers();
        for ( UserDTO u: followers){
            User follower = new User(u.getUserId(),u.getUserName());
            userResponse.getFollowers().add(follower);
        }
        return userResponse;
    }
    @Override
    public UserFollowedDTO getFollowedList(int userId){
        UserDTO user = getUserById(userId);
        UserFollowedDTO userResponse = new UserFollowedDTO(user.getUserId(),user.getUserName());
        List<UserDTO> followed = user.getFollowed();
        for ( UserDTO u: followed){
            User followedUser = new User(u.getUserId(),u.getUserName());
            userResponse.getFollowed().add(followedUser);
        }
        return userResponse;
    }

    @Override
    public UserFollowedDTO orderByNameFollowed(int userId, String order){
        if (repositoryUsers.userExists(userId)){
            List<User> followed = getFollowedList(userId).getFollowed();
            if(order.equalsIgnoreCase("name_asc"))
                followed.sort(Comparator.comparing(User::getUserName));
            else{
                if(order.equalsIgnoreCase("name_desc"))
                {followed.sort(Comparator.comparing(User::getUserName).reversed());}
                else{throw new NotValidParamException(order);}
            }
            UserFollowedDTO userResponseFollowed =
                    new UserFollowedDTO(userId,getFollowedList(userId).getUserName(),followed);
            return userResponseFollowed;

        }
        else {throw new UserIdNotFoundException(userId);}

    }


    @Override
    public UserFollowersDTO orderByNameFollowers(int userId, String order){
        if (repositoryUsers.userExists(userId)){
            List<User> followers = getFollowersList(userId).getFollowers();
            if(order.equalsIgnoreCase("name_asc"))
                followers.sort(Comparator.comparing(User::getUserName));
            else{
                if(order.equalsIgnoreCase("name_desc"))
                {followers.sort(Comparator.comparing(User::getUserName).reversed());}
                else{throw new NotValidParamException(order);}
            }
            UserFollowersDTO userResponseFollowers =
                    new UserFollowersDTO(userId,getFollowersList(userId).getUserName(),followers);

            return userResponseFollowers;
        }else {throw new UserIdNotFoundException(userId);}

    }

}
