package com.example.demo.service;


import com.example.demo.dto.LinkDTO;
import com.example.demo.dto.LinkMetricsDTO;
import com.example.demo.dto.LinkUrlDTO;
import com.example.demo.model.Link;
import com.example.demo.repository.ILinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LinkService implements ILinkService{

    @Autowired
    ILinkRepository iLinkRepository;

    @Override
    public LinkDTO guardarLink(LinkUrlDTO url) {
        LinkDTO response = new LinkDTO();
        Link linkGuardado = iLinkRepository.guardarLink(url);

        response.setId(linkGuardado.getId());

        return response;
    }

    @Override
    public List<Link> obtenerLinks() {
        return iLinkRepository.obtenerLinks();
    }

    @Override
    public LinkUrlDTO obtenerLinkPorID(LinkDTO id) {

        LinkUrlDTO linkUrl = new LinkUrlDTO();
        Link respuestaRep = iLinkRepository.obtenerLinkPorID(id);
        actualizarLink(id);
        linkUrl.setUrl(respuestaRep.getUrl());
         return linkUrl;
    }

    @Override
    public LinkMetricsDTO obtenerMetricasPorLinkId(Integer linkId) {

        LinkMetricsDTO response = new LinkMetricsDTO();
        response = iLinkRepository.obtenerMetricasPorLinkId(linkId);

        return response;
    }

    @Override
    public void actualizarLink(LinkDTO id) {

        Link link = iLinkRepository.obtenerLinkPorID(id);
        int accesos = link.getAccesos() + 1;
        link.setAccesos(accesos);

        iLinkRepository.actualizarLink(link);

    }
}
