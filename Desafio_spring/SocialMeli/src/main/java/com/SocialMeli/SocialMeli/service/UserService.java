package com.SocialMeli.SocialMeli.service;

import com.SocialMeli.SocialMeli.dto.*;
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
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService{
    @Autowired
    IUserRepository userRepository;

    @Override
    public SellerCountFollowersDTOResponse getSellerFollowersCount(int id) {
        User seller = userRepository.getUser(id);
        if (seller == null || seller.getClass() != Seller.class){
            throw new NotFoundException("Vendedor no encontrado");
        }
        return UserMapper.sellerToSellerDTO((Seller)seller);
    }

    @Override
    public MessageDTOResponse followSeller(int userId, int userToFollowId) {
        User seller = userRepository.getUser(userToFollowId);
        if (seller == null || seller.getClass() != Seller.class){
            throw new BadRequestException("Vendedor no encontrado");
        }
        User buyer = userRepository.getUser(userId);
        if (buyer == null){
            throw new BadRequestException("Usuario no encontrado");
        }

        userRepository.addFollower(userId, userToFollowId);
        MessageDTOResponse followSellerDTO = new MessageDTOResponse();
        followSellerDTO.setMessage("Todo Ok");
        return followSellerDTO;
    }

    @Override
    public SellerFollowersDTOResponse getFollowers(int sellerId, String order) {
        User seller = userRepository.getUser(sellerId);
        if (seller == null || seller.getClass() != Seller.class){
            throw new NotFoundException("Vendedor no encontrado");
        }

        SellerFollowersDTOResponse sellerFollowersDTOResponse = UserMapper.sellerToSellerFollowersDTO((Seller)seller);
        Map<Integer, User> followers = userRepository.getFollowers(sellerId);
        List<UserDTO> followersDTO = followers.values().stream().map(UserMapper::userToUserDTO).collect(Collectors.toList());

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
                        followersDTO = followersDTO.stream().sorted(Comparator.comparing(UserDTO::getUser_name).reversed()).collect(Collectors.toList());
                    } else {
                        if(order_dir.toLowerCase().equals("asc")){
                            followersDTO = followersDTO.stream().sorted(Comparator.comparing(UserDTO::getUser_name)).collect(Collectors.toList());
                        } else {
                            throw new BadRequestException("Formato de orden incorrecto");
                        }
                    }
                    break;
                default:
                    throw new BadRequestException("Formato de orden incorrecto");
            }
        }
        sellerFollowersDTOResponse.setFollowers(followersDTO);
        return sellerFollowersDTOResponse;
    }

    @Override
    public SellersFollowedDTOResponse getFollowed(int buyerId, String order) {
        User buyer = userRepository.getUser(buyerId);
        if (buyer == null){
            throw new NotFoundException("Usuario no encontrado");
        }

        SellersFollowedDTOResponse sellerFollowedDTO = UserMapper.userToSellersFollowedDTO(buyer);
        Map<Integer, User> followed = userRepository.getFollowed(buyerId);

        List<UserDTO> followedDTO = followed.values().stream().map(UserMapper::userToUserDTO).collect(Collectors.toList());

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
                        followedDTO = followedDTO.stream().sorted(Comparator.comparing(UserDTO::getUser_name).reversed()).collect(Collectors.toList());
                    } else {
                        if(order_dir.toLowerCase().equals("asc")){
                            followedDTO = followedDTO.stream().sorted(Comparator.comparing(UserDTO::getUser_name)).collect(Collectors.toList());
                        } else {
                            throw new BadRequestException("Formato de orden incorrecto");
                        }
                    }
                    break;
                default:
                    throw new BadRequestException("Formato de orden incorrecto");
            }
        }
        sellerFollowedDTO.setFollowed(followedDTO);
        return sellerFollowedDTO;
    }

    @Override
    public MessageDTOResponse unfollowSeller(int userId, int userToUnfollowId) {
        User seller = userRepository.getUser(userToUnfollowId);
        if (seller == null || seller.getClass() != Seller.class){
            throw new NotFoundException("Vendedor no encontrado");
        }
        User buyer = userRepository.getUser(userId);
        if (buyer == null){
            throw new NotFoundException("Usuario no encontrado");
        }

        userRepository.unFollowSeller(userId, userToUnfollowId);
        MessageDTOResponse messageDTOResponse = new MessageDTOResponse();
        messageDTOResponse.setMessage("Todo Ok");
        return messageDTOResponse;
    }
}
