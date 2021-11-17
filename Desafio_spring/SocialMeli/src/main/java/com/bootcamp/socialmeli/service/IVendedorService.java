package com.bootcamp.socialmeli.service;

import com.bootcamp.socialmeli.dto.CompradorDTO;
import com.bootcamp.socialmeli.dto.UserCountDTO;
import com.bootcamp.socialmeli.dto.VendedorDTO;

public interface IVendedorService {
    public void addFollower(long idFollowed, long idFollwer);
    public UserCountDTO getFollowersCount(long idUser);
    public VendedorDTO getFollowersList(long idUser, String order);
    public CompradorDTO getFollowedsList(long idUser);
    public void unFollow (Long idFollower, Long idFollowed);
}
