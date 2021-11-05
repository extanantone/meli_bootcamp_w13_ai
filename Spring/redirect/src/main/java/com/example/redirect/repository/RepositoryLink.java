package com.example.redirect.repository;

import com.example.redirect.model.Link;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RepositoryLink implements IRepositoryLink {
    Integer idLink = 0;
    Map<Integer, Link> hashLinks = new HashMap<>();
    Set<String> listUrls ;


    public Integer create(Link link) {
       if (listUrls.add(link.getUrl())){
           hashLinks.put(idLink++, link);
           return idLink;
       }else{
           return -1;
       }
    }
}
