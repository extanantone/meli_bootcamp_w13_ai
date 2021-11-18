package com.mercadolibre.socialmeli.service;
import com.mercadolibre.socialmeli.dto.*;
import com.mercadolibre.socialmeli.exception.FollowException;
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
    final ISocialRepository socialRepository;

    public SocialServiceImpl(ISocialRepository socialRepository) {
        this.socialRepository = socialRepository;
    }

    @Override
    public FollowDTO followToUser(FollowDTO follow)
            throws NotFoundException, FollowException {
        Follow followUser = socialRepository.followToUser(follow.getUserId(), follow.getIdUserToFollow());
        if (followUser.getUserId() == followUser.getIdUserToFollow()) throw new NotFoundException();
        else if(followUser.getUserId() == -1 || followUser.getIdUserToFollow() == -1) throw new FollowException();
        return mapper.map(followUser,FollowDTO.class);
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
    public FollowersDTO allFollowed(Integer idUser) throws NotFoundException {
        FollowersDTO usersFolloweds = new FollowersDTO();
        try{
            if (socialRepository.findUserById(idUser) != null){
                usersFolloweds = mapperDTO.followersToFollowersDTO(socialRepository.allFollowed(idUser));
                if(usersFolloweds.getFollowers().size() == 0){
                    String msg = "El usuario " + usersFolloweds.getName() + " con id " + usersFolloweds.getId() + " no sigue a nadie aún";
                    System.out.println(msg);
                    // TODO no esta lanzando la excepcion que deberia
                    throw new NotFoundException(msg);
                }
            }
        } catch (Exception e){
            throw new NotFoundException("El usuario con el id "+ idUser + " no se encuentra registrado");

        }
        return usersFolloweds;
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
