package com.example.c4_man_excep_vivo_p1.repository;

import com.example.c4_man_excep_vivo_p1.model.Link;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class LinkRepository implements ILinkRepository
{
    Map<Integer, Link> linkMap;

    public LinkRepository()
    {
        this.linkMap = new HashMap<>();
    }

    @Override
    public Map<Integer, Link> getMap()
    {
        return linkMap;
    }

    @Override
    public void saveData(Integer linkId, Link link)
    {
        linkMap.put(linkId, link);
    }
}
