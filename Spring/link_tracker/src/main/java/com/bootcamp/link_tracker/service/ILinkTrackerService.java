package com.bootcamp.link_tracker.service;

import com.bootcamp.link_tracker.dto.LinkDTO;

public interface ILinkTrackerService {

    //boolean validarLink(LinkDTO link);

    //void invalidarLink();

    Integer crearLink(String url, String password);

    void eliminarLink(Integer id);

    Integer getEstadisticas(Integer id);
}
