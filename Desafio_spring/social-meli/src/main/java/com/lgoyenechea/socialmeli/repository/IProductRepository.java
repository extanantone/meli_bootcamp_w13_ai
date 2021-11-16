package com.lgoyenechea.socialmeli.repository;

import com.lgoyenechea.socialmeli.model.Post;

import java.util.List;

public interface IProductRepository<K> {
    List<Post> getByUserId(K userId);
}
