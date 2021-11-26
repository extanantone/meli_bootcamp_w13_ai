package com.lgoyenechea.socialmeli.repository;

public interface IUserRepository<K> {
    boolean existsById(K k);
}
