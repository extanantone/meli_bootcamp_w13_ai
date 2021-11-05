package com.example.link_tracker.repository;

import com.example.link_tracker.Dto.LinkDto;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
@Repository

public class LinkRepository {
    HashMap<Integer, LinkDto> listaLinks = new HashMap<Integer,LinkDto>();
    private static Integer id = 0;
    public LinkRepository() {};

    public Integer setListaLinks(LinkDto link){

        this.id++;
        listaLinks.put(this.id, link);
        return this.id;
    }

    public LinkDto getLink(Integer linkId){
        return listaLinks.get(linkId);
    }

    public LinkDto invalidar (Integer linkId){
        LinkDto link = listaLinks.get(linkId);
        link.invalidar();
        return link;
    }
}
