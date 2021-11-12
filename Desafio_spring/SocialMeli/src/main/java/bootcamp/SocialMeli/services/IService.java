package bootcamp.SocialMeli.services;

import bootcamp.SocialMeli.dto.CountSellerFollowersDto;

public interface IService {

    void followUser(int idUser, int idSeller);
    CountSellerFollowersDto getCountBySeller(int idSeller);

}
