package com.bootcamp.Linktraker.demo.repository;

import com.bootcamp.Linktraker.demo.model.Link;

import java.util.Map;

public interface ILinkRepository {

    void setLink(Link link);
    Link getLink(long id);
    void inhabilitarLink(long id);
    Map<Long,Link> getMapLink();
}
