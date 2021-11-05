package com.linktracker.demo.repository;

import com.linktracker.demo.model.Link;

public interface ILinkRepository {

    public Integer agregarListaLinks(Link link);

    public Link findById(int idLink);

}
