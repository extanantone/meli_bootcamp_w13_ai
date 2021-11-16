package com.bootcamp.SocialMeli.service;

import com.bootcamp.SocialMeli.repository.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService implements IPostService{
    @Autowired
    IPostRepository postRepository;

    @Override
    public void create() {

    }
}
