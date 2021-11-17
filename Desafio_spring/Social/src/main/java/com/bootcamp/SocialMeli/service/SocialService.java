package com.bootcamp.SocialMeli.service;

import com.bootcamp.SocialMeli.dto.FollowedsDTO;
import com.bootcamp.SocialMeli.dto.CountFollowersDTO;
import com.bootcamp.SocialMeli.dto.FollowDTO;
import com.bootcamp.SocialMeli.dto.FollowersDTO;
import com.bootcamp.SocialMeli.exception.NotFoundUserException;
import com.bootcamp.SocialMeli.model.Buyer;
import com.bootcamp.SocialMeli.model.Seller;
import com.bootcamp.SocialMeli.repository.ISocialRepository;
import org.springframework.stereotype.Service;

@Service
public class SocialService implements ISocialService {

    ISocialRepository socialRepository;

    public SocialService(ISocialRepository socialRepository) {
        this.socialRepository = socialRepository;
    }

    // 1. Poder realizar la acción de “Follow” (seguir) a un determinado vendedor
    @Override
    public FollowDTO follow(int idb, int ids) throws NotFoundUserException {
        Buyer buyer = socialRepository.findb(idb)
                .orElseThrow(()->
                        new NotFoundUserException(idb)

                );

        Seller seller =socialRepository.finds(ids)
                .orElseThrow(()->
                        new NotFoundUserException(ids)

                );

        buyer.getFolloweds().add(seller);
        seller.getFollowers().add(buyer);

        return new FollowDTO(idb,ids, " Follow Ok");

    }

    // 2. cantidad de usuarios que siguen a un vendedor /users/{user_id}/followers/count
    @Override
    public CountFollowersDTO getFollowersCount(int ids) throws NotFoundUserException {
        Seller seller =socialRepository.finds(ids)
                .orElseThrow(()->
                        new NotFoundUserException(ids)

                );
        int count = seller.getFollowers().size();
        return new CountFollowersDTO(seller.getId_Seller(),seller.getName(),count);

    }

    // 3. Obtener un listado de todos los usuarios que siguen a un determinado vendedor
    //    /users/{user_id}/followers/count
    @Override
    public FollowersDTO getFollowers(int ids) throws NotFoundUserException {

        Seller seller = socialRepository.finds(ids)
                .orElseThrow(()->
                        new NotFoundUserException(ids)

                );

        return new FollowersDTO(seller.getId_Seller(),seller.getName(),seller.getFollowers());
    }

    // 4.Obtener un listado de todos los vendedores a los cuales sigue un determinado usuario (¿A quién sigo?)
    @Override
    public FollowedsDTO getFolloweds(int idb) throws NotFoundUserException {

        Buyer buyer = socialRepository.findb(idb)
                .orElseThrow(()->
                        new NotFoundUserException(idb)

                );

        return new FollowedsDTO(buyer.getId_Buyer(),buyer.getName(),buyer.getFolloweds());
    }












}
