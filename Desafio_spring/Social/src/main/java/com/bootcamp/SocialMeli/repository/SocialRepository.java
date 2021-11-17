package com.bootcamp.SocialMeli.repository;

import com.bootcamp.SocialMeli.model.Buyer;
import com.bootcamp.SocialMeli.model.Post;
import com.bootcamp.SocialMeli.model.Seller;
import org.springframework.stereotype.Repository;


import java.util.*;

@Repository
public class SocialRepository implements ISocialRepository{

    Map<Integer,Buyer> buyers = new HashMap<>();
    Map<Integer,Seller> sellers = new HashMap<>();



    public SocialRepository(){
      buyers.put(1,new Buyer());
      buyers.put(2,new Buyer());

      sellers.put(3,new Seller());
      sellers.put(4,new Seller());
    }


    @Override
    /*public boolean follow(int idb, int ids) {
        if( (buyers.containsKey(idb)) && (sellers.containsKey(ids)) ){
            return true;
        }else {
            return false;
        }
    }*/

    public Optional<Buyer> findb(int id) {
        if( buyers.containsKey( id ) ) {
            return Optional.of( buyers.get(id) );
        }
        return Optional.empty();
    }

    public Optional<Seller> finds(int id) {
        if( sellers.containsKey( id ) ) {
            return Optional.of(sellers.get(id));
        }
        return Optional.empty();
    }


}


