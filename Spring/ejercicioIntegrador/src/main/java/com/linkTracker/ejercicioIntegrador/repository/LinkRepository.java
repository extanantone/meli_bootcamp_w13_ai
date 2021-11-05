package com.linkTracker.ejercicioIntegrador.repository;
import com.linkTracker.ejercicioIntegrador.dto.LinkDto;
import com.linkTracker.ejercicioIntegrador.model.Link;

import java.util.HashMap;

public class LinkRepository implements IlinkRepository{
    HashMap<Integer, Link> map = new HashMap<>();

    @Override
    public Link guardarLinks(Link link) {
        map.put(map.size()+1,link);
        return null;
    }
}
