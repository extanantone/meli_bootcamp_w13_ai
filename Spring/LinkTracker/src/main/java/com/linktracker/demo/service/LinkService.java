package com.linktracker.demo.service;

import com.linktracker.demo.DTO.LinkDTO;
import com.linktracker.demo.DTO.LinkInfoDTO;
import com.linktracker.demo.model.Link;
import com.linktracker.demo.repository.ILinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.awt.geom.RectangularShape;


@Service
public class LinkService implements ILinkService{

    @Autowired
    ILinkRepository iLinkRepository;

    @Override
    public LinkInfoDTO crearLinkInfo(LinkDTO linkDTO) {

        Link link = new Link(linkDTO.getLink(),true,linkDTO.getPassword(),0);

        LinkInfoDTO res = new LinkInfoDTO();
        res.setLink(linkDTO.getLink());
        res.setId(iLinkRepository.agregarListaLinks(link));

        return res;

    }

    @Override
    public String verificarExistenciaLink(int idLink, String password) throws RuntimeException{

        Link link = iLinkRepository.findById(idLink);

        if(link.getPassword().equals(password) && link.getIsValid()){
            link.setContadorRedirects(link.getContadorRedirects() + 1);
            return link.getLink();
        }

        throw new RuntimeException("El link ingresado no existe o esta fuera de servicio");
    }

    @Override
    public Object getCantRedirecciones(int linkID) {

        Link link = iLinkRepository.findById(linkID);

        return link.getContadorRedirects();

    }

    @Override
    public ResponseEntity<String> invalidarLinkService(int linkId) {

        Link link = iLinkRepository.findById(linkId);

        link.setIsValid(false);

        return new ResponseEntity(HttpStatus.OK);

    }

}
