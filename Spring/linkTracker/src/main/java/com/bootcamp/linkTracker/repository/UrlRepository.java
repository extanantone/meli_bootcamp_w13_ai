package com.bootcamp.linkTracker.repository;

import com.bootcamp.linkTracker.model.Url;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UrlRepository implements IUrlRepository{

    List<Url> urls = new ArrayList<>();

    @Override
    public Url findById(int id) {
        return urls.stream().filter(i->i.getId() == id).findFirst().orElse(null);
    }

    @Override
    public Url addUrl(Url url) {
        urls.add(url);
        url.setId(urls.size());
        return url;
    }

    @Override
    public void update(Url url) {

    }
}
