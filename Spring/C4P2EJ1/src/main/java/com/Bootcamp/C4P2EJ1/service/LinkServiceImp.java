package com.Bootcamp.C4P2EJ1.service;

import com.Bootcamp.C4P2EJ1.dto.LinkDTO;
import com.Bootcamp.C4P2EJ1.mapper.LinkMapper;
import com.Bootcamp.C4P2EJ1.model.Link;
import com.Bootcamp.C4P2EJ1.repository.ILinkRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class LinkServiceImp implements ILinkService {
    ILinkRepository iLinkRepository;
    LinkMapper linkMapper;
    ModelMapper modelMapper;

    public LinkServiceImp(ILinkRepository iLinkRepository, LinkMapper linkMapper, ModelMapper modelMapper) {
        this.iLinkRepository = iLinkRepository;
        this.linkMapper = linkMapper;
        this.modelMapper = modelMapper;
    }

    @Override
    public LinkDTO nuevoLink(LinkDTO linkDTO) {
        Link link = linkMapper.linkDTOALink(linkDTO);
        return linkMapper.linkALinkDTO(this.iLinkRepository.insertLink(link));
    }

    @Override
    public LinkDTO redireccionarLink(String password, LinkDTO linkDTO) {
        Link link = linkMapper.linkDTOALink(linkDTO);
        return linkMapper.linkALinkDTO(this.iLinkRepository.buscarLink(password, link));
    }

    @Override
    public int estadisticaLink(LinkDTO linkDTO) {
        Link link = linkMapper.linkDTOALink(linkDTO);
        this.iLinkRepository.buscarLinkSinPassword(link);
        return linkDTO.getContador();
    }

    @Override
    public boolean eliminarLink(LinkDTO linkDTO) {
        Link link = linkMapper.linkDTOALink(linkDTO);
        return this.iLinkRepository.eliminarLink(link);
    }
}
