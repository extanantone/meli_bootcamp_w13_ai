package bootcamp.SocialMeli.services;

import bootcamp.SocialMeli.dto.CountSellerFollowersDto;
import bootcamp.SocialMeli.exception.InvalidUserException;
import bootcamp.SocialMeli.exception.NotFoundUserException;
import bootcamp.SocialMeli.model.User;
import bootcamp.SocialMeli.repository.IRepository;
import org.springframework.stereotype.Service;

@Service
public class Services implements IService{

    public IRepository iRepository;


    public Services(IRepository iRepository) {
        this.iRepository = iRepository;
    }


    @Override
    public void followUser(int idUser, int idSeller) {
        User seller = iRepository.getUserById(idSeller);
        User user = iRepository.getUserById(idUser);
        if(seller==null || user==null)
            throw  new NotFoundUserException("No se encontró el usuario para seguirlo");
        seller.addFollower(user);
    }

    @Override
    public CountSellerFollowersDto getCountBySeller(int idSeller) {
        User seller = iRepository.getUserById(idSeller);
        if(seller==null)
            throw new NotFoundUserException("No se encontro al vendedor");
        else if(!seller.isSeller())
            throw new InvalidUserException("No es un vendedor");
        return new CountSellerFollowersDto(seller.getId(),seller.getName(),seller.getFollowers().size());
    }
}
