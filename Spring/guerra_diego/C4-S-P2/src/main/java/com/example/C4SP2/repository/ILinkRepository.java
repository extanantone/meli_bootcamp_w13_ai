package com.example.C4SP2.repository;

import com.example.C4SP2.model.Link;

public interface ILinkRepository {

    Link crearLink(Link link);
    Link buscarLink(String url);
    Link linkValido(Link link);
    Link autenticar(Link link);
    void aumentarMetrica(Link link);
    Link getMetricas(int id);
    Link invalidarLink(int id);

}
