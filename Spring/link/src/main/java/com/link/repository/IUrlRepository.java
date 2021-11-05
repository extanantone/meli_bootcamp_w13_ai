package com.link.repository;

import com.link.model.Url;

public interface IUrlRepository {
    Url findById(int id);
    Url addUrl(Url url);
    void update(Url url);
}
