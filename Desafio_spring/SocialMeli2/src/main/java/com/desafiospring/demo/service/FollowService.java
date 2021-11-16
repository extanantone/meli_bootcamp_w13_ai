package com.desafiospring.demo.service;

import com.desafiospring.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class FollowService implements IFollowService {
    //de esta forma me traigo el repositorio

    UserRepository repository;
//constructor
    public FollowService(UserRepository repository) {
        this.repository = repository;
    }

//hicimos la logica de agregarle al vendedor el usuario que nos sigue y usamos el repositorio.
    public void FollowSeller(int userId, int userIdToFollow) {
        repository.AddFollow(userId, userIdToFollow);

    }


}
