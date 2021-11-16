package com.bootcamp.SocialMeli.service;

import com.bootcamp.SocialMeli.dto.CountDTO;
import com.bootcamp.SocialMeli.dto.FollowedDTO;
import com.bootcamp.SocialMeli.dto.FollowerDTO;
import com.bootcamp.SocialMeli.dto.PublicationDTO;
import com.bootcamp.SocialMeli.exception.BadRequest;
import com.bootcamp.SocialMeli.mapper.PublicationMapper;
import com.bootcamp.SocialMeli.mapper.UserMapper;
import com.bootcamp.SocialMeli.model.Publication;
import com.bootcamp.SocialMeli.repository.ISocialMeliRepository;
import org.springframework.stereotype.Service;

@Service
public class SocialMeliService implements ISocialMeliService {

    ISocialMeliRepository iSocialMeliRepository;
    UserMapper userMapper;
    PublicationMapper publicationMapper;


    public SocialMeliService(ISocialMeliRepository iSocialMeliRepository) {
        this.iSocialMeliRepository = iSocialMeliRepository;
        this.userMapper = userMapper;
        this.publicationMapper = publicationMapper;
    }

    public void userNotFound(Integer user_id) {
        if (iSocialMeliRepository.findUser(user_id) == false) {
            throw new BadRequest("no existe el usuario número" + user_id);
        }
    }

    @Override
    public void addNewFollow(Integer user_id, Integer user_id_to_follow) throws BadRequest {
        iSocialMeliRepository.addNewFollowed(user_id, user_id_to_follow);
        iSocialMeliRepository.addNewFollower(user_id, user_id_to_follow);
    }

    @Override
    public CountDTO followerCount(Integer user_id) {
        userNotFound(user_id);
        CountDTO countDTO = userMapper.countDTO(iSocialMeliRepository.userId(user_id));
        if (countDTO.getCount() == 0) {
            throw new BadRequest("No tiene ningun seguidor el usuario: " + user_id);
        }
        return countDTO;
    }

    @Override
    public FollowerDTO followerList(Integer user_id) {
        userNotFound(user_id);
        FollowerDTO followerDTO = userMapper.followerDTO(iSocialMeliRepository.userId(user_id));
        if (followerDTO.getFollowers().size() == 0) {
            throw new BadRequest("No tiene seguidores el usuario " + user_id);
        }
        return followerDTO;
    }

    @Override
    public FollowedDTO followedList(Integer user_id) {
        userNotFound(user_id);
        FollowedDTO followedDTO = userMapper.followedDTO(iSocialMeliRepository.userId(user_id));
        if (followedDTO.getFollowed().size() == 0) {
            throw new BadRequest("No sigue a nadie el usuario " + user_id);
        }
        return followedDTO;
    }

    @Override
    public Publication newPublication(PublicationDTO publicationDTO) throws BadRequest {
        return iSocialMeliRepository.createPublication(publicationMapper.newPublication(publicationDTO));
    }

    @Override
    public void deleteFollow(Integer user_id, Integer user_id_to_unfollow) {
        if (user_id.equals(user_id_to_unfollow)) {
            iSocialMeliRepository.deleteFollower(user_id, user_id_to_unfollow);
            iSocialMeliRepository.deleteFollowed(user_id, user_id_to_unfollow);
        }
    }
}
