package com.example.blog.repository;

import com.example.blog.dto.LinkDto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LinkRepository implements  ILinkRepository{
    List<LinkDto> listaLinks = new ArrayList<LinkDto>();
    public void añadirLinks(LinkDto link){
        link.setLinkId(listaLinks.size());
        listaLinks.add(link);
    }
    public LinkDto buscarLink(int id){
        return listaLinks.stream().filter(lin->lin.getLinkId()==id).findFirst().orElse(null);
    }
}
