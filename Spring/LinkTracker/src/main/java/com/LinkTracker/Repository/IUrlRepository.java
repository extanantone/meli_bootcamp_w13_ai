package com.LinkTracker.Repository;

import com.LinkTracker.Model.Url;

public interface IUrlRepository {
    Url findById(int id);
    Url addUrl(Url url);
    void update(Url url);
}
