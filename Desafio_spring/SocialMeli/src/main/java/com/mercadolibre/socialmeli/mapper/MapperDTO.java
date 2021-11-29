package com.mercadolibre.socialmeli.mapper;

import com.mercadolibre.socialmeli.dto.FollowersDTO;
import com.mercadolibre.socialmeli.dto.PublicationDTO;
import com.mercadolibre.socialmeli.dto.PublicationsFollowDTO;
import com.mercadolibre.socialmeli.dto.UserDTO;
import com.mercadolibre.socialmeli.model.Followers;
import com.mercadolibre.socialmeli.model.Publication;
import com.mercadolibre.socialmeli.model.PublicationsFollowed;
import com.mercadolibre.socialmeli.model.User;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class MapperDTO {

    final ModelMapper modelMapper = new ModelMapper();

    public FollowersDTO followersToFollowersDTO(Followers followers){
        FollowersDTO followersDTO = new FollowersDTO();
        List<UserDTO>userDTOS = new ArrayList<>();
        followersDTO.setId(followers.getId());
        followersDTO.setName(followers.getName());
        if (followers.getUsers() != null){
            for(User u : followers.getUsers()){
                userDTOS.add(new UserDTO(u.getId(),u.getName()));
            }
        }
        followersDTO.setFollowers(userDTOS);
        return followersDTO;
    }

    public PublicationsFollowDTO publicationsToPublicationsDTO(PublicationsFollowed publicationsFollowed){
        PublicationsFollowDTO publicationsFollowDTO = new PublicationsFollowDTO();
        List<PublicationDTO>publicationDTOS = new ArrayList<>();
        for(Publication p : publicationsFollowed.getPosts()){
            p.setUserId(0);
            publicationDTOS.add(modelMapper.map(p,PublicationDTO.class));
        }
        publicationsFollowDTO.setUserId(publicationsFollowed.getUserId());
        publicationsFollowDTO.setPosts(publicationDTOS);
        return publicationsFollowDTO;
    }

}
