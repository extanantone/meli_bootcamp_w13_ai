package com.sprint.SocialMeli.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Comprador extends Usuario{
    List<Integer> followedIds;

    public Comprador(int user_id, String user_name) {
        super(user_id, user_name);
        followedIds = new ArrayList<>();
    }

    public void addFollowed(int user_id){
        followedIds.add(user_id);
    }

    public Integer followedCount(){
        return followedIds.size();
    }

    public boolean existsFollowed(int user_id){
        return followedIds.contains(user_id);
    }

    public List<Integer> getFollowedIds(){
        return followedIds;
    }

    @Override
    TipoUsuario getUserType() {
        return TipoUsuario.COMPRADOR;
    }
}
