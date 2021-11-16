package com.ejerciciolinktracker.demo.repository;

import com.ejerciciolinktracker.demo.dto.LinkDTO;
import com.ejerciciolinktracker.demo.mapper.LinkMapper;
import com.ejerciciolinktracker.demo.model.Link;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class LinkRepository {
    Map<Integer, Link> bibliotecaLink = new HashMap<Integer,Link>();

    @Autowired
    LinkMapper linkMapper;

    public String idValido(Integer id,String password){
        if (bibliotecaLink.size() > id){
            if (bibliotecaLink.get(id).getActivo() == 1){
                return "true";
            } else{
                return "invalidated";
            }
        } else {
            return "notExist";
        }
    }

    public Link obtenerLink(Integer id){
        return bibliotecaLink.get(id);
    }

    public List<Link> obtenerLinks(){
        return new ArrayList<Link>(bibliotecaLink.values());
    }

    public Integer guardarLink(LinkDTO link){
        Integer id = bibliotecaLink.size();
        bibliotecaLink.put(id,linkMapper.linkDTOToLink(link,id));
        return id;
    }

    public void invalidarLink(Integer id){
        bibliotecaLink.get(id).setActivo(0);
    }
}
