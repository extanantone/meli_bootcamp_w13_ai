package com.SpringRecapitulando.LinkTracker.repository;

import com.SpringRecapitulando.LinkTracker.entity.Link;

public interface ILinkRepository {
    public Link findById(int linkId);
    public Link createLink(Link link);
    public Link invalidateLink(int id);
    public Link addView(int linkId);
}
