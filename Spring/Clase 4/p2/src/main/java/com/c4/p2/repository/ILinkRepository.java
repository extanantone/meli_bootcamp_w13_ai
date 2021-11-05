package com.c4.p2.repository;

import com.c4.p2.model.Link;

public interface ILinkRepository {

    Integer nuevoLink(Link link);
    void actualizarLink(Link link);
    Link obtenerLink(Integer idLink);
}
