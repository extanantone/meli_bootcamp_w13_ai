package com.mercadolibre.linktracker.util;

import com.mercadolibre.linktracker.dto.LinkDTO;

import java.util.HashMap;
import java.util.Map;

public class LinKs {

    public static Map<Integer, LinkDTO> getdabase(){

         Map<Integer, LinkDTO> database = new HashMap<>();
        LinkDTO link = new LinkDTO();
        link.setLink("google");
        link.setCount(1);
        link.setPassword("1234");
        link.setLinkId(database.values().size());
        database.put(link.getLinkId(), link);
        link = new LinkDTO();
        link.setLink("amazon");
        link.setCount(1);
        link.setPassword("2547");
        link.setLinkId(database.values().size());
        database.put(link.getLinkId(), link);

        return database;
    }
}
