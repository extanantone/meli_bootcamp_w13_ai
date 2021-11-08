package com.bootcamp.link_tracker.service;

import com.bootcamp.link_tracker.dto.LinkReqDTO;

public interface ILinkTrackerService {

    Integer crearLink(LinkReqDTO link);

    void invalidarLink(Integer id);

    Integer getEstadisticas(Integer id);

    String redireccionar(Integer id, String password);
}
