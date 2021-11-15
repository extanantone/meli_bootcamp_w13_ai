package com.Sprint1.SocialMeli.service;

import com.Sprint1.SocialMeli.dto.FollowCountDTO;
import com.Sprint1.SocialMeli.dto.FollowListDTO;
import com.Sprint1.SocialMeli.dto.FollowerDTO;
import com.Sprint1.SocialMeli.model.User;
import com.Sprint1.SocialMeli.repository.IUserRepository;
import org.springframework.stereotype.Service;

@Service

public class UserService implements IUserService{
    IUserRepository userRepository;


    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void followSeller(int user_id, int user_id_to_follow){
        User userFollower = this.userRepository.findUser(user_id).orElseThrow();
        User userFollowing = this.userRepository.findUser(user_id_to_follow).orElseThrow();

        System.out.println(userFollower);
        System.out.println(userFollowing);

//        userFollower sigue al usuario userFollowing
//        al usuario seguido "userFollowing" le agrego en followers los datos del usuario seguidor "userFollower"
        userFollowing.getFollowers().add(new FollowerDTO(userFollower.getUser_id(),userFollower.getUser_name()));

//      al usuario seguidor "userFollower" le agrego a followed los datos del usuario seguido "userFollowing"
        userFollower.getFollowed().add(new FollowerDTO(userFollowing.getUser_id(),userFollowing.getUser_name()));

        System.out.println("Despues de seguir");
        System.out.println( userFollower + " " + userFollower.getFollowed());
        System.out.println( userFollowing + " " + userFollowing.getFollowers());
    }

    @Override
    public FollowCountDTO followerCount (int user_id){
        User user = this.userRepository.findUser(user_id).orElseThrow();

        FollowCountDTO userFollowersCount = new FollowCountDTO(
                                                            user.getUser_id(),
                                                            user.getUser_name(),
                                                            user.getFollowers().size());
        System.out.println("userFollowersCount " + userFollowersCount);
        return userFollowersCount;
    }


    @Override
    public FollowListDTO followerList (int user_id){
        User user = this.userRepository.findUser(user_id).orElseThrow();

        FollowListDTO userFollowersList = new FollowListDTO(
                                                            user.getUser_id(),
                                                            user.getUser_name(),
                                                            user.getFollowers());
        System.out.println("userFollowersCount " + userFollowersList);
        return userFollowersList;
    }
}
