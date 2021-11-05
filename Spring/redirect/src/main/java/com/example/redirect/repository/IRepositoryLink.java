package com.example.redirect.repository;

import com.example.redirect.dto.LinkDTO;
import com.example.redirect.model.Link;

public interface IRepositoryLink {
    public Integer create(Link link);

    public Link getLinkById(Integer id, String pass);

    public Integer getMetrics(Integer linkid);

    public String invalidateLink(Integer linkid);
}
