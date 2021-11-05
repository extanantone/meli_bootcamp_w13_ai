package com.example.demo.service;

import com.example.demo.dto.LinkDTO;
import com.example.demo.dto.LinkMetricsDTO;
import com.example.demo.dto.LinkUrlDTO;
import com.example.demo.model.Link;

import java.util.List;

public interface ILinkService{

    public LinkDTO guardarLink(LinkUrlDTO url);

    public List<Link> obtenerLinks();

    public LinkUrlDTO obtenerLinkPorID(LinkDTO id);

    public LinkMetricsDTO obtenerMetricasPorLinkId(Integer linkId);

    public void actualizarLink(LinkDTO id);

}
