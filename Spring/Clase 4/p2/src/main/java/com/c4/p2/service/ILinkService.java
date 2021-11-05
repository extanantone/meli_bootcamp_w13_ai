package com.c4.p2.service;

import com.c4.p2.dto.LinkCreatorDto;
import com.c4.p2.dto.LinkIdDto;
import com.c4.p2.dto.RedireccionesDto;
import com.c4.p2.exceptions.NotFoundException;

public interface ILinkService {
    LinkIdDto nuevoLink(LinkCreatorDto linkCreatorDto);

    String permiteRedireccion(Integer id, String pass);

    RedireccionesDto obtenerEstadisticas(Integer id) throws NotFoundException;

    void invalidarLink(Integer id) throws NotFoundException;
}
