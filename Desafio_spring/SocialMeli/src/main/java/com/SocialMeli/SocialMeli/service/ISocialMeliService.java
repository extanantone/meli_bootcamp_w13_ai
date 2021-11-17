package com.SocialMeli.SocialMeli.service;

import com.SocialMeli.SocialMeli.dto.*;
import com.SocialMeli.SocialMeli.exceptions.NotFoundException;
import com.SocialMeli.SocialMeli.model.Buyer;
import com.SocialMeli.SocialMeli.model.Seller;

import java.util.List;

public interface ISocialMeliService {
        public ResponseUserDTO follow (int id_buyer, int id_seller) throws NotFoundException;
        public Buyer checkBuyer(int id) throws NotFoundException;
        public Seller checkSeller(int id) throws NotFoundException;
        public CountFollowDTO count(int id_seller) throws NotFoundException;
        public FollowersDTO searchFollower (int id,String order) throws NotFoundException;
        public FollowedDTO searchFollowed (int id,String order) throws NotFoundException;
        public ResponseUserDTO createPost (PostDTO post) throws NotFoundException;
        public List<PostDTO> searchPost (int user_id, String order) throws NotFoundException;
        public ResponseUserDTO unfollow (int id_buyer, int id_seller) throws NotFoundException;


}
