package com.linktracker.repository;

import com.linktracker.model.Link;

public interface ILinkRepository {

    int addLink(Link link);

    Link findById(int idLink);

}