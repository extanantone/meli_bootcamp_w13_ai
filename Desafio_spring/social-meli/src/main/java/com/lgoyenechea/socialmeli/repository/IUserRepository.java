package com.lgoyenechea.socialmeli.repository;

import com.lgoyenechea.socialmeli.model.User;

public interface IUserRepository<K> {
    User deleteFollowById(K k);
}
