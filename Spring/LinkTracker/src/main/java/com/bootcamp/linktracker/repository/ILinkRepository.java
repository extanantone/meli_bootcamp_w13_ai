package com.bootcamp.linktracker.repository;

import com.bootcamp.linktracker.model.Link;

public interface ILinkRepository {

    public int createLink(Link link);

    public Link getLink(int id);

    public void countVisit(int id);
}
