package com.bootcamp.SocialMeli.repository;

import com.bootcamp.SocialMeli.model.Buyer;
import com.bootcamp.SocialMeli.model.Seller;

import java.util.Optional;

public interface ISocialRepository {

    //boolean follow(int idb,int ids);
    Optional<Buyer> findb(int id);
    Optional<Seller> finds(int id);

}
