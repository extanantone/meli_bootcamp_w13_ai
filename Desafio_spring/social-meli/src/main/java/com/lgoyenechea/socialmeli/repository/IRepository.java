package com.lgoyenechea.socialmeli.repository;

public interface IRepository<K, T> {
    T save (T t);
    T getById(K k);
}
