package com.SocialMeli.SocialMeli.repository;

import com.SocialMeli.SocialMeli.dto.BuyersDTO;
import com.SocialMeli.SocialMeli.dto.FollowersCountDTO;
import com.SocialMeli.SocialMeli.dto.SellersDTO;
import com.SocialMeli.SocialMeli.dto.UserDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository implements IUserRepository{

    private final List<UserDTO> database = new ArrayList<>();

    @Override
    public UserDTO createBuyers(UserDTO user) {
        BuyersDTO buyersDTO = new BuyersDTO();

        if(user.getUser_id() == null){

            buyersDTO.setUser_id(database.size()+1);
            buyersDTO.setUser_name(user.getUser_name());
            database.add(buyersDTO);
        }

        return buyersDTO;
    }

    @Override
    public UserDTO createSellers(UserDTO user) {
        SellersDTO sellersDTO = new SellersDTO();

        if(user.getUser_id() == null){
            sellersDTO.setUser_id(database.size()+1);
            sellersDTO.setUser_name(user.getUser_name());
            database.add(sellersDTO);
        }

        return sellersDTO;
    }

    @Override
    public UserDTO findUserByUserId(Integer user_id) {
        UserDTO userDTO = null;
        try{
            userDTO = database.get(user_id-1);
            //System.out.println(userDTO.toString());
            throw new IndexOutOfBoundsException("El usuario no existe con id -> " + user_id );

        }catch (IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }


        return userDTO;
    }


    /*@Override
    public Boolean follow(Integer user_id, Integer user_id_to_follow) {
        UserDTO current_user = findUserByUserId(user_id);
        UserDTO follow_user = findUserByUserId(user_id_to_follow);
        Boolean band = false;

        if( current_user != null && follow_user != null && user_id != user_id_to_follow ){
            //Al usuario actual se le agrega el usuario a seguir
            //List<UserDTO> followedList = current_user.getFollowed();
            /*List<Integer> followedList = current_user.getFollowed();
            if( followedList == null ){
                followedList = new ArrayList<>();
            }
            if( !followedList.contains(follow_user.getUser_id())  ){
                followedList.add(follow_user.getUser_id());
                current_user.setFollowed(followedList);
                band = true;
            }*/
    /*        BuyersDTO followedList = new BuyersDTO();
            followedList.setUser_id(current_user.getUser_id());
            followedList.setUser_name(current_user.getUser_name());
            List<UserDTO> followedUsersList = current_user.getFollowed();*/




            //Al usuario seguido se le agrega al usuario quién lo sigue
            //List<UserDTO> followersList = follow_user.getFollowers();
     /*       List<Integer> followersList = follow_user.getFollowers();
            if( followersList == null ){
                followersList = new ArrayList<>();
            }
            if( !followersList.contains(current_user.getUser_id()) && band ){
                followersList.add(current_user.getUser_id());
                follow_user.setFollowers(followersList);
            }else{
                band = false;
            }


        }

        return band;
    }*/

    /*@Override
    public FollowersCountDTO followersCount(Integer user_id) {
        UserDTO userDTO = findUserByUserId(user_id);
        FollowersCountDTO user = new FollowersCountDTO();
        Integer count = 0;

        if( userDTO != null ){
            user.setUser_id(userDTO.getUser_id());
            user.setUser_name(userDTO.getUser_name());
            if( userDTO.getFollowers() != null ){
                count = userDTO.getFollowers().size();
            }
            //System.out.println(count);
            user.setFollowers_count(count);
        }

        return user;
    }*/

    /*@Override
    public SellersDTO followersList(Integer user_id) {
        UserDTO userDTO = findUserByUserId(user_id);
        SellersDTO user = new SellersDTO();

        if( userDTO != null ){
            user.setUser_id(userDTO.getUser_id());
            user.setUser_name(userDTO.getUser_name());
            if( userDTO.getFollowers() != null ){
                List<UserDTO> followersList = new ArrayList<>();

                for( Integer i : userDTO.getFollowers() ){
                    System.out.println(i);
                    UserDTO follower = findUserByUserId(i);
                    followersList.add(follower);
                }
                user.setFollowersList(followersList);
            }

        }

        return user;
    }*/
}
