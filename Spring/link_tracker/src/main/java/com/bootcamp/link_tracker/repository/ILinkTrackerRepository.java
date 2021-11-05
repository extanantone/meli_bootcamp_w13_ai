package com.bootcamp.link_tracker.repository;

import com.bootcamp.link_tracker.model.Link;

public interface ILinkTrackerRepository {

    Link buscarLink(Integer id);

    void guardarLink(Link link);

    void eliminarLink(Link link);
}
