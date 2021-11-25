package com.Sprint1.SocialMeli.service;

import com.Sprint1.SocialMeli.dto.FollowCountDTO;
import com.Sprint1.SocialMeli.dto.FollowedListDTO;
import com.Sprint1.SocialMeli.dto.FollowersListDTO;
import com.Sprint1.SocialMeli.dto.FollowerDTO;
import com.Sprint1.SocialMeli.exceptions.NotFoundException;
import com.Sprint1.SocialMeli.mapper.UserMapper;
import com.Sprint1.SocialMeli.model.User;
import com.Sprint1.SocialMeli.repository.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


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

        if(userFollower == userFollowing){
            throw new NotFoundException("Un usuario no puede seguirse a si mismo");
        }

        FollowerDTO dataUserFollower = new FollowerDTO(userFollower.getUser_id(),userFollower.getUser_name());
        FollowerDTO dataUserFollowing = new FollowerDTO(userFollowing.getUser_id(),userFollowing.getUser_name());

//        al usuario seguido "userFollowing" le agrego en followers los datos del usuario seguidor "userFollower"
        userFollowing.getFollowers().add(dataUserFollower);

//      al usuario seguidor "userFollower" le agrego a followed los datos del usuario seguido "userFollowing"
        userFollower.getFollowed().add(dataUserFollowing);

    }

    @Override
    public FollowCountDTO followerCount (int user_id){
        User user = this.userRepository.findUser(user_id).orElseThrow();
        return new FollowCountDTO(
                                                            user.getUser_id(),
                                                            user.getUser_name(),
                                                            user.getFollowers().size());
    }


    @Override
    public FollowersListDTO followerList(int user_id, String order){
        User user = this.userRepository.findUser(user_id).orElseThrow();
        FollowersListDTO userFollowersList = new FollowersListDTO(
                                                                user.getUser_id(),
                                                                user.getUser_name(),
                                                                user.getFollowers()) ;
        if (order == null){
            return new FollowersListDTO(
                    user.getUser_id(),
                    user.getUser_name(),
                    user.getFollowers()) ;
        }
        List<FollowerDTO> followersSorted = userFollowersList.getFollowers()
                .stream()
                .sorted(Comparator.comparing(FollowerDTO::getUser_name))
                .collect(Collectors.toList());

        if(order.equals("name_asc")) {
            userFollowersList.setFollowers(followersSorted);
        }

        if(order.equals("name_desc")) {
            Collections.reverse(followersSorted);
            userFollowersList.setFollowers(followersSorted);
        }
        
        return UserMapper.listFollowersDTOtoFollowerListDTO(user, followersSorted);
    }


    @Override
    public FollowedListDTO followedList(int user_id, String order){
        User user = this.userRepository.findUser(user_id).orElseThrow();
        FollowedListDTO userFollowedList = new FollowedListDTO(
                                                            user.getUser_id(),
                                                            user.getUser_name(),
                                                            user.getFollowed());
        if (order == null){
            return new FollowedListDTO(
                    user.getUser_id(),
                    user.getUser_name(),
                    user.getFollowed());
        }
        List<FollowerDTO> followedSorted = userFollowedList.getFollowed()
                .stream()
                .sorted(Comparator.comparing(FollowerDTO::getUser_name))
                .collect(Collectors.toList());

        if(order.equals("name_asc")) {
            userFollowedList.setFollowed(followedSorted);
        }else if(order.equals("name_desc")) {
            Collections.reverse(followedSorted);
            userFollowedList.setFollowed(followedSorted);
        }
        return userFollowedList;
    }



    @Override
    public void unfollowSeller(int user_id, int user_id_to_follow){
        User user = this.userRepository.findUser(user_id).orElseThrow();
        User userUnfollow = this.userRepository.findUser(user_id_to_follow).orElseThrow();

        if(user == userUnfollow){
            throw new NotFoundException("Un usuario no puede dejar de seguirse a si mismo");
        }

        FollowerDTO dataUserFollower = new FollowerDTO(user.getUser_id(),user.getUser_name());
        FollowerDTO dataUserFollowing = new FollowerDTO(userUnfollow.getUser_id(),userUnfollow.getUser_name());

        if(user.getFollowed().contains(dataUserFollowing)){
            user.getFollowed().remove(dataUserFollowing);
            userUnfollow.getFollowers().remove(dataUserFollower);
        }else {
            throw new NotFoundException("El usuario con el ID: "+user.getUser_id()+" no sigue al usuario con ID : "+userUnfollow.getUser_id());
        }

    }
}
