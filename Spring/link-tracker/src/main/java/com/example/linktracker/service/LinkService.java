package com.example.linktracker.service;

import com.example.linktracker.dto.LinkDTO;
import com.example.linktracker.dto.LinkIdDTO;
import com.example.linktracker.dto.LinkUrlPassDTO;
import com.example.linktracker.entity.Link;
import com.example.linktracker.mapper.LinkMapper;
import com.example.linktracker.repository.LinkRepositorio;
import org.springframework.stereotype.Service;

@Service
public class LinkService {

    private final LinkRepositorio repositorio;

    public LinkService(LinkRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public LinkIdDTO guardar(Link link) {
        repositorio.guardar(link);
        return LinkMapper.linkToIdDTO(link);
    }

    public String redireccionar(Integer id, String pass) {
        Link link = repositorio.obtenerPorId(id);
        String url = "";
        if (link == null || !link.getPassword().equals(pass)) {
            System.out.println("Id o contraseña invalida");
            return url;
        }
        url = link.getUrl();
        return url;
    }

    public LinkDTO invalidar(Integer id) {
        Link link = repositorio.obtenerPorId(id);
        if (link == null) return null;
        link.setEsValido(false);
        repositorio.guardar(link);
        return LinkMapper.linkToDTO(link);
    }
}
