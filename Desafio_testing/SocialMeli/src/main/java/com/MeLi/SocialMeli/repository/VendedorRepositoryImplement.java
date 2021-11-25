package com.MeLi.SocialMeli.repository;

import com.MeLi.SocialMeli.model.Usuario;
import com.MeLi.SocialMeli.model.Vendedor;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

public interface VendedorRepositoryImplement {

    Set<Map.Entry<Integer, Vendedor>> findAll();
    Optional<Vendedor> find(Integer id);
}
