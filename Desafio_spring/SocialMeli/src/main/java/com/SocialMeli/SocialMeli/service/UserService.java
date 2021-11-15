package com.SocialMeli.SocialMeli.service;

import com.SocialMeli.SocialMeli.dto.*;
import com.SocialMeli.SocialMeli.entity.Buyer;
import com.SocialMeli.SocialMeli.entity.Seller;
import com.SocialMeli.SocialMeli.entity.User;
import com.SocialMeli.SocialMeli.exception.BadRequestException;
import com.SocialMeli.SocialMeli.exception.NotFoundException;
import com.SocialMeli.SocialMeli.mapper.UserMapper;
import com.SocialMeli.SocialMeli.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService{
    @Autowired
    IUserRepository userRepository;

    @Override
    public SellerCountFollowersDTO getSellerFollowersCount(int id) {
        User seller = userRepository.getUser(id);
        if (seller == null || seller.getClass() != Seller.class){
            throw new NotFoundException("Vendedor no encontrado");
        }
        return UserMapper.sellerToSellerDTO((Seller)seller);
    }

    @Override
    public FollowSellerDTO followSeller(int userId, int userToFollowId) {
        User seller = userRepository.getUser(userToFollowId);
        if (seller == null || seller.getClass() != Seller.class){
            throw new BadRequestException("Vendedor no encontrado");
        }
        User buyer = userRepository.getUser(userId);
        if (buyer == null){
            throw new BadRequestException("Usuario no encontrado");
        }

        userRepository.addFollower(userId, userToFollowId);
        FollowSellerDTO followSellerDTO = new FollowSellerDTO();
        followSellerDTO.setMessage("Todo Ok");
        return followSellerDTO;
    }

    @Override
    public SellerFollowersDTO getFollowers(int sellerId, String order) {
        User seller = userRepository.getUser(sellerId);
        if (seller == null || seller.getClass() != Seller.class){
            throw new NotFoundException("Vendedor no encontrado");
        }

        SellerFollowersDTO sellerFollowersDTO = UserMapper.sellerToSellerFollowersDTO((Seller)seller);
        Map<Integer, User> followers = userRepository.getFollowers(sellerId);
        List<BuyerDTO> followersDTO = followers.values().stream().map(UserMapper::userToBuyerDTO).collect(Collectors.toList());

        if (order != null){
            String[] order_request = order.split("_");
            if (order_request.length != 2) {
                throw new BadRequestException("Formato de orden incorrecto");
            }
            String order_type = order_request[0];
            String order_dir = order_request[1];

            switch (order_type.toLowerCase()){
                case "name":
                    if (order_dir.toLowerCase().equals("desc")) {
                        followersDTO = followersDTO.stream().sorted(Comparator.comparing(BuyerDTO::getUser_name).reversed()).collect(Collectors.toList());
                    } else {
                        if(order_dir.toLowerCase().equals("asc")){
                            followersDTO = followersDTO.stream().sorted(Comparator.comparing(BuyerDTO::getUser_name)).collect(Collectors.toList());
                        } else {
                            throw new BadRequestException("Formato de orden incorrecto");
                        }
                    }
                    break;
                default:
                    throw new BadRequestException("Formato de orden incorrecto");
            }
        }
        sellerFollowersDTO.setFollowers(followersDTO);
        return sellerFollowersDTO;
    }

    @Override
    public SellersFollowedDTO getFollowed(int buyerId) {
        User buyer = userRepository.getUser(buyerId);
        if (buyer == null){
            throw new NotFoundException("Usuario no encontrado");
        }

        SellersFollowedDTO sellerFollowersDTO = UserMapper.userToSellersFollowedDTO(buyer);
        Map<Integer, User> followed = userRepository.getFollowed(buyerId);
        sellerFollowersDTO.setFollowed(followed.values().stream().map(UserMapper::userToUserDTO).collect(Collectors.toList()));

        return sellerFollowersDTO;
    }

    @Override
    public UnfollowSellerDTO unfollowSeller(int userId, int userToUnfollowId) {
        User seller = userRepository.getUser(userToUnfollowId);
        if (seller == null || seller.getClass() != Seller.class){
            throw new NotFoundException("Vendedor no encontrado");
        }
        User buyer = userRepository.getUser(userId);
        if (buyer == null){
            throw new NotFoundException("Usuario no encontrado");
        }

        userRepository.unFollowSeller(userId, userToUnfollowId);
        UnfollowSellerDTO unfollowSellerDTO = new UnfollowSellerDTO();
        unfollowSellerDTO.setMessage("Todo Ok");
        return unfollowSellerDTO;
    }
}
