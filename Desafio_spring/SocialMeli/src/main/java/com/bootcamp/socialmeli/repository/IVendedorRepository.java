package com.bootcamp.socialmeli.repository;

import com.bootcamp.socialmeli.model.User;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface IVendedorRepository {
    public List<User> openUserJson();
    Optional<User> addFollowerToSeller(Long actualUserId, Long userId);
    Optional<User> getSellerFollowersCount(Long id);
    Optional<User> findSellerById(Long id);


}
