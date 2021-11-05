package com.example.linktracker.repository;

import com.example.linktracker.entity.Link;

public interface ILinkRepositorio {
    Link guardar(Link link);
    Link obtenerPorId(Integer id);
    Link obtenerPorUrl(String url);
    Link obtenerPorPassword(String pass);
}
