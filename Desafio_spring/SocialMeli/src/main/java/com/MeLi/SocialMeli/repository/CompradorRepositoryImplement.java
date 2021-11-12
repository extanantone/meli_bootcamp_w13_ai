package com.MeLi.SocialMeli.repository;

import com.MeLi.SocialMeli.model.Comprador;
import com.MeLi.SocialMeli.model.Usuario;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

public interface CompradorRepositoryImplement {
    Set<Map.Entry<Integer, Comprador>> findAll();
    Optional<Comprador> find(Integer id);
}
