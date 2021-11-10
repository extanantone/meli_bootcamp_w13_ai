package com.Bootcamp.C4P2EJ1.repository;

import com.Bootcamp.C4P2EJ1.model.Link;

public interface ILinkRepository {
    public Link insertLink(Link link);

    public Link buscarLink(String password, Link link);

    public Link buscarLinkSinPassword(Link link);

    public boolean eliminarLink(Link link);
}
