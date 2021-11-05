package com.example.linktracker.repository;

import com.example.linktracker.entity.Link;

public interface ILinkRepository {
    Link getLink(Long id);

    Long saveLink(Link link);

    void incrementeVisits(Long id);

    void invalidateLink(Long id);
}
