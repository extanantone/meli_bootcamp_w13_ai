package com.MeLi.SocialMeli.repository;

import com.MeLi.SocialMeli.model.Comprador;

import java.util.HashMap;
import java.util.Optional;

public interface CompradorRepositoryImplement {
    HashMap<Integer, Comprador> findAll();
    Optional<Comprador> find(Integer id);
}
