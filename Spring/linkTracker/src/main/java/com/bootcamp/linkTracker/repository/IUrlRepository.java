package com.bootcamp.linkTracker.repository;

import com.bootcamp.linkTracker.model.Url;

public interface IUrlRepository {
    Url findById(int id);
    Url addUrl(Url url);
    void update(Url url);
}
