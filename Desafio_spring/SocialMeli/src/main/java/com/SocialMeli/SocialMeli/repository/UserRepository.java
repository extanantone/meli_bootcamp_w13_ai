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

    private final List<BuyersDTO> buyersDTOList = new ArrayList<>();
    private final List<SellersDTO> sellersDTOList = new ArrayList<>();

    @Override
    public UserDTO createBuyers(UserDTO user) {
        BuyersDTO buyersDTO = new BuyersDTO();

        if(user.getUser_id() == null){

            buyersDTO.setUser_id(buyersDTOList.size()+1);
            buyersDTO.setUser_name(user.getUser_name());
            buyersDTOList.add(buyersDTO);
        }

        return buyersDTO;
    }

    @Override
    public UserDTO createSellers(UserDTO user) {
        SellersDTO sellersDTO = new SellersDTO();

        if(user.getUser_id() == null){
            sellersDTO.setUser_id(sellersDTOList.size()+1);
            sellersDTO.setUser_name(user.getUser_name());
            sellersDTOList.add(sellersDTO);
        }

        return sellersDTO;
    }

    @Override
    public BuyersDTO findBuyerByUserId(Integer user_id) {
        BuyersDTO buyersDTO = null;
        try{
            buyersDTO = buyersDTOList.get(user_id-1);
            //System.out.println(userDTO.toString());
            throw new IndexOutOfBoundsException("El usuario no existe con id -> " + user_id );

        }catch (IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }


        return buyersDTO;
    }

    @Override
    public SellersDTO findSellerByUserId(Integer user_id) {
        SellersDTO sellersDTO = null;
        try{
            sellersDTO = sellersDTOList.get(user_id-1);
            //System.out.println(userDTO.toString());
            throw new IndexOutOfBoundsException("El usuario no existe con id -> " + user_id );

        }catch (IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }


        return sellersDTO;
    }


    @Override
    public Boolean follow(Integer user_id, Integer user_id_to_follow) {
        BuyersDTO buyerUser = findBuyerByUserId(user_id);
        SellersDTO sellerUser = findSellerByUserId(user_id_to_follow);
        Boolean band = false;

        if( buyerUser != null && sellerUser != null ){
            //Al buyer se le agrega el usuario a seguir(seller)
            //List<UserDTO> followedList = current_user.getFollowed();
            List<UserDTO> followedList = buyerUser.getFollowed();
            if( followedList == null ){
                followedList = new ArrayList<UserDTO>();
            }
            if( !followedList.contains(sellerUser)  ){
                followedList.add(sellerUser);
                buyerUser.setFollowed(followedList);
                band = true;
            }
            /*
            BuyersDTO followedList = new BuyersDTO();
            followedList.setUser_id(buyerUser.getUser_id());
            followedList.setUser_name(buyerUser.getUser_name());
            List<UserDTO> followedUsersList = buyerUser.getFollowed();*/




            //Al vendedor se le agrega al usuario comprador
            //List<UserDTO> followersList = follow_user.getFollowers();
            List<UserDTO> followersList = sellerUser.getFollowers();
            if( followersList == null ){
                followersList = new ArrayList<>();
            }
            if( !followersList.contains(buyerUser) && band ){
                followersList.add(buyerUser);
                sellerUser.setFollowers(followersList);
            }else{
                band = false;
            }


        }

        return band;
    }

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
