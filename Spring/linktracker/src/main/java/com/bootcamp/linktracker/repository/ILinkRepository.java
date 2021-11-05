package com.bootcamp.linktracker.repository;

import com.bootcamp.linktracker.model.Link;

public interface ILinkRepository {
    public Link getLink(int id);
    public int newLink(Link link);
}
