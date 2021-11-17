package com.mercadolibre.socialmeli.service;
import com.mercadolibre.socialmeli.dto.*;
import com.mercadolibre.socialmeli.exception.NotFoundException;
import com.mercadolibre.socialmeli.mapper.MapperDTO;
import com.mercadolibre.socialmeli.model.Follow;
import com.mercadolibre.socialmeli.model.Publication;
import com.mercadolibre.socialmeli.model.User;
import com.mercadolibre.socialmeli.repository.ISocialRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class SocialServiceImpl implements ISocialService{

    final ModelMapper mapper = new ModelMapper();
    final MapperDTO mapperDTO = new MapperDTO();

    final
    ISocialRepository socialRepository;

    public SocialServiceImpl(ISocialRepository socialRepository) {
        this.socialRepository = socialRepository;
    }

    @Override
    public FollowDTO followToUser(FollowDTO follow) throws NotFoundException {
        Follow followUser = socialRepository.followToUser(follow.getUserId(), follow.getIdUserToFollow());
        if(followUser.getUserId()!=0 && followUser.getIdUserToFollow()!=0) mapper.map(followUser,FollowDTO.class);
        else throw new NotFoundException();
        return follow;
    }

    @Override
    public FollowersCountDTO followersCount(Integer userId) throws NotFoundException{
        //TODO agregar excepcion si el userId no tiene seguidores
        User user = socialRepository.findUserById(userId);
        if(user==null) throw new NotFoundException();
        long cantFollowers;
        try {
            cantFollowers = socialRepository.countFollowers(userId);
        } catch (Exception e){
            cantFollowers = 0L;
        }
        return new FollowersCountDTO(user.getId(), user.getName(), (int) cantFollowers);
    }

    @Override
    public FollowersDTO allFollowers(Integer idUserFollow) {
        return mapperDTO.followersToFollowersDTO(socialRepository.allFollowers(idUserFollow));
    }

    @Override
    public FollowersDTO allFollowed(Integer idUser) {
        return mapperDTO.followersToFollowersDTO(socialRepository.allFollowed(idUser));
    }

    @Override
    public Boolean addPublication(PublicationDTO publicationDTO) {
        return socialRepository.addPublication(mapper.map(publicationDTO, Publication.class));
    }

    @Override
    public PublicationsFollowDTO latestPublications(Integer idUser) {
        return mapperDTO.publicationsToPublicationsDTO(socialRepository.latestPublications(idUser));
    }

    @Override
    public Boolean unfollowUser(Integer userId, Integer userIdUnfollow) {
        return socialRepository.unFollowUser(userId,userIdUnfollow);
    }

    @Override
    public FollowersDTO orderingUsersFollowers(Integer user_id, String order) {
        return mapperDTO.followersToFollowersDTO(socialRepository.orderingUsersFollowers(user_id,order));
    }
    @Override
    public FollowersDTO orderingUsersFolloweds(Integer user_id, String order) {
        return mapperDTO.followersToFollowersDTO(socialRepository.orderingUsersFolloweds(user_id,order));
    }

    @Override
    public PublicationsFollowDTO sortPublicationsSellers(Integer userId, String order) {
        return mapperDTO.publicationsToPublicationsDTO(socialRepository.sortPublicationsSellers(userId,order));
    }
}
