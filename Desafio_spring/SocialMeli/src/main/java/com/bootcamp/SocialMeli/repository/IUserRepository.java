package com.bootcamp.SocialMeli.repository;

import com.bootcamp.SocialMeli.model.Seguidor;
import com.bootcamp.SocialMeli.model.User;

import java.util.Optional;

public interface IUserRepository {

    Seguidor setSeguidor(Seguidor seguidor);

    User getUser(int id);

}
