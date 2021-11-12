package com.bootcamp.socialmeli.repository;

import com.bootcamp.socialmeli.model.User;

import java.util.List;
import java.util.Optional;

public interface IVendedorRepository {
    public List<User> openUserJson();
    Optional<User> findSellerById(Long id);


}
