package com.example.redirect.service;

import com.example.redirect.dto.LinkDTO;
import com.example.redirect.exceptions.AlreadyAddLinkException;
import com.example.redirect.exceptions.LinkNoFound;
import com.example.redirect.map.LinkMapper;
import com.example.redirect.model.Link;
import com.example.redirect.repository.RepositoryLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkService implements ILinkService{
    @Autowired
    RepositoryLink repositorio;

    @Override
    public Integer createLink(LinkDTO link) {
        Integer value = repositorio.create(LinkMapper.LinkDTOtoLink(link));
        if ( value == -1){
           throw new AlreadyAddLinkException("Este link ya se encuentra asociado a un id, usa otro");
        }
        return value;
    }

    @Override
    public String getRedirection(Integer linkid, String pass) {
        Link value = repositorio.getLinkById(linkid, pass);
        if ( value == null){
            throw  new LinkNoFound("El link no fue encontrado en nuestra base de datos");
        }else {
            value.setMetrics(value.getMetrics()+1);
            return value.getUrl();
        }
    }


    @Override
    public Integer getMetrics(Integer linkid) {
        Integer metrics = repositorio.getMetrics(linkid);
        if ( metrics == null){
            throw  new LinkNoFound("El link no fue encontrado en nuestra base de datos");
        }else {
            return metrics;
        }
    }

    @Override
    public String invalideteLink(Integer linkid) {
        String response = repositorio.invalidateLink(linkid);
        if (response == null){
            throw  new LinkNoFound("El link no fue encontrado en nuestra base de datos");
        }else{
            return response;
        }

    }
}
