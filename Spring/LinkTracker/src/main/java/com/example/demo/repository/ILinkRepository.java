package com.example.demo.repository;

import com.example.demo.dto.LinkDTO;
import com.example.demo.dto.LinkMetricsDTO;
import com.example.demo.dto.LinkUrlDTO;
import com.example.demo.model.Link;

import java.util.List;

public interface ILinkRepository {

    public Link guardarLink(LinkUrlDTO url);

    public List<Link> obtenerLinks();

    public Link obtenerLinkPorID(LinkDTO id);

    public Integer obtenerAccesosPorLinkId(Integer linkId);

    public void actualizarLink(Link link);

}
